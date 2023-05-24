package com.example.raspberry_test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ButtonPressedEventListener {

  @EventListener
  public void handleButtonPressedEvent(ButtonPressedEvent buttonPressedEvent) {
    log.info("button on pin {} was pressed", buttonPressedEvent.getPinNumber());
  }
}
