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
        partA1.setCapitalAndReservesAsInTheBalanceSheet("2006225.87");
        partA1.setCapitalFunds("840002.02");
        partA1.setContingentLiabilitiesOrOffBalanceSheetExposures("2882028.78");
        partA1.setLoansAndAdvancesGross("11760443.66");
        partA1.setMinPrescribedCapital("600000.00");
        partA1.setMinPrescribedCapitalPercentage("12.50");
        partA1.setNonPerformingInvestments("0.00");
        partA1.setNonPerformingLoansGross("592945.28");
        partA1.setNotionalCapitalAdequacyRatio("0.00");
        partA1.setNotionalCapitalFunds("0.00");
        partA1.setProfitAfterTaxOrReturn("63694.73");
        partA1.setProfitBeforeTax("90992.47");
        partA1.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA1.setProvisionsHeldAgainstNonPerformingLoans("345001.51");
        partA1.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA1.setProvisionsRequiredAgainstNonPerformingLoans("0.00");
        partA1.setReturnOnAssets("0.71");
        partA1.setReturnOnEquity("5.68");
        partA1.setRiskWeightedAssets("14259067.48");
        partA1.setSurplusOrLossOnProfitAndLossACCarriedForward("0.00");
        partA1.setTotalAssets("17867134.97");
        partA1.setTotalBorrowings("0.00");
        partA1.setTotalDeposits("14722455.81");
        partA1.setTotalDividendsPaid("414846.00");
        partA1.setTotalInvestmentBookValue("2647843.19");
        partA1.setTotalInvestmentMarketValue("2647843.19");
        rosItem.setPartAFinancialParameters(partA1);

        partB1.setAggregateExposureAmount("3265282.65");
        partB1.setAggregateExposurePercentage("27.76");
        partB1.setInvestmentInCapitalByParentBank("420750.00");
        partB1.setNoOfCounterparties("10");
        partB1.setSharesHeldByParentBank("51.00");
        partB1.setTotalCapitalHeldByParentBank("420750.00");
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
        partA2.setCapitalAndReservesAsInTheBalanceSheet("116699.56");
        partA2.setCapitalFunds("168766.94");
        partA2.setContingentLiabilitiesOrOffBalanceSheetExposures("176961.54");
        partA2.setLoansAndAdvancesGross("737199.01");
        partA2.setMinPrescribedCapital("100023.12");
        partA2.setMinPrescribedCapitalPercentage("15.55");
        partA2.setNonPerformingInvestments("7814.03");
        partA2.setNonPerformingLoansGross("256666.89");
        partA2.setNotionalCapitalAdequacyRatio("0.00");
        partA2.setNotionalCapitalFunds("149099.17");
        partA2.setProfitAfterTaxOrReturn("1858.47");
        partA2.setProfitBeforeTax("1858.47");
        partA2.setProvisionsHeldAgainstNonPerformingInvestments("7717.17");
        partA2.setProvisionsHeldAgainstNonPerformingLoans("162510.27");
        partA2.setProvisionsRequiredAgainstNonPerformingInvestments("7717.17");
        partA2.setProvisionsRequiredAgainstNonPerformingLoans("162510.27");
        partA2.setReturnOnAssets("0.36");
        partA2.setReturnOnEquity("3.19");
        partA2.setRiskWeightedAssets("643235.49");
        partA2.setSurplusOrLossOnProfitAndLossACCarriedForward("0.00");
        partA2.setTotalAssets("1031156.02");
        partA2.setTotalBorrowings("2.46");
        partA2.setTotalDeposits("658182.22");
        partA2.setTotalDividendsPaid("0.00");
        partA2.setTotalInvestmentBookValue("132627.41");
        partA2.setTotalInvestmentMarketValue("131246.30");
        rosItem2.setPartAFinancialParameters(partA2);

        partB2.setAggregateExposureAmount("112336.90");
        partB2.setAggregateExposurePercentage("75.00");
        partB2.setInvestmentInCapitalByParentBank("155719.31");
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
        partA3.setCapitalAndReservesAsInTheBalanceSheet("131098.00");
        partA3.setCapitalFunds("5856.03");
        partA3.setContingentLiabilitiesOrOffBalanceSheetExposures("321375.00");
        partA3.setLoansAndAdvancesGross("868723.00");
        partA3.setMinPrescribedCapital("0.00");
        partA3.setMinPrescribedCapitalPercentage("9.00");
        partA3.setNonPerformingInvestments("0.00");
        partA3.setNonPerformingLoansGross("803.00");
        partA3.setNotionalCapitalAdequacyRatio("0.00");
        partA3.setNotionalCapitalFunds("0.00");
        partA3.setProfitAfterTaxOrReturn("6826.00");
        partA3.setProfitBeforeTax("9782.00");
        partA3.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA3.setProvisionsHeldAgainstNonPerformingLoans("634.00");
        partA3.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA3.setProvisionsRequiredAgainstNonPerformingLoans("634.00");
        partA3.setReturnOnAssets("1.11");
        partA3.setReturnOnEquity("10.41");
        partA3.setRiskWeightedAssets("967818.00");
        partA3.setSurplusOrLossOnProfitAndLossACCarriedForward("6826.00");
        partA3.setTotalAssets("1228018.00");
        partA3.setTotalBorrowings("39655.00");
        partA3.setTotalDeposits("985705.00");
        partA3.setTotalDividendsPaid("0.00");
        partA3.setTotalInvestmentBookValue("246302.00");
        partA3.setTotalInvestmentMarketValue("246302.00");
        rosItem3.setPartAFinancialParameters(partA3);

        partB3.setAggregateExposureAmount("51588.00");
        partB3.setAggregateExposurePercentage("43.45");
        partB3.setInvestmentInCapitalByParentBank("2664.45");
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
        partA4.setCapitalAndReservesAsInTheBalanceSheet("5857.25");
        partA4.setCapitalFunds("5856.03");
        partA4.setContingentLiabilitiesOrOffBalanceSheetExposures("33.00");
        partA4.setLoansAndAdvancesGross("1894.97");
        partA4.setMinPrescribedCapital("0.00");
        partA4.setMinPrescribedCapitalPercentage("9.00");
        partA4.setNonPerformingInvestments("0.00");
        partA4.setNonPerformingLoansGross("5018.14");
        partA4.setNotionalCapitalAdequacyRatio("2.45");
        partA4.setNotionalCapitalFunds("0.00");
        partA4.setProfitAfterTaxOrReturn("-26.66");
        partA4.setProfitBeforeTax("-26.66");
        partA4.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA4.setProvisionsHeldAgainstNonPerformingLoans("1561.40");
        partA4.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA4.setProvisionsRequiredAgainstNonPerformingLoans("1561.40");
        partA4.setReturnOnAssets("-0.06");
        partA4.setReturnOnEquity("-11.12");
        partA4.setRiskWeightedAssets("15899.66");
        partA4.setSurplusOrLossOnProfitAndLossACCarriedForward("-5684.84");
        partA4.setTotalAssets("51021.82");
        partA4.setTotalBorrowings("4389.12");
        partA4.setTotalDeposits("34777.28");
        partA4.setTotalDividendsPaid("0.00");
        partA4.setTotalInvestmentBookValue("20921.30");
        partA4.setTotalInvestmentMarketValue("20509.89");
        rosItem4.setPartAFinancialParameters(partA4);

        partB4.setAggregateExposureAmount("0.00");
        partB4.setAggregateExposurePercentage("0.00");
        partB4.setInvestmentInCapitalByParentBank("2049.61");
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
        partA5.setCapitalAndReservesAsInTheBalanceSheet("2485.83");
        partA5.setCapitalFunds("18675.37");
        partA5.setContingentLiabilitiesOrOffBalanceSheetExposures("2217.91");
        partA5.setLoansAndAdvancesGross("451031.54");
        partA5.setMinPrescribedCapital("200000.00");
        partA5.setMinPrescribedCapitalPercentage("9.00");
        partA5.setNonPerformingInvestments("0.00");
        partA5.setNonPerformingLoansGross("139601.17");
        partA5.setNotionalCapitalAdequacyRatio("1.28");
        partA5.setNotionalCapitalFunds("4971.66");
        partA5.setProfitAfterTaxOrReturn("-1151.46");
        partA5.setProfitBeforeTax("-1151.46");
        partA5.setProvisionsHeldAgainstNonPerformingInvestments("0.00");
        partA5.setProvisionsHeldAgainstNonPerformingLoans("69623.30");
        partA5.setProvisionsRequiredAgainstNonPerformingInvestments("0.00");
        partA5.setProvisionsRequiredAgainstNonPerformingLoans("56882.64");
        partA5.setReturnOnAssets("-1.80");
        partA5.setReturnOnEquity("-31.66");
        partA5.setRiskWeightedAssets("388468.72");
        partA5.setSurplusOrLossOnProfitAndLossACCarriedForward("-48594.40");
        partA5.setTotalAssets("1251815.03");
        partA5.setTotalBorrowings("83298.11");
        partA5.setTotalDeposits("1142870.43");
        partA5.setTotalDividendsPaid("0.00");
        partA5.setTotalInvestmentBookValue("768854.80");
        partA5.setTotalInvestmentMarketValue("731631.76");
        rosItem5.setPartAFinancialParameters(partA5);

        partB5.setAggregateExposureAmount("0.00");
        partB5.setAggregateExposurePercentage("0.00");
        partB5.setInvestmentInCapitalByParentBank("6537.08");
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
