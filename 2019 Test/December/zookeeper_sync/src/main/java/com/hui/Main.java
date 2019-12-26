package com.hui;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        TicketSeller ticketSeller = new TicketSeller();
        for(int i=0;i<1000;i++){
            ticketSeller.sellTicketWithLock();
        }
    }
}
