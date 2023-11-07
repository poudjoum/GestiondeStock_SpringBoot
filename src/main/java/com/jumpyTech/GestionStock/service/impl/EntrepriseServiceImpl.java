package com.jumpyTech.GestionStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ArticleDto;
import com.jumpyTech.GestionStock.dto.EntrepriseDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.Entreprise;
import com.jumpyTech.GestionStock.repository.EntrepriseRepository;
import com.jumpyTech.GestionStock.service.EntrepriseService;
import com.jumpyTech.GestionStock.validator.EntrepriseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService{
	
	private EntrepriseRepository entRepo;
	
	public EntrepriseServiceImpl(EntrepriseRepository es) {
		this.entRepo=es;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		List<String>errors=EntrepriseValidator.validate(dto);
		if(!errors.isEmpty()) {
			
		}
    Entreprise savedEntreprise=entRepo.save(EntrepriseDto.toEntity(dto));
		
		return EntrepriseDto.fromEntity(savedEntreprise);
		
		
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if(id==null) {
			log.error("Entreprise ID est null");
			return null;
		}
		Optional<Entreprise>entreprise=entRepo.findById(id);
		EntrepriseDto dto=EntrepriseDto.fromEntity(entreprise.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucune Entreprise avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.ENTREPRISE_NOT_FOUND)) ;
	
	}

	@Override
	public EntrepriseDto findByNom(String nomEntreprise) {
		if(!StringUtils.hasLength(nomEntreprise)) {
			log.error("Le nom Entreprise est null");
			return null;
		}
		Optional<Entreprise>entreprise=entRepo.findEntrepriseByNom(nomEntreprise);
		EntrepriseDto dto=EntrepriseDto.fromEntity(entreprise.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucune Entreprise  avec le nom= "+nomEntreprise+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.ENTREPRISE_NOT_FOUND)) ;
	}

	@Override
	public List<EntrepriseDto> findAll() {
		return entRepo.findAll().stream()
				.map(EntrepriseDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			
		}
		entRepo.deleteById(id);
	}

	@Override
	public EntrepriseDto findByRegistreCommerce(String registreCommerce) {
		Optional<Entreprise>entreprise=entRepo.findEntrepriseByRegistreCommerce(registreCommerce);
		EntrepriseDto dto=EntrepriseDto.fromEntity(entreprise.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucune Entreprise  avec le registre de commerce= "+registreCommerce+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.ENTREPRISE_NOT_FOUND)) ;
	}

}
