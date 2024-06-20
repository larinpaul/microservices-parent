package com.examplename.javamicroservicesorderservice.repository;

import com.examplename.javamicroservicesorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
