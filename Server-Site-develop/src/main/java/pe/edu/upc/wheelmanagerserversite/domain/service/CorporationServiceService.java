package pe.edu.upc.wheelmanagerserversite.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.wheelmanagerserversite.domain.model.CorporationService;

public interface CorporationServiceService {
    CorporationService createCorporationService(Long corporationId, CorporationService corporationService);
    CorporationService updateCorporationService(Long corporationServiceId, CorporationService corporationServiceRequest);
    ResponseEntity<?> deleteCorporationService(Long corporationServiceId);
    Page<CorporationService> getAllCorporationServices(Pageable pageable);
    CorporationService getCorporationServiceById(Long corporationServiceId);
}

