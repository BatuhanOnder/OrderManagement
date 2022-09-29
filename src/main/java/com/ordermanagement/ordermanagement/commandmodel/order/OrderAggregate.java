package com.employeemanagement.usermanagement.commandmodel.order;

import com.employeemanagement.usermanagement.coreapi.commands.CreateOrderCommand;
import com.employeemanagement.usermanagement.coreapi.commands.UpdateOrderCommand;
import com.employeemanagement.usermanagement.coreapi.events.OrderCreatedEvent;
import com.employeemanagement.usermanagement.coreapi.events.OrderUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    private int stock;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        AggregateLifecycle.apply(new OrderCreatedEvent(command.getOrderId(), false));
    }

    @CommandHandler
    public void handler(UpdateOrderCommand command){
        if (this.stock <= command.getCount()){
            throw new RuntimeException("Stock is not valid.");
        }
        AggregateLifecycle.apply(new OrderUpdatedEvent(command.getOrderId(), command.getCount()));
    }


    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        this.orderId = event.getOrderId();
        this.orderConfirmed = event.getOrderConfirmed();
        this.stock = 100;
    }

    @EventSourcingHandler
    public void on(OrderUpdatedEvent event){
        this.stock -= event.getCount();

    }


}
