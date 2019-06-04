package com.jaletechs.png.entities.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * Created by jaletechs on 2019-06-01.
 */
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @JoinTable(name = "user_authority", joinColumns = {
            @JoinColumn(name = "authority_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "email")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static Authority getUserRole() {
        Authority authority = new Authority();
        authority.setName(AuthorityName.ROLE_USER);
        authority.setId(1L);

        return authority;
    }
}