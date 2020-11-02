package com.creationalpatterns.factory;

// this is the product
interface Member {
    public void register();
    public void notifyPeople();
}

enum MemberTypes {
    LIFETIME, ANNUAL, MONTHLY;
}

enum NewyorkMemberTypes {
    LIFETIME, ANNUAL, MONTHLY;
}

// concrete product
class LifetimeMember implements Member {
    public void register() {

    }

    @Override
    public void notifyPeople() {
        // TODO Auto-generated method stub

    }
}

class AnnualMember implements Member {
    public void register() {

    }

    @Override
    public void notifyPeople() {
        // TODO Auto-generated method stub

    }
}

class MonthlyMember implements Member {
    public void register() {

    }

    @Override
    public void notifyPeople() {
        // TODO Auto-generated method stub

    }
}


class MemberFactory {
    /**
     * creates a specific type of object based on certain conditions are called factory methods
     */
    public static Member createMember(MemberTypes type) {
        Member member = null;
        if (type == MemberTypes.LIFETIME) {
            member = new LifetimeMember();
        } else if (type == MemberTypes.ANNUAL) {
            member = new AnnualMember();
        } else if (type == MemberTypes.MONTHLY) {
            member = new MonthlyMember();
        }
        // 3 more conditionals would be added
        return member;
    }
}


class MembershipManager {
    /**
     * client of the factory
     */
    public Member createMembership(MemberTypes type) {
        Member member = MemberFactory.createMember(type);
        return member;
    }
}


public class Main {
    public static void main(String[] args) {
        NewyorkMembershipManager manager = new NewyorkMembershipManager();
        manager.createMembership("LIFETIME");
//        MembershipManager manager = new MembershipManager();
//        Member memberObj = manager.createMembership(MemberTypes.ANNUAL);
    }
}



abstract class AMembershipManager {
    public Member createMembership(String type) {
        Member m = createMember(type);
        m.register();
        m.notifyPeople();
        return m;
    }
    abstract Member createMember(String type);
}


class JapanMembershipManager extends AMembershipManager {
    Member createMember(String type) {
        Member m = null;
        if (type == "LIFETIME") {
            m = new NYLifetimeMember();
        } else if (type == "ANNUAL") {
            m = new NYAnnualMember();
        } else {
            m = new NYMonthlyMember();
        }
        return m;
    }
}

class NewyorkMembershipManager extends AMembershipManager {
    @Override
    Member createMember(String type) {
        Member m = null;
        if (type == "LIFETIME") {
            m = new NYLifetimeMember();
        } else if (type == "ANNUAL") {
            m = new NYAnnualMember();
        } else {
            m = new NYMonthlyMember();
        }
        return m;
    }
}


class NYLifetimeMember implements Member {
    public void register() {
        System.out.println("I am a ny life time member");
    }

    @Override
    public void notifyPeople() {
        System.out.println("I am notifed ");
    }
}

class NYAnnualMember implements Member {
    public void register() {

    }

    @Override
    public void notifyPeople() {
        // TODO Auto-generated method stub

    }
}

class NYMonthlyMember implements Member {
    public void register() {

    }

    @Override
    public void notifyPeople() {
        // TODO Auto-generated method stub

    }
}
