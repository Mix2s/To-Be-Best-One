package com.hui;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class LockSample {
    private ZooKeeper zkClient;
    private static final String LOCK_ROOT_PATH = "/Locks";
    private static final String LOCK_NODE_NAME = "Lock_";
    private String lockPath;
    private Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.getPath()+"前锁释放");
            synchronized (this){
                notifyAll();
            }
        }
    };

    public LockSample() throws IOException {
        zkClient = new ZooKeeper("192.168.159.134:2181", 10000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState()==Event.KeeperState.Disconnected){
                    System.out.println("失去连接");
                }
            }
        });
    }
    public void acquireLock() throws KeeperException, InterruptedException {
        createLock();

        attemptLock();
    }

    private void attemptLock() throws KeeperException, InterruptedException {
        List<String> lockPaths = null;
        lockPaths = zkClient.getChildren(LOCK_ROOT_PATH,false);
        Collections.sort(lockPaths);
        int index = lockPaths.indexOf(lockPath.substring(LOCK_ROOT_PATH.length())+1);
        if(index==0){
            System.out.println(Thread.currentThread().getName()+"锁获取，lockPath"+lockPath);
            return;
        }else{
            String preLockPath = lockPaths.get(index-1);
            Stat stat = zkClient.exists(LOCK_ROOT_PATH+"/"+preLockPath,watcher);
            if (stat == null){
                attemptLock();
            }else{
                System.out.println("等待前锁释放，prelockPath:"+preLockPath);
                synchronized (watcher){
                    watcher.wait();
                }
                attemptLock();
            }
        }
    }

    private void createLock() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists(LOCK_ROOT_PATH, false);
        if(stat == null ){
            zkClient.create(LOCK_ROOT_PATH,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }
        String lockPath = zkClient.create(LOCK_ROOT_PATH+"/"+LOCK_NODE_NAME,
                Thread.currentThread().getName().getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(Thread.currentThread().getName()+"锁创建"+lockPath);
        this.lockPath = lockPath;
    }

    public void releaseLock() throws KeeperException, InterruptedException {
        zkClient.delete(lockPath,-1);
        zkClient.close();
        System.out.println("锁释放："+lockPath);
    }
}
