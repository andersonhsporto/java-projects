package dev.anderson.jwtexample.entities;

import java.util.List;

public enum RoleName {

    SUPERADMIN, ADMIN, USER;

    public static RoleEntity toEntity(RoleName roleName) {
        return new RoleEntity(roleName);
    }

    public static List<RoleEntity> generateUserRole() {
        return List.of(toEntity(USER));
    }
}
