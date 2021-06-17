package Dto.TypeEssai;
import java.util.List;
import com.example.gtm.Entities.Essai;
import lombok.Data;

@Data
public class TypeEssaiDto {
    private Long id;
    private String nom;
    private String sigle;
    private String description;
    private List<Essai> essais;
}
