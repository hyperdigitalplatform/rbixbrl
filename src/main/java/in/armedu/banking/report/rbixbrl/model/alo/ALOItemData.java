package in.armedu.banking.report.rbixbrl.model.alo;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ALOItemData extends ItemData{
    

    // private String detailsOfAccountsWithBranchesAxis;
    // private String periodOfPendingReconcilliationAxis;
    private String countryCodeAxis;
    private String branchCodeAxis;

    //Item Data for General Body
    private String cashAndBalancesWithCentralBanks;
    private String investmentsInSecurities;
    private String investmentsInLocalGovernments;
    private String investmentsInIndia;
    private String investmentsInOECDCountries;
    private String otherInvestments;
    private String interBranchPlacementsOrDeposits;
    private String interBranchPlacementsOrDepositsWithBranchesInSameForeignCentre;
    private String interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre;
    private String interBranchPlacementsOrDepositsWithIndiaBranches;
    private String interBankPlacementsOrDeposits;
    private String interBankPlacementsOrDepositsInCurrentAccounts;
    private String interBankPlacementsInOtherDeposits;
    private String grossCustomerCredit;
    private String loansOrOverdrafts;
    private String loansAgainstDepositsOrSecuritiesHeldIn;
    private String loansAgainstLCOrLOCByHeadOffice;
    private String loansToIndianPSU;
    private String shortTermFacilitiesByBank;
    private String bankerAcceptanceFacilities;
    private String syndicatedLoans;
    private String otherLoansToIndianPSU;
    private String otherIndiaRelatedFundedExposures;
    private String sovereignLoans;
    private String loansToProblemCountries;
    private String otherSovereignLoans;
    private String realEstateExposures;
    private String commercialLoans;
    private String otherLoans;
    private String billsPurchasedAndDiscounted;
    private String nettingItems;
    private String provisions;
    private String interestSuspense;
    private String netCustomerCredit;
    private String accumulatedLosses;
    private String otherAssets;
    private String aggregateAssets;
    private String headOfficeFunds;
    private String assignedCapital;
    private String supportFunds;
    private String earningsRetained;
    private String otherFunds;
    private String customerDeposits;
    private String customerDepositsInCurrentAccounts;
    private String customerDepositsInOtherAccounts;
    private String interBranchBorrowingsOrDeposits;
    private String interBranchBorrowingsOrDepositsWithBranchesInSameForeign;
    private String interBranchBorrowingsOrDepositswithBranchesInOtherForeign;
    private String interBranchBorrowingsOrDepositsWithIndiaBranches;
    private String interBankBorrowings;
    private String interBankBorrowingsInCurrentAccount;
    private String interBankBorrowingsInOtherDeposits;
    private String otherDebtInstruments;
    private String otherLiabilities;
    private String generalProvision;
    private String miscellaneousLiabilities;
    private String aggregateLiabilities;
    private String aggregateCapital;
    private String aggregateForwardRateAgreements;
    private String swaps;
    private String futures;
    private String options;
    private String otherProducts;
    private String aggregateOtherProducts;
    private String netGap;
    private String cumulativeGap;
    private String netGapAsPercentageOfAggregateAssets;

    
    private String debitNumberOfEntriesInAccount;
    private String debitAmountOfEntriesInAccount;
    private String creditNumberOfEntriesInAccount;
    private String creditAmountOfEntriesInAccount;


}
