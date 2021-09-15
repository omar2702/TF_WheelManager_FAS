package pe.edu.upc.wheelmanagerserversite.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.wheelmanagerserversite.domain.model.AuditModel;

@Getter
@Setter
public class ProductCategoryResource extends AuditModel {
    private Long id;
    private String name;
    private String picture;
}
