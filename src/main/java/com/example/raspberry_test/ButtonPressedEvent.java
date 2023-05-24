package com.example.raspberry_test;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ButtonPressedEvent {
    private int pinNumber;
    private OffsetDateTime timestamp;
}
