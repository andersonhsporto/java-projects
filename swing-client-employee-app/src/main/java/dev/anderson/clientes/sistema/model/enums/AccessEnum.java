/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.model.enums;

/**
 *
 * @author ahigo
 */
public enum AccessEnum {
    USER(),
    ADMIN();

    public static AccessEnum fromString(String value) {
        if (value != null) {
            for (AccessEnum accessEnum : AccessEnum.values()) {
                if (value.equalsIgnoreCase(accessEnum.name()) || value.equalsIgnoreCase(accessEnum.translate())) {
                    return accessEnum;
                }
            }
        }
        return null;
    }

    private String translate() {
        switch (this) {
            case USER -> {
                return "usuario";
            }
            case ADMIN -> {
                return "admin";
            }
        }
        return null;
    }

}
