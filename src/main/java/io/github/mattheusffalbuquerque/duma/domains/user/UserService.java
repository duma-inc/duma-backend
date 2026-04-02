package io.github.mattheusffalbuquerque.duma.domains.user;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.user.dto.CreateUserRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.dto.UpdateUserRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        return userMapper.toResponseList(userRepository.findAll());
    }

     public UserResponse getUserById(UUID id) {
        return userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id)));
    }

    public UserResponse createUser(CreateUserRequest request, String keycloakId, String name, String email) {
        
        User newUser = User.builder()
            .name(name) // associa o nome do Keycloak
            .email(email) // associa o email do Keycloak
            .keycloakId(keycloakId) // associa o keycloakId
            .phone(request.phone())
            .birthDate(request.birthDate())
            .build();

        User savedUser = userRepository.save(newUser);

        return new UserResponse(
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getPhone(),
            savedUser.getBirthDate(),
            savedUser.getCreatedAt()
        );
    }

    public UserResponse updateUser(UUID id, UpdateUserRequest request) {

        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (request.phone() != null) {
            existingUser.setPhone(request.phone());
        }
        if (request.birthDate() != null) {
            existingUser.setBirthDate(request.birthDate());
        }

        return userMapper.toResponse(userRepository.save(existingUser));
    }

     public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
