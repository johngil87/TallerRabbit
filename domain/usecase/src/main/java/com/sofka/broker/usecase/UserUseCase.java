package com.sofka.broker.usecase;

import com.sofka.broker.model.UnevenMail;
import com.sofka.broker.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserGateway userGateway;

    public Mono<Void> floorMail(UnevenMail messageMail) {
        return userGateway.send(messageMail);
    }

    public Mono<Boolean> unevenMail(UnevenMail user) {
        return userGateway.exist(user, user.getTipoPisoImpar()).thenReturn(Boolean.TRUE);
    }
}
