package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "security_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLDelete(sql = "UPDATE security_user SET data_exclusao = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("data_exclusao is null")
public class SecurityUser extends BaseEntity implements UserDetails {


    @OneToOne (cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(unique = true)
    private String username;

    @Column
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.pessoa.isAdmin()){
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}