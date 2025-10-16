package de.nadu_ocholt.anbauplaner.infrastructure.web.controller.user;

import de.nadu_ocholt.anbauplaner.application.user.UserService;
import de.nadu_ocholt.anbauplaner.application.user.dto.CreateUserDTO;
import de.nadu_ocholt.anbauplaner.application.user.dto.UpdateUserDTO;
import de.nadu_ocholt.anbauplaner.application.user.dto.UserDTO;
import de.nadu_ocholt.anbauplaner.domain.user.exception.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser() {
        log.warn("hallo UserController");
        return userService.getAllUsers(); // später DTO-Liste zurückgeben
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserDTO userDTO) {
        UserDTO savedUser = userService.createUser(userDTO);
        log.info("Für den User {} wurde ein Benutzerkonto angelegt",
                savedUser.username());
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @RequestBody UpdateUserDTO updateUserDTO) {
        UserDTO userDTO = this.userService.updateUser(id, updateUserDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
