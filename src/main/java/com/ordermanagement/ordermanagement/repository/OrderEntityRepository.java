package com.employeemanagement.usermanagement.repository;

import com.employeemanagement.usermanagement.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, String> {
}
