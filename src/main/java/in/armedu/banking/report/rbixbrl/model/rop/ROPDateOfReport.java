package in.armedu.banking.report.rbixbrl.model.rop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ROPDateOfReport {
    
    //item data for general context
    private String countryCodeAxis;
    private String branchCodeAxis;

    //item data for body
    private String interestIncome;
    private String interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits;
    private String interestOnLoansAndAdvancesNonBank;
    private String interestOnGovernmentSecurities;
    private String interestOnOtherInvestments;
    private String interestIncomeOnOtherInterestBearingAssets;
    private String interestExpenses;
    private String interestExpensesOnCustomerDeposits;
    private String interestExpensesOnInterBranchAndInterBankBorrowings;
    private String otherInterestExpended;
    private String netInterestIncome;
    private String otherIncome;
    private String otherFeeIncome;
    private String profitLossOnForexTrading;
    private String profitLossOnSecuritiesTrading;
    private String miscellaneousIncome;
    private String grossIncome;
    private String staffExpenses;
    private String otherExpenses;
    private String aggregateExpenses;
    private String operatingSurplusDeficit;
    private String badDebtsWrittenoff;
    private String extraordinaryLossAndOtherWriteOff;
    private String headOfficeAdministrationCharges;
    private String provisionOtherThanTax;
    private String profitLossBeforeTax;
    private String netPovisionOfTaxes;
    private String netProfitLossForPeriod;
    private String remittanceToHeadOfficeExpenses;
    private String remittanceToHeadOfficeProfit;
    private String remittanceToHeadOfficeOthers;
    private String businessesPerEmployee;
    private String profitPerEmployee;
    private String averageYieldOnInterestEarningAssets;
    private String costOfFundsAveragePercentage;
    private String returnsOnAssets;
    private String interestSpreadInReturnOnProfitability;

}
