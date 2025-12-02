package br.bernardomecabo.gradle;

import br.bernardomecabo.gradle.dto.UserDTO;
import br.bernardomecabo.gradle.mapper.UserMapper;
import br.bernardomecabo.gradle.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {
    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(157);
        model.setUsername("Rafael");
        model.setBirthday(LocalDate.now().minusYears(18));
        System.out.println(mapper.toDTO(model));

        var dto = new UserDTO();
        dto.setId(171);
        dto.setName("Rafael");
        dto.setBirthday(LocalDate.now().minusYears(22));
        System.out.println(mapper.toModel(dto));


    }
}