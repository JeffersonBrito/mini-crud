package com.masrter.bank.mastertech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado")
public class UserNotFoundException extends RuntimeException {
}
