package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MemoryController {

    @GetMapping("/memory")
    public Map<String, Object> getMemoryUsage() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        Map<String, Object> memoryUsage = new HashMap<>();
        memoryUsage.put("heapInitMB", bytesToMegabytes(heapMemoryUsage.getInit()));
        memoryUsage.put("heapUsedMB", bytesToMegabytes(heapMemoryUsage.getUsed()));
        memoryUsage.put("heapCommittedMB", bytesToMegabytes(heapMemoryUsage.getCommitted()));
        memoryUsage.put("heapMaxMB", bytesToMegabytes(heapMemoryUsage.getMax()));
        memoryUsage.put("nonHeapInitMB", bytesToMegabytes(nonHeapMemoryUsage.getInit()));
        memoryUsage.put("nonHeapUsedMB", bytesToMegabytes(nonHeapMemoryUsage.getUsed()));
        memoryUsage.put("nonHeapCommittedMB", bytesToMegabytes(nonHeapMemoryUsage.getCommitted()));
        memoryUsage.put("nonHeapMaxMB", bytesToMegabytes(nonHeapMemoryUsage.getMax()));

        return memoryUsage;
    }

    private long bytesToMegabytes(long bytes) {
        return bytes / (1024 * 1024);
    }
}
