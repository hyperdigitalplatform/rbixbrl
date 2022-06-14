package in.armedu.banking.report.rbixbrl.model.cem;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CEMItemData  extends ItemData {

    //item data for general context
    private String riskClassificationAxis;
    private String maturityPeriodAxis;
    private String countryCodeAxis;
    private String branchCodeAxis;
    private String exposureCountryCodeAxis;

    //item data for body
    private String amountOfCountryExposure;

    
}
