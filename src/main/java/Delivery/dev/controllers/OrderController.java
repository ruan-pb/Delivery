package Delivery.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Delivery.dev.dto.OrderDTO;
import Delivery.dev.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO>list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
