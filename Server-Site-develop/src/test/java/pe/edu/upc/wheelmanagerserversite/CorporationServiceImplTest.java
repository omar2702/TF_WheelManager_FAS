package pe.edu.upc.wheelmanagerserversite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.wheelmanagerserversite.domain.model.Corporation;
import pe.edu.upc.wheelmanagerserversite.domain.repository.CorporationRepository;
import pe.edu.upc.wheelmanagerserversite.domain.service.CorporationService;
import pe.edu.upc.wheelmanagerserversite.service.CorporationServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CorporationServiceImplTest {
    @Autowired
    private CorporationService corporationService;
    @MockBean
    private CorporationRepository corporationRepository;

    @TestConfiguration
    static class CorporationServiceTestConfiguration {
        @Bean
        public CorporationService corporationService() {
            return new CorporationServiceImpl();
        }
    }

    @Test
    public void whenCorporationsIsCreated() {
        Long Id = 1L;
        Corporation corporation = new Corporation();
        corporation.setId(Id);

        when(corporationRepository.save(corporation)).thenReturn(corporation);
        Corporation saveCorporation = corporationService.createCorporation(corporation);
        assertThat(saveCorporation).isEqualTo(corporation);
    }
}
