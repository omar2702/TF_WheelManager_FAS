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
import pe.edu.upc.wheelmanagerserversite.domain.model.CorporationService;
import pe.edu.upc.wheelmanagerserversite.domain.service.CorporationServiceService;
import pe.edu.upc.wheelmanagerserversite.resource.CorporationServiceResource;
import pe.edu.upc.wheelmanagerserversite.resource.SaveCorporationServiceResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "CorporationServices", description = "CorporationService API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CorporationServiceController {

    @Autowired
    CorporationServiceService corporationServiceService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/corporation_services")
    public Page<CorporationServiceResource> getAllCorporationServices(@ParameterObject Pageable pageable) {
        Page<CorporationService> corporationServicePage = corporationServiceService.getAllCorporationServices(pageable);
        List<CorporationServiceResource> resources = corporationServicePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/corporation_services/{corporationServiceId}")
    public CorporationServiceResource getCorporationServiceById(@PathVariable(value = "corporationServiceId") Long corporationServiceId) {
        return convertToResource(corporationServiceService.getCorporationServiceById(corporationServiceId));
    }

    @PostMapping("/corporation_services")
    public CorporationServiceResource createCorporationService(@RequestParam(name="corporation_id") Long corporationId,
                                         @Valid @RequestBody SaveCorporationServiceResource resource) {
        CorporationService corporationService = convertToEntity(resource);
        return convertToResource(corporationServiceService.createCorporationService(corporationId, corporationService));
    }

    @PutMapping("/corporation_services/{corporationServiceId}")
    public CorporationServiceResource updateCorporationService(@PathVariable Long corporationServiceId,
                                                               @Valid @RequestBody SaveCorporationServiceResource resource) {
        CorporationService corporationService = convertToEntity(resource);
        return convertToResource(corporationServiceService.updateCorporationService(corporationServiceId, corporationService));
    }

    @DeleteMapping("/corporation_services/{corporationServiceId}")
    public ResponseEntity<?> deleteCorporationService(@PathVariable Long corporationServiceId) {
        return corporationServiceService.deleteCorporationService(corporationServiceId);
    }

    private CorporationService convertToEntity(SaveCorporationServiceResource resource) {
        return mapper.map(resource, CorporationService.class);
    }

    private CorporationServiceResource convertToResource(CorporationService entity) {
        return mapper.map(entity, CorporationServiceResource.class);
    }

}
