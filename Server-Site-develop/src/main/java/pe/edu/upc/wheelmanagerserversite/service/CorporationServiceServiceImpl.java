package pe.edu.upc.wheelmanagerserversite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.wheelmanagerserversite.domain.model.CorporationService;
import pe.edu.upc.wheelmanagerserversite.domain.repository.CorporationRepository;
import pe.edu.upc.wheelmanagerserversite.domain.repository.CorporationServiceRepository;
import pe.edu.upc.wheelmanagerserversite.domain.service.CorporationServiceService;
import pe.edu.upc.wheelmanagerserversite.exception.ResourceNotFoundException;

@Service
public class CorporationServiceServiceImpl implements CorporationServiceService {
    @Autowired
    private CorporationServiceRepository corporationServiceRepository;

    @Autowired
    private CorporationRepository corporationRepository;

    @Override
    public CorporationService createCorporationService(Long corporationId, CorporationService corporationService)
    {
        return corporationRepository.findById(corporationId).map(corporation -> {
            corporationService.setCorporation(corporation);
            return corporationServiceRepository.save(corporationService);
        }).orElseThrow(()->new ResourceNotFoundException("Corporation","Id",corporationId));
    }

    @Override
    public CorporationService updateCorporationService(Long corporationServiceId,
                                                       CorporationService corporationServiceRequest){
        return corporationServiceRepository.findById(corporationServiceId).map(corporationService -> {
            corporationService.setRating(corporationServiceRequest.getRating());
            corporationService.setName(corporationServiceRequest.getName());
            corporationService.setDescription(corporationServiceRequest.getDescription());
            corporationService.setPrice(corporationServiceRequest.getPrice());
            corporationService.setPicture(corporationServiceRequest.getPicture());
            return corporationServiceRepository.save(corporationService);
        }).orElseThrow(()->new ResourceNotFoundException("CorporationService","Id",corporationServiceId));
    }

    @Override
    public ResponseEntity<?> deleteCorporationService(Long corporationServiceId){
        return corporationServiceRepository.findById(corporationServiceId).map(corporationService -> {
            corporationServiceRepository.delete(corporationService);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("CorporationService","Id",corporationServiceId));
    }

    @Override
    public Page<CorporationService> getAllCorporationServices(Pageable pageable){
        return corporationServiceRepository.findAll(pageable);
    }

    @Override
    public CorporationService getCorporationServiceById(Long corporationServiceId){
        return corporationServiceRepository.findById(corporationServiceId)
                .orElseThrow(() -> new ResourceNotFoundException("CorporationService", "Id", corporationServiceId));
    }

}
