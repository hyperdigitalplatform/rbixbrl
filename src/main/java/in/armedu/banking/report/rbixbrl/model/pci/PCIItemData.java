package in.armedu.banking.report.rbixbrl.model.pci;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PCIItemData  extends ItemData  {  
    
    //item data for general context
    private String customerCreditLimitAxis;
    private String typeOfProblemCreditAndInvestmentCustomerAxis;
    private String countryCodeAxis;
    private String branchCodeAxis;
    private String nameOfBorrowerAxis;
    private String borrowerGroupNameAxis;
    private String industryCodeAxis;
    private String nameOfIssuerAxis;
    private String issuerGroupNameAxis;

    //item data for body
    private String soverignCharacter;
    private String categoryOfBorrower;
    private String aggregateAmountOfLimitsSanctioned;
    private String amountOfFundedLimitsSanctioned;
    private String amountOfNonFundedLimitsSanctioned;
    private String amountOutstandingOfCustomerCreditLimitSenctioned;
    private String securityValue;
    private String assetsClassification;
    private String assetsClassificationHostCountry;
    private String amountOfProvisionsHeldAtBranch;
    private String amountOfProvisionsHeldAtHeadOffice;
    private String amountOfInterestSuspense;
    private String aggregateAmountOfProvisionAndInterestSuspense;
    private String amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities;
    private String amountOfShortFall;
    private String amountOfHeadOfficeSupportFund;
    private String developmentsDuringQuarter;

}
