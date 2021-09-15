package pe.edu.upc.wheelmanagerserversite.resource;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.wheelmanagerserversite.domain.model.AuditModel;


@Getter
@Setter
public class CorporationResource extends AuditModel{
    private Long id;
    private String ruc;
    private String name;
    private String address;
    private String phone;
}
