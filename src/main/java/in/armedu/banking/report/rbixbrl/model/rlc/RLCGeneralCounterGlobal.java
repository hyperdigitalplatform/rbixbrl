package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RLCGeneralCounterGlobal {
    
    private String amountOfFundedExposure;
    private String amountOfNonFundedExposure;
    private String aggregateCreditExposure;
    private String aggregateExposureAsPercentageOfCapitalFunds;
    
}
