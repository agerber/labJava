package edu.uchicago.gerber.labjava.lec06.patterns.bridge.example.remotes;

import edu.uchicago.gerber.labjava.lec06.patterns.bridge.example.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
