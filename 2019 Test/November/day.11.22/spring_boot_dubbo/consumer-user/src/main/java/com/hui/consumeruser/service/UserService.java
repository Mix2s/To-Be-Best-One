package com.hui.consumeruser.service;

import com.hui.consumeruser.ticket.service.TicketService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Reference
    TicketService ticketService;

    public void heello(){
        String ticket = ticketService.getTicket();
        System.out.println("老铁"+ticket);
    }
}
