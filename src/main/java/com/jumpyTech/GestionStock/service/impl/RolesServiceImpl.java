package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.jumpyTech.GestionStock.dto.RolesDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;

import com.jumpyTech.GestionStock.model.Roles;
import com.jumpyTech.GestionStock.repository.RolesRepository;
import com.jumpyTech.GestionStock.service.RolesService;
import com.jumpyTech.GestionStock.validator.RolesValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {
	
	private RolesRepository rolesRepo;
	
public RolesServiceImpl(RolesRepository rRepo){
	this.rolesRepo=rRepo;
}

	
	
	@Override
	public RolesDto save(RolesDto dto) {
		List<String>errors=RolesValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Le rolename est null {}",dto);
			throw new InvalidEntityException("Le Rolename n'est pas valide ",ErrorCode.ROLES_NOT_VALIDE,errors);
		}
		Roles savedRoles=rolesRepo.save(RolesDto.toEntity(dto));
		return RolesDto.fromEntity(savedRoles);
	}

	@Override
	public RolesDto findById(Integer id) {
		if(id==null) {
			log.error("roles ID est null");
			return null;
		}
		Optional<Roles>roles=rolesRepo.findById(id);
		RolesDto dto=RolesDto.fromEntity(roles.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Role avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.ROLES_NOT_FOUND)) ;
	
	}

	@Override
	public List<RolesDto> findAll() {
		
		return rolesRepo.findAll().stream()
				.map(RolesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			
		}
		rolesRepo.deleteById(id);
		
	}
	

}
