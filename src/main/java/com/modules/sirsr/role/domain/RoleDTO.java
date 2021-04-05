/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.role.domain;

import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */

public class RoleDTO {
    
    private int noRole;
    private String roleName;
    private boolean selected;

    public int getNoRole() {
        return noRole;
    }

    public void setNoRole(int noRole) {
        this.noRole = noRole;
    }

    public String getRoleName() {
        return Objects.nonNull(roleName) ? roleName.toUpperCase() : roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
