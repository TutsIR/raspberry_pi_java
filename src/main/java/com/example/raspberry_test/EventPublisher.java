package com.example.raspberry_test;

import java.time.OffsetDateTime;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public void publishButtonPressedEvent(int pinNumber) {
    applicationEventPublisher.publishEvent(
        ButtonPressedEvent.builder().pinNumber(pinNumber).timestamp(OffsetDateTime.now()).build());
  }
}
