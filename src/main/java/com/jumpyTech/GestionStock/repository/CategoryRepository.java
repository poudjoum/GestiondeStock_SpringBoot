package com.jumpyTech.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
