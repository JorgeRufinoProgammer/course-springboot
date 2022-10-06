package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

//Indica que esta class é um componente de serviço do Spring, sendo assim possível fazer a injeção de depenencia com o "@Autowired" no controlador
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		//metodo "findById" retorna um "Optional"
		Optional<User> obj = userRepository.findById(id);
		
		//metodo "get" pega o objeto do "Optional"
		//return obj.get();
		
		//Se nao tiver o "objeto" dispara um exceção
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert (User obj) {
		//O metodo "save" já retorna um objeto "User" depois de salvar no banco
		return userRepository.save(obj);
	}
	
	public void delete (Long id) {
		userRepository.deleteById(id);
	}
	
	public User update (Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
