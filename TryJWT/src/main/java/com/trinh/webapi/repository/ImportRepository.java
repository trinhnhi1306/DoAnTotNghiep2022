package com.trinh.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trinh.webapi.model.Import;
import com.trinh.webapi.model.Order;
import com.trinh.webapi.model.OrderStatus;
import com.trinh.webapi.model.User;

@Repository
public interface ImportRepository extends JpaRepository<Import, Integer>{

	public List<Import> findByUser(User user);
	
	public List<Import> findAllByOrderByDateDesc();

	public long countByDate(Date date);
}
