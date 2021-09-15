package pe.edu.upc.wheelmanagerserversite.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.wheelmanagerserversite.domain.model.AuditModel;
import pe.edu.upc.wheelmanagerserversite.domain.model.Corporation;


@Getter
@Setter
public class CorporationServiceResource extends AuditModel{

    private Long id;
    private int rating;
    private String name;
    private String description;
    private  Double price;
    private String picture;
    private Corporation corporation;
}
