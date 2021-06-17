package Dto.Institution;
import lombok.Data;

@Data
public class InstitutionDto {
    private Long id;
    private String nom;
    private String sigle;
    private String adresse;
    private String telephone1;
    private String telephone2;
    private String email;
    private String siteWeb;
    private String numeroFiscal;
    private String description;

}
