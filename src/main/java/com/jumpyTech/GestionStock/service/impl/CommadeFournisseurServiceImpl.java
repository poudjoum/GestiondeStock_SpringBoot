package com.jumpyTech.GestionStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.jumpyTech.GestionStock.dto.CommandeFournisseurDto;
import com.jumpyTech.GestionStock.dto.LigneCmndeFournisseurDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.Fournisseur;
import com.jumpyTech.GestionStock.model.CommandeFournisseur;
import com.jumpyTech.GestionStock.model.LigneCmndeFournisseur;
import com.jumpyTech.GestionStock.repository.ArticleRepository;
import com.jumpyTech.GestionStock.repository.CommandeFournisseurRepository;
import com.jumpyTech.GestionStock.repository.FournisseurRepository;
import com.jumpyTech.GestionStock.repository.LigneCmndeFournisseurRepository;
import com.jumpyTech.GestionStock.service.CommandeFournisseurService;
import com.jumpyTech.GestionStock.validator.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommadeFournisseurServiceImpl implements CommandeFournisseurService{
	private CommandeFournisseurRepository cmdeFourRepo;
	private LigneCmndeFournisseurRepository ligCmdFourRepo;
	private FournisseurRepository fourRepo;
	private ArticleRepository artRepo;
	
	
	
	public CommadeFournisseurServiceImpl(CommandeFournisseurRepository cmdeFourRepo,
			LigneCmndeFournisseurRepository ligCmdFourRepo, FournisseurRepository fourRepo, ArticleRepository artRepo) {
		super();
		this.cmdeFourRepo = cmdeFourRepo;
		this.ligCmdFourRepo = ligCmdFourRepo;
		this.fourRepo = fourRepo;
		this.artRepo = artRepo;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
List<String>errors= CommandeFournisseurValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("La commande Fournisseur n'est pas valide");
			throw new InvalidEntityException("La commande Fournisseur n'est "
					+ "pas Valide",
					ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
		}
		Optional<Fournisseur> fourni=fourRepo.findById(dto.getFournisseur().getId());
		if(fourni.isEmpty()) {
			log.warn("Le fournisseur avec l'id {} n'est pas dans la base de "
					+ "donnée ",dto.getFournisseur().getId());
			throw new EntityNotFoundException("Aucun fournisseur avec l'id "
					+ ""+dto.getFournisseur().getId()+"n'a été trouvé dans la "
							+ "base",ErrorCode.FOURNISSEUR_NOT_FOUND);
		}
		List<String>articleErrors=new ArrayList<>();
		if(dto.getLigneCmndeFournisseur()!=null) {
			dto.getLigneCmndeFournisseur().forEach(ligCmdFr->{
				if(ligCmdFr.getArticle()!=null) {
					Optional<Article>article=artRepo.findById(
							ligCmdFr.getArticle().getId());
					if(article.isEmpty()) {
						articleErrors.add("L'article avec l'ID "+
								ligCmdFr.getArticle().getId()+"n'existe pas ");
					}
				}
			});
		}
		if(!articleErrors.isEmpty()) {
			log.warn("");
			throw new InvalidEntityException("",
					ErrorCode.ARTICLE_NOT_FOUND,articleErrors);
		}
		 CommandeFournisseur saveCmdClt=cmdeFourRepo.save(
				 CommandeFournisseurDto.toEntity(dto));
		 if(dto.getLigneCmndeFournisseur()!=null) {
			 dto.getLigneCmndeFournisseur().forEach(lgCmdfr ->{
					LigneCmndeFournisseur lgcf=LigneCmndeFournisseurDto.fromEntity(lgCmdfr);
					lgcf.setCommandeFournisseur(saveCmdClt);
					ligCmdFourRepo.save(lgcf);
				});
		 }
		 
		return CommandeFournisseurDto.fromEntity(saveCmdClt);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id==null) {
			log.error("Commande client Id is Null");
			return null;
			
		}
		
		return cmdeFourRepo.findById(id)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("Aucune Commande "
						+ "avec l'id {}",ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
	
	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("Commande fournisseur code is Null");
			return null;
		}
		return cmdeFourRepo.findCommandeFournisseurByCode(code)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("Aucune Commande "
						+ "avec l'id {}",ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
	
	
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		
		return cmdeFourRepo.findAll().stream()
				.map(CommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Commande fournisseur id est null");
		}
		cmdeFourRepo.deleteById(id);
		
	}

}
