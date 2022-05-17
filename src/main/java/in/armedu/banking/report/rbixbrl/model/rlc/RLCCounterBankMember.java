package in.armedu.banking.report.rbixbrl.model.rlc;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//CounterPartyBankMember

public class RLCCounterBankMember extends ItemData{
    
    private String AggregateExposureAsPercentageOfCapitalFunds;
    private String AmountOfFundedExposure;
    private String AmountOfNonFundedExposure;
    private String AggregateCreditExposure;
    
}
