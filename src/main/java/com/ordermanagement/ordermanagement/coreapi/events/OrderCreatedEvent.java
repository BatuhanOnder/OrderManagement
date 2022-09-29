package com.employeemanagement.usermanagement.coreapi.events;

import com.employeemanagement.usermanagement.coreapi.commands.CreateOrderCommand;

import java.util.Objects;

public class OrderCreatedEvent {
    private final String orderId;
    private final Boolean orderConfirmed;


    public OrderCreatedEvent(String orderId, Boolean orderConfirmed) {
        this.orderId = orderId;
        this.orderConfirmed = orderConfirmed;
    }

    public Boolean getOrderConfirmed() {
        return orderConfirmed;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return  false;
        CreateOrderCommand that = (CreateOrderCommand) o;
        return Objects.equals(orderId, that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "CreateOrderCommand{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
