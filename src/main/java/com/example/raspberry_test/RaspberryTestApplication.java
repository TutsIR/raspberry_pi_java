package com.example.raspberry_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class RaspberryTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RaspberryTestApplication.class, args);
  }
}
