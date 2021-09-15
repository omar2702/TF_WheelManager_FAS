package pe.edu.upc.wheelmanagerserversite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.wheelmanagerserversite.domain.model.Corporation;
import pe.edu.upc.wheelmanagerserversite.domain.repository.CorporationRepository;
import pe.edu.upc.wheelmanagerserversite.domain.service.CorporationService;
import pe.edu.upc.wheelmanagerserversite.exception.ResourceNotFoundException;

@Service
public class CorporationServiceImpl implements CorporationService{

    @Autowired
    private CorporationRepository corporationRepository;

    @Override
    public Corporation createCorporation(Corporation corporation)
    {
        return corporationRepository.save(corporation);
    }

    @Override
    public Corporation updateCorporation(Long corporationId, Corporation corporationRequest){
        return corporationRepository.findById(corporationId).map(corporation -> {
            corporation.setRuc(corporationRequest.getRuc());
            corporation.setName(corporationRequest.getName());
            corporation.setAddress(corporationRequest.getAddress());
            corporation.setPhone(corporationRequest.getPhone());
            return corporationRepository.save(corporation);
        }).orElseThrow(()->new ResourceNotFoundException("Corporation","Id",corporationId));
    }

    @Override
    public ResponseEntity<?> deleteCorporation(Long corporationId){
        return corporationRepository.findById(corporationId).map(corporation -> {
            corporationRepository.delete(corporation);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Corporation","Id",corporationId));
    }

    @Override
    public Page<Corporation> getAllCorporations(Pageable pageable){
        return corporationRepository.findAll(pageable);
    }

    @Override
    public Corporation getCorporationById(Long corporationId){
        return corporationRepository.findById(corporationId)
                .orElseThrow(() -> new ResourceNotFoundException("Corporation", "Id", corporationId));
    }


}
