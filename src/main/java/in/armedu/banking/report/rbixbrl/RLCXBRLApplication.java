package in.armedu.banking.report.rbixbrl;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCReportData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCBasic;

public class RLCXBRLApplication {
    public static void main(String[] args) throws Exception {
        RLCReportData data = new RLCReportData();

        RLCGeneralData rlcGeneralData = new RLCGeneralData();
        rlcGeneralData.setReturnName("Report on Large Credit");
        rlcGeneralData.setReturnCode("RLC");
        rlcGeneralData.setNameOfReportingInstitution("AXIS BANK LIMITED");
        rlcGeneralData.setBankCode("636");
        rlcGeneralData.setAddress("AUDUau");
        rlcGeneralData.setEndDate("2020-09-30");                //ReportForTheYearEnded
        rlcGeneralData.setReportingFrequency("Quarterly");
        rlcGeneralData.setReportStatus("Un-Audited");
        rlcGeneralData.setWhetherNilReporting("false");
        rlcGeneralData.setCategoriesOfBanks("Domestic bank with overseas branches");
        rlcGeneralData.setReturnVersion("V1.5");
        rlcGeneralData.setGeneralRemarks("df weru werwer null");
        rlcGeneralData.setStartDate("2020-07-01");               //ReportingPeriodStartDate
        rlcGeneralData.setRegulatoryCapital("1000000");
        rlcGeneralData.setCapitalInfusion("10000000");        
        rlcGeneralData.setLastEndDate("2020-03-31");             //LastYearEndDate
        rlcGeneralData.setCurrentDate("2020-04-01");         //BeginingOfCurrentYear
    
        //Signatory Details
        rlcGeneralData.setNameOfSignatory("rtre");
        rlcGeneralData.setDesignationOfSignatory("erterte");
        rlcGeneralData.setAuthorisedSignatoryMobileNumber("55235235236");
        rlcGeneralData.setAuthorisedSignatoryLandlineNumber("52352352355");
        rlcGeneralData.setEMailIDOfAuthorisedReportingOfficial("ertertr@m.vom");
        data.setRlcGeneralData(rlcGeneralData);

        RLCItem rlcItem1 = new RLCItem();

        RLCBasic basic1 = new RLCBasic();
        basic1.setRegionOfBusinessAxis("GlobalMember");
        basic1.setLargeCreditAxis("IndividualBorrowersMember");
        basic1.setUniqueTransactionCodeAxis("TransactionID1");
        basic1.setIndustryCodeAxis("28101");
        basic1.setIndustryNameAxis("Mfg of Structural Metal Products");
        basic1.setLeadBankNameAxis("Bank Of Baroda");
        basic1.setGroupBorrowerCode("");
        basic1.setGroupAxis("");
        basic1.setCounterPartyBankNameAxis("");
        basic1.setCounterPartyBankDomicileAxis("");        
        rlcItem1.setRlcBasicInfo(basic1);

        RLCItem rlcItem2 = new RLCItem();

        RLCBasic basic2 = new RLCBasic();
        basic2.setRegionOfBusinessAxis("GlobalMember");
        basic2.setLargeCreditAxis("IndividualBorrowersMember");
        basic2.setUniqueTransactionCodeAxis("TransactionID2");
        basic2.setIndustryCodeAxis("27101");
        basic2.setIndustryNameAxis("Mfg of Basic Iron and Steel");
        basic2.setLeadBankNameAxis("State Bank Of India");
        basic2.setGroupBorrowerCode("");
        basic2.setGroupAxis("");
        basic2.setCounterPartyBankNameAxis("");
        basic2.setCounterPartyBankDomicileAxis("");
        rlcItem2.setRlcBasicInfo(basic2);

        RLCItem rlcItem3 = new RLCItem();

        RLCBasic basic3 = new RLCBasic();
        basic3.setRegionOfBusinessAxis("GlobalMember");
        basic3.setLargeCreditAxis("IndividualBorrowersMember");
        basic3.setUniqueTransactionCodeAxis("TransactionID3");
        basic3.setIndustryCodeAxis("45013");
        basic3.setIndustryNameAxis("Construction/Maintenance of Roads");
        basic3.setLeadBankNameAxis("");
        basic3.setGroupBorrowerCode("");
        basic3.setGroupAxis("");
        basic3.setCounterPartyBankNameAxis("");
        basic3.setCounterPartyBankDomicileAxis("");
        rlcItem3.setRlcBasicInfo(basic3);

        RLCItem rlcItem4 = new RLCItem();

        RLCBasic basic4 = new RLCBasic();
        basic4.setRegionOfBusinessAxis("GlobalMember");
        basic4.setLargeCreditAxis("IndividualBorrowersMember");
        basic4.setUniqueTransactionCodeAxis("TransactionID4");
        basic4.setIndustryCodeAxis("40103");
        basic4.setIndustryNameAxis("Collection and Distn of Electricity");
        basic4.setLeadBankNameAxis("");
        basic4.setGroupBorrowerCode("");
        basic4.setGroupAxis("");
        basic4.setCounterPartyBankNameAxis("");
        basic4.setCounterPartyBankDomicileAxis("");
        rlcItem4.setRlcBasicInfo(basic4);

        RLCItem rlcItem5 = new RLCItem();

        RLCBasic basic5 = new RLCBasic();
        basic5.setRegionOfBusinessAxis("GlobalMember");
        basic5.setLargeCreditAxis("IndividualBorrowersMember");
        basic5.setUniqueTransactionCodeAxis("TransactionID5");
        basic5.setIndustryCodeAxis("27201");
        basic5.setIndustryNameAxis("Mfg of Basic Non-ferrous Metals");
        basic5.setLeadBankNameAxis("HDFC Bank Ltd.");
        basic5.setGroupBorrowerCode("");
        basic5.setGroupAxis("");
        basic5.setCounterPartyBankNameAxis("");
        basic5.setCounterPartyBankDomicileAxis("");
        rlcItem5.setRlcBasicInfo(basic5);

        RLCItem rlcItem6 = new RLCItem();

        RLCBasic basic6 = new RLCBasic();
        basic6.setRegionOfBusinessAxis("GlobalMember");
        basic6.setLargeCreditAxis("IndividualBorrowersMember");
        basic6.setUniqueTransactionCodeAxis("");
        basic6.setIndustryCodeAxis("");
        basic6.setIndustryNameAxis("");
        basic6.setLeadBankNameAxis("");
        basic6.setGroupBorrowerCode("");
        basic6.setGroupAxis("");
        basic6.setCounterPartyBankNameAxis("");
        basic6.setCounterPartyBankDomicileAxis("");
        rlcItem6.setRlcBasicInfo(basic6);

        RLCItem rlcItem7 = new RLCItem();

        RLCBasic basic7 = new RLCBasic();
        basic7.setRegionOfBusinessAxis("GlobalMember");
        basic7.setLargeCreditAxis("BorrowerGroupMember");
        basic7.setUniqueTransactionCodeAxis("TransactionID1");
        basic7.setGroupBorrowerCode("A0023");
        basic7.setGroupAxis("AIR LIQUIDE GROUP");
        basic7.setIndustryCodeAxis("40201");
        basic7.setIndustryNameAxis("Mfg of Gas");
        basic7.setLeadBankNameAxis("");
        basic7.setCounterPartyBankNameAxis("");
        basic7.setCounterPartyBankDomicileAxis("");
        rlcItem7.setRlcBasicInfo(basic7);

        RLCItem rlcItem8 = new RLCItem();

        RLCBasic basic8 = new RLCBasic();
        basic8.setRegionOfBusinessAxis("GlobalMember");
        basic8.setLargeCreditAxis("BorrowerGroupMember");
        basic8.setUniqueTransactionCodeAxis("TransactionID2");
        basic8.setGroupBorrowerCode("A0023");
        basic8.setGroupAxis("AIR LIQUIDE GROUP");
        basic8.setIndustryCodeAxis("74201");
        basic8.setIndustryNameAxis("Architectural/Engineering Technical Activity");
        basic8.setLeadBankNameAxis("KRISHNA BHIMA SAMRUDDHI LAB LTD.");
        basic8.setCounterPartyBankNameAxis("");
        basic8.setCounterPartyBankDomicileAxis("");
        rlcItem8.setRlcBasicInfo(basic8);

        RLCItem rlcItem9 = new RLCItem();

        RLCBasic basic9 = new RLCBasic();
        basic9.setRegionOfBusinessAxis("GlobalMember");
        basic9.setLargeCreditAxis("BorrowerGroupMember");
        basic9.setUniqueTransactionCodeAxis("TransactionID3");
        basic9.setGroupBorrowerCode("A0023");
        basic9.setGroupAxis("AIR LIQUIDE GROUP");
        basic9.setIndustryCodeAxis("40201");
        basic9.setIndustryNameAxis("Mfg of Gas");
        basic9.setLeadBankNameAxis("");
        basic9.setCounterPartyBankNameAxis("");
        basic9.setCounterPartyBankDomicileAxis("");
        rlcItem9.setRlcBasicInfo(basic9);

        RLCItem rlcItem10 = new RLCItem();

        RLCBasic basic10 = new RLCBasic();
        basic10.setRegionOfBusinessAxis("GlobalMember");
        basic10.setLargeCreditAxis("BorrowerGroupMember");
        basic10.setUniqueTransactionCodeAxis("TransactionID4");
        basic10.setGroupBorrowerCode("A0023");
        basic10.setGroupAxis("AIR LIQUIDE GROUP");
        basic10.setIndustryCodeAxis("29209");
        basic10.setIndustryNameAxis("Mfg of Other Special Purpose Machinery");
        basic10.setLeadBankNameAxis("Kotak Mahindra Bank Ltd.");
        basic10.setCounterPartyBankNameAxis("");
        basic10.setCounterPartyBankDomicileAxis("");
        rlcItem10.setRlcBasicInfo(basic10);

        RLCItem rlcItem11 = new RLCItem();

        RLCBasic basic11 = new RLCBasic();
        basic11.setRegionOfBusinessAxis("GlobalMember");
        basic11.setLargeCreditAxis("BorrowerGroupMember");
        basic11.setUniqueTransactionCodeAxis("TransactionID5");
        basic11.setGroupBorrowerCode("A0032");
        basic11.setGroupAxis("ALSTOM GROUP");
        basic11.setIndustryCodeAxis("35201");
        basic11.setIndustryNameAxis("Mfg of Railway and Tramway Locos etc");
        basic11.setLeadBankNameAxis("HDFC Bank Ltd.");
        basic11.setCounterPartyBankNameAxis("");
        basic11.setCounterPartyBankDomicileAxis("");
        rlcItem11.setRlcBasicInfo(basic11);

        RLCItem rlcItem12 = new RLCItem();

        RLCBasic basic12 = new RLCBasic();
        basic12.setRegionOfBusinessAxis("GlobalMember");
        basic12.setLargeCreditAxis("BorrowerGroupMember");
        basic12.setUniqueTransactionCodeAxis("");
        basic12.setIndustryCodeAxis("");
        basic12.setIndustryNameAxis("");
        basic12.setLeadBankNameAxis("");
        basic12.setGroupBorrowerCode("");
        basic12.setGroupAxis("");
        basic12.setCounterPartyBankNameAxis("");
        basic12.setCounterPartyBankDomicileAxis("");
        rlcItem12.setRlcBasicInfo(basic12);

        RLCItem rlcItem13 = new RLCItem();

        RLCBasic basic13 = new RLCBasic();
        basic13.setLargeCreditAxis("CounterPartyBankMember");
        basic13.setRegionOfBusinessAxis("DomesticMember");
        basic13.setCounterPartyBankNameAxis("National Bank for Agriculture and Rural Development");
        basic13.setCounterPartyBankDomicileAxis("ANGUILLA");
        basic13.setUniqueTransactionCodeAxis("TransactionID1");
        basic13.setIndustryCodeAxis("");
        basic13.setIndustryNameAxis("");
        basic13.setLeadBankNameAxis("");
        basic13.setGroupBorrowerCode("");
        basic13.setGroupAxis("");
        rlcItem13.setRlcBasicInfo(basic13);

        RLCItem rlcItem14 = new RLCItem();

        RLCBasic basic14 = new RLCBasic();
        basic14.setLargeCreditAxis("CounterPartyBankMember");
        basic14.setRegionOfBusinessAxis("DomesticMember");
        basic14.setCounterPartyBankNameAxis("Subhadra Local Area Bank Ltd.");
        basic14.setCounterPartyBankDomicileAxis("AFGHANISTAN");
        basic14.setUniqueTransactionCodeAxis("TransactionID2");
        basic14.setIndustryCodeAxis("");
        basic14.setIndustryNameAxis("");
        basic14.setLeadBankNameAxis("");
        basic14.setGroupBorrowerCode("");
        basic14.setGroupAxis("");
        rlcItem14.setRlcBasicInfo(basic14);

        RLCItem rlcItem15 = new RLCItem();

        RLCBasic basic15 = new RLCBasic();
        basic15.setLargeCreditAxis("CounterPartyBankMember");
        basic15.setRegionOfBusinessAxis("DomesticMember");
        basic15.setCounterPartyBankNameAxis("HDFC Bank Ltd.");
        basic15.setCounterPartyBankDomicileAxis("Antarctica");
        basic15.setUniqueTransactionCodeAxis("TransactionID3");
        basic15.setIndustryCodeAxis("");
        basic15.setIndustryNameAxis("");
        basic15.setLeadBankNameAxis("");
        basic15.setGroupBorrowerCode("");
        basic15.setGroupAxis("");
        rlcItem15.setRlcBasicInfo(basic15);

        RLCItem rlcItem16 = new RLCItem();

        RLCBasic basic16 = new RLCBasic();
        basic16.setLargeCreditAxis("CounterPartyBankMember");
        basic16.setRegionOfBusinessAxis("DomesticMember");
        basic16.setCounterPartyBankNameAxis("Kotak Mahindra Bank Ltd.");
        basic16.setCounterPartyBankDomicileAxis("BONAIRE,SINT EUSTATIUS AND SABA");
        basic16.setUniqueTransactionCodeAxis("TransactionID4");
        basic16.setIndustryCodeAxis("");
        basic16.setIndustryNameAxis("");
        basic16.setLeadBankNameAxis("");
        basic16.setGroupBorrowerCode("");
        basic16.setGroupAxis("");
        rlcItem16.setRlcBasicInfo(basic16);

        RLCItem rlcItem17 = new RLCItem();

        RLCBasic basic17 = new RLCBasic();
        basic17.setLargeCreditAxis("CounterPartyBankMember");
        basic17.setRegionOfBusinessAxis("DomesticMember");
        basic17.setCounterPartyBankNameAxis("KRUNG THAI BANK PUBLIC COMPANY LIMITED.");
        basic17.setCounterPartyBankDomicileAxis("BOUVET ISLAND");
        basic17.setUniqueTransactionCodeAxis("TransactionID5");
        basic17.setIndustryCodeAxis("");
        basic17.setIndustryNameAxis("");
        basic17.setLeadBankNameAxis("");
        basic17.setGroupBorrowerCode("");
        basic17.setGroupAxis("");
        rlcItem17.setRlcBasicInfo(basic17);

        RLCItem rlcItem18 = new RLCItem();

        RLCBasic basic18 = new RLCBasic();
        basic18.setLargeCreditAxis("CounterPartyBankMember");
        basic18.setRegionOfBusinessAxis("DomesticMember");
        basic18.setCounterPartyBankNameAxis("");
        basic18.setCounterPartyBankDomicileAxis("");
        basic18.setUniqueTransactionCodeAxis("");
        basic18.setIndustryCodeAxis("");
        basic18.setIndustryNameAxis("");
        basic18.setLeadBankNameAxis("");
        basic18.setGroupBorrowerCode("");
        basic18.setGroupAxis("");
        rlcItem18.setRlcBasicInfo(basic18);

        RLCItem rlcItem19 = new RLCItem();

        RLCBasic basic19 = new RLCBasic();
        basic19.setLargeCreditAxis("CounterPartyBankMember");
        basic19.setRegionOfBusinessAxis("OverseasMember");
        basic19.setCounterPartyBankNameAxis("Bank of China");
        basic19.setCounterPartyBankDomicileAxis("BAHAMAS");
        basic19.setUniqueTransactionCodeAxis("TransactionID1");
        basic19.setIndustryCodeAxis("");
        basic19.setIndustryNameAxis("");
        basic19.setLeadBankNameAxis("");
        basic19.setGroupBorrowerCode("");
        basic19.setGroupAxis("");
        rlcItem19.setRlcBasicInfo(basic19);

        RLCItem rlcItem20 = new RLCItem();

        RLCBasic basic20 = new RLCBasic();
        basic20.setLargeCreditAxis("CounterPartyBankMember");
        basic20.setRegionOfBusinessAxis("OverseasMember");
        basic20.setCounterPartyBankNameAxis("KEB HANA BANK");
        basic20.setCounterPartyBankDomicileAxis("Bosnia");
        basic20.setUniqueTransactionCodeAxis("TransactionID2");
        basic20.setIndustryCodeAxis("");
        basic20.setIndustryNameAxis("");
        basic20.setLeadBankNameAxis("");
        basic20.setGroupBorrowerCode("");
        basic20.setGroupAxis("");
        rlcItem20.setRlcBasicInfo(basic20);

        RLCItem rlcItem21 = new RLCItem();

        RLCBasic basic21 = new RLCBasic();
        basic21.setLargeCreditAxis("CounterPartyBankMember");
        basic21.setRegionOfBusinessAxis("OverseasMember");
        basic21.setCounterPartyBankNameAxis("MUFG Bank Ltd.");
        basic21.setCounterPartyBankDomicileAxis("CANARY ISLANDS");
        basic21.setUniqueTransactionCodeAxis("TransactionID3");
        basic21.setIndustryCodeAxis("");
        basic21.setIndustryNameAxis("");
        basic21.setLeadBankNameAxis("");
        basic21.setGroupBorrowerCode("");
        basic21.setGroupAxis("");
        rlcItem21.setRlcBasicInfo(basic21);

        RLCItem rlcItem22 = new RLCItem();

        RLCBasic basic22 = new RLCBasic();
        basic22.setLargeCreditAxis("CounterPartyBankMember");
        basic22.setRegionOfBusinessAxis("OverseasMember");
        basic22.setCounterPartyBankNameAxis("SOUTH INDIAN BANK LTD");
        basic22.setCounterPartyBankDomicileAxis("Central African Republic");
        basic22.setUniqueTransactionCodeAxis("TransactionID4");
        basic22.setIndustryCodeAxis("");
        basic22.setIndustryNameAxis("");
        basic22.setLeadBankNameAxis("");
        basic22.setGroupBorrowerCode("");
        basic22.setGroupAxis("");
        rlcItem22.setRlcBasicInfo(basic22);

        RLCItem rlcItem23 = new RLCItem();

        RLCBasic basic23 = new RLCBasic();
        basic23.setLargeCreditAxis("CounterPartyBankMember");
        basic23.setRegionOfBusinessAxis("OverseasMember");
        basic23.setCounterPartyBankNameAxis("MASHREQ BANK PSC");
        basic23.setCounterPartyBankDomicileAxis("GUINEA");
        basic23.setUniqueTransactionCodeAxis("TransactionID5");
        basic23.setIndustryCodeAxis("");
        basic23.setIndustryNameAxis("");
        basic23.setLeadBankNameAxis("");
        basic23.setGroupBorrowerCode("");
        basic23.setGroupAxis("");
        rlcItem23.setRlcBasicInfo(basic23);

        RLCItem rlcItem24 = new RLCItem();

        RLCBasic basic24 = new RLCBasic();
        basic24.setLargeCreditAxis("CounterPartyBankMember");
        basic24.setRegionOfBusinessAxis("DomesticMember");
        basic24.setCounterPartyBankNameAxis("");
        basic24.setCounterPartyBankDomicileAxis("");
        basic24.setUniqueTransactionCodeAxis("");
        basic24.setIndustryCodeAxis("");
        basic24.setIndustryNameAxis("");
        basic24.setLeadBankNameAxis("");
        basic24.setGroupBorrowerCode("");
        basic24.setGroupAxis("");
        rlcItem24.setRlcBasicInfo(basic24);

        RLCItem rlcItem25 = new RLCItem();

        RLCBasic basic25 = new RLCBasic();
        basic25.setRegionOfBusinessAxis("GlobalMember");
        basic25.setLargeCreditAxis("CounterPartyBankMember");
        basic25.setCounterPartyBankNameAxis("IDBI BANK LIMITED");
        basic25.setCounterPartyBankDomicileAxis("ARUBA");
        basic25.setUniqueTransactionCodeAxis("TransactionID1");
        basic25.setIndustryCodeAxis("");
        basic25.setIndustryNameAxis("");
        basic25.setLeadBankNameAxis("");
        basic25.setGroupBorrowerCode("");
        basic25.setGroupAxis("");
        rlcItem25.setRlcBasicInfo(basic25);

        RLCItem rlcItem26 = new RLCItem();

        RLCBasic basic26 = new RLCBasic();
        basic26.setRegionOfBusinessAxis("GlobalMember");
        basic26.setLargeCreditAxis("CounterPartyBankMember");
        basic26.setCounterPartyBankNameAxis("BANK OF BAHRAIN &amp; KUWAIT B.S.C.");
        basic26.setCounterPartyBankDomicileAxis("Central African Republic");
        basic26.setUniqueTransactionCodeAxis("TransactionID2");
        basic26.setIndustryCodeAxis("");
        basic26.setIndustryNameAxis("");
        basic26.setLeadBankNameAxis("");
        basic26.setGroupBorrowerCode("");
        basic26.setGroupAxis("");
        rlcItem26.setRlcBasicInfo(basic26);

        RLCItem rlcItem27 = new RLCItem();

        RLCBasic basic27 = new RLCBasic();
        basic27.setRegionOfBusinessAxis("GlobalMember");
        basic27.setLargeCreditAxis("CounterPartyBankMember");
        basic27.setCounterPartyBankNameAxis("Societe Generale");
        basic27.setCounterPartyBankDomicileAxis("Ethiopia");
        basic27.setUniqueTransactionCodeAxis("TransactionID3");
        basic27.setIndustryCodeAxis("");
        basic27.setIndustryNameAxis("");
        basic27.setLeadBankNameAxis("");
        basic27.setGroupBorrowerCode("");
        basic27.setGroupAxis("");
        rlcItem27.setRlcBasicInfo(basic27);

        RLCItem rlcItem28 = new RLCItem();

        RLCBasic basic28 = new RLCBasic();
        basic28.setRegionOfBusinessAxis("GlobalMember");
        basic28.setLargeCreditAxis("CounterPartyBankMember");
        basic28.setCounterPartyBankNameAxis("Bank Of Nova Scotia");
        basic28.setCounterPartyBankDomicileAxis("Trinidad And Tobago");
        basic28.setUniqueTransactionCodeAxis("TransactionID4");
        basic28.setIndustryCodeAxis("");
        basic28.setIndustryNameAxis("");
        basic28.setLeadBankNameAxis("");
        basic28.setGroupBorrowerCode("");
        basic28.setGroupAxis("");
        rlcItem28.setRlcBasicInfo(basic28);

        RLCItem rlcItem29 = new RLCItem();

        RLCBasic basic29 = new RLCBasic();
        basic29.setRegionOfBusinessAxis("GlobalMember");
        basic29.setLargeCreditAxis("CounterPartyBankMember");
        basic29.setCounterPartyBankNameAxis("Credit Agricole Corporate And Investment Bank");
        basic29.setCounterPartyBankDomicileAxis("Western Sahara");
        basic29.setUniqueTransactionCodeAxis("TransactionID5");
        basic29.setIndustryCodeAxis("");
        basic29.setIndustryNameAxis("");
        basic29.setLeadBankNameAxis("");
        basic29.setGroupBorrowerCode("");
        basic29.setGroupAxis("");
        rlcItem29.setRlcBasicInfo(basic29);

        RLCItem rlcItem30 = new RLCItem();

        RLCBasic basic30 = new RLCBasic();
        basic30.setRegionOfBusinessAxis("GlobalMember");
        basic30.setLargeCreditAxis("CounterPartyBankMember");
        basic30.setCounterPartyBankNameAxis("");
        basic30.setCounterPartyBankDomicileAxis("");
        basic30.setUniqueTransactionCodeAxis("");
        basic30.setIndustryCodeAxis("");
        basic30.setIndustryNameAxis("");
        basic30.setLeadBankNameAxis("");
        basic30.setGroupBorrowerCode("");
        basic30.setGroupAxis("");
        rlcItem30.setRlcBasicInfo(basic30);


        data.getRlcItem().add(rlcItem1);
        data.getRlcItem().add(rlcItem2);
        data.getRlcItem().add(rlcItem3);
        data.getRlcItem().add(rlcItem4);
        data.getRlcItem().add(rlcItem5);
        data.getRlcItem().add(rlcItem6);
        data.getRlcItem().add(rlcItem7);
        data.getRlcItem().add(rlcItem8);
        data.getRlcItem().add(rlcItem9);
        data.getRlcItem().add(rlcItem10);
        data.getRlcItem().add(rlcItem11);
        data.getRlcItem().add(rlcItem12);
        data.getRlcItem().add(rlcItem13);
        data.getRlcItem().add(rlcItem14);
        data.getRlcItem().add(rlcItem15);
        data.getRlcItem().add(rlcItem16);
        data.getRlcItem().add(rlcItem17);
        data.getRlcItem().add(rlcItem18);
        data.getRlcItem().add(rlcItem19);
        data.getRlcItem().add(rlcItem20);
        data.getRlcItem().add(rlcItem21);
        data.getRlcItem().add(rlcItem22);
        data.getRlcItem().add(rlcItem23);
        data.getRlcItem().add(rlcItem24);
        data.getRlcItem().add(rlcItem25);
        data.getRlcItem().add(rlcItem26);
        data.getRlcItem().add(rlcItem27);
        data.getRlcItem().add(rlcItem28);
        data.getRlcItem().add(rlcItem29);
        data.getRlcItem().add(rlcItem30);

        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        engine.execute(ReportGenerationFactory.RBI_RLC_XBRL_REPORT, data);
        
    }
    
}
