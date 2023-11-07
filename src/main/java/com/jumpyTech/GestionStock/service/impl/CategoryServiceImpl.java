package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;


import com.jumpyTech.GestionStock.dto.CategoryDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Category;
import com.jumpyTech.GestionStock.repository.CategoryRepository;
import com.jumpyTech.GestionStock.service.CategoryService;
import com.jumpyTech.GestionStock.validator.CategoryValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository catRepo;

	public CategoryServiceImpl(CategoryRepository cr) {
		this.catRepo=cr;
	}
	@Override
	public CategoryDto save(CategoryDto dto) {
		List<String>errors=CategoryValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Category non Valide {}",dto);
			throw new InvalidEntityException("La Categorie n'est pas valide ",ErrorCode.CATEGORY_NOT_FOUND,errors);
		}
		Category saveCategorie=catRepo.save(CategoryDto.toEntity(dto));
		
		return CategoryDto.fromEntity(saveCategorie);
	}

	@Override
	public CategoryDto findById(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			return null;
		}
		Optional<Category> cate=catRepo.findById(id);
		CategoryDto dto=CategoryDto.fromEntity(cate.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucune Category avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.CATEGORY_NOT_FOUND)) ;

	}

	@Override
	public List<CategoryDto> findAll() {
		return catRepo.findAll().stream()
				.map(CategoryDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			
		}
		catRepo.deleteById(id);
		
	}
}
