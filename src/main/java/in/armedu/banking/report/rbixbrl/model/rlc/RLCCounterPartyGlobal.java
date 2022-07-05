package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//RLC Items fields RLCCounterPartyGlobal

public class RLCCounterPartyGlobal {
 
    // Item fields for general context
    // private String largeCreditAxis;
    // private String regionOfBusinessAxis;
    private String counterPartyBankNameAxis;
    private String counterPartyBankDomicileAxis;
    private String uniqueTransactionCodeAxis;

    //Item fields for body
    private String amountOfFundedExposure;
    private String amountOfNonFundedExposure;
    private String aggregateCreditExposure;
    private String aggregateExposureAsPercentageOfCapitalFunds;

}
