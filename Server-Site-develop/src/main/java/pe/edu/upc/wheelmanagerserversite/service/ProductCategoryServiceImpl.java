package pe.edu.upc.wheelmanagerserversite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.wheelmanagerserversite.domain.model.ProductCategory;
import pe.edu.upc.wheelmanagerserversite.domain.repository.ProductCategoryRepository;
import pe.edu.upc.wheelmanagerserversite.domain.service.ProductCategoryService;
import pe.edu.upc.wheelmanagerserversite.exception.ResourceNotFoundException;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategoryRequest) {
        return productCategoryRepository.findById(productCategoryId).map(productCategory -> {
            productCategory.setName(productCategoryRequest.getName());
            productCategory.setPicture(productCategoryRequest.getPicture());
            return productCategoryRepository.save(productCategory);
        }).orElseThrow(()->new ResourceNotFoundException("ProductCategory","Id",productCategoryId));
    }

    @Override
    public ResponseEntity<?> deleteProductCategory(Long productCategoryId) {
        return productCategoryRepository.findById(productCategoryId).map(productCategory -> {
            productCategoryRepository.delete(productCategory);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("ProductCategory","Id",productCategoryId));
    }

    @Override
    public Page<ProductCategory> getAllProductCategory(Pageable pageable) {
        return productCategoryRepository.findAll(pageable);
    }

    @Override
    public ProductCategory getProductCategoryById(Long productCategoryId) {
        return productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory","Id",productCategoryId));
    }
}
