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

        //  *** ROS1 ****

        SubsidiaryData sData1 = new SubsidiaryData();
        sData1.setActivityName("Banking");
        sData1.setAreaOfOperations("Foreign");
        sData1.setCategory("Subsidiary");
        sData1.setRegulatorName("Royal Monetary Authority of Bhutan");
        sData1.setSubsidiaryCode("600145");
        sData1.setSubsidiaryName("Druk PNB Bank Ltd");        
        rosItem.setSubsidiaryInfo(sData1);

        FinancialParameters partA1 = new FinancialParameters();
        ExposureAndOwnership partB1 = new ExposureAndOwnership();
        partA1.setCapitalAdequacyRatio("15.74");
        partA1.setCapitalAndReservesAsInTheBalanceSheet("200622587000");
        partA1.setCapitalFunds("84000202000");
        partA1.setContingentLiabilitiesOrOffBalanceSheetExposures("288202878000");
        partA1.setLoansAndAdvancesGross("1176044366000");
        partA1.setMinPrescribedCapital("60000000000");
        partA1.setMinPrescribedCapitalPercentage("12.50");
        partA1.setNonPerformingInvestments("0");
        partA1.setNonPerformingLoansGross("59294528000");
        partA1.setNotionalCapitalAdequacyRatio("0.00");
        partA1.setNotionalCapitalFunds("0");
        partA1.setProfitAfterTaxOrReturn("6369473000");
        partA1.setProfitBeforeTax("9099247000");
        partA1.setProvisionsHeldAgainstNonPerformingInvestments("0");
        partA1.setProvisionsHeldAgainstNonPerformingLoans("34500151000");
        partA1.setProvisionsRequiredAgainstNonPerformingInvestments("0");
        partA1.setProvisionsRequiredAgainstNonPerformingLoans("0");
        partA1.setReturnOnAssets("0.71");
        partA1.setReturnOnEquity("5.68");
        partA1.setRiskWeightedAssets("1425906748000");
        partA1.setSurplusOrLossOnProfitAndLossACCarriedForward("0");
        partA1.setTotalAssets("1786713497000");
        partA1.setTotalBorrowings("0");
        partA1.setTotalDeposits("1472245581000");
        partA1.setTotalDividendsPaid("41484600000");
        partA1.setTotalInvestmentBookValue("264784319000");
        partA1.setTotalInvestmentMarketValue("264784319000");
        rosItem.setPartAFinancialParameters(partA1);

        partB1.setAggregateExposureAmount("326528265000");
        partB1.setAggregateExposurePercentage("27.76");
        partB1.setInvestmentInCapitalByParentBank("42075000000");
        partB1.setNoOfCounterparties("10");
        partB1.setSharesHeldByParentBank("51.00");
        partB1.setTotalCapitalHeldByParentBank("21.63");
        rosItem.setPartBExposureAndOwnership(partB1);

        
        //  *** ROS13 ****

        ROSItem rosItem2 = new ROSItem();

        SubsidiaryData sData2 = new SubsidiaryData();
        sData2.setActivityName("BANKING");
        sData2.setAreaOfOperations("Foreign");
        sData2.setCategory("Subsidiary");
        sData2.setRegulatorName("Financial Service Authority");
        sData2.setSubsidiaryCode("600141");
        sData2.setSubsidiaryName("Punjab National Bank (International) Limited");        
        rosItem2.setSubsidiaryInfo(sData2);

        FinancialParameters partA2 = new FinancialParameters();
        ExposureAndOwnership partB2 = new ExposureAndOwnership();
        partA2.setCapitalAdequacyRatio("23.18");
        partA2.setCapitalAndReservesAsInTheBalanceSheet("11669956000");
        partA2.setCapitalFunds("16876694000");
        partA2.setContingentLiabilitiesOrOffBalanceSheetExposures("17696154000");
        partA2.setLoansAndAdvancesGross("73719901000");
        partA2.setMinPrescribedCapital("10002312000");
        partA2.setMinPrescribedCapitalPercentage("15.55");
        partA2.setNonPerformingInvestments("781403000");
        partA2.setNonPerformingLoansGross("25666689000");
        partA2.setNotionalCapitalAdequacyRatio("0.00");
        partA2.setNotionalCapitalFunds("14909917000");
        partA2.setProfitAfterTaxOrReturn("185847000");
        partA2.setProfitBeforeTax("185847000");
        partA2.setProvisionsHeldAgainstNonPerformingInvestments("771717000");
        partA2.setProvisionsHeldAgainstNonPerformingLoans("16251027000");
        partA2.setProvisionsRequiredAgainstNonPerformingInvestments("771717000");
        partA2.setProvisionsRequiredAgainstNonPerformingLoans("16251027000");
        partA2.setReturnOnAssets("0.36");
        partA2.setReturnOnEquity("3.19");
        partA2.setRiskWeightedAssets("64323549000");
        partA2.setSurplusOrLossOnProfitAndLossACCarriedForward("0");
        partA2.setTotalAssets("103115602000");
        partA2.setTotalBorrowings("246000");
        partA2.setTotalDeposits("65818222000");
        partA2.setTotalDividendsPaid("0");
        partA2.setTotalInvestmentBookValue("13262741000");
        partA2.setTotalInvestmentMarketValue("13124630000");
        rosItem2.setPartAFinancialParameters(partA2);

        partB2.setAggregateExposureAmount("11233690000");
        partB2.setAggregateExposurePercentage("75.00");
        partB2.setInvestmentInCapitalByParentBank("15571931000");
        partB2.setNoOfCounterparties("5");
        partB2.setSharesHeldByParentBank("100.00");
        partB2.setTotalCapitalHeldByParentBank("96.00");
        rosItem2.setPartBExposureAndOwnership(partB2);

         //  *** ROS17 ****

        ROSItem rosItem3 = new ROSItem();

        SubsidiaryData sData3 = new SubsidiaryData();
        sData3.setActivityName("Associate");
        sData3.setAreaOfOperations("Foreign");
        sData3.setCategory("Associate");
        sData3.setRegulatorName("Nepal Rashtra Bank");
        sData3.setSubsidiaryCode("600110");
        sData3.setSubsidiaryName("EVEREST BANK LTD. NEPAL");        
        rosItem3.setSubsidiaryInfo(sData3);

        FinancialParameters partA3 = new FinancialParameters();
        ExposureAndOwnership partB3 = new ExposureAndOwnership();
        partA3.setCapitalAdequacyRatio("12.27");
        partA3.setCapitalAndReservesAsInTheBalanceSheet("13109800000");
        partA3.setCapitalFunds("585603000");
        partA3.setContingentLiabilitiesOrOffBalanceSheetExposures("32137500000");
        partA3.setLoansAndAdvancesGross("86872300000");
        partA3.setMinPrescribedCapital("0.00");
        partA3.setMinPrescribedCapitalPercentage("9.00");
        partA3.setNonPerformingInvestments("0.00");
        partA3.setNonPerformingLoansGross("80300000");
        partA3.setNotionalCapitalAdequacyRatio("0.00");
        partA3.setNotionalCapitalFunds("0.00");
        partA3.setProfitAfterTaxOrReturn("682600000");
        partA3.setProfitBeforeTax("978200000");
        partA3.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA3.setProvisionsHeldAgainstNonPerformingLoans("63400000");
        partA3.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA3.setProvisionsRequiredAgainstNonPerformingLoans("63400000");
        partA3.setReturnOnAssets("1.11");
        partA3.setReturnOnEquity("10.41");
        partA3.setRiskWeightedAssets("96781800000");
        partA3.setSurplusOrLossOnProfitAndLossACCarriedForward("682600000");
        partA3.setTotalAssets("122801800000");
        partA3.setTotalBorrowings("3965500000");
        partA3.setTotalDeposits("98570500000");
        partA3.setTotalDividendsPaid("0.00");
        partA3.setTotalInvestmentBookValue("24630200000");
        partA3.setTotalInvestmentMarketValue("24630200000");
        rosItem3.setPartAFinancialParameters(partA3);

        partB3.setAggregateExposureAmount("5158800000");
        partB3.setAggregateExposurePercentage("43.45");
        partB3.setInvestmentInCapitalByParentBank("266445000");
        partB3.setNoOfCounterparties("6");
        partB3.setSharesHeldByParentBank("20.03");
        partB3.setTotalCapitalHeldByParentBank("9.67");
        rosItem3.setPartBExposureAndOwnership(partB3);
        

            //  *** ROS2 ****

        ROSItem rosItem4 = new ROSItem();

        SubsidiaryData sData4 = new SubsidiaryData();
        sData4.setActivityName("BANKING");
        sData4.setAreaOfOperations("India");
        sData4.setCategory("Associate");
        sData4.setRegulatorName("Department of Banking Supervision");
        sData4.setSubsidiaryCode("600115");
        sData4.setSubsidiaryName("Manipur Rural Bank");        
        rosItem4.setSubsidiaryInfo(sData4);

        FinancialParameters partA4 = new FinancialParameters();
        ExposureAndOwnership partB4 = new ExposureAndOwnership();
        partA4.setCapitalAdequacyRatio("2.45");
        partA4.setCapitalAndReservesAsInTheBalanceSheet("585725000");
        partA4.setCapitalFunds("585603000");
        partA4.setContingentLiabilitiesOrOffBalanceSheetExposures("33.00");
        partA4.setLoansAndAdvancesGross("189497000");
        partA4.setMinPrescribedCapital("0.00");
        partA4.setMinPrescribedCapitalPercentage("9.00");
        partA4.setNonPerformingInvestments("0.00");
        partA4.setNonPerformingLoansGross("501814000");
        partA4.setNotionalCapitalAdequacyRatio("2.45");
        partA4.setNotionalCapitalFunds("0.00");
        partA4.setProfitAfterTaxOrReturn("-26.66");
        partA4.setProfitBeforeTax("-26.66");
        partA4.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA4.setProvisionsHeldAgainstNonPerformingLoans("156140000");
        partA4.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA4.setProvisionsRequiredAgainstNonPerformingLoans("156140000");
        partA4.setReturnOnAssets("-0.06");
        partA4.setReturnOnEquity("-11.12");
        partA4.setRiskWeightedAssets("1589966000");
        partA4.setSurplusOrLossOnProfitAndLossACCarriedForward("-568484000");
        partA4.setTotalAssets("5102182000");
        partA4.setTotalBorrowings("438912000");
        partA4.setTotalDeposits("3477728000");
        partA4.setTotalDividendsPaid("0.00");
        partA4.setTotalInvestmentBookValue("2092130000");
        partA4.setTotalInvestmentMarketValue("2050989000");
        rosItem4.setPartAFinancialParameters(partA4);

        partB4.setAggregateExposureAmount("0.00");
        partB4.setAggregateExposurePercentage("0.00");
        partB4.setInvestmentInCapitalByParentBank("204961000");
        partB4.setNoOfCounterparties("0");
        partB4.setSharesHeldByParentBank("35.00");
        partB4.setTotalCapitalHeldByParentBank("35.00");
        rosItem4.setPartBExposureAndOwnership(partB4);

            //  *** ROS3 ****

        ROSItem rosItem5 = new ROSItem();

        SubsidiaryData sData5 = new SubsidiaryData();
        sData5.setActivityName("BANKING");
        sData5.setAreaOfOperations("India");
        sData5.setCategory("Associate");
        sData5.setRegulatorName("Department of Banking Supervision");
        sData5.setSubsidiaryCode("600111");
        sData5.setSubsidiaryName("Assam Gramin Vikash Bank");        
        rosItem5.setSubsidiaryInfo(sData5);

        FinancialParameters partA5 = new FinancialParameters();
        ExposureAndOwnership partB5 = new ExposureAndOwnership();
        partA5.setCapitalAdequacyRatio("1.28");
        partA5.setCapitalAndReservesAsInTheBalanceSheet("248583000");
        partA5.setCapitalFunds("1867537000");
        partA5.setContingentLiabilitiesOrOffBalanceSheetExposures("221791000");
        partA5.setLoansAndAdvancesGross("45103154000");
        partA5.setMinPrescribedCapital("20000000000");
        partA5.setMinPrescribedCapitalPercentage("9.00");
        partA5.setNonPerformingInvestments("0.00");
        partA5.setNonPerformingLoansGross("13960117000");
        partA5.setNotionalCapitalAdequacyRatio("1.28");
        partA5.setNotionalCapitalFunds("497166000");
        partA5.setProfitAfterTaxOrReturn("-115146000");
        partA5.setProfitBeforeTax("-115146000");
        partA5.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA5.setProvisionsHeldAgainstNonPerformingLoans("6962330000");
        partA5.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA5.setProvisionsRequiredAgainstNonPerformingLoans("5688264000");
        partA5.setReturnOnAssets("-1.80");
        partA5.setReturnOnEquity("-31.66");
        partA5.setRiskWeightedAssets("38846872000");
        partA5.setSurplusOrLossOnProfitAndLossACCarriedForward("-4859440000");
        partA5.setTotalAssets("125181503000");
        partA5.setTotalBorrowings("8329811000");
        partA5.setTotalDeposits("114287043000");
        partA5.setTotalDividendsPaid("0.00");
        partA5.setTotalInvestmentBookValue("76885480000");
        partA5.setTotalInvestmentMarketValue("73163176000");
        rosItem5.setPartAFinancialParameters(partA5);

        partB5.setAggregateExposureAmount("0.00");
        partB5.setAggregateExposurePercentage("0.00");
        partB5.setInvestmentInCapitalByParentBank("653708000");
        partB5.setNoOfCounterparties("0");
        partB5.setSharesHeldByParentBank("35.00");
        partB5.setTotalCapitalHeldByParentBank("35.00");
        rosItem5.setPartBExposureAndOwnership(partB5);


        data.getRosItems().add(rosItem);
        data.getRosItems().add(rosItem2);
        data.getRosItems().add(rosItem3);
        data.getRosItems().add(rosItem4);
        data.getRosItems().add(rosItem5);

        RBIROSXBRLReportImpl report = new RBIROSXBRLReportImpl();
        report.generateReport(data);
        
    }
    
}
