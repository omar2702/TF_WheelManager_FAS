package pe.edu.upc.wheelmanagerserversite.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wheelmanagerserversite.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
