package Delivery.dev.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Delivery.dev.dto.OrderDTO;
import Delivery.dev.dto.ProductDTO;
import Delivery.dev.entities.Order;
import Delivery.dev.entities.OrderStatus;
import Delivery.dev.entities.Product;
import Delivery.dev.repositories.OrderRepository;
import Delivery.dev.repositories.ProductRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderBD;
	
	@Autowired
	private ProductRepository productBD;
	
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order>lista = orderBD.findOrdersWithProducts();
		return lista.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO orderDTO){
		Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for(ProductDTO p:orderDTO.getProduct()) {
			Product product = productBD.getOne(p.getId());
			order.getProducts().add(product);
			
			
			
		}
		order = orderBD.save(order);
		return new OrderDTO(order);
	}
	@Transactional
	public OrderDTO setDelivered(Long id){
		Order order = orderBD.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderBD.save(order);
		return new OrderDTO(order);
	}
}
