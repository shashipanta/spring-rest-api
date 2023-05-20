package com.assesment.restapi.controller;

import com.assesment.restapi.model.Tenant;
import com.assesment.restapi.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping
    public ResponseEntity<Tenant> registerTenant(@RequestBody Tenant tenant) {
        Tenant savedTenant = tenantService.registerTenant(tenant);
        return ResponseEntity.ok(savedTenant);
    }

    // http://localhost:8080/api/tenants/
    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenant() {
        List<Tenant> tenantList = tenantService.getAllTenant();
        return ResponseEntity.status(HttpStatus.OK).body(tenantList);
    }

    // http://localhost:8080/api/tenants/1
    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getSingleTenant(@PathVariable("id") Integer tenantId) {
        return ResponseEntity.ok(tenantService.findTenantById(tenantId));
    }

    // http://localhost:8080/api/tenants/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable("id") Integer tenantId, @RequestBody Tenant tenant){
        Tenant updatedTenant = tenantService.updateTenant(tenant);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedTenant);
    }

    // http://localhost:8080/api/tenants/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTenant(@PathVariable("id") Integer tenantId) {
        tenantService.removeTenantById(tenantId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // http://localhost:8080/api/tenants/active
    @GetMapping("/active")
    public ResponseEntity<List<Tenant>> getActiveTenants(){
        return ResponseEntity.ok(tenantService.getActiveTenants());
    }

    // http://localhost:8080/api/tenants/{id}/activate
    @PutMapping("/{id}/activate")
    public ResponseEntity activateTenantStatus(@PathVariable("id") Integer tenantId) {
        Boolean isActivated = tenantService.activateTenantStatus(tenantId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // http://localhost:8080/api/tenants/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity deactivateTenantStatus(@PathVariable("id") Integer tenantId) {
        tenantService.deactivateTenantStatus(tenantId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
