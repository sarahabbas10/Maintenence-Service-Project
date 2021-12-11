package com.example.demo.Request;

import com.example.demo.serviceType.ServiceType;
import com.example.demo.serviceType.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="request")
@CrossOrigin("*")
public class RequestController {
    private final RequestService requestService;

private final RequestRepository requestRepository;

private final ServiceTypeRepository serviceTypeRepository;
    @Autowired
    public RequestController(RequestService requestService, RequestRepository requestRepository, ServiceTypeRepository serviceTypeRepository) {
        this.requestService = requestService;
        this.requestRepository = requestRepository;
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @GetMapping
    public List<Request> getRequests(){
        return requestService.getRequests();
    }


    @GetMapping("/{idRequest}")
    public Request getRequest(@PathVariable String idRequest){
        return requestService.getRequest(idRequest);
    }

    @PostMapping
    public Request addRequest(@RequestBody Form form){
        return requestService.addRequest(form.getRequest(),form.getIdCustomer());
    }

    @PostMapping("/re/{idRequest}/service/{idServiceType}")
    Request enrollServiceToRequest(
            @PathVariable Long idRequest,
           @PathVariable Long idServiceType
    ){
        Request request=requestRepository.findById(idRequest).get();
        ServiceType serviceType=serviceTypeRepository.findById(idServiceType).get();
        request.enrollService(serviceType);
        return requestRepository.save(request);

    }




}

class Form{
    private Request request;
    private Long idCustomer;
      public Request getRequest(){return request;}
    public Long getIdCustomer(){return idCustomer;}

}