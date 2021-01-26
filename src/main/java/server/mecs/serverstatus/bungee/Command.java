package server.mecs.serverstatus.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import server.mecs.serverstatus.bungee.usages.CPU;
import server.mecs.serverstatus.bungee.usages.Memory;
import server.mecs.serverstatus.bungee.usages.Process;

import static server.mecs.serverstatus.bungee.database.MySQLManager.executeQueue;

public class Command extends net.md_5.bungee.api.plugin.Command {

    private static boolean isEnabled = false;
    private static CPU cpu = new CPU();
    private static Memory mem = new Memory();
    private static Process process = new Process();

    public Command() {
        super("startrecordingbungee");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender.hasPermission("server.status"))) {
            sender.sendMessage(new ComponentBuilder("§cYou are not allowed to use this command.").create());
            return;
        }

        isEnabled = true;

        new Thread(() -> {
            while (isEnabled) {
                try {
                    Thread.sleep(1000);

                    String query = "INSERT INTO vps_usage (cpu_usage,memory_usage,process_time) " +
                            "VALUES (" + cpu.getCPUusage() + "," + mem.getMEMORYusage() + "," + process.getProcessTime() + ");";

                    executeQueue(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
