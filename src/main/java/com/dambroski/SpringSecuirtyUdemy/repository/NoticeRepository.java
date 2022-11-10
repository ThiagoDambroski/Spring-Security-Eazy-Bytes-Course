package com.dambroski.SpringSecuirtyUdemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Notices;

@Repository
public interface NoticeRepository extends CrudRepository<Notices, Long> {
	
	@Query(value = "from Notices n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notices> findAllActiveNotices();

}
