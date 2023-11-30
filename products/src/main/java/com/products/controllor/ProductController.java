package com.products.controllor;

import com.products.entity.Product;
import com.products.service.ProductService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/products")
public class ProductController {

    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping //# new response time :151 ms  Old response time:1366 ms NO RESPONSE MESSAGE HERE
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        Product outp =productService.getProductById(id);
        if(outp!=null){
            logger.info("Product Found : {}" ,outp);
            return outp;
        }
        else{
            try{
                throw new Exception();

            }
            catch(Exception e){
                e.printStackTrace();
                logger.error("Product not found with the given ID : {} ",id);
            }
            return new Product();
        }

        //return productService.getProductById(id);
    }

    // # new response time :421 ms  Old response time:1366 ms for the below code
   /* @GetMapping
    public List<Product> getProduct(HttpServletResponse response) {
        List<Product> product = productService.getAllProducts();

        // Set the standard Content-Encoding header to indicate compression, o/p :Could not get response
        //         reason unknown                                           Error: incorrect header check
       //response.setHeader("Content-Encoding", "gzip");

        // Set the custom header to indicate compression: works
        response.addHeader("X-Compression", "GZIP");

        return product;
    }*/

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
