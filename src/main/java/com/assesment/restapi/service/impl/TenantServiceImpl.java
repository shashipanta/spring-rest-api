package com.assesment.restapi.service.impl;

import com.assesment.restapi.exceptions.TenantNotFoundException;
import com.assesment.restapi.model.Tenant;
import com.assesment.restapi.repo.TenantRepo;
import com.assesment.restapi.service.TenantService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepo tenantRepo;

    public TenantServiceImpl(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    @Override
    public Tenant registerTenant(Tenant tenant) {
        tenant.setJoinedDate(LocalDateTime.now());
        return tenantRepo.save(tenant);
    }

    @Override
    public List<Tenant> getAllTenant() {
        return tenantRepo.findAll();
    }

    @Override
    public Tenant findTenantById(Integer tenantId) {
        return tenantRepo.findById(tenantId).orElseThrow(TenantNotFoundException::new);
    }

    @Override
    public Tenant updateTenant(Tenant tenant) {
        tenant.setJoinedDate(LocalDateTime.now());
        return tenantRepo.save(tenant);
    }

    @Override
    public void removeTenantById(Integer tenantId) {
        // check if tenant exists by given id
        Tenant tenant = tenantRepo.findById(tenantId).orElseThrow(TenantNotFoundException::new);
        tenantRepo.delete(tenant);
    }

    @Override
    public List<Tenant> getActiveTenants() {
        List<Tenant> activeTenantList = tenantRepo.findTenantByActive(Boolean.TRUE);

        if(activeTenantList.size() == 0) {
            throw new TenantNotFoundException();
        }
        return activeTenantList;
    }

    @Override
    public Boolean activateTenantStatus(Integer tenantId) {
        tenantRepo.findById(tenantId).orElseThrow(TenantNotFoundException::new);

        tenantRepo.toggleTenantStatusById(tenantId, true);
        Boolean isActivated = tenantRepo.findById(tenantId).get().getActive();
        return isActivated;
    }

    @Override
    public Boolean deactivateTenantStatus(Integer tenantId) {
        // check if tenant exists with given id
        tenantRepo.findById(tenantId).orElseThrow(TenantNotFoundException::new);

        // if exists deactivate it
        tenantRepo.toggleTenantStatusById(tenantId, false);
        Boolean isDeactivated = tenantRepo.findById(tenantId).get().getActive();
        return isDeactivated;
    }
}
