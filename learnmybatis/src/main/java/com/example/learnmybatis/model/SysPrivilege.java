package com.example.learnmybatis.model;

public class SysPrivilege {

    /**
     * 权限ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String privilegeName;

    /**
     * 有效标志
     */
    private String privilegeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
