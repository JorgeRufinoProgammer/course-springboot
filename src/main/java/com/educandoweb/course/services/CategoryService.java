package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//Indica que esta class é um componente de serviço do Spring, sendo assim possível fazer a injeção de depenencia com o "@Autowired" no controlador
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		//metodo "findById" retorna um "Optional"
		Optional<Category> obj = categoryRepository.findById(id);
		
		//metodo "get" pega o objeto do "Optional"
		return obj.get();
	}
}
