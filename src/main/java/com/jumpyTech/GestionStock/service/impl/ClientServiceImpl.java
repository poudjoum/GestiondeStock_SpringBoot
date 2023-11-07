package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.jumpyTech.GestionStock.dto.ClientDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Client;
import com.jumpyTech.GestionStock.repository.ClientRepository;
import com.jumpyTech.GestionStock.service.ClientService;

import com.jumpyTech.GestionStock.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService{
	private ClientRepository clientRepo;
	
	@Autowired
	public ClientServiceImpl(ClientRepository cs) {
		this.clientRepo=cs;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		List<String>errors=ClientValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Client non Valid {}",dto);
			throw new InvalidEntityException("Le Client n'est pas valide ",ErrorCode.CLIENT_NOT_FOUND,errors);
		}
		Client savedClient=clientRepo.save(ClientDto.toEntity(dto));
		
		return ClientDto.fromEntity(savedClient);
	}

	@Override
	public ClientDto findById(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			return null;
		}
		Optional<Client>client=clientRepo.findById(id);
		ClientDto dto=ClientDto.fromEntity(client.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Client avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.CLIENT_NOT_FOUND)) ;
	
	}

	@Override
	public ClientDto findByNomClient(String nomClient) {
		if(!StringUtils.hasLength(nomClient)) {
			log.error("Le  Nom client est null");
			return null;
		}
		Optional<Client>client=clientRepo.findClientByNom(nomClient);
		ClientDto dto=ClientDto.fromEntity(client.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Client avec le Nom= "+nomClient+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.CLIENT_NOT_FOUND)) ;
	}

	@Override
	public List<ClientDto> findAll() {
		return clientRepo.findAll().stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			
		}
		clientRepo.deleteById(id);
	}

}
