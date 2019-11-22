package com.hui.providerticket.ticket.service.impl;

import com.hui.providerticket.ticket.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "666";
    }
}
