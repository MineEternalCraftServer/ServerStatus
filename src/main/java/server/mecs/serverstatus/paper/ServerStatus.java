package server.mecs.serverstatus.paper;

import org.bukkit.plugin.java.JavaPlugin;

import static server.mecs.serverstatus.paper.database.MySQLManager.setupBlockingQueue;

public final class ServerStatus extends JavaPlugin {

    @Override
    public void onEnable() {
        setupBlockingQueue(this, "Grafana Queue");
    }

    @Override
    public void onDisable() {
    }
}
