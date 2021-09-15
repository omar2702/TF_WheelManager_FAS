package pe.edu.upc.wheelmanagerserversite.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wheelmanagerserversite.domain.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
