package br.bernardomecabo.gradle.mapper;

import br.bernardomecabo.gradle.dto.UserDTO;
import br.bernardomecabo.gradle.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "username", source = "name")
    UserModel toModel(final UserDTO dto);



    @Mapping(target = "id", source = "code")
    @Mapping(target = "name", source = "username")
    UserDTO toDTO(final UserModel model);
}
