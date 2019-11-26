package com.toshiba.assetmgmtapp.model;

public class Organization {
    private final long organizationId;
    private final String name;
    private final String location;

    public Organization(long organizationId, String name, String location) {
        this.organizationId = organizationId;
        this.name = name;
        this.location = location;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}