package in.armedu.banking.report.rbixbrl.model.cpr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CRRAndSLR {
    private String cashFundEligibleForCRR;
    private String liquidAssetsEligibleForSLR;
    private String percCRR;
    private String percSLR;

}
