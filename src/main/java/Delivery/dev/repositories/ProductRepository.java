package Delivery.dev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Delivery.dev.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();

}
