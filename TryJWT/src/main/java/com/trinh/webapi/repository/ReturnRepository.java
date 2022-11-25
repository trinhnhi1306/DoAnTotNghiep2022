package com.trinh.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trinh.webapi.model.Order;
import com.trinh.webapi.model.OrderStatus;
import com.trinh.webapi.model.Return;
import com.trinh.webapi.model.User;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer>{
	public List<Return> findByIsApprovedOrderByDateDesc(boolean isApproved);

	public List<Return> findByOrder(Order order);

	@Query("select sum(r.totalPrice) from Return r where DATE(r.date) = :date")
	public Long countItem(@Param("date") Date date);
	public long countByIsApproved(boolean isApproved);
	public List<Return> findByOrderOrderByDateDesc(Order order);
}
