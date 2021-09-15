package pe.edu.upc.wheelmanagerserversite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.wheelmanagerserversite.domain.model.UserProfile;
import pe.edu.upc.wheelmanagerserversite.domain.repository.UserProfileRepository;
import pe.edu.upc.wheelmanagerserversite.domain.service.UserProfileService;
import pe.edu.upc.wheelmanagerserversite.exception.ResourceNotFoundException;


@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createUserProfile(UserProfile userprofile) {
        return userProfileRepository.save(userprofile);
    }

    @Override
    public UserProfile updateUserProfile(Long userprofileId, UserProfile userRequest) {
        return userProfileRepository.findById(userprofileId).map(userProfile-> {
            userProfile.setName(userRequest.getName());
            userProfile.setLast_name(userRequest.getLast_name());
            userProfile.setGender(userRequest.getGender());
            return userProfileRepository.save(userProfile);
        }).orElseThrow(()->new ResourceNotFoundException("UserProfile","Id",userprofileId));
    }

    @Override
    public ResponseEntity<?> deleteUserProfile(Long userprofileId) {
        return userProfileRepository.findById(userprofileId).map(comment-> {
            userProfileRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("UserProfile","Id",userprofileId));
    }

    @Override
    public Page<UserProfile> getAllUsersProfile(Pageable pageable) {
        return userProfileRepository.findAll(pageable);
    }

    @Override
    public UserProfile getUserProfileById(Long userprofileId) {
        return userProfileRepository.findById(userprofileId)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "Id", userprofileId));
    }
}
