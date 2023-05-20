package com.assesment.restapi.service;

import com.assesment.restapi.model.Tenant;

import java.util.List;

public interface TenantService {

    Tenant registerTenant(Tenant tenant);

    List<Tenant> getAllTenant();

    Tenant findTenantById(Integer tenantId);

    Tenant updateTenant(Tenant tenant);

    void removeTenantById(Integer tenantId);

    List<Tenant> getActiveTenants();

    Boolean activateTenantStatus(Integer tenantId);

    Boolean deactivateTenantStatus(Integer tenantId);

}
