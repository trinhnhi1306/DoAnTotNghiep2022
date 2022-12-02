package com.trinh.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trinh.webapi.model.Order;
import com.trinh.webapi.model.OrderStatus;
import com.trinh.webapi.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public List<Order> findByStatusOrderByDateDesc(OrderStatus status);

	public List<Order> findByUser(User user);

	@Query("select sum(o.totalPrice) from Order o where DATE(o.date) = :date")
	public Long countItem(@Param("date") Date date);
	public long countByStatus(OrderStatus statusId);
	
	public List<Order> findByUserAndStatusOrderByDateDesc(User user, OrderStatus orderStatus);
	public List<Order> findByShipperAndStatusOrderByDateDesc(User user, OrderStatus orderStatus);
	public List<Order> findByUserOrderByDateDesc(User user);
}
