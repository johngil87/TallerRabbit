package com.sofka.broker.model.gateway;

import com.sofka.broker.model.UnevenMail;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<Void> send(UnevenMail messageMail);
    Mono<UnevenMail> exist(UnevenMail messageMail, String propiedadApto);
}
