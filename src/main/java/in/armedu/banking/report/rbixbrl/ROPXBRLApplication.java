package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.rop.ROPGeneralData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPReportData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPReportingPeriod;
import in.armedu.banking.report.rbixbrl.model.rop.ROPDateOfReport;

public class ROPXBRLApplication {

    public static void main(String[] args) throws Exception {
    ROPReportData data = new ROPReportData();

    ROPGeneralData ropGeneralData = new ROPGeneralData();
    ropGeneralData.setReturnName("Report on profitability");
    ropGeneralData.setReturnCode("ROP");
    ropGeneralData.setNameOfReportingInstitution("Kookmin Bank");
    ropGeneralData.setBankCode("00A");
    ropGeneralData.setAddress("dfgg");
    ropGeneralData.setDateOfQuarterEnded("2018-09-30");
    ropGeneralData.setReportingFrequency("Quarterly");
    ropGeneralData.setDateOfReport("2019-08-01");
    ropGeneralData.setReportStatus("Audited");
    ropGeneralData.setDateOfAudit("2019-08-05");
    ropGeneralData.setValidationStatus("Validated");
    ropGeneralData.setReturnVersion("V1.2");
    ropGeneralData.setGeneralRemarks("fdfdsfsdfsdfdsf");
    ropGeneralData.setReportingPeriodStartDate("2018-07-01");

    data.setGeneralData(ropGeneralData);


    // ROP Item

    ROPItemData ropItemData = new ROPItemData();

    ROPReportingPeriod ropReportingPeriodData = new ROPReportingPeriod();

    //Item Data for General Context
    ropReportingPeriodData.setCountryCodeAxis("IN");
    ropReportingPeriodData.setBranchCodeAxis("592");

    //item data for body
    ropReportingPeriodData.setInterestIncome("40910000");
    ropReportingPeriodData.setInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits("1120000");
    ropReportingPeriodData.setInterestOnLoansAndAdvancesNonBank("2320000");
    ropReportingPeriodData.setInterestOnGovernmentSecurities("3500000");
    ropReportingPeriodData.setInterestOnOtherInvestments("21630000");
    ropReportingPeriodData.setInterestIncomeOnOtherInterestBearingAssets("12340000");
    ropReportingPeriodData.setInterestExpenses("77300000");
    ropReportingPeriodData.setInterestExpensesOnCustomerDeposits("54300000");
    ropReportingPeriodData.setInterestExpensesOnInterBranchAndInterBankBorrowings("2000000");
    ropReportingPeriodData.setOtherInterestExpended("21000000");
    ropReportingPeriodData.setNetInterestIncome("-36390000");
    ropReportingPeriodData.setOtherIncome("78210000");
    ropReportingPeriodData.setOtherFeeIncome("34000000");
    ropReportingPeriodData.setProfitLossOnForexTrading("9990000");
    ropReportingPeriodData.setProfitLossOnSecuritiesTrading("21000000");
    ropReportingPeriodData.setMiscellaneousIncome("13220000");
    ropReportingPeriodData.setGrossIncome("41820000");
    ropReportingPeriodData.setStaffExpenses("32340000");
    ropReportingPeriodData.setOtherExpenses("32460000");
    ropReportingPeriodData.setAggregateExpenses("64800000");
    ropReportingPeriodData.setOperatingSurplusDeficit("-22980000");
    ropReportingPeriodData.setBadDebtsWrittenoff("43350000");
    ropReportingPeriodData.setExtraordinaryLossAndOtherWriteOff("43760000");
    ropReportingPeriodData.setHeadOfficeAdministrationCharges("23870000");
    ropReportingPeriodData.setProvisionOtherThanTax("54770000");
    ropReportingPeriodData.setProfitLossBeforeTax("-188730000");
    ropReportingPeriodData.setNetPovisionOfTaxes("4430000");
    ropReportingPeriodData.setNetProfitLossForPeriod("-193160000");
    ropReportingPeriodData.setRemittanceToHeadOfficeExpenses("54560000");
    ropReportingPeriodData.setRemittanceToHeadOfficeProfit("56640000");
    ropReportingPeriodData.setRemittanceToHeadOfficeOthers("56870000");
    ropReportingPeriodData.setBusinessesPerEmployee("35");
    ropReportingPeriodData.setProfitPerEmployee("35");
    ropReportingPeriodData.setAverageYieldOnInterestEarningAssets("6.78");
    ropReportingPeriodData.setCostOfFundsAveragePercentage("56.76");
    ropReportingPeriodData.setReturnsOnAssets("45.44");
    ropReportingPeriodData.setInterestSpreadInReturnOnProfitability("23.34");
    ropItemData.setRopReportingPeriod(ropReportingPeriodData);


    ROPDateOfReport ropDateOfReportData = new ROPDateOfReport();

    //Item Data for General Context
    ropDateOfReportData.setCountryCodeAxis("IN");
    ropDateOfReportData.setBranchCodeAxis("592");

    //item data for body
    ropDateOfReportData.setInterestIncome("121290000");
    ropDateOfReportData.setInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits("54300000");
    ropDateOfReportData.setInterestOnLoansAndAdvancesNonBank("2000000");
    ropDateOfReportData.setInterestOnGovernmentSecurities("21000000");
    ropDateOfReportData.setInterestOnOtherInvestments("34000000");
    ropDateOfReportData.setInterestIncomeOnOtherInterestBearingAssets("9990000");
    ropDateOfReportData.setInterestExpenses("55850000");
    ropDateOfReportData.setInterestExpensesOnCustomerDeposits("21000000");
    ropDateOfReportData.setInterestExpensesOnInterBranchAndInterBankBorrowings("13220000");
    ropDateOfReportData.setOtherInterestExpended("21630000");
    ropDateOfReportData.setNetInterestIncome("65440000");
    ropDateOfReportData.setOtherIncome("165750000");
    ropDateOfReportData.setOtherFeeIncome("43350000");
    ropDateOfReportData.setProfitLossOnForexTrading("43760000");
    ropDateOfReportData.setProfitLossOnSecuritiesTrading("23870000");
    ropDateOfReportData.setMiscellaneousIncome("54770000");
    ropDateOfReportData.setGrossIncome("231190000");
    ropDateOfReportData.setStaffExpenses("2000000");
    ropDateOfReportData.setOtherExpenses("21000000");
    ropDateOfReportData.setAggregateExpenses("23000000");
    ropDateOfReportData.setOperatingSurplusDeficit("208190000");
    ropDateOfReportData.setBadDebtsWrittenoff("54560000");
    ropDateOfReportData.setExtraordinaryLossAndOtherWriteOff("56640000");
    ropDateOfReportData.setHeadOfficeAdministrationCharges("56870000");
    ropDateOfReportData.setProvisionOtherThanTax("35000000");
    ropDateOfReportData.setProfitLossBeforeTax("5120000");
    ropDateOfReportData.setNetPovisionOfTaxes("7770000");
    ropDateOfReportData.setNetProfitLossForPeriod("-2650000");
    ropDateOfReportData.setRemittanceToHeadOfficeExpenses("2320000");
    ropDateOfReportData.setRemittanceToHeadOfficeProfit("3440000");
    ropDateOfReportData.setRemittanceToHeadOfficeOthers("21630000");
    ropDateOfReportData.setBusinessesPerEmployee("12.34");
    ropDateOfReportData.setProfitPerEmployee("34");
    ropDateOfReportData.setAverageYieldOnInterestEarningAssets("9.99");
    ropDateOfReportData.setCostOfFundsAveragePercentage("21");
    ropDateOfReportData.setReturnsOnAssets("13.22");
    ropDateOfReportData.setInterestSpreadInReturnOnProfitability("4.43");
    ropItemData.setRopDateOfReport(ropDateOfReportData);
    
    data.getItemDatas().add(ropItemData);    

    ReportGenerationEngine engine = new XBRLReportGenerationEngine();
    StringWriter sw = engine.execute(ReportGenerationFactory.RBI_ROP_XBRL_REPORT, data);
    FileWriter fw = new FileWriter("file.txt"); 
    fw.write(sw.toString());
    fw.close();
        
    }
    
}
