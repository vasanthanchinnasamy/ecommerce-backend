package com.innovate.entity;

public enum NotifyChannel {
    SMS(0),
    EMAIL(1),
    WHATSAPP(2);

    private final int value;

    NotifyChannel(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
