package com.example.bookworldrpg.common.util.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum BookworldExceptionCode {

    B_01("B-01", "Error");

    private final String message;
    private final String code;

}
