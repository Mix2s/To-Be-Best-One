package com.hui.Excutor;

import com.zookeeper_service.DataMonitor;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class Executor implements Watcher,Runnable, DataMonitor.DataMonitorListener {

    public Executor(String hostPort, String znode, String filename, String[] exec) throws IOException {

        this.filename = filename;
        this.exec = exec;
        zk = new ZooKeeper(hostPort,3000,this);


    }

    public static void main(String[] args) {
        if(args.length<4){
            System.err.println("error Executor hostPort");
            System.exit(2);
        }
        String hostPort = args[0];
        String znode = args[1];
        String filename = args[2];
        String exec[]  = new String[args.length-3];
        System.arraycopy(args,3,exec,0,exec.length);
        try {
            new Executor(hostPort,znode,filename,exec).run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void changer(List<String> saIds) {

    }

    @Override
    public void closing(int rc) {

    }

    @Override
    public void run() {

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
    public void exists(byte[] data){
        if(data == null){
            if(child != null){
                System.out.println("Kill process");
                child.destory();

            }
        }
    }

}
