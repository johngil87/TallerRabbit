package com.sofka.broker.api;

import com.sofka.broker.model.UnevenMail;
import com.sofka.broker.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserService {
    private final UserUseCase userUseCase;

    @PostMapping(path = "/messageFloor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> floorMail(@RequestBody UnevenMail messageMail) {
        return userUseCase.floorMail(messageMail);
    }

    @PostMapping(path = "/messageUneven", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> unevenMail(@RequestBody UnevenMail messageMail) {
        return userUseCase.unevenMail(messageMail);
    }
}
