package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ArticleDto;
import com.jumpyTech.GestionStock.dto.FournisseurDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.Fournisseur;
import com.jumpyTech.GestionStock.repository.FournisseurRepository;
import com.jumpyTech.GestionStock.service.FournisseurService;
import com.jumpyTech.GestionStock.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FournisseurServiceImpl implements FournisseurService{


	private FournisseurRepository fourRepo;
	public FournisseurServiceImpl(FournisseurRepository fr) {
		this.fourRepo=fr;
	}
	
	@Override
	public FournisseurDto save(FournisseurDto dto) {
		List<String>errors=FournisseurValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Fournisseur non valide {}",dto);
			throw new InvalidEntityException("Le Fournisseur n'est pas valide ",ErrorCode.FOURNISSEUR_NOT_VALID,errors);
			
		}
		Fournisseur saveFournisseur =fourRepo.save(FournisseurDto.toEntity(dto));
		return FournisseurDto.fromEntity(saveFournisseur);
	}

	@Override
	public FournisseurDto findById(Integer id) {
		if(id==null) {
			log.error("L'id du fournisseur est null");
			return null;
		}
		Optional<Fournisseur>fourni=fourRepo.findById(id);
		FournisseurDto dto=FournisseurDto.fromEntity(fourni.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Fournisseur avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.FOURNISSEUR_NOT_FOUND)) ;
	}

	@Override
	public FournisseurDto findByName(String nomFournisseur) {
		if(!StringUtils.hasLength(nomFournisseur)) {
			log.error("Le  nom fournisseur est null");
			return null;
		}
		Optional<Fournisseur>fourni=fourRepo.findFournisseurByNom(nomFournisseur);
		FournisseurDto dto=FournisseurDto.fromEntity(fourni.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Fournisseur avec le nom = "+nomFournisseur+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.FOURNISSEUR_NOT_FOUND)) ;
	}

	@Override
	public List<FournisseurDto> findAll() {
		
		return fourRepo.findAll().stream()
				.map(FournisseurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("L'id FOurnisseur null");
		}
		fourRepo.deleteById(id);
	}

}
