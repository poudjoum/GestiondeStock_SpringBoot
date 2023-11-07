package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ArticleDto;
import com.jumpyTech.GestionStock.dto.UtilisateurDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.Utilisateurs;
import com.jumpyTech.GestionStock.repository.UtilisateurRepository;
import com.jumpyTech.GestionStock.service.UtilisateurService;
import com.jumpyTech.GestionStock.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService{
	
	private UtilisateurRepository userRepo;
	
	public UtilisateurServiceImpl(UtilisateurRepository ur) {
		this.userRepo=ur;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		List<String>errors=UtilisateurValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Utilisateur non Valide {}",dto);
			throw new InvalidEntityException("L'utilisateur n'est pas valide",ErrorCode.UTILISATEUR_NOT_VALID,errors);
		}
		Utilisateurs Saveutilisateur=userRepo.save(UtilisateurDto.toEntity(dto));
		
		return UtilisateurDto.fromEntity(Saveutilisateur);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		if(id==null) {
			log.error("L'id de l'utilisateur null");
		}
		Optional <Utilisateurs>user=userRepo.findById(id);
		UtilisateurDto dto=UtilisateurDto.fromEntity(user.get());
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Utilisateur avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.UTILISATEUR_NOT_FOUND)) ;
		
	}

	@Override
	public UtilisateurDto findByNomUtilisateur(String nomUtilisateur) {
		if(!StringUtils.hasLength(nomUtilisateur)) {
			log.error("Le  Code Article est null");
			return null;
		}
		Optional<Utilisateurs>user=userRepo.findUtilisateurByNom(nomUtilisateur);
		UtilisateurDto dto=UtilisateurDto.fromEntity(user.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Utilisateur avec le nom= "+nomUtilisateur+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.UTILISATEUR_NOT_FOUND)) ;
	}

	@Override
	public List<UtilisateurDto> findAll() {
		
		return userRepo.findAll().stream()
				.map(UtilisateurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("L'identifiant de l'utilisation est null");
		
		}
		userRepo.deleteById(id);
		
	}

}
