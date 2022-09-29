package com.employeemanagement.usermanagement.coreapi.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class OrderUpdatedEvent {
    @TargetAggregateIdentifier
    private final String orderId;
    private final Integer count;

    public OrderUpdatedEvent(String orderId, Integer count) {
        this.orderId = orderId;
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderUpdatedEvent that = (OrderUpdatedEvent) o;
        return orderId.equals(that.orderId) && count.equals(that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, count);
    }
}
