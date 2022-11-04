package com.nelson.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelson.algalog.api.model.Cliente;

@Repository//classe | tipo do id	
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByName(String name);
	
	List<Cliente> findByNameContaining(String name); //operador like do SQL, padrão de especificação JPA
	
	Optional<Cliente> findByEmail(String email);
	
}
