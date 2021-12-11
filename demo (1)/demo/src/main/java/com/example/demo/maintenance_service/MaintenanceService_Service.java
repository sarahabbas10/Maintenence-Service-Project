package com.example.demo.maintenance_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService_Service {

    private final MaintenanceServiceRepository maintenanceServiceRepository;

    @Autowired
    public MaintenanceService_Service(MaintenanceServiceRepository maintenanceServiceRepository) {
        this.maintenanceServiceRepository = maintenanceServiceRepository;
    }

    public List<MaintenanceService> getServices(){
        return maintenanceServiceRepository.findAll();
    }

    public MaintenanceService getService(String name){
        return maintenanceServiceRepository.findByName(name);
    }

    public MaintenanceService addService(MaintenanceService maintenanceService){
        return  maintenanceServiceRepository.save(maintenanceService);
    }

}
