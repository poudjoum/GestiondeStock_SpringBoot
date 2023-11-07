package com.jumpyTech.GestionStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.LigneVenteDto;
import com.jumpyTech.GestionStock.dto.VentesDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.LigneVente;
import com.jumpyTech.GestionStock.model.Ventes;
import com.jumpyTech.GestionStock.repository.ArticleRepository;
import com.jumpyTech.GestionStock.repository.LigneVenteRepository;
import com.jumpyTech.GestionStock.repository.VenteRepository;
import com.jumpyTech.GestionStock.service.VentesService;
import com.jumpyTech.GestionStock.validator.VentesValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService{
	private ArticleRepository artRepo;
	private LigneVenteRepository lgvRepo;
	private VenteRepository venteRepo;
	
	public VentesServiceImpl(ArticleRepository artRepo, LigneVenteRepository lgvRepo, VenteRepository venteRepo) {
		super();
		this.artRepo = artRepo;
		this.lgvRepo = lgvRepo;
		this.venteRepo = venteRepo;
	}

	@Override
	public VentesDto save(VentesDto dto) {
		List<String>errors=VentesValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error(" La vente est n'est pas Valide {}",dto);
			throw new InvalidEntityException("La Vente n'est pas valide ",ErrorCode.VENTE_NOT_VALID,errors);
		}
		
		List<String>articleError=new ArrayList<>();
		dto.getLigneVente().forEach(LigneVenteDto ->{
			Optional<Article> article=artRepo.findById(LigneVenteDto.getArticle().getId());
			if(article.isEmpty()) {
				log.error("Aucun Article avec l'id "+LigneVenteDto.getArticle().getId()+"n'a été trouvé dans la base de donnée");
			}
				
			});
		if(!articleError.isEmpty()) {
			log.error("One or More article  not found in BD {}",errors);
			throw new InvalidEntityException("Un ou plusieur article n'ont pas été trouvé ",ErrorCode.ARTICLE_NOT_FOUND,articleError);
		}
		
		Ventes saveVente=venteRepo.save(VentesDto.toEntity(dto));
		dto.getLigneVente().forEach(ligneVenteDto->{
			LigneVente lgv=LigneVenteDto.toEntity(ligneVenteDto);
			lgv.setVente(saveVente);
			lgvRepo.save(lgv);
			
		});
		
		return VentesDto.fromEntity(saveVente);
	}

	@Override
	public VentesDto findById(Integer id) {
		if(id==null) {
			log.error("l'Id ventes est null");
			return null;
		}
		return venteRepo.findById(id)
				.map(VentesDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucune Vente n'a été trouvé dans la BDD",ErrorCode.VENTE_NOT_FOUND));
	}

	@Override
	public VentesDto findByCodeVente(String codeVente) {
		if(!StringUtils.hasLength(codeVente)) {
			log.error("Code vente introuvable dans la base de donnée ");
			 return null;
		}
		return venteRepo.findVentesByCode(codeVente)
				.map(VentesDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucune Vente n'a été trouvé dans la BDD",ErrorCode.VENTE_NOT_FOUND));
	
	}

	@Override
	public List<VentesDto> findAll() {
		
		return venteRepo.findAll().stream()
				.map(VentesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Integer id) {
		if(id==null) {
			log.error("Aucune Vente avec l'id "+id);
		}
		venteRepo.deleteById(id);
		
	}

}
