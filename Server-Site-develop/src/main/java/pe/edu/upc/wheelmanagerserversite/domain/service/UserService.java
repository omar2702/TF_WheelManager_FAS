package pe.edu.upc.wheelmanagerserversite.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.wheelmanagerserversite.domain.model.User;


public interface UserService {
    User createUser(Long corporationId, Long userProfileId, User user);
    User updateUser(Long userId, User userRequest);
    ResponseEntity<?> deleteUser(Long userId);
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
}
