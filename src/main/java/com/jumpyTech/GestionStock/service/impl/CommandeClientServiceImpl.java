package com.jumpyTech.GestionStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.CommandeClientDto;
import com.jumpyTech.GestionStock.dto.LigneCmndeClientDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.model.Client;
import com.jumpyTech.GestionStock.model.CommandeClient;
import com.jumpyTech.GestionStock.model.LigneCmndeClient;
import com.jumpyTech.GestionStock.repository.ArticleRepository;
import com.jumpyTech.GestionStock.repository.ClientRepository;
import com.jumpyTech.GestionStock.repository.CommandeClientRepository;
import com.jumpyTech.GestionStock.repository.LigneCmndeClientRepository;
import com.jumpyTech.GestionStock.service.CommandeClientService;
import com.jumpyTech.GestionStock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
	
	private CommandeClientRepository cmndeRepo;
	private LigneCmndeClientRepository ligRepo;
	private ClientRepository cliRepo;
	private ArticleRepository artRepo;

	public CommandeClientServiceImpl(CommandeClientRepository cr,ClientRepository cl,LigneCmndeClientRepository lr,ArticleRepository ar) {
		this.cmndeRepo=cr;
		this.cliRepo=cl;
		this.ligRepo=lr;
		this.artRepo=ar;
	}
	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		List<String>errors= CommandeClientValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("La commande Client n'est pas valide");
			throw new InvalidEntityException("La commande client n'est "
					+ "pas Valide",
					ErrorCode.LIGNE_COMMANDE_CLIENT_NOT_VALID,errors);
		}
		Optional <Client>client=cliRepo.findById(dto.getClient().getId());
		if(client.isEmpty()) {
			log.warn("Le Client avec l'id {} n'est pas dans la base de "
					+ "donnée ",dto.getClient().getId());
			throw new EntityNotFoundException("Aucun Client avec l'id "
					+ ""+dto.getClient().getId()+"n'a été trouvé dans la "
							+ "base",ErrorCode.CLIENT_NOT_FOUND);
		}
		List<String>articleErrors=new ArrayList<>();
		if(dto.getLigneCmndeClient()!=null) {
			dto.getLigneCmndeClient().forEach(ligCmdClt->{
				if(ligCmdClt.getArticle()!=null) {
					Optional<Article>article=artRepo.findById(
							ligCmdClt.getArticle().getId());
					if(article.isEmpty()) {
						articleErrors.add("L'article avec l'ID "+
					ligCmdClt.getArticle().getId()+"n'existe pas ");
					}
				}
			});
		}
		if(!articleErrors.isEmpty()) {
			log.warn("");
			throw new InvalidEntityException("",
					ErrorCode.ARTICLE_NOT_FOUND,articleErrors);
		}
		 CommandeClient saveCmdClt=cmndeRepo.save(
				 CommandeClientDto.toEntity(dto));
		 if(dto.getLigneCmndeClient()!=null) {
			 dto.getLigneCmndeClient().forEach(lgCmdClt ->{
					LigneCmndeClient lgc=LigneCmndeClientDto.toEntity(
							lgCmdClt);
					lgc.setCommandeClient(saveCmdClt);
					ligRepo.save(lgc);
				});
		 }
		 
		return CommandeClientDto.fromEntity(saveCmdClt);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id==null) {
			log.error("Commande client Id is Null");
			return null;
			
		}
		
		return cmndeRepo.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("Aucune Commande "
						+ "avec l'id {}",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("Commande client Id is Null");
			return null;
		}
		return cmndeRepo.findCommandClientByCode(code)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("Aucune Commande "
						+ "avec le Code {}",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
	
	}

	@Override
	public List<CommandeClientDto> findAll() {
		
		return cmndeRepo.findAll().stream()
				.map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Commande Client Id is Null");
		}
		cmndeRepo.deleteById(id);
	}

}
