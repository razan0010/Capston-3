package com.example.personalshoppersystem.Controller;

import com.example.personalshoppersystem.Model.Orders;
import com.example.personalshoppersystem.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }


    @PostMapping("/add/{id}")
    public ResponseEntity addOrder(@RequestBody @Valid Orders order,@PathVariable Integer id ){
        orderService.addOrder(order, id);
        return ResponseEntity.status(200).body("Order added!");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id,@RequestBody @Valid Orders order){
        orderService.updateOrder(id, order);
        return ResponseEntity.status(200).body("Order updated!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("Order deleted!");
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity getOrderById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(orderService.getOrderById(id));
    }

    @GetMapping("/getStatusById/{id}")
    public ResponseEntity getStatusById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(orderService.getStatusById(id));
    }

    @GetMapping("/sortByOldestOrders")
    public ResponseEntity sortByOldestOrders(){
        return ResponseEntity.status(200).body(orderService.sortByOldestOrders());
    }

    @GetMapping("/sortByLatestOrders")
    public ResponseEntity sortByLatestOrders(){
        return ResponseEntity.status(200).body(orderService.sortByLatestOrders());
    }

//    @GetMapping("/getOrderByCustomerCity/{city}")
//    public ResponseEntity getOrderByCustomerCity(@PathVariable String city){
//        return ResponseEntity.status(200).body(orderService.getOrderByCustomerCity(city));
//    }
}
