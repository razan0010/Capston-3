package com.example.personalshoppersystem.Service;

import com.example.personalshoppersystem.API.ApiException;
import com.example.personalshoppersystem.Model.Customer;
import com.example.personalshoppersystem.Model.Orders;
import com.example.personalshoppersystem.Repository.CustomerRepository;
import com.example.personalshoppersystem.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }


    public void addOrder(Orders order, Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null){
            throw new ApiException("customer not found");
        }

        order.setCreatedAt(LocalDateTime.now());
        order.setCreatedBy(customer.getName());
        order.setCustomer(customer);

        customerRepository.save(customer);
        orderRepository.save(order);
    }


    public void updateOrder(Integer id, Orders order){
        Orders order1 = orderRepository.findOrderById(id);

        if (order1 == null){
            throw new ApiException("Order Id not found");
        }
        order1.setCategory(order.getCategory());
        order1.setProduct(order.getProduct());
        order1.setBudget(order.getBudget());

        orderRepository.save(order1);

    }

    public void deleteOrder(Integer id){
        Orders order = orderRepository.findOrderById(id);

        if (order == null){
            throw new ApiException("Order Id not found");
        }

        orderRepository.delete(order);
    }


    public Orders getOrderById(Integer id){
        Orders order = orderRepository.findOrderById(id);

        if (order == null){
            throw new ApiException("Order Id not found");
        }

        return order;
    }

    public String getStatusById(Integer id){
        Orders order = orderRepository.findOrderById(id);

        if (order == null){
            throw new ApiException("Order Id not found");
        }

        return order.getStatus();
    }

    public List<Orders> sortByLatestOrders(){
       List<Orders> orders = orderRepository.sortByLatestOrders();

       if (orders.isEmpty()){
           throw new ApiException("No orders yet");
       }

       return orders;
    }

    public List<Orders> sortByOldestOrders(){
        List<Orders> orders = orderRepository.sortByOldestOrders();

        if (orders.isEmpty()){
            throw new ApiException("No orders yet");
        }

        return orders;
    }


    public List<Orders> getOrderByCustomerCity(String customerCity){

        List<Orders> orders = orderRepository.findOrdersByCustomer_City(customerCity);

        if ((orders.isEmpty())){
            throw new ApiException("City has no orders");
        }

        return orders;
    }
}
