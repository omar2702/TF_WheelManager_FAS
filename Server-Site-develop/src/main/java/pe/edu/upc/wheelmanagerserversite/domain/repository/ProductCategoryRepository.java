package pe.edu.upc.wheelmanagerserversite.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.wheelmanagerserversite.domain.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
