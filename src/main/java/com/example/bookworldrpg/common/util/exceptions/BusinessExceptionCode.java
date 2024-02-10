package com.example.bookworldrpg.common.util.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusinessExceptionCode {
  B_01("B-01", "Could not add new book. This book already exists!");

  private final String code;
  private final String message;
}
