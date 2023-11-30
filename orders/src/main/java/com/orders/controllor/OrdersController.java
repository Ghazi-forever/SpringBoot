package com.orders.controllor;

import com.orders.RestTemplateVO.RestTemplateVO;
import com.orders.entity.Orders;
import com.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // Create a new order
    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersService.createOrder(order);
    }

    // Retrieve a specific order by ID
    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId) {
        return ordersService.getOrderById(orderId);
    }

    @GetMapping("/allOrders")
    public List<Orders> getAllOrder() {
        return ordersService.getAllOrder();
    }
    // Retrieve a list of all orders
    @GetMapping
    public RestTemplateVO getAllOrders() {
        return ordersService.getAllOrders();
    }

    // Update an existing order
    @PutMapping("/{orderId}")
    public Orders updateOrder(@PathVariable Long orderId, @RequestBody Orders updatedOrder) {
        return ordersService.updateOrder(orderId, updatedOrder);
    }

    // Delete a specific order by ID
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        ordersService.deleteOrder(orderId);
    }
}

