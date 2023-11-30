package com.orders.RestTemplateVO;


import com.orders.data.OrdersData;
import com.orders.data.Product;

import java.util.List;

public class RestTemplateVO {
  private List<OrdersData> order;
  private List<Product> product;


  public List<OrdersData> getOrder() {
    return order;
  }

  public void setOrder(List<OrdersData> order) {
    this.order = order;
  }

  public List<Product> getProduct() {
    return product;
  }

  public void setProduct(List<Product> product) {
    this.product = product;
  }
}
