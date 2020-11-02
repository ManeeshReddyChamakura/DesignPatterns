package com.creationalpatterns.builder;

import java.util.ArrayList;
import java.util.List;


public class Notification {
    List<PersonalNotification> list = new ArrayList<>();
    Booking b;
    public void addNotification(PersonalNotification n) {
        list.add(n);
    }
    public void sendNotification() {
        for (PersonalNotification n: list) {
            n.sendNotification(b);
        }
    }
}

class NotificationBuilder {
    public static Notification buildNotification(Booking b) {
        Notification n = null;
        if (b.type == "Individual") {
            n = buildIndividualNotfication(b);
        } else if (b.type == "Coach") {
            n = buildCoachNotification(b);
        }
        return n;
    }

    public static Notification buildIndividualNotfication(Booking b) {
        Notification n = new Notification();
        n.addNotification(new SecurityNotification());
        n.addNotification(new MemberNotification());
        n.b = b;
        return n;
    }

    public static Notification buildCoachNotification(Booking b) {
        Notification n = new Notification();
        n.addNotification(new SecurityNotification());
        n.addNotification(new MemberNotification());
        n.addNotification(new CoachNotification());
        n.b = b;
        return n;
    }
}

class Booking {
    String type;
    Booking(String type) {
        this.type = type;
    }
}

interface PersonalNotification {
    public void sendNotification(Booking b);
}

class SecurityNotification implements PersonalNotification {
    @Override
    public void sendNotification(Booking b) {
        // send a sms to security
        System.out.println("sent a sms to security");
    }
}

class MemberNotification implements PersonalNotification {
    @Override
    public void sendNotification(Booking b) {
        // send a sms to member
        System.out.println("sent a sms to member");
    }
}

class CoachNotification implements PersonalNotification {
    @Override
    public void sendNotification(Booking b) {
        // send a sms & email to coach
        System.out.println("sent a sms & email to coach");
    }
}

class ManagerNotification implements PersonalNotification {
    @Override
    public void sendNotification(Booking b) {
        // send a sms & email to manager
        System.out.println("sent a sms & email to manager");
    }
}

/**
 * Booking b = new Booking("individual");
 * // individual and coach
 * if (b.type == "individual") {
 *     PersonalNotification obj1 = new SecurityNotification();
 *     obj.sendNotification(b);
 *     PersonalNotification obj2 = new MemberNotification();
 *     obj.sendNotification(b);
 * } else {
 *     PersonalNotification obj1 = new SecurityNotification();
 *  *     obj.sendNotification(b);
 *  *     PersonalNotification obj2 = new MemberNotification();
 *  *     obj.sendNotification(b);
 *  PersonalNotification obj3 = new CoachNotification();
 *  obj.sendNotification(b):
 * }
 *
 * if (b.type == "individual") {
 * Notification n = new Notification();
 * n.addNotification(new SecurityNotification());
 * n.addNotification(new MemberNotification());
 * n.sendNotification(b);
 * } else {
 *     // same as above
 * } else if (b.type == "type3") {
 *     Notification n = new Notification();
 *  * n.addNotification(new SecurityNotification());
 *  * n.sendNotification(b);
 * }
 *
 */

