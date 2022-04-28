package com.lin.pojo;

public class Role {
    public Integer roleID;
    public String roleName;
    public String permissions;

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Role(Integer roleID, String roleName, String permissions) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public Role() {
    }
}
