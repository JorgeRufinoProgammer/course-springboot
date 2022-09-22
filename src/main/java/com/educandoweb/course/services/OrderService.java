package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//Indica que esta class é um componente de serviço do Spring, sendo assim possível fazer a injeção de depenencia com o "@Autowired" no controlador
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		//metodo "findById" retorna um "Optional"
		Optional<Order> obj = orderRepository.findById(id);
		
		//metodo "get" pega o objeto do "Optional"
		return obj.get();
	}
}
