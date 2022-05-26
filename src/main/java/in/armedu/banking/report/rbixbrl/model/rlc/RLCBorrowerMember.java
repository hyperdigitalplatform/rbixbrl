package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

// BorrowerGroupMember

public class RLCBorrowerMember{
    
    private String permanentAccountNumberOfCustomerOrBorrower;
    private String customerName;
    private String sectorCode;
    private String bankingArrangement;
    private String internalRating;
    private String externalRating;
    private String assetClassificationRLC;
    private String limitSanctionedForFundedExposure;
    private String amountOutstandingForFundedExposure;
    private String amountEligibleForNettingFromFundedExposure;
    private String amountOfFundedExposure;
    private String limitSanctionedForNonFundedExposure;
    private String amountOutstandingForNonFundedExposure;
    private String amountEligibleForNettingFromNonFundedExposure;
    private String amountOfNonFundedExposure;
    private String aggregateLimitSanctioned;
    private String aggregateAmountOutstanding;
    private String aggregateCreditExposure;
    private String aggregateCreditExposureAsPercentageOfCapitalFunds;
    private String aggregateInvestmentExposure;
    private String aggregateExposureAsPercentageOfCapitalFunds;

    

}
