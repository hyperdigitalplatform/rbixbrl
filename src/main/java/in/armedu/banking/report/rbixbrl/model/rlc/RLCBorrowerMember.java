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

// BorrowerGroupMember

public class RLCBorrowerMember extends ItemData{
    
    private String PermanentAccountNumberOfCustomerOrBorrower;
    private String CustomerName;
    private String SectorCode;
    private String BankingArrangement;
    private String InternalRating;
    private String ExternalRating;
    private String AssetClassificationRLC;
    private String LimitSanctionedForFundedExposure;
    private String AmountOutstandingForFundedExposure;
    private String AmountEligibleForNettingFromFundedExposure;
    private String AmountOfFundedExposure;
    private String LimitSanctionedForNonFundedExposure;
    private String AmountOutstandingForNonFundedExposure;
    private String AmountEligibleForNettingFromNonFundedExposure;
    private String AmountOfNonFundedExposure;
    private String AggregateLimitSanctioned;
    private String AggregateAmountOutstanding;
    private String AggregateCreditExposure;
    private String AggregateCreditExposureAsPercentageOfCapitalFunds;
    private String AggregateInvestmentExposure;
    private String AggregateExposureAsPercentageOfCapitalFunds;

    

}
