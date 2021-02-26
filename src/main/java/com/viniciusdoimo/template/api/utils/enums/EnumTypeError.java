package com.viniciusdoimo.template.api.utils.enums;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Arrays;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
//@Getter(AccessLevel.PUBLIC)
public enum EnumTypeError {
    ERROR("ERROR"),
    CONSULTATION_WITHOUT_RETURN("CONSULTATION WITHOUT RETURN"),
    FIELD_INVALID("FIELD INVALID"),
    JSON_INVALID("JSON INVALID");

    private final String typeItem;

    EnumTypeError(String typeItem) {
        this.typeItem = typeItem;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public static EnumTypeError find(String typeItem) {
        return Arrays.asList(values()).stream().filter(e -> e.getTypeItem().equals(typeItem))
                .findFirst().orElse(null);
    }
}
