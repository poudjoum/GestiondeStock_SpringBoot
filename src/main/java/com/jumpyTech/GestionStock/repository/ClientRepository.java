package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

	Optional<Client> findClientByNom(String nomClient);

}
