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

// Ou fè anpil travay.
// sou wè sa ki gen pou fèt yo men ou pa utiliser zouti ki pou aleje kòd la.
// gen 2 fason ou ka structurer kòd la:
// 1: izole chak kopozan; pa egzanp jan ou fèl la: kreye yon folder Institution epi
// 	mete tout sa wap bezwen ladan l (plusieurs fichiers .java)
// 2: regrouper tout konpozan ki sable yo: kreye yon folder Controllers ki gen tout controller projet a,
// kreye yon folder Entities ki gen tout entity projet a, etc.
// PA GEN YON METÒD KI PI BON KE LÒT.

// Men etant donné ke m mte kite yon example pou ou ak metòd 2 a,
// kote mwen te kreye API pou type de test yo (TestType), ou ka kontinye
// ak stucture 2 a.

// ETAP:
// 1. kreye yon fichier Intitution.java nan folder Entities la (suiv example TestType.java la)
// 2. kreye yon fichier IntitutionRepository.java nan folder Repositories la (suiv example TestTypeRepository.java la)
// 3. kreye yon fichier IntitutionService.java nan folder Services la (suiv example TestTypeServices.java la)
// 4. kreye yon fichier IntitutionController.java nan folder Controllers la (suiv example TestType.java la)
// 5. kreye yon fichier InstitutionRepositoryController.java nan folder test/java/com/example/gtm la (suiv example TestTypeRepositoryController.java la)
// 	sa ap pèmèt ou test yon fonction nan controller a.Nou fè sa paske lè test la pral fèt
// 	table yo ap tou jenere nan BD a san ou pa bezwen fè anyen.
// 	NB: lè ou pral run test la :
// 	ale nan application.properties epi:
// 	retire 
// 	spring.jpa.hibernate.ddl-auto=none
// 	mete
// 	spring.jpa.hibernate.ddl-auto=create
// 	lè ou fin run test la, remetel
// 	spring.jpa.hibernate.ddl-auto=none
// 6. enstale Postman sou PC ou pou ou ka test API ou sot kreye a