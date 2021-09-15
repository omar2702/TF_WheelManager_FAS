package pe.edu.upc.wheelmanagerserversite.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.wheelmanagerserversite.domain.model.Product;

public interface ProductService {
    Product createProduct(Long corporationId, Long categoryId, Product product);
    Product updateProduct(Long productId, Product productRequest);
    ResponseEntity<?> deleteProduct(Long productId);
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long productId);
}
