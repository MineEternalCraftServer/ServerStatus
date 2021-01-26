package server.mecs.serverstatus.bungee;

import net.md_5.bungee.api.plugin.Plugin;

import static server.mecs.serverstatus.bungee.database.MySQLManager.setupBlockingQueue;

public final class ServerStatus extends Plugin {

    @Override
    public void onEnable() {
        setupBlockingQueue(this, "Grafana Queue");
    }

    @Override
    public void onDisable() {
    }
}
