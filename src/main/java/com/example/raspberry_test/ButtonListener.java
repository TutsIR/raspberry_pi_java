package com.example.raspberry_test;

import org.springframework.stereotype.Component;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.*;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ButtonListener {

  private static final int PIN_BUTTON = 21;
  private static final int GREEN_PIN_LED = 22;
  private static final int YELLOW_PIN_LED = 17;
  private static final int RED_PIN_LED = 27;

  private final Context pi4j = Pi4J.newAutoContext();
  private final DigitalOutputConfigBuilder greenLedConfig =
      DigitalOutput.newConfigBuilder(pi4j)
          .id("led_green")
          .name("Green LED Flasher")
          .address(GREEN_PIN_LED)
          .shutdown(DigitalState.LOW)
          .initial(DigitalState.HIGH)
          .provider("pigpio-digital-output");

  private final DigitalOutputConfigBuilder yellowLedConfig =
      DigitalOutput.newConfigBuilder(pi4j)
          .id("led_yellow")
          .name("Yellow LED Flasher")
          .address(YELLOW_PIN_LED)
          .shutdown(DigitalState.LOW)
          .initial(DigitalState.LOW)
          .provider("pigpio-digital-output");

  private final DigitalOutputConfigBuilder redLedConfig =
      DigitalOutput.newConfigBuilder(pi4j)
          .id("led_red")
          .name("Red LED Flasher")
          .address(RED_PIN_LED)
          .shutdown(DigitalState.LOW)
          .initial(DigitalState.LOW)
          .provider("pigpio-digital-output");

  private final DigitalInputConfigBuilder buttonConfig =
      DigitalInput.newConfigBuilder(pi4j)
          .id("button")
          .name("Press button")
          .address(PIN_BUTTON)
          .pull(PullResistance.PULL_DOWN)
          .debounce(3000L)
          .provider("pigpio-digital-input");
  private final DigitalInput button = pi4j.create(buttonConfig);
  private final DigitalOutput greenLed = pi4j.create(greenLedConfig);
  private final DigitalOutput yellowLed = pi4j.create(yellowLedConfig);
  private final DigitalOutput redLed = pi4j.create(redLedConfig);

  public ButtonListener() {

    button.addListener(
        e -> {
          if (e.state() == DigitalState.HIGH) {
            log.info("Button was pressed ...");
            greenLed.on();
            try {
              sleep(6000);
            } catch (InterruptedException ex) {
              throw new RuntimeException(ex);
            }
            greenLed.off();
            yellowLed.on();
            try {
              sleep(1000);
            } catch (InterruptedException ex) {
              throw new RuntimeException(ex);
            }
            yellowLed.off();
            redLed.on();
          } else if (e.state() == DigitalState.LOW) {
            log.info("Button was released ...");
            greenLed.off();
            yellowLed.off();
            redLed.off();
          }
        });
  }

  private void sleep(int ms) throws InterruptedException {
    Thread.sleep(ms);
  }
}
