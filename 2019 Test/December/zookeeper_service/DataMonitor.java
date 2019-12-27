package com.zookeeper_service;

import org.apache.zookeeper.*;

import java.util.List;



public class DataMonitor implements Watcher, AsyncCallback, AsyncCallback.ChildrenCallback {
    ZooKeeper zk;
    String znode;
    Watcher chainedWatcher;
    boolean dead;
    DataMonitorListener listener;
    List<String> prevSaIds;

    public DataMonitor(ZooKeeper zk,
                       String znode,
                       Watcher chainedWatcher,
                       DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;

        zk.getChildren(znode,true,this,null);
    }

    public interface DataMonitorListener{
        void changer(List<String> saIds);

        void closing(int rc);
    }

    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children) {
        boolean exists;
        switch (rc){
            case KeeperException.Code.Ok :
                exists = true;
                break;
            case KeeperException.Code
                        .NoNode:
                exists = false;
            break;
            case KeeperException.Code
                    .SessionExpired:
            case KeeperException.Code
                        .NoAuth:
                dead = true;
                listener.closing(rc);
                return;
                default:zk.getChildren(znode,true,this,null);
                return;
        }
        List<String> saIds = null;
        if(exists){
                try {
                    saIds = zk.getChildren(znode,null);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    return;
                }
        }
        if(saIds == null &&
                saIds != prevSaIds ||
                (saIds != null && !saIds.equals(prevSaIds))
        ){
            listener.changer(saIds);
            prevSaIds = saIds;
        }
    }

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        if(event.getType()==Event.EventType.None){
            switch (event.getState()){
                case SyncConnected:
                    break;
                case Expired:
                    dead = true;
                    listener.closing(KeeperException.Code.SESSIONEXPIRED.intValue());
                    break;
            }
        }else {
            if(path!=null && path.equals(znode)){
                zk.getChildren(znode,true,this,null);
            }
        }
        if(chainedWatcher!=null){
            chainedWatcher.process(event);
        }
    }
}
