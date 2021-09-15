package pe.edu.upc.wheelmanagerserversite.resource;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveUserResource {
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 25)
    private String password;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    private boolean isBusinessman;
}
