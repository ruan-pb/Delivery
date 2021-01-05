package Delivery.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Delivery.dev.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
