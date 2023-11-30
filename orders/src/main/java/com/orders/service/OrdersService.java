package com.orders.service;

import com.orders.RestTemplateVO.RestTemplateVO;
import com.orders.data.OrdersData;
import com.orders.data.Product;
import com.orders.entity.Orders;
//import com.orders.entity.Product;
//import com.orders.entity.ProductDTO;
//import com.orders.entity.Product;
import com.orders.repository.OrdersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrdersService {


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private  OrdersRepository ordersRepository;


    public Orders createOrder(Orders order) {
        // Add custom business logic if needed
        return ordersRepository.save(order);
    }

    public Orders getOrderById(Long orderId) {
        return ordersRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order with ID " + orderId + " not found"));
    }

    public RestTemplateVO getAllOrders() {
        // Fetch orders from the Orders microservice database
        List<Orders> orders = ordersRepository.findAll();
        System.out.println(orders);
        List<OrdersData> ordersDataList = new ArrayList<>();


        for(Orders order : orders){
            OrdersData ordersData = new OrdersData();
            //BeanUtils.copyProperties(orders,ordersData);
            ordersData.setUserid(order.getUserid());
            ordersData.setCustomerName(order.getCustomerName());
            ordersDataList.add(ordersData);

        }
        String uri = "http://localhost:8081/products";


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Compression", "GZIP"); // Indicate that you want the response to be compressed

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<Product>> responseData= new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<Product>> response=restTemplate.exchange(uri,HttpMethod.GET,entity,responseData);

        List<Product> productDTO = response.getBody();
        RestTemplateVO restTemplateVO = new RestTemplateVO();
        restTemplateVO.setOrder((List<OrdersData>) ordersDataList);
        restTemplateVO.setProduct(productDTO);


        return restTemplateVO;

        // Fetch products from the Products microservice using RestTemplate
        /*ResponseEntity<List<ProductDTO>> productResponse = restTemplate.exchange(
                "http://localhost:8080/products", // URL of the Products microservice
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>() {} // Response type
        );

        if (productResponse.getStatusCode() == HttpStatus.OK) {
            List<ProductDTO> products = productResponse.getBody();

            // Merge products into orders or perform other business logic
            // ...
        }*/


    }

    public Orders updateOrder(Long orderId, Orders updatedOrder) {
        Orders existingOrder = getOrderById(orderId);
        // Implement update logic as needed, e.g., updating fields
        // Then save the updated order
        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        //existingOrder.setOrderDate(updatedOrder.getOrderDate());
      //  existingOrder.setProductDTO(updatedOrder.getProduct()); // Consider proper handling for product updates
        return ordersRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        // Check if the order exists
        getOrderById(orderId);
        ordersRepository.deleteById(orderId);
    }

    public List<Orders> getAllOrder() {
        return ordersRepository.findAll();
    }
}
