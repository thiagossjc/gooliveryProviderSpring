package com.engrenelog.engrenemc.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer>  {
		@Transactional(readOnly=true)
		public List<City> findAllByOrderByName();
		
		@Transactional(readOnly=true)
		@Query("SELECT obj FROM Cities obj WHERE obj.State.id= := state_id ORDER BY obj.name")
		public List<City>findCities(@Param("state_id") Integer state_id);
		
}

