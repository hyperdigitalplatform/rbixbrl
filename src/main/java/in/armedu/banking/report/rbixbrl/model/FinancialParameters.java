package in.armedu.banking.report.rbixbrl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FinancialParameters {
    private String totalAssets;
    private String capitalFunds;
    private String minPrescribedCapital;
    private String minPrescribedCapitalPercentage;
    private String capitalAdequacyRatio;
    private String notionalCapitalFunds;
    private String riskWeightedAssets;
    private String notionalCapitalAdequacyRatio;
    private String capitalAndReservesAsInTheBalanceSheet;
    private String totalDeposits;
    private String totalBorrowings;
    private String profitBeforeTax;
    private String profitAfterTaxOrReturn;
    private String surplusOrLossOnProfitAndLossACCarriedForward;
    private String returnOnAssets;
    private String returnOnEquity;
    private String totalDividendsPaid;
    private String loansAndAdvancesGross;
    private String nonPerformingLoansGross;
    private String provisionsHeldAgainstNonPerformingLoans;
    private String provisionsRequiredAgainstNonPerformingLoans;
    private String totalInvestmentBookValue;
    private String totalInvestmentMarketValue;
    private String nonPerformingInvestments;
    private String provisionsHeldAgainstNonPerformingInvestments;
    private String provisionsRequiredAgainstNonPerformingInvestments;
    private String contingentLiabilitiesOrOffBalanceSheetExposures;
}
