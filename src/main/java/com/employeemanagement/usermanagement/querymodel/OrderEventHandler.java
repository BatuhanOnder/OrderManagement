package com.employeemanagement.usermanagement.querymodel;

import com.employeemanagement.usermanagement.coreapi.events.OrderCreatedEvent;
import com.employeemanagement.usermanagement.coreapi.events.OrderUpdatedEvent;
import com.employeemanagement.usermanagement.coreapi.queries.FindAllOrderQuery;
import com.employeemanagement.usermanagement.model.OrderEntity;
import com.employeemanagement.usermanagement.repository.OrderEntityRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ProcessingGroup("orders")
public class OrderEventHandler {
    private final OrderEntityRepository repository;

    public OrderEventHandler(OrderEntityRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event){
        repository.save(new OrderEntity(event.getOrderId(), event.getOrderConfirmed()));

    }

    @QueryHandler
    public List<OrderEntity> on(FindAllOrderQuery query){
        return repository.findAll();
    }
}
