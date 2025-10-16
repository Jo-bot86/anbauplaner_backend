package de.nadu_ocholt.anbauplaner.application.user.dto.mapper;

import de.nadu_ocholt.anbauplaner.application.user.dto.CreateUserDTO;
import de.nadu_ocholt.anbauplaner.application.user.dto.UpdateUserDTO;
import de.nadu_ocholt.anbauplaner.application.user.dto.UserDTO;
import de.nadu_ocholt.anbauplaner.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);

    User toEntity(CreateUserDTO dto);

    void updateEntity(UpdateUserDTO dto, @MappingTarget User entity);
}
