package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//Indica que esta class é um componente de serviço do Spring, sendo assim possível fazer a injeção de depenencia com o "@Autowired" no controlador
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		//metodo "findById" retorna um "Optional"
		Optional<Product> obj = productRepository.findById(id);
		
		//metodo "get" pega o objeto do "Optional"
		return obj.get();
	}
}
