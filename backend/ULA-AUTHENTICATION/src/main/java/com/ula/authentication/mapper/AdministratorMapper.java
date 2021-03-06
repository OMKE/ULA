package com.ula.authentication.mapper;

import com.ula.authentication.domain.model.Administrator;
import com.ula.authentication.dto.model.AdminDTO;
import org.ula.core.domain.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AdministratorMapper
{
    public static AdminDTO map(Administrator administrator)
    {
        return new AdminDTO()
                    .setId(administrator.getId())
                    .setDeleted(administrator.isDeleted())
                    .setCreatedAt(administrator.getCreatedAt())
                    .setUpdatedAt(administrator.getUpdatedAt())
                    .setUser
                        (
                            new UserDTO()
                                .setId(administrator.getUser().getId())
                                .setEmail(administrator.getUser().getEmail())
                                .setFirstName(administrator.getUser().getFirstName())
                                .setLastName(administrator.getUser().getLastName())
                                .setProfileImage(administrator.getUser().getProfileImage())
                                .setUsername(administrator.getUser().getUsername())
                        );
    }

    public static List<AdminDTO> map(List<Administrator> administrators)
    {
        return administrators.stream().map(AdministratorMapper::map).collect(Collectors.toList());
    }
}
