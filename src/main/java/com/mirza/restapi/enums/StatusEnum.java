package com.mirza.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done")
    ;

    private final String value;
}
