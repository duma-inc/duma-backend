package io.github.mattheusffalbuquerque.duma.domains.user;

import java.util.List;
import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.user.dto.CreateUserRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.dto.UpdateUserRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

     public UserResponse createUser(CreateUserRequest request) {
        
        User newUser = User.builder()
            .name(request.name())
            .email(request.email())
            .password(request.password())
            .phone(request.phone())
            .birthDate(request.birthDate())
            .build();

        User savedUser = userRepository.save(newUser);

        return new UserResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getPhone(),
            savedUser.getBirthDate(),
            savedUser.getCreatedAt()
        );
    }

    public User updateUser(String id, UpdateUserRequest request) {

        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (request.name() != null) {
            existingUser.setName(request.name());
        }
        if (request.email() != null) {
            existingUser.setEmail(request.email());
        }
        if (request.phone() != null) {
            existingUser.setPhone(request.phone());
        }
        if (request.birthDate() != null) {
            existingUser.setBirthDate(request.birthDate());
        }

        return userRepository.save(existingUser);
    }

     public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
