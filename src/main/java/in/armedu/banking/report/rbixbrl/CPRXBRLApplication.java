package in.armedu.banking.report.rbixbrl;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.cpr.BorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRReportData;
import in.armedu.banking.report.rbixbrl.model.cpr.GroupCompany;
import in.armedu.banking.report.rbixbrl.model.cpr.IndividualBorrower;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToBorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToIndividualBorrower;

public class CPRXBRLApplication {
    public static void main(String[] args) throws Exception {
        CPRReportData data = new CPRReportData();
        CPRGeneralData genInfoData = new CPRGeneralData();
        genInfoData.setBankCode("600");
        genInfoData.setInstitutionAddress("Punjab National Bank corporate office dwarka");
        genInfoData.setReportInstitution("Punjab National Bank");
        genInfoData.setReportingFrequency("HalfYearly");
        genInfoData.setReturnCode("ROS");
        genInfoData.setReturnName("Report on Subsidiaries");
        genInfoData.setReturnVersion("v1.2");
        genInfoData.setStartDate("2021-04-01");
        genInfoData.setEndDate("2021-09-30");
        genInfoData.setDateOfReport("2021-09-30");
        genInfoData.setReportForTheYearEnded("2018-03-31");
        genInfoData.setValidationStatus("validated");
        data.setGeneralData(genInfoData);
        CPRItemData cprItemData = new CPRItemData();
        // changes are done to add amountfunded and amount nonfunded
        LargeExposureToIndividualBorrower individualBorrower = new LargeExposureToIndividualBorrower();
        LargeExposureToBorrowerGroup borrowerGroup = new LargeExposureToBorrowerGroup();
        IndividualBorrower ib = new IndividualBorrower();
        ib.setPanNumber("AAACF0365N");
        ib.setBorrowerName("FOOD CORPORATION OF INDIA");
        ib.setIndustryCode("51201");
        ib.setIndustryName("Wholesale Food Procurement");
        ib.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib);

        IndividualBorrower ib2 = new IndividualBorrower();
        ib2.setPanNumber("AAACT4053B");
        ib2.setBorrowerName("THE COTTON CORPORATION OF INDIA LIMITED");
        ib2.setIndustryCode("51401");
        ib2.setIndustryName("Wholesale Cotton");
        ib2.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib2);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib3 = new IndividualBorrower();
        ib3.setPanNumber("AAACI0681C");
        ib3.setBorrowerName("INDIAN RAILWAY FINANCE CORPORATION  LTD");
        ib3.setIndustryCode("65929");
        ib3.setIndustryName("NBFCs- general purpose loans");
        ib3.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib3);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib4 = new IndividualBorrower();
        ib4.setPanNumber("AAACN0255D");
        ib4.setBorrowerName("NTPC LIMITED");
        ib4.setIndustryCode("40101");
        ib4.setIndustryName("Generation of Electricity");
        ib4.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib4);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib5 = new IndividualBorrower();
        ib5.setPanNumber("AAACP1570H");
        ib5.setBorrowerName("POWER FINANCE CORPORATION LTD");
        ib5.setIndustryCode("65939");
        ib5.setIndustryName("Other Financial Intermediation");
        ib5.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib5);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib6 = new IndividualBorrower();
        ib6.setPanNumber("AAACR4512R");
        ib6.setBorrowerName("RURAL ELECTRIFICATION CORPORATION LIMITED");
        ib6.setIndustryCode("65911");
        ib6.setIndustryName("Developmental Financial Institutions");
        ib6.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib6);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib7 = new IndividualBorrower();
        ib7.setPanNumber("AAACJ4323N");
        ib7.setBorrowerName("JSW STEEL LIMITED");
        ib7.setIndustryCode("27101");
        ib7.setIndustryName("Mfg of Basic Iron and Steel");
        ib7.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib7);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib8 = new IndividualBorrower();
        ib8.setPanNumber("AAACH0997E");
        ib8.setBorrowerName("HOUSING DEVELOPMENT FINANCE CORPORATION LIMITED");
        ib8.setIndustryCode("65923");
        ib8.setIndustryName("NBFCs- in the housing sector");
        ib8.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib8);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib9 = new IndividualBorrower();
        ib9.setPanNumber("AAATN1963H");
        ib9.setBorrowerName("NATIONAL HIGHWAYS AUTHORITY OF INDIA");
        ib9.setIndustryCode("45013");
        ib9.setIndustryName("Construction/Maintenance of Roads");
        ib9.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib9);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib10 = new IndividualBorrower();
        ib10.setPanNumber("AAACL1799C");
        ib10.setBorrowerName("LIC HOUSING FINANCE LIMITED");
        ib10.setIndustryCode("65923");
        ib10.setIndustryName("NBFCs- in the housing sector");
        ib10.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib10);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib11 = new IndividualBorrower();
        ib11.setPanNumber("AAECJ4213B");
        ib11.setBorrowerName("JIO DIGITAL FIBRE PRIVATE LIMITED");
        ib11.setIndustryCode("64201");
        ib11.setIndustryName("Telecommunication Services");
        ib11.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib11);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);

        IndividualBorrower ib12 = new IndividualBorrower();
        ib12.setPanNumber("AACCN6194P");
        ib12.setBorrowerName("AIR INDIA LIMITED");
        ib12.setIndustryCode("62001");
        ib12.setIndustryName("Schduled Air Transport");
        ib12.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib12);

        IndividualBorrower ib13 = new IndividualBorrower();
        ib13.setPanNumber("AAAAH0087M");
        ib13.setBorrowerName("HARYANA URBAN DEVELOPMENT AUTHORTY");
        ib13.setIndustryCode("67103");
        ib13.setIndustryName("Industrial Development Boards/Corporation etc");
        ib13.setSector("10-Public-central government");
        individualBorrower.getIndividualBorrowers().add(ib13);

        IndividualBorrower ib14 = new IndividualBorrower();
        ib14.setPanNumber("AAACG1642F");
        ib14.setBorrowerName("GITANJALI GEMS LIMITED");
        ib14.setIndustryCode("36902");
        ib14.setIndustryName("Diamond Cutting and Polishing");
        ib14.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib14);

        IndividualBorrower ib15 = new IndividualBorrower();
        ib15.setPanNumber("AAACI1681G");
        ib15.setBorrowerName("INDIAN OIL CORPORATION LTD");
        ib15.setIndustryCode("23201");
        ib15.setIndustryName("Mfg of Refined Pretroleum Products");
        ib15.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib15);

        IndividualBorrower ib16 = new IndividualBorrower();
        ib16.setPanNumber("AAACP3682N");
        ib16.setBorrowerName("PNB HOUSING FINANCE LTD");
        ib16.setIndustryCode("65923");
        ib16.setIndustryName("NBFCs- in the housing sector");
        ib16.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib16);

        IndividualBorrower ib17 = new IndividualBorrower();
        ib17.setPanNumber("AACCM5763B");
        ib17.setBorrowerName("MP STATE CIVIL SUPPLIES CORPN. LTD");
        ib17.setIndustryCode("45013");
        ib17.setIndustryName("Construction/Maintenance of Roads");
        ib17.setSector("11-Public-state government");
        individualBorrower.getIndividualBorrowers().add(ib17);

        IndividualBorrower ib18 = new IndividualBorrower();
        ib18.setPanNumber("AAAAN4629F");
        ib18.setBorrowerName("NATIONAL AGRICULTURAL COOP MKTG FEDERATION OF INDIA LIMITED");
        ib18.setIndustryCode("1181");
        ib18.setIndustryName("Storage & Market yards");
        ib18.setSector("20-Co-operative");
        individualBorrower.getIndividualBorrowers().add(ib18);

        IndividualBorrower ib19 = new IndividualBorrower();
        ib19.setPanNumber("AAALU0121E");
        ib19.setBorrowerName("UTTAR PRADESH EXPRESSWAYS INDUSTRIAL DEVELOPMENT AUTHORITY");
        ib19.setIndustryCode("45013");
        ib19.setIndustryName("Construction/Maintenance of Roads");
        ib19.setSector("11-Public-state government");
        individualBorrower.getIndividualBorrowers().add(ib19);

        IndividualBorrower ib20 = new IndividualBorrower();
        ib20.setPanNumber("AACCA1963B");
        ib20.setBorrowerName("L&T FINANCE LIMITED");
        ib20.setIndustryCode("65929");
        ib20.setIndustryName("NBFCs- general purpose loans");
        ib20.setSector("30-Private");
        individualBorrower.getIndividualBorrowers().add(ib20);
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);


        //borrower group
        BorrowerGroup bg = new BorrowerGroup();
        bg.setBorrowerGroupName("NTPC");
        GroupCompany gc = new GroupCompany();
        gc.setGroupCompanyName("NTPC LIMITED");
        bg.getGroupCompanies().add(gc);
        GroupCompany gc1 = new GroupCompany();
        gc1.setGroupCompanyName("HINDUSTAN URVARAK & RASAYAN LIMITED");
        bg.getGroupCompanies().add(gc1);
        borrowerGroup.getBorrowerGroups().add(bg);
        //cprItemData.setLargeExposureToBorrowerGroup(borrowerGroup);
        BorrowerGroup bg1 = new BorrowerGroup();
        bg1.setBorrowerGroupName("ONGC");
        GroupCompany agc = new GroupCompany();
        agc.setGroupCompanyName("ONGC PETRO ADDITIONS LIMITED");
        bg1.getGroupCompanies().add(agc);
        GroupCompany agc1 = new GroupCompany();
        agc1.setGroupCompanyName("ONGC VIDESH LIMITED");
        bg1.getGroupCompanies().add(agc1);
        borrowerGroup.getBorrowerGroups().add(bg1);
        cprItemData.setLargeExposureToBorrowerGroup(borrowerGroup);
        data.getItemDatas().add(cprItemData);

        CPRGeneralData generalData = new CPRGeneralData();
        CPRGeneralFinancialForConsolidated cgfc = new CPRGeneralFinancialForConsolidated();
        cgfc.setAssets("12935763752000");
        cgfc.setCapitalAndReserves("974945945000");
        cgfc.setRegulatoryCapitalActualOrNotionalAfterNettingForConsolidation("920224419000");
        cgfc.setRiskWeightedAssetsActualOrNotional("6050089720000");
        cgfc.setCapitalAdequacyRatioPercentActualOrNotional("15.21");
        cgfc.setAggregateDeposits("11235307200000");
        cgfc.setAggregateBorrowings("503770269000");
        cgfc.setGrossAdvances("7444318987000");
        cgfc.setGrossNonPerformingAssets("1029237838000");
        cgfc.setInvestmentsBookValueMemeber("3860341143000");
        cgfc.setInvestmentsMarketValueMemeber("3942106593000");
        cgfc.setNonPerformingInvestments("41709003000");
        cgfc.setNonPerformingAssetsIncludingNonPerformingAdvancesAndInvestments("1070946841000");
        cgfc.setProvisionsHeldForNonPerformingAdvances("649640336000");
        cgfc.setProvisionsHeldForNonPerformingInvestments("37959603000");
        cgfc.setProfitLossBeforeTax("23780499000");
        cgfc.setNetProfitLossAfterTax("22725799000");
        cgfc.setReturnOnAssets("0.36");
        cgfc.setReturnOnEquity("5.18");
        cgfc.setContingentLiabilities("4605838156000");
        cgfc.setDividendPaid("0");
        generalData.setGeneralData(cgfc);

        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        engine.execute(ReportGenerationFactory.RBI_CPR_XBRL_REPORT, data);
        
    }
    
}
