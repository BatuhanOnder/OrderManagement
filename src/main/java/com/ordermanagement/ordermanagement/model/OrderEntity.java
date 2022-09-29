package com.employeemanagement.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderEntity {
    @Id
    public String orderId;
    public Boolean orderConfirmed;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, Boolean orderConfirmed) {
        this.orderId = orderId;
        this.orderConfirmed = orderConfirmed;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getOrderConfirmed() {
        return orderConfirmed;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderConfirmed=" + orderConfirmed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderId.equals(that.orderId) && orderConfirmed.equals(that.orderConfirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderConfirmed);
    }
}
