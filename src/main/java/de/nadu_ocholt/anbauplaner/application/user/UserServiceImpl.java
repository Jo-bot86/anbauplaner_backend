package de.nadu_ocholt.anbauplaner.application.user;

import de.nadu_ocholt.anbauplaner.application.user.dto.*;
import de.nadu_ocholt.anbauplaner.application.user.dto.mapper.UserMapper;
import de.nadu_ocholt.anbauplaner.domain.user.User;
import de.nadu_ocholt.anbauplaner.domain.user.UserRepository;
import de.nadu_ocholt.anbauplaner.domain.user.exception.UserAlreadyExistsException;
import de.nadu_ocholt.anbauplaner.domain.user.exception.UserNotFoundException;
import de.nadu_ocholt.anbauplaner.infrastructure.security.jwt.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();
    }

    @Override
    public UserDTO createUser(CreateUserDTO userDTO) {
        log.info("Creating user: {}", userDTO.username());

        if (userRepository.existsByEmailAddress(userDTO.emailAddress())) {
            throw new UserAlreadyExistsException(userDTO.emailAddress());
        }

        User entity = userMapper.toEntity(userDTO);
        User savedEntity = userRepository.save(entity);
        return userMapper.toDTO(savedEntity);
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> mayUser = this.userRepository.findById(id);
        return mayUser.map(userMapper::toDTO);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        this.userMapper.updateEntity(userDTO, user);
        return this.userMapper.toDTO(this.userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        var user = userRepository.findByEmailAddress(request.emailAddress())
                .orElseThrow(() -> new UserNotFoundException(request.emailAddress()));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token, userMapper.toDTO(user));
    }

    @Override
    public LoginResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistsException("Username '" + request.username() + "' already exists");
        }

        if (userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistsException("EmailAddress '" + request.emailAddress() + "' already exists");
        }

        var user = new User();
        user.setUsername(request.username());
        user.setEmailAddress(request.emailAddress());
        user.setPasswordHash(passwordEncoder.encode(request.password()));

        var saved = userRepository.save(user);

        String token = jwtUtil.generateToken(saved.getUsername());

        return new LoginResponse(token, this.userMapper.toDTO(saved));
    }
}
