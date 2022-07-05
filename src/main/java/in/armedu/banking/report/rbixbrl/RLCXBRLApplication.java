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
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralIndividual;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralBorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralCounterDomestic;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralCounterGlobal;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCIndividualMember;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCBorrowerGroupMember;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCCounterPartyDomestic;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCCounterPartyGlobal;

public class RLCXBRLApplication {
    public static void main(String[] args) throws Exception {
        RLCReportData data = new RLCReportData();

        RLCGeneralData rlcGeneralData = new RLCGeneralData();
        rlcGeneralData.setReturnName("Report on Large Credit");
        rlcGeneralData.setReturnCode("RLC");
        rlcGeneralData.setNameOfReportingInstitution("Allahabad UP Gramin Bank");
        rlcGeneralData.setBankCode("362");
        rlcGeneralData.setAddress("AUDUau");
        rlcGeneralData.setReportForTheYearEnded("2020-09-30");                //end Date
        rlcGeneralData.setReportingFrequency("Quarterly");
        rlcGeneralData.setReportStatus("Un-Audited");
        rlcGeneralData.setWhetherNilReporting("false");
        rlcGeneralData.setCategoriesOfBanks("Domestic bank with overseas branches");
        rlcGeneralData.setReturnVersion("V1.5");
        rlcGeneralData.setGeneralRemarks("df weru werwer null");
        rlcGeneralData.setReportingPeriodStartDate("2020-07-01");               //start Date
        rlcGeneralData.setRegulatoryCapital("1000000");
        rlcGeneralData.setCapitalInfusion("10000000");        
        rlcGeneralData.setLastEndDate("2020-03-31");             //LastYearEndDate

        // general body details borrower group global member
        RLCGeneralIndividual rlcGeneralIndividual = new RLCGeneralIndividual();
        rlcGeneralIndividual.setLimitSanctionedForFundedExposure("58382463000");
        rlcGeneralIndividual.setAmountOutstandingForFundedExposure("25475990000");
        rlcGeneralIndividual.setAmountEligibleForNettingFromFundedExposure("65600000");
        rlcGeneralIndividual.setAmountOfFundedExposure("57594563000");
        rlcGeneralIndividual.setLimitSanctionedForNonFundedExposure("53834821000");
        rlcGeneralIndividual.setAmountOutstandingForNonFundedExposure("36200156000");
        rlcGeneralIndividual.setAmountEligibleForNettingFromNonFundedExposure("454500000");
        rlcGeneralIndividual.setAmountOfNonFundedExposure("55010521000");
        rlcGeneralIndividual.setAggregateLimitSanctioned("112217284000");
        rlcGeneralIndividual.setAggregateAmountOutstanding("61676146000");
        rlcGeneralIndividual.setAggregateCreditExposure("112605084000");
        rlcGeneralIndividual.setAggregateCreditExposureAsPercentageOfCapitalFunds("10236.8258");
        rlcGeneralIndividual.setAggregateInvestmentExposure("45400000");
        rlcGeneralIndividual.setAggregateExposure("112650484000");
        rlcGeneralIndividual.setAggregateExposureAsPercentageOfCapitalFunds("10240.9531");
        rlcGeneralData.setRlcGeneralIndividual(rlcGeneralIndividual);


        // general body details borrower group global member
        RLCGeneralBorrowerGroup rlcGeneralBorrowerGroup = new RLCGeneralBorrowerGroup();
        rlcGeneralBorrowerGroup.setLimitSanctionedForFundedExposure("34676375000");
        rlcGeneralBorrowerGroup.setAmountOutstandingForFundedExposure("14131578000");
        rlcGeneralBorrowerGroup.setAmountEligibleForNettingFromFundedExposure("0");
        rlcGeneralBorrowerGroup.setAmountOfFundedExposure("34676375000");
        rlcGeneralBorrowerGroup.setLimitSanctionedForNonFundedExposure("18215116000");
        rlcGeneralBorrowerGroup.setAmountOutstandingForNonFundedExposure("11951648000");
        rlcGeneralBorrowerGroup.setAmountEligibleForNettingFromNonFundedExposure("0");
        rlcGeneralBorrowerGroup.setAmountOfNonFundedExposure("18215116000");
        rlcGeneralBorrowerGroup.setAggregateLimitSanctioned("52891491000");
        rlcGeneralBorrowerGroup.setAggregateAmountOutstanding("26083226000");
        rlcGeneralBorrowerGroup.setAggregateCreditExposure("52891491000");
        rlcGeneralBorrowerGroup.setAggregateCreditExposureAsPercentageOfCapitalFunds("4808.3174");
        rlcGeneralBorrowerGroup.setAggregateInvestmentExposure("0");
        rlcGeneralBorrowerGroup.setAggregateExposure("52891491000");
        rlcGeneralBorrowerGroup.setAggregateExposureAsPercentageOfCapitalFunds("4808.3174");
        rlcGeneralData.setRlcGeneralBorrowerGroup(rlcGeneralBorrowerGroup);

        // general counter party domestic
        RLCGeneralCounterDomestic rlcGeneralCounterDomestic = new RLCGeneralCounterDomestic();
        rlcGeneralCounterDomestic.setAmountOfFundedExposure("109760000000");
        rlcGeneralCounterDomestic.setAmountOfNonFundedExposure("149534200000");
        rlcGeneralCounterDomestic.setAggregateCreditExposure("259294200000");
        rlcGeneralCounterDomestic.setAggregateExposureAsPercentageOfCapitalFunds("23572.2");
        rlcGeneralData.setRlcGeneralCounterDomestic(rlcGeneralCounterDomestic);

        // general counter party global
        RLCGeneralCounterGlobal rlcGeneralCounterGlobal = new RLCGeneralCounterGlobal();
        rlcGeneralCounterGlobal.setAmountOfFundedExposure("109760000000");
        rlcGeneralCounterGlobal.setAmountOfNonFundedExposure("149534200000");
        rlcGeneralCounterGlobal.setAggregateCreditExposure("259294200000");
        rlcGeneralCounterGlobal.setAggregateExposureAsPercentageOfCapitalFunds("23572.2");
        rlcGeneralData.setRlcGeneralCounterGlobal(rlcGeneralCounterGlobal);

        data.setRlcGeneralData(rlcGeneralData);

        // Basic RLC Item Info

        RLCItem rlcItem = new RLCItem();

        // for IndividualMember
        RLCIndividualMember rlcIndividualMember = new RLCIndividualMember();

        rlcIndividualMember.setUniqueTransactionCodeAxis("TransactionID1");
        rlcIndividualMember.setIndustryCodeAxis("28101");
        rlcIndividualMember.setIndustryNameAxis("Mfg of Structural Metal Products");
        rlcIndividualMember.setLeadBankNameAxis("Bank Of Baroda");

        rlcIndividualMember.setPermanentAccountNumberOfCustomerOrBorrower("AAACW0744L");
        rlcIndividualMember.setCustomerName("WELSPUN CORPORATION LIMITED");
        rlcIndividualMember.setSectorCode("30-Private");
        rlcIndividualMember.setBankingArrangement("6-Multiple Arrangement and Consortium");
        rlcIndividualMember.setInternalRating("C");
        rlcIndividualMember.setExternalRating("Not-Rated");
        rlcIndividualMember.setAssetClassificationRLC("S-Standard");
        rlcIndividualMember.setLimitSanctionedForFundedExposure("1282406000");
        rlcIndividualMember.setAmountOutstandingForFundedExposure("438913000");
        rlcIndividualMember.setAmountEligibleForNettingFromFundedExposure("0");
        rlcIndividualMember.setAmountOfFundedExposure("1282406000");
        rlcIndividualMember.setLimitSanctionedForNonFundedExposure("2006594000");
        rlcIndividualMember.setAmountOutstandingForNonFundedExposure("2006594000");
        rlcIndividualMember.setAmountEligibleForNettingFromNonFundedExposure("0");
        rlcIndividualMember.setAmountOfNonFundedExposure("2006594000");
        rlcIndividualMember.setAggregateLimitSanctioned("3289000000");
        rlcIndividualMember.setAggregateAmountOutstanding("2445507000");
        rlcIndividualMember.setAggregateCreditExposure("3289000000");
        rlcIndividualMember.setAggregateCreditExposureAsPercentageOfCapitalFunds("0.0299");
        rlcIndividualMember.setAggregateInvestmentExposure("0");
        rlcIndividualMember.setAggregateExposure("3289000000");
        rlcIndividualMember.setAggregateExposureAsPercentageOfCapitalFunds("0.0299");

        // for BorrowerGroupMember
        RLCBorrowerGroupMember rlcBorrowerGroupMember = new RLCBorrowerGroupMember();

        rlcBorrowerGroupMember.setUniqueTransactionCodeAxis("TransactionID1");
        rlcBorrowerGroupMember.setIndustryCodeAxis("40201");
        rlcBorrowerGroupMember.setIndustryNameAxis("Mfg of Gas");
        rlcBorrowerGroupMember.setGroupBorrowerCode("A0023");
        rlcBorrowerGroupMember.setGroupAxis("AIR LIQUIDE GROUP");

        rlcBorrowerGroupMember.setPermanentAccountNumberOfCustomerOrBorrower("AAACA9121F");
        rlcBorrowerGroupMember.setCustomerName("AIR LIQUIDE INDIA HOLDING PVT LTD");
        rlcBorrowerGroupMember.setSectorCode("30-Private");
        rlcBorrowerGroupMember.setBankingArrangement("2-Multiple Arrangement");
        rlcBorrowerGroupMember.setInternalRating("C");
        rlcBorrowerGroupMember.setExternalRating("Not-Rated");
        rlcBorrowerGroupMember.setAssetClassificationRLC("S-Standard");
        rlcBorrowerGroupMember.setLimitSanctionedForFundedExposure("350000000");
        rlcBorrowerGroupMember.setAmountOutstandingForFundedExposure("350000000");
        rlcBorrowerGroupMember.setAmountEligibleForNettingFromFundedExposure("0");
        rlcBorrowerGroupMember.setAmountOfFundedExposure("350000000");
        rlcBorrowerGroupMember.setLimitSanctionedForNonFundedExposure("0");
        rlcBorrowerGroupMember.setAmountOutstandingForNonFundedExposure("0");
        rlcBorrowerGroupMember.setAmountEligibleForNettingFromNonFundedExposure("0");
        rlcBorrowerGroupMember.setAmountOfNonFundedExposure("0");
        rlcBorrowerGroupMember.setAggregateLimitSanctioned("350000000");
        rlcBorrowerGroupMember.setAggregateAmountOutstanding("350000000");
        rlcBorrowerGroupMember.setAggregateCreditExposure("350000000");
        rlcBorrowerGroupMember.setAggregateCreditExposureAsPercentageOfCapitalFunds("31.8182");
        rlcBorrowerGroupMember.setAggregateInvestmentExposure("0");
        rlcBorrowerGroupMember.setAggregateExposure("350000000");
        rlcBorrowerGroupMember.setAggregateExposureAsPercentageOfCapitalFunds("31.8182");

        // RLC CounterParty Domestic
        RLCCounterPartyDomestic rlcCounterPartyDomesticMember = new RLCCounterPartyDomestic();

        rlcCounterPartyDomesticMember.setUniqueTransactionCodeAxis("TransactionID1");
        rlcCounterPartyDomesticMember.setCounterPartyBankNameAxis("YES BANK LTD.");
        rlcCounterPartyDomesticMember.setCounterPartyBankDomicileAxis("ALAND ISLANDS");
        
        rlcCounterPartyDomesticMember.setAmountOfFundedExposure("4500000");
        rlcCounterPartyDomesticMember.setAmountOfNonFundedExposure("876700000");
        rlcCounterPartyDomesticMember.setAggregateCreditExposure("881200000");
        rlcCounterPartyDomesticMember.setAggregateExposureAsPercentageOfCapitalFunds("80.1091");

        // RLC CounterParty Global
        RLCCounterPartyGlobal rlcCounterPartyGlobalMember = new RLCCounterPartyGlobal();

        rlcCounterPartyGlobalMember.setUniqueTransactionCodeAxis("TransactionID1");
        rlcCounterPartyGlobalMember.setCounterPartyBankNameAxis("YES BANK LTD.");
        rlcCounterPartyGlobalMember.setCounterPartyBankDomicileAxis("ALAND ISLANDS");
        
        rlcCounterPartyGlobalMember.setAmountOfFundedExposure("4500000");
        rlcCounterPartyGlobalMember.setAmountOfNonFundedExposure("876700000");
        rlcCounterPartyGlobalMember.setAggregateCreditExposure("881200000");
        rlcCounterPartyGlobalMember.setAggregateExposureAsPercentageOfCapitalFunds("80.1091");

        rlcItem.setRlcIndividualMember(rlcIndividualMember);

        rlcItem.setRlcBorrowerGroupMember(rlcBorrowerGroupMember);

        rlcItem.setRlcCounterPartyDomestic(rlcCounterPartyDomesticMember);

        rlcItem.setRlcCounterPartyGlobal(rlcCounterPartyGlobalMember);

        data.getRlcItem().add(rlcItem);   


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
