package com.sofka.broker.adapter;

import com.sofka.broker.model.UnevenMail;
import com.sofka.broker.model.gateway.UserGateway;
import com.sofka.broker.model.user.UserCreate;
import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class UserMessageAsyncAdapter implements UserGateway {

    private final static String EXCHANGE_NAME = "casilleros.apto";
    private final RabbitTemplate rabbitTemplate;


    @Override
    public Mono<Void> send(UnevenMail unevenMail) {
        try {
            rabbitTemplate.setExchange(EXCHANGE_NAME);
            rabbitTemplate.convertAndSend("",unevenMail.getMessage(),m->{
                m.getMessageProperties().setHeader("numeroPiso", unevenMail.getPiso());
                m.getMessageProperties().setPriority(1);
                return m;
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.empty();
        }
        return Mono.empty();
    }

    @Override
    public Mono<UnevenMail> exist(UnevenMail unevenMail, String tipoPisoImpar) {
        rabbitTemplate.setExchange(EXCHANGE_NAME);
        rabbitTemplate.convertAndSend("",unevenMail.getMessage(),m->{
            m.getMessageProperties().setHeader("tipoPisoImpar",tipoPisoImpar);
            m.getMessageProperties().setPriority(1);
            return m;
        });
        return Mono.just(unevenMail);
    }
}
