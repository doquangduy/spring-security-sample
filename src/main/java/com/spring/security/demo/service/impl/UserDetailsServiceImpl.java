package com.spring.security.demo.service.impl;

import com.spring.security.demo.entities.PermissionsEntity;
import com.spring.security.demo.entities.RolesEntity;
import com.spring.security.demo.entities.UsersEntity;
import com.spring.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User Name Not Found"));
        return buildUserForAuthentication(usersEntity);
    }
    private User buildUserForAuthentication( UsersEntity usersEntity) {
        Set<PermissionsEntity> permissionsEntities = usersEntity.getPermissionsEntities();
        Set<RolesEntity> rolesEntities = usersEntity.getRolesEntities();
        rolesEntities.forEach(rolesEntity -> permissionsEntities.addAll(rolesEntity.getPermissionsEntities()));
        Set<GrantedAuthority> grantedAuthorities = buildGrantedAuthority(permissionsEntities);
        return new User(usersEntity.getUsername(), usersEntity.getPassword(), true, true, true, true, grantedAuthorities );
    }

    private Set<GrantedAuthority> buildGrantedAuthority(Set<PermissionsEntity> permissionsEntities) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        permissionsEntities.forEach(permissionsEntity -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(permissionsEntity.getCode()));
        });
        return grantedAuthorities;
    }
}
