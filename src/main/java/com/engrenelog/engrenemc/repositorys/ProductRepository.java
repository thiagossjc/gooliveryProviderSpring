package com.engrenelog.engrenemc.repositorys;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.Category;
import com.engrenelog.engrenemc.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional(readOnly = true)

	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categorys cat WHERE obj.name LIKE %:name% AND cat IN :categorys")

	Page<Product> search(@Param("name") String name, @Param("categorys") List<Category> categorys,
			Pageable pageRequest);
}
