package Dto.Fichier;
import lombok.Data;

@Data
public class FichierDto {
    private Long id;
    private String nom;
    private String lien;
    private String format;
    private String capacite;
    private String hash;
}
