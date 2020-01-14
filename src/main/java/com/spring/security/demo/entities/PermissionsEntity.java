package com.spring.security.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "PERMISSIONS")
public class PermissionsEntity implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false, length = 50)
    private String code;
    @Column(name = "PERMISSION_TYPE", nullable = false)
    private Integer permissionType;
    @Column(name = "DESCRIPTION", columnDefinition = "text")
    private String description;
    @Column(name = "DELETED", nullable = false)
    private Boolean deleted;
    @Column(name = "VERSION", nullable = false)
    private Integer version;
    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;
    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;
    @Column(name = "LAST_UPDATED_BY", nullable = false)
    private Long lastUpdatedBy;
    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private Timestamp lastUpdatedDate;


}
