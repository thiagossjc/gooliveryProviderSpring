package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.State;

@Repository
public interface StateRepository extends JpaRepository<State,Integer>  {
	
}
