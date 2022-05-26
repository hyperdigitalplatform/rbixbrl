package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//CounterPartyBankMember

public class RLCCounterBankMember{
    
    private String aggregateExposureAsPercentageOfCapitalFunds;
    private String amountOfFundedExposure;
    private String amountOfNonFundedExposure;
    private String aggregateCreditExposure;
    
}
