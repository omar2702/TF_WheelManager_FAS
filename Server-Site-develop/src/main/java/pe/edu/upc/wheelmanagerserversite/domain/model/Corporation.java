package pe.edu.upc.wheelmanagerserversite.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "corporations")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Corporation extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String ruc;

    @NotNull
    @Size(max = 25)
    private String name;

    @NotNull
    @Size(max = 50)
    private String address;

    @NotNull
    @Size(max = 20)
    private String phone;
}
