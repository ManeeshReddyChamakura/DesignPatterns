package com.behavioralpatterns.chainofresponsibility;


public class Main {
    public static void main(String[] args) {
        // initialize the handlers
        Handler h1 = new ValidationHandler();
        Handler h2 = new AuthenticationHandler();
        Handler h3 = new PermissionHandler();
        // chain the handlers
//        h1.setNext(h2);
//        h2.setNext(h3);
        h1.setNext(h3);
        // issue a request
        h1.handle("###hello-world///");
    }
}

/**
 * This interface is common for all concrete handlers. It has two methods one to set the
 * next handler on the chain and other method to handle the request
 */
interface Handler {
    public void setNext(Handler next);
    public void handle(String s);
}


/**
 * The abstract class below is the base handler for all concrete handlers. The concrete handlers
 * extends from this abstract class. Having this abstract class is completely optional.
 */
abstract class BaseHandler implements Handler{
    Handler next;

    /**
     * This method sets the next handler
     * @param next is the reference to the next handler
     */
    public void setNext(Handler next) {
        this.next = next;
    }

    /**
     * This method takes care of handling the request. It simply sends the request to the next handler
     * @param s is the request data
     */
    @Override
    public void handle(String s) {
        if (next != null) {
            next.handle(s);
        }
    }
}

class ValidationHandler extends BaseHandler {
    @Override
    public void handle(String s) {
        // perform validation
        int index = s.indexOf('-');
        if (index >= 0) {
            System.out.println("request is Validated");
            super.handle(s);
        } else {
            // invalid input
            // i wont propagate the request down the chain
            System.out.println("ValidateHandler:Invalid input string");
        }
    }
}

class AuthenticationHandler extends BaseHandler {
    @Override
    public void handle(String s) {
        // perform authentication
        boolean authenticated = s.startsWith("###");
        if (authenticated) {
            System.out.println("request is authenticated");
            super.handle(s);
        } else {
            // invalid input
            // don't propagate the request down the chain
            System.out.println("AuthenticationHandler: invalid input");
        }
    }
}

class PermissionHandler extends BaseHandler {
    @Override
    public void handle(String s) {
        // perform permission checks
        if (s.endsWith("///")) {
            System.out.println("request has enough permissions");
            super.handle(s);
        } else {
            System.out.println("PermissionHandler: invalid input");
        }
    }
}


