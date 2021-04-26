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
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhone1(phone1);
        this.setPhone2(phone2);
        this.setEmail(email);
        this.setWebsite(website);
        this.setTaxNumber(taxNumber);
        this.setDescription(description);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        this.setDeletedAt(deletedAt);
        this.setCreatedBy(createdBy);
        this.setIsDeleted(isDeleted);
        this.setUpdatedBy(updatedBy);
        this.setDeletedBy(deletedBy);
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
        this.setName(name);
        this.setAddress(address);
        this.setPhone1(phone1);
        this.setPhone2(phone2);
        this.setEmail(email);
        this.setWebsite(website);
        this.setTaxNumber(taxNumber);
        this.setDescription(description);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        this.setDeletedAt(deletedAt);
        this.setCreatedBy(createdBy);
        this.setIsDeleted(isDeleted);
        this.setUpdatedBy(updatedBy);
        this.setDeletedBy(deletedBy);
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

    
}
