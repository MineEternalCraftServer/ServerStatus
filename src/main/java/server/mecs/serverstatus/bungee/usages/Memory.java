package server.mecs.serverstatus.bungee.usages;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class Memory {
    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public long getMEMORYusage() {
        return bean.getTotalPhysicalMemorySize() - bean.getFreePhysicalMemorySize();
    }

    public long getFreeMEMORY() {
        return bean.getFreePhysicalMemorySize();
    }
}

