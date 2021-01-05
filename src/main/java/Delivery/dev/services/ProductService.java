package Delivery.dev.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Delivery.dev.dto.ProductDTO;
import Delivery.dev.entities.Product;
import Delivery.dev.repositories.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productBD;
	
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product>lista = productBD.findAllByOrderByNameAsc();
		return lista.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
