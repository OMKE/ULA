package com.ula.authentication.mapper;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import org.ula.core.domain.model.ULAUserDTO;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ULAUserMapper
{
    public static ULAUserDTO map(User user)
    {
        return new ULAUserDTO()
                    .setId(user.getId())
                    .setUsername(user.getUsername())
                    .setRoles(ULAUserMapper.map(user.getUserPermissions()));
    }

    public static ArrayList<String> map(Set<UserPermission> userPermissions)
    {
        return userPermissions
                .stream()
                .map(userPermission -> userPermission.getPermission().getTitle())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
