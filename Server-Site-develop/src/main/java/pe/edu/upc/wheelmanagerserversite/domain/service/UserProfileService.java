package pe.edu.upc.wheelmanagerserversite.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.wheelmanagerserversite.domain.model.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userprofile);
    UserProfile updateUserProfile(Long userprofileId, UserProfile userRequest);
    ResponseEntity<?> deleteUserProfile(Long userprofileId);
    Page<UserProfile> getAllUsersProfile(Pageable pageable);
    UserProfile getUserProfileById(Long userprofileId);
}
