package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
}
