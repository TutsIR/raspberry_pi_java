//package com.example.raspberry_test;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pi4j.Pi4J;
//import com.pi4j.context.Context;
//import com.pi4j.io.gpio.digital.*;
//
//@RestController
//public class LEDController {
//
//  private static final int PIN_BUTTON = 24; // PIN 18 = BCM 24
//  private static final int PIN_LED = 22; // PIN 15 = BCM 22
//
//  private final Context pi4j = Pi4J.newAutoContext();
//  private final DigitalOutputConfigBuilder ledConfig =
//      DigitalOutput.newConfigBuilder(pi4j)
//          .id("led")
//          .name("LED Flasher")
//          .address(PIN_LED)
//          .shutdown(DigitalState.LOW)
//          .initial(DigitalState.LOW)
//          .provider("pigpio-digital-output");
//
//  private final DigitalInputConfigBuilder buttonConfig =
//      DigitalInput.newConfigBuilder(pi4j)
//          .id("button")
//          .name("Press button")
//          .address(PIN_BUTTON)
//          .pull(PullResistance.PULL_DOWN)
//          .debounce(3000L)
//          .provider("pigpio-digital-input");
//  private final DigitalInput button = pi4j.create(buttonConfig);
//  private final DigitalOutput led = pi4j.create(ledConfig);
//
//  @GetMapping("/toggle")
//  public String toggleLED() {
//    led.toggle();
//    return "LED toggled!";
//  }
//
//  //    @GetMapping("/state")
//  //    public String getLEDState() {
//  //        return "LED state: " + (led.getState() == PinState.HIGH ? "ON" : "OFF");
//  //    }
//  //
//  @GetMapping("/button")
//  public String getButtonState() {
//    return "Button state: " + (button.state() == DigitalState.HIGH ? "RELEASED" : "PRESSED");
//  }
//}
