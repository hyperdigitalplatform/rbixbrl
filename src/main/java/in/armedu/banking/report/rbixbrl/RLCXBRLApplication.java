package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralInfo;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCReportData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCBasic;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCBorrowerMember;

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
        data.setRlcGeneralData(rlcGeneralData);

        // Basic RLC Info

        RLCItem rlcItemIndividual = new RLCItem();

        RLCBasic basicInfoIndividual = new RLCBasic();
        basicInfoIndividual.setRegionOfBusinessAxis("GlobalMember");
        basicInfoIndividual.setLargeCreditAxis("IndividualBorrowersMember");
        basicInfoIndividual.setUniqueTransactionCodeAxis("TransactionID1");
        basicInfoIndividual.setIndustryCodeAxis("28101");
        basicInfoIndividual.setIndustryNameAxis("Mfg of Structural Metal Products");
        basicInfoIndividual.setLeadBankNameAxis("Bank Of Baroda");
        basicInfoIndividual.setGroupBorrowerCode("");
        basicInfoIndividual.setGroupAxis("");
        // basicInfoIndividual.setCounterPartyBankNameAxis("");
        // basicInfoIndividual.setCounterPartyBankDomicileAxis("");      
        
        RLCBorrowerMember borrowerMemberIndividual = new RLCBorrowerMember();
        borrowerMemberIndividual.setPermanentAccountNumberOfCustomerOrBorrower("AAACW0744L");
        borrowerMemberIndividual.setCustomerName("WELSPUN CORPORATION LIMITED");
        borrowerMemberIndividual.setSectorCode("30-Private");
        borrowerMemberIndividual.setBankingArrangement("6-Multiple Arrangement and Consortium");
        borrowerMemberIndividual.setInternalRating("C");
        borrowerMemberIndividual.setExternalRating("Not-Rated");
        borrowerMemberIndividual.setAssetClassificationRLC("S-Standard");
        borrowerMemberIndividual.setLimitSanctionedForFundedExposure("1282406000");
        borrowerMemberIndividual.setAmountOutstandingForFundedExposure("438913000");
        borrowerMemberIndividual.setAmountEligibleForNettingFromFundedExposure("0");
        borrowerMemberIndividual.setAmountOfFundedExposure("1282406000");
        borrowerMemberIndividual.setLimitSanctionedForNonFundedExposure("2006594000");
        borrowerMemberIndividual.setAmountOutstandingForNonFundedExposure("2006594000");
        borrowerMemberIndividual.setAmountEligibleForNettingFromNonFundedExposure("0");
        borrowerMemberIndividual.setAmountOfNonFundedExposure("2006594000");
        borrowerMemberIndividual.setAggregateLimitSanctioned("3289000000");
        borrowerMemberIndividual.setAggregateAmountOutstanding("2445507000");
        borrowerMemberIndividual.setAggregateCreditExposure("3289000000");
        borrowerMemberIndividual.setAggregateCreditExposureAsPercentageOfCapitalFunds("0.0299");
        borrowerMemberIndividual.setAggregateInvestmentExposure("0");
        borrowerMemberIndividual.setAggregateExposure("3289000000");
        borrowerMemberIndividual.setAggregateExposureAsPercentageOfCapitalFunds("0.0299");

        RLCItem rlcItemGroupBorrowerMember = new RLCItem();

        RLCBasic basicInfoBorrowerGroup = new RLCBasic();
        basicInfoBorrowerGroup.setRegionOfBusinessAxis("GlobalMember");
        basicInfoBorrowerGroup.setLargeCreditAxis("BorrowerGroupMember");
        basicInfoBorrowerGroup.setUniqueTransactionCodeAxis("TransactionID1");
        basicInfoBorrowerGroup.setIndustryCodeAxis("40201");
        basicInfoBorrowerGroup.setIndustryNameAxis("Mfg of Gas");
        basicInfoBorrowerGroup.setGroupBorrowerCode("A0023");
        basicInfoBorrowerGroup.setGroupAxis("AIR LIQUIDE GROUP");
        basicInfoBorrowerGroup.setLeadBankNameAxis("");
        // basicInfoBorrowerGroup.setCounterPartyBankNameAxis("");
        // basicInfoBorrowerGroup.setCounterPartyBankDomicileAxis("");

        RLCBorrowerMember borrowerMemberGroup = new RLCBorrowerMember();
        borrowerMemberGroup.setPermanentAccountNumberOfCustomerOrBorrower("AAACA9121F");
        borrowerMemberGroup.setCustomerName("AIR LIQUIDE INDIA HOLDING PVT LTD");
        borrowerMemberGroup.setSectorCode("30-Private");
        borrowerMemberGroup.setBankingArrangement("2-Multiple Arrangement");
        borrowerMemberGroup.setInternalRating("C");
        borrowerMemberGroup.setExternalRating("Not-Rated");
        borrowerMemberGroup.setAssetClassificationRLC("S-Standard");
        borrowerMemberGroup.setLimitSanctionedForFundedExposure("350000000");
        borrowerMemberGroup.setAmountOutstandingForFundedExposure("350000000");
        borrowerMemberGroup.setAmountEligibleForNettingFromFundedExposure("0");
        borrowerMemberGroup.setAmountOfFundedExposure("350000000");
        borrowerMemberGroup.setLimitSanctionedForNonFundedExposure("0");
        borrowerMemberGroup.setAmountOutstandingForNonFundedExposure("0");
        borrowerMemberGroup.setAmountEligibleForNettingFromNonFundedExposure("0");
        borrowerMemberGroup.setAmountOfNonFundedExposure("0");
        borrowerMemberGroup.setAggregateLimitSanctioned("350000000");
        borrowerMemberGroup.setAggregateAmountOutstanding("350000000");
        borrowerMemberGroup.setAggregateCreditExposure("350000000");
        borrowerMemberGroup.setAggregateCreditExposureAsPercentageOfCapitalFunds("31.8182");
        borrowerMemberGroup.setAggregateInvestmentExposure("0");
        borrowerMemberGroup.setAggregateExposure("350000000");
        borrowerMemberGroup.setAggregateExposureAsPercentageOfCapitalFunds("31.8182");

        // RLC CounterParty Domestic
        RLCItem rlcItemCounterPartyDomestic = new RLCItem();

        RLCBasic basicInfoCounterPartyDomestic = new RLCBasic();
        basicInfoCounterPartyDomestic.setRegionOfBusinessAxis("DomesticMember");
        basicInfoCounterPartyDomestic.setLargeCreditAxis("CounterPartyBankMember");
        basicInfoCounterPartyDomestic.setUniqueTransactionCodeAxis("TransactionID1");
        basicInfoCounterPartyDomestic.setCounterPartyBankNameAxis("YES BANK LTD.");
        basicInfoCounterPartyDomestic.setCounterPartyBankDomicileAxis("ALAND ISLANDS");
        // basicInfoCounterPartyDomestic.setIndustryCodeAxis("");
        // basicInfoCounterPartyDomestic.setIndustryNameAxis("");
        // basicInfoCounterPartyDomestic.setGroupBorrowerCode("");
        // basicInfoCounterPartyDomestic.setGroupAxis("");
        // basicInfoCounterPartyDomestic.setLeadBankNameAxis("");


        RLCBorrowerMember counterPartyDomestic = new RLCBorrowerMember();
        counterPartyDomestic.setAmountOfFundedExposure("4500000");
        counterPartyDomestic.setAmountOfNonFundedExposure("876700000");
        counterPartyDomestic.setAggregateCreditExposure("881200000");
        counterPartyDomestic.setAggregateCreditExposureAsPercentageOfCapitalFunds("80.1091");

        
        rlcItemIndividual.setRlcBasicInfo(basicInfoIndividual);
        rlcItemIndividual.setRlcBorrowerMember(borrowerMemberIndividual);

        rlcItemGroupBorrowerMember.setRlcBasicInfo(basicInfoBorrowerGroup);
        rlcItemGroupBorrowerMember.setRlcBorrowerMember(borrowerMemberGroup);

        rlcItemCounterPartyDomestic.setRlcBasicInfo(basicInfoCounterPartyDomestic);
        rlcItemCounterPartyDomestic.setRlcBorrowerMember(counterPartyDomestic);

        data.getRlcItem().add(rlcItemIndividual);   

        data.getRlcItem().add(rlcItemGroupBorrowerMember);   

        data.getRlcItem().add(rlcItemCounterPartyDomestic);   

        //Signatory Details
        RLCGeneralInfo rlcGeneralInfo = new RLCGeneralInfo();
        rlcGeneralInfo.setNameOfSignatory("rtre");
        rlcGeneralInfo.setDesignationOfSignatory("erterte");
        rlcGeneralInfo.setAuthorisedSignatoryMobileNumber("55235235236");
        rlcGeneralInfo.setAuthorisedSignatoryLandlineNumber("52352352355");
        rlcGeneralInfo.setEMailIDOfAuthorisedReportingOfficial("ertertr@m.vom");
        rlcGeneralData.setRlcGeneralInfo(rlcGeneralInfo);
        
        data.setRlcGeneralData(rlcGeneralData);

        
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_RLC_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("file.txt");
        fw.write(sw.toString());
        fw.close();
        
    }
    
}
