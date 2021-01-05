package Delivery.dev.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Delivery.dev.dto.OrderDTO;
import Delivery.dev.entities.Order;
import Delivery.dev.repositories.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderBD;
	
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order>lista = orderBD.findOrdersWithProducts();
		return lista.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
}
