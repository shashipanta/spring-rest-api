package com.assesment.restapi.repo;

import com.assesment.restapi.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TenantRepo extends JpaRepository<Tenant, Integer> {

    // get all active tenants
    List<Tenant> findTenantByActive(Boolean activeStatus);

    // activate tenant
    @Modifying
    @Transactional
    @Query("update Tenant t set t.active = :status where t.id = :id")
    void toggleTenantStatusById(@Param("id") Integer tenantId, @Param("status") Boolean status);
}
