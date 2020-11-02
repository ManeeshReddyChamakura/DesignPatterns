package com.structuralpatterns.bridge;

// The "implementation" interface declares methods common to all
// concrete implementation classes. It doesn't have to match the
// abstraction's interface. In fact, the two interfaces can be
// entirely different. Typically the implementation interface
// provides only primitive operations, while the abstraction
// defines higher-level operations based on those primitives.
interface Device {
    public boolean isEnabled();
    public void enable();
    public void disable();
    public int getVolume();
    public void setVolume(int vol);
    public void setChannel(int channel);
    public int getChannel();
}

class Tv implements Device{
    int channel;
    int volume;
    boolean enabled;


    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return enabled;
    }

    @Override
    public void enable() {
        // TODO Auto-generated method stub

    }

    @Override
    public void disable() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getVolume() {
        // TODO Auto-generated method stub
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        // TODO Auto-generated method stub
        this.volume = vol;
    }

    @Override
    public void setChannel(int channel) {
        // TODO Auto-generated method stub
        this.channel = channel;
    }

    @Override
    public int getChannel() {
        // TODO Auto-generated method stub
        return channel;
    }

}

class Radio extends Tv {

}

// The "abstraction" defines the interface for the "control"
// part of the two class hierarchies. It maintains a reference
// to an object of the "implementation" hierarchy and delegates
// all of the real work to this object.
class Remote {
    protected Device device;

    Remote(Device device) {
        this.device = device;
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 1);
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 1);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() + 1);
    }

}

class AdvancedRemote extends Remote {
    AdvancedRemote(Device d) {
        super(d);
    }
    public void mute() {
        device.setVolume(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Device tv = new Tv();
        Remote remote = new Remote(tv);
        remote.channelUp();
        remote.channelUp();
        System.out.println(remote.device.getChannel());
        AdvancedRemote radioremote = new AdvancedRemote(new Radio());
        radioremote.mute();
        System.out.println(radioremote.device.getVolume());
    }
}
