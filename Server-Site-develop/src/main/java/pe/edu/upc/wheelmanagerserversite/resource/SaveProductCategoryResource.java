package pe.edu.upc.wheelmanagerserversite.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveProductCategoryResource {

    @NotNull
    @Size(max = 210)
    @Column(unique = true)
    private String name;

    @Lob
    @Type(type = "text")
    @Column(name = "picture", nullable = false)
    private String picture;
}
