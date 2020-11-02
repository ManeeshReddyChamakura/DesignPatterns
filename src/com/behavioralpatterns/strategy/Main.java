package com.behavioralpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        HawkHunting hawkHunting = new HawkHunting();
        Eagle eagle = new Eagle(hawkHunting, new HawkFlying());
        eagle.hunt();
        eagle.fly();
        eagle.setHuntingBehaviour(new WhiteHunting());
        eagle.hunt();
    }
}

interface HuntingBehaviour {
    public void hunt();
}

interface FlyingBehaviour {
    public void fly();
}

interface EatingBehaviour {
    public void eat();
}

class HawkFlying implements FlyingBehaviour {
    public void fly() {
        System.out.println("hawk is flying");
    }
}

class HawkHunting implements HuntingBehaviour{
    public void hunt() {
        System.out.println("I am hunting like a hawk");
    }
}

class WhiteHunting implements HuntingBehaviour {
    public void hunt() {
        System.out.println("I am hunting like a white eagle");
    }
}



class Eagle {

    HuntingBehaviour huntingBehaviour;
    FlyingBehaviour flyingBehaviour;

    public Eagle(HuntingBehaviour huntingBehaviour, FlyingBehaviour flyingBehaviour) {
        this.huntingBehaviour = huntingBehaviour;
        this.flyingBehaviour = flyingBehaviour;
    }

    public void hunt() {
        // some default behaviour
        huntingBehaviour.hunt();
    }

    public void fly() {
        // some default implementation
        flyingBehaviour.fly();
    }

    public void setHuntingBehaviour(HuntingBehaviour huntingBehaviour) {
        this.huntingBehaviour = huntingBehaviour;
    }
}

// class Hawk extends Eagle {
//     public void hunt() {
//         // hawk specific behaviour
//     }
// }

// class WhiteEagle extends Eagle {
//     public void fly() {
//         // white eagle flying behaviour
//         // ..
//     }
// }


// class HawkBaldHeadedEagle extends Eagle {
//     public void fly() {
//         // flying behaviour 1
//         CustomFly obj = new CustomFly();
//         obj.fly();
//     }
// }

// class WhiteQueenEagle extends Eagle {
//     public void fly() {
//         // flying behaviour 1
//         CustomFly obj = new CustomFly();
//         obj.fly();
//     }
// }

// class BlackEagle extends Eagle {

// }

class CustomFly {
    public void fly() {
        // code for flying
    }
}










class EagleCustom {
    public void eat() {
        ///
        System.out.println("do something");
    }
}
