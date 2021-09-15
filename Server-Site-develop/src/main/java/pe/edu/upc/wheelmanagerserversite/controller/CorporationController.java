package pe.edu.upc.wheelmanagerserversite.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wheelmanagerserversite.domain.model.Corporation;
import pe.edu.upc.wheelmanagerserversite.domain.service.CorporationService;
import pe.edu.upc.wheelmanagerserversite.resource.CorporationResource;
import pe.edu.upc.wheelmanagerserversite.resource.SaveCorporationResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Corporations", description = "Corporation API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CorporationController {
    @Autowired
    CorporationService corporationService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/corporations")
    public Page<CorporationResource> getAllCorporations(@ParameterObject Pageable pageable) {
        Page<Corporation> corporationPage = corporationService.getAllCorporations(pageable);
        List<CorporationResource> resources = corporationPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/corporations/{corporationId}")
    public CorporationResource getCorporationById(@PathVariable(value = "corporationId") Long corporationId) {
        return convertToResource(corporationService.getCorporationById(corporationId));
    }

    @PostMapping("/corporations")
    public CorporationResource createCorporation(@Valid @RequestBody SaveCorporationResource resource) {
        Corporation corporation = convertToEntity(resource);
        return convertToResource(corporationService.createCorporation(corporation));
    }

    @PutMapping("/corporations/{corporationId}")
    public CorporationResource updateCorporation(@PathVariable Long corporationId, @Valid @RequestBody SaveCorporationResource resource) {
        Corporation corporation = convertToEntity(resource);
        return convertToResource(corporationService.updateCorporation(corporationId, corporation));
    }

    @DeleteMapping("/corporations/{corporationId}")
    public ResponseEntity<?> deleteCorporation(@PathVariable Long corporationId) {
        return corporationService.deleteCorporation(corporationId);
    }

    private Corporation convertToEntity(SaveCorporationResource resource) {
        return mapper.map(resource, Corporation.class);
    }

    private CorporationResource convertToResource(Corporation entity) {
        return mapper.map(entity, CorporationResource.class);
    }


}
