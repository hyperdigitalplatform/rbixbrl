package in.armedu.banking.report.rbixbrl;

import in.armedu.banking.report.rbixbrl.model.ExposureAndOwnership;
import in.armedu.banking.report.rbixbrl.model.FinancialParameters;
import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;
import in.armedu.banking.report.rbixbrl.model.SubsidiaryData;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIROSXBRLReportImpl;

public class XBRLApplication {
    public static void main(String[] args) throws Exception {
        ROSData data = new ROSData();
        
        GeneralInfoData genInfoData = new GeneralInfoData();
        genInfoData.setBankCode("600");
        genInfoData.setDateOfReport("2021-09-30");
        genInfoData.setEndDate("2021-09-30");
        genInfoData.setInstitutionAddress("Punjab National Bank corporate office dwarka");
        genInfoData.setReportInstitution("Punjab National Bank");
        genInfoData.setReportingFrequency("HalfYearly");
        genInfoData.setReturnCode("ROS");
        genInfoData.setReturnName("Report on Subsidiaries");
        genInfoData.setReturnVersion("v1.2");
        genInfoData.setStartDate("2021-04-01");
        genInfoData.setValidationStatus("validated");
        data.setRosGeneralInfo(genInfoData);

        ROSItem rosItem = new ROSItem();
        SubsidiaryData sData = new SubsidiaryData();
        sData.setActivityName("Banking");
        sData.setAreaOfOperations("Foreign");
        sData.setCategory("Subsidiary");
        sData.setRegulatorName("Royal Monetary Authority of Bhutan");
        sData.setSubsidiaryCode("600145");
        sData.setSubsidiaryName("Druk PNB Bank Ltd");
        
        
        rosItem.setSubsidiaryInfo(sData);
        FinancialParameters partA = new FinancialParameters();
        ExposureAndOwnership partB = new ExposureAndOwnership();
        partA.setCapitalAdequacyRatio("15.74");
        partA.setCapitalAndReservesAsInTheBalanceSheet("2006225.87");
        partA.setCapitalFunds("840002.02");
        partA.setContingentLiabilitiesOrOffBalanceSheetExposures("2882028.78");
        partA.setLoansAndAdvancesGross("11760443.66");
        partA.setMinPrescribedCapital("600000.00");
        partA.setMinPrescribedCapitalPercentage("12.50");
        partA.setNonPerformingInvestments("0.00");
        partA.setNonPerformingLoansGross("592945.28");
        partA.setNotionalCapitalAdequacyRatio("0.00");
        partA.setNotionalCapitalFunds("0.00");
        partA.setProfitAfterTaxOrReturn("63694.73");
        partA.setProfitBeforeTax("90992.47");
        partA.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA.setProvisionsHeldAgainstNonPerformingLoans("345001.51");
        partA.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA.setProvisionsRequiredAgainstNonPerformingLoans("0.00");
        partA.setReturnOnAssets("0.71");
        partA.setReturnOnEquity("5.68");
        partA.setRiskWeightedAssets("14259067.48");
        partA.setSurplusOrLossOnProfitAndLossACCarriedForward("0.00");
        partA.setTotalAssets("17867134.97");
        partA.setTotalBorrowings("0.00");
        partA.setTotalDeposits("14722455.81");
        partA.setTotalDividendsPaid("414846.00");
        partA.setTotalInvestmentBookValue("2647843.19");
        partA.setTotalInvestmentMarketValue("2647843.19");
        rosItem.setPartAFinancialParameters(partA);
        partB.setAggregateExposureAmount("3265282.65");
        partB.setAggregateExposurePercentage("27.76");
        partB.setInvestmentInCapitalByParentBank("420750.00");
        partB.setNoOfCounterparties("10");
        partB.setSharesHeldByParentBank("51.00");
        partB.setTotalCapitalHeldByParentBank("420750.00");

        rosItem.setPartBExposureAndOwnership(partB);

        data.getRosItems().add(rosItem);

        RBIROSXBRLReportImpl report = new RBIROSXBRLReportImpl();
        report.generateReport(data);
        
    }
    
}
