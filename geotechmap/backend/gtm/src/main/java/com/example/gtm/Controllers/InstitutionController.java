import java.util.List;

import com.example.gtm.institution.Institution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/institution")

public class InstitutionController {
    @GetMapping
    public List<Institution> getInstitutions(){
        return List.of(
            new Institution(
                1,
                "LNBTP",
                "Delmas 33",
                "37894562",
                "32145698",
                "infos@lnbtp.ht",
                "www.lnbtp.org",
                "0052356987",
                "Laboratoine National Machin Chose",
            )
        )
    }
}
