package com.example.demo.serviceType;

import com.example.demo.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping(path="serviceType")
@CrossOrigin("*")
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping
    public List<ServiceType> getServiceType() {
        return serviceTypeService.getAllServiceType();
    }

    @PostMapping
    public ServiceType addServiceType(@RequestBody Form form){
        return serviceTypeService.addServiceType(form.getServiceType());
    }

}

class Form{
    private ServiceType serviceType;
    private Long idMaintenanceService;
    public Long getIdMaintenanceService() {return idMaintenanceService;}
    public ServiceType getServiceType(){return serviceType;}
}