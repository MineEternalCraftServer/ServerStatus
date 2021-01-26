package server.mecs.serverstatus.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import static server.mecs.serverstatus.bungee.database.MySQLManager.setupBlockingQueue;

public final class ServerStatus extends Plugin {

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command());

        setupBlockingQueue(this, "Grafana Queue");

        ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "startrecordingbungee");
    }

    @Override
    public void onDisable() {
    }
}
