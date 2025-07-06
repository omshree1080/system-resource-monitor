package com.example.monitor.service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class SystemStatsService {
    private final SystemInfo systemInfo = new SystemInfo();

    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        OperatingSystem os = systemInfo.getOperatingSystem();
        FileSystem fs = os.getFileSystem();
        stats.put("cpu_load", processor.getSystemCpuLoadBetweenTicks() * 100);
        stats.put("memory_total_MB", memory.getTotal() / (1024 * 1024));
        stats.put("memory_available_MB", memory.getAvailable() / (1024 * 1024));
        long totalDisk = 0, usableDisk = 0;
        for (OSFileStore store : fs.getFileStores()) {
            totalDisk += store.getTotalSpace();
            usableDisk += store.getUsableSpace();
        }
        stats.put("disk_total_GB", totalDisk / (1024 * 1024 * 1024));
        stats.put("disk_free_GB", usableDisk / (1024 * 1024 * 1024));
        return stats;
    }
}
