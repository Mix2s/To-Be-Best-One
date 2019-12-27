package com.zookeeper_service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class LoadSaIdsExecuator implements
        Watcher,Runnable,DataMonitor.DataMonitorListener {
    private DataMonitor dm;
    private ZooKeeper zk;
    private static final String znode = "/sas";
    private String hostName = "192.168.159.134:2181";

    public void setHostName(String hostName){
        this.hostName = hostName;
    }

    public LoadSaIdsExecuator() throws IOException {
        zk = new ZooKeeper(hostName,300000,this);
        dm = new DataMonitor(zk,znode,null,this);
    }

    public static void main(String[] args) {
        try {
            new LoadSaIdsExecuator().run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static class SaIdsLoader extends Thread{
        List<String> saIds = null;
        public SaIdsLoader(List<String> saIds){
            this.saIds = saIds;
            start();
        }
        public void run(){
            System.out.println("******加载开始*******");
            if(saIds != null){
                saIds.forEach(id->{
                    System.out.println(id);
                });
                System.out.println("********加载结束********");
            }
        }

    }

    @Override
    public void changer(List<String> saIds) {
        new SaIdsLoader(saIds);
    }

    @Override
    public void closing(int rc) {
        synchronized (this){
            notifyAll();
        }
    }

    @Override
    public void run() {
        synchronized (this){
            while (!dm.dead){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
            dm.process(watchedEvent);
    }
}
