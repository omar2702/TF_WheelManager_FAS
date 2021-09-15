package pe.edu.upc.wheelmanagerserversite.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wheelmanagerserversite.domain.model.Product;
import pe.edu.upc.wheelmanagerserversite.domain.service.ProductService;
import pe.edu.upc.wheelmanagerserversite.resource.ProductResource;
import pe.edu.upc.wheelmanagerserversite.resource.SaveProductResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Products", description = "Product API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/products")
    public Page<ProductResource> getAllProducts(@ParameterObject Pageable pageable) {
        Page<Product> productPage = productService.getAllProducts(pageable);
        List<ProductResource> resources = productPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/products/{productId}")
    public ProductResource getProductById(@PathVariable(value = "productId") Long productId) {
        return convertToResource(productService.getProductById(productId));
    }

    @PostMapping("/products")
    public ProductResource createProduct(@RequestParam(name="corporation_id") Long corporationId,
                                         @RequestParam(name="category_id") Long productCategoryId,
                                         @Valid @RequestBody SaveProductResource resource) {
        Product product = convertToEntity(resource);
        return convertToResource(productService.createProduct(corporationId,productCategoryId, product));
    }

    @PutMapping("/products/{productId}")
    public ProductResource updateProduct(@PathVariable Long productId, @Valid @RequestBody SaveProductResource resource) {
        Product product = convertToEntity(resource);
        return convertToResource(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    private Product convertToEntity(SaveProductResource resource) {
        return mapper.map(resource, Product.class);
    }

    private ProductResource convertToResource(Product entity) {
        return mapper.map(entity, ProductResource.class);
    }

}
