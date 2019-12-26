package com.hui;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class TicketSeller {
    private void sell(){
        System.out.println("售票开始");
        int sleepMillis = (int)(Math.random()*2000);
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }

    public void sellTicketWithLock() throws IOException, KeeperException, InterruptedException {
        LockSample lockSample = new LockSample();
        lockSample.acquireLock();
        sell();
        lockSample.releaseLock();
    }
}
