package com.example.demo.serviceType;

import com.example.demo.maintenance_service.MaintenanceService;
import com.example.demo.maintenance_service.MaintenanceServiceRepository;
import com.example.demo.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeService {
    private final ServiceTypeRepository serviceTypeRepository;
    private final MaintenanceServiceRepository maintenanceServiceRepository;

    @Autowired
    public ServiceTypeService(ServiceTypeRepository serviceTypeRepository, MaintenanceServiceRepository maintenanceServiceRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.maintenanceServiceRepository = maintenanceServiceRepository;
    }

    public List<ServiceType> getAllServiceType(){
        return serviceTypeRepository.findAll();
    }


    public ServiceType addServiceType(ServiceType serviceType){

        return serviceTypeRepository.save(serviceType);

    }

}
