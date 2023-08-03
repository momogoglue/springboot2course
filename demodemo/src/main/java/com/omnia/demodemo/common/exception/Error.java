package com.omnia.demodemo.common.exception;

import lombok.Builder;

@Builder
public class Error {

    String message;
    String cause;
    int status;
    String path;
}
