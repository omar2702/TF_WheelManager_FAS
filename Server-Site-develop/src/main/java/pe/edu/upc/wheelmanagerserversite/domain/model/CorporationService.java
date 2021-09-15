package pe.edu.upc.wheelmanagerserversite.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "services")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CorporationService extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private int rating;

    @NotNull
    @Size(max = 50)
    private String name;

    @Lob
    @Type(type = "text")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Size(max = 20)
    private  Double price;

    @Lob
    @Type(type = "text")
    @Column(name = "picture", nullable = false)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "corporation_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Corporation corporation;
}
