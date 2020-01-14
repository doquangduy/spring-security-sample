package com.spring.security.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_CODE", nullable = false, length = 100)
    private String userCode;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false, length = 500)
    private String password;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "USER_COMPANY_CODE", nullable = false, length = 100)
    private String userCompanyCode;
    @Column(name = "PHONE_NUMBER", nullable = false, length = 20)
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID") )
    private Set<RolesEntity> rolesEntities = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_PERMISSION", joinColumns = @JoinColumn(name = "USER_ID", updatable = false, insertable = false),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", updatable = false, insertable = false))
    private Set<PermissionsEntity> permissionsEntities = new HashSet<>();
}
