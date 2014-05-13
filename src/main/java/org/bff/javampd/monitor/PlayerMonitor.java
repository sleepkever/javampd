package org.bff.javampd.monitor;

import org.bff.javampd.events.PlayerBasicChangeListener;

public interface PlayerMonitor extends StatusMonitor {
    void addPlayerChangeListener(PlayerBasicChangeListener pcl);

    void removePlayerChangeListener(PlayerBasicChangeListener pcl);

    PlayerStatus getStatus();
}
