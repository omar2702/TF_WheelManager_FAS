package pe.edu.upc.wheelmanagerserversite.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveCorporationServiceResource {

    @Size(max = 20)
    private int rating;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Lob
    @Type(type = "text")
    private String description;


    @NotNull
    private  Double price;

    @NotNull
    @Lob
    @Type(type = "text")
    private String picture;
}
