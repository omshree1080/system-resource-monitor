package com.example.monitor.controller;
import com.example.monitor.service.SystemStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ResourceController {
    private final SystemStatsService service;
    public ResourceController(SystemStatsService service) {
        this.service = service;
    }
    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        return service.getStats();
    }
}
