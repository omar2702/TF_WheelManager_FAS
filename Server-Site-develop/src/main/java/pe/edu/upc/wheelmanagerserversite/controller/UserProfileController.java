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
import pe.edu.upc.wheelmanagerserversite.domain.model.UserProfile;
import pe.edu.upc.wheelmanagerserversite.domain.service.UserProfileService;
import pe.edu.upc.wheelmanagerserversite.resource.SaveUserProfileResource;
import pe.edu.upc.wheelmanagerserversite.resource.UserProfileResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "UserProfile", description = "UserProfile API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/userProfile")
    public Page<UserProfileResource> getallUserProfile(@ParameterObject Pageable pageable) {
        Page<UserProfile> userProfilePage = userProfileService.getAllUsersProfile(pageable);
        List<UserProfileResource> resources = userProfilePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/userProfile/{userProfileId}")
    public UserProfileResource getUserProfileById(@PathVariable(value = "userProfileId") Long userProfileId) {
        return convertToResource(userProfileService.getUserProfileById(userProfileId));
    }

    @PostMapping("/userProfile")
    public UserProfileResource createUserProfile(@Valid @RequestBody SaveUserProfileResource resource) {
        UserProfile userProfile = convertToEntity(resource);
        return convertToResource(userProfileService.createUserProfile(userProfile));
    }

    @PutMapping("/userProfile/{userProfileId}")
    public UserProfileResource updateUserProfile(@PathVariable Long userProfileId, @Valid @RequestBody SaveUserProfileResource resource) {
        UserProfile userProfile = convertToEntity(resource);
        return convertToResource(userProfileService.updateUserProfile(userProfileId, userProfile));
    }

    @DeleteMapping("/userProfile/{userProfileId}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long userProfileId) {
        return userProfileService.deleteUserProfile(userProfileId);
    }

    private UserProfile convertToEntity(SaveUserProfileResource resource) {
        return mapper.map(resource, UserProfile.class);
    }

    private UserProfileResource convertToResource(UserProfile entity) {
        return mapper.map(entity, UserProfileResource.class);
    }

}
