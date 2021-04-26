package com.example.gtm.institution;

public class Institution {
    private Long id;
    private String name;
    private String address;
    private String phone1;
    private String phone2;
    private String email;
    private String website;
    private String taxNumber;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String createdBy;
    private String isDeleted;
    private String updatedBy;
    private String deletedBy;

    public Institution() {
    }

    public Institution( Long id, 
                        String name, 
                        String address, 
                        String phone1, 
                        String phone2, 
                        String email, 
                        String website,
                        String taxNumber, 
                        String description, 
                        String createdAt, 
                        String updatedAt, 
                        String deletedAt,
                        String createdBy, 
                        String isDeleted, 
                        String updatedBy, 
                        String deletedBy) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.website = website;
        this.taxNumber = taxNumber;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
        this.updatedBy = updatedBy;
        this.deletedBy = deletedBy;
    }
    
    public Institution( String name, 
                        String address, 
                        String phone1, 
                        String phone2, 
                        String email, 
                        String website,
                        String taxNumber, 
                        String description, 
                        String createdAt, 
                        String updatedAt, 
                        String deletedAt,
                        String createdBy, 
                        String isDeleted, 
                        String updatedBy, 
                        String deletedBy) {
        this.name = name;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.website = website;
        this.taxNumber = taxNumber;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
        this.updatedBy = updatedBy;
        this.deletedBy = deletedBy;
    }
}
