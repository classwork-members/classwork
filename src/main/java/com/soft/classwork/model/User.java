package com.soft.classwork.model;

import java.util.List;

public class User  {

  private String userid;
  private String password;
  private String username;
  private long isAuthority;
  private List<Role> roles;


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getIsAuthority() {
    return isAuthority;
  }

  public void setIsAuthority(long isAuthority) {
    this.isAuthority = isAuthority;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

//  @JsonIgnore
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    List<GrantedAuthority> authorities = new ArrayList<>();
//    for (Role role : this.getRoles()) {
//      authorities.add(new SimpleGrantedAuthority(role.getRolename()));
//    }
//    return authorities;
//  }
//
//  @JsonIgnore
//  @Override
  public String getPassword() {
    return this.password;
  }

//  @Override
  public String getUsername() {
    return this.username;
  }
//
//  @JsonIgnore
//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
//  @JsonIgnore
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @JsonIgnore
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return true;
//  }

}
