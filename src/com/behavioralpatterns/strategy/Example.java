package com.behavioralpatterns.strategy;

public class Example {
    public static void main(String[] args) {

    }
}


class Bird {
    public void eat() {
        // some default behaviour for eating
    }
    public void hunt() {
        // some default behaviour for hunting
    }
    public void fly() {
        // some default behaviour for flying
    }
}



 class Hawk extends Bird {
     public void hunt() {
         // hawk specific behaviour
     }
 }

 class WhiteEagle extends Bird {
     public void fly() {
         // white eagle flying behaviour
     }
 }


 class HawkBaldHeadedEagle extends Bird {
     public void fly() {
         // flying behaviour 1
         CustomFly obj = new CustomFly();
         obj.fly();
     }
 }

 class WhiteQueenEagle extends Bird {
     public void fly() {
         // flying behaviour 1
         CustomFly obj = new CustomFly();
         obj.fly();
     }
 }

 class BlackEagle extends Bird {

 }

class CustomBirdFly {
    public void fly() {
        // code for flying
    }
}