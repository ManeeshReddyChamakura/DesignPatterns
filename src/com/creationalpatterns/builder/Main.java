package com.creationalpatterns.builder;

public class Main {
    public static void main(String[] args) {
        Booking b = new Booking("Individual");
        Notification n = NotificationBuilder.buildNotification(b);
        n.sendNotification();
    }
}
