package com.sofka.broker.model.common;

import reactor.core.publisher.Mono;

public interface EventsGateway {
    Mono<Void> emit(Event event);
}
