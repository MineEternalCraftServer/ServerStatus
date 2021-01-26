package server.mecs.serverstatus.bungee.usages;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class CPU {
    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public double getCPUusage() {
        return bean.getSystemCpuLoad() + bean.getProcessCpuLoad();
    }
}
