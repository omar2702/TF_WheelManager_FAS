package pe.edu.upc.wheelmanagerserversite.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.wheelmanagerserversite.domain.model.ProductCategory;

public interface ProductCategoryService {
    ProductCategory createProductCategory(ProductCategory productCategory);
    ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategoryRequest);
    ResponseEntity<?> deleteProductCategory(Long productCategoryId);
    Page<ProductCategory> getAllProductCategory(Pageable pageable);
    ProductCategory getProductCategoryById(Long productCategoryId);
}
