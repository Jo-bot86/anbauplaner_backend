package de.nadu_ocholt.anbauplaner.application.user;

import de.nadu_ocholt.anbauplaner.application.user.dto.*;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO createUser(CreateUserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    UserDTO updateUser(Long id, UpdateUserDTO userDTO);

    void deleteUser(Long id);

    LoginResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
