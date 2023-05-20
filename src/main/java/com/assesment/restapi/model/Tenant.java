package com.assesment.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tbl_tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenant_name", length = 100, nullable = false)
    private String name;

    @Column(name = "tenant_address", length = 100, nullable = false)
    private String address;

    private LocalDateTime joinedDate;

    @Column(name = "is_active", nullable = false)
    private Boolean active = true;

}
