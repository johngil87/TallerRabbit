package com.sofka.broker.model.user;

import com.sofka.broker.model.UnevenMail;
import com.sofka.broker.model.common.Event;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserCreate implements Event {

    public static final String EVENT_NAME = "casillero.apto";
    private final UnevenMail data;

    @Override
    public String name() {
        return EVENT_NAME;
    }

    @Override
    public String data() {
        return data.getMessage();
    }
}
