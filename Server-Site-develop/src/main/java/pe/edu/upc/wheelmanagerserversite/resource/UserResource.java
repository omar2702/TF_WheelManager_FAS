package pe.edu.upc.wheelmanagerserversite.resource;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.wheelmanagerserversite.domain.model.AuditModel;
import pe.edu.upc.wheelmanagerserversite.domain.model.Corporation;
import pe.edu.upc.wheelmanagerserversite.domain.model.UserProfile;

@Getter
@Setter
public class UserResource extends AuditModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean isBusinessman;
    private UserProfile userProfile;
    private Corporation corporation;
}
