package com.example.personalshoppersystem.Repository;

import com.example.personalshoppersystem.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    Orders findOrderById(Integer id);
    List<Orders> findOrderByStatus(String status);
    @Query("select o from Orders o ORDER BY o.createdAt desc ")
    List<Orders> sortByLatestOrders();
    @Query("select o from Orders o ORDER BY o.createdAt asc")
    List<Orders> sortByOldestOrders();

}
