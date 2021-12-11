package com.example.demo.maintenance_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="maintenanceService")
@CrossOrigin("*")
public class MaintenanceServiceController {

    private final MaintenanceService_Service maintenanceService_service;

    @Autowired
    public MaintenanceServiceController(MaintenanceService_Service maintenanceService_service) {
        this.maintenanceService_service = maintenanceService_service;
    }

    @GetMapping
    public List<MaintenanceService> getServices(){
        return maintenanceService_service.getServices();
    }

    @GetMapping("/{name}")
    public MaintenanceService getService(@PathVariable String name){
        return maintenanceService_service.getService(name);
    }

    @PostMapping("/post")
    public MaintenanceService addService(@RequestBody MaintenanceService maintenanceService){
        return maintenanceService_service.addService(maintenanceService);
    }


}
