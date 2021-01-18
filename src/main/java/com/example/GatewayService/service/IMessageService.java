package com.example.GatewayService.service;

public interface IMessageService<T> {
    boolean sendMessage(T message);
}
