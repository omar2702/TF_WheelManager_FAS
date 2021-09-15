package pe.edu.upc.wheelmanagerserversite.resource;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.wheelmanagerserversite.domain.model.AuditModel;

@Getter
@Setter
public class UserProfileResource extends AuditModel {
    private Long id;
    private String name;
    private String last_name;
    private String gender;
}
