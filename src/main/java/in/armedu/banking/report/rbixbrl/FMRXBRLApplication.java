package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.model.fmr.AuthorizedReporting;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRReportData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRItemData;


public class FMRXBRLApplication {
    public static void main(String[] args) throws Exception {
        FMRReportData data = new FMRReportData();

        FMRGeneralData fmrGeneralData = new FMRGeneralData();
        fmrGeneralData.setReturnName("Return on Bank Robberies, Dacoities, Thefts and Burglaries");
        fmrGeneralData.setReturnCode("RBR");
        fmrGeneralData.setReportInstitution("State Bank Of India");
        fmrGeneralData.setBankCode("010");
        fmrGeneralData.setInstitutionAddress("Vashi, Navi Mumbai");
        fmrGeneralData.setQuarterEndDate("2020-12-31");              
        fmrGeneralData.setDateOfSubmission("2021-02-22");
        fmrGeneralData.setReportingFrequency("Quarterly");
        fmrGeneralData.setReturnVersion("V2.0");
        fmrGeneralData.setWhetherNilReporting("false");
        fmrGeneralData.setReportStatus("Audited");
        fmrGeneralData.setReportingPeriodStartDate("2020-10-01");
        data.setGeneralData(fmrGeneralData);

        // FMR Item

        FMRItemData fmrItemData = new FMRItemData();

        fmrItemData.setBranchCode("0000003");
        fmrItemData.setBranchName("AKBARPUR");
        fmrItemData.setDateTimeOfOccurrence("2020-10-22T12:51:00"); 
        fmrItemData.setTypeOfBranch("Rural");
        fmrItemData.setRiskClassificationPhishing("High");
        fmrItemData.setWhetherCurrencyChestBranch("true");
        fmrItemData.setNumberOfArmedGuards("10");
        fmrItemData.setTypeOfCase("Dacoity");
        fmrItemData.setPlaceOfOccurence("In Branch");
        fmrItemData.setAmountInvolvedInCases("524100000");
        fmrItemData.setAmountRecovered("547600000");
        fmrItemData.setInsuranceClaimSettled("571100000");
        fmrItemData.setNumberOfArrestedStaffs("42");
        fmrItemData.setNumberOfArrestedRobbers("45");
        fmrItemData.setNumberOfKilledStaffs("48");
        fmrItemData.setNumberOfKilledRobbers("51");
        fmrItemData.setNumberOfKilledOtherCriminals("54");
        fmrItemData.setNumberOfInjuredStaffs("68");
        fmrItemData.setNumberOfInjuredOtherCriminals("82");
        fmrItemData.setNumberOfConvictedStaffs("96");
        fmrItemData.setNumberOfConvictedRobbers("110");
        fmrItemData.setCompensationPaidStaffs("5946");
        fmrItemData.setCompensationPaidOtherCriminal("6181");
        fmrItemData.setActionTaken("Suit filed");
        fmrItemData.setCrimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered("DHDRFHSDRY");
        fmrItemData.setModusOperandi("PJIOHJIIHO");
       
        data.getItemDatas().add(fmrItemData);

        //Authorized Reporting Details
        AuthorizedReporting authorizedReportingData = new AuthorizedReporting();
        authorizedReportingData.setNameOfAuthorisedReportingOfficial("Prashant Shah");
        authorizedReportingData.setNameOfPersonCountersigned("Jignash Jain");
        authorizedReportingData.setDesignationOfAuthorisedReportingOfficial("Managing director");
        authorizedReportingData.setDesignationOfPersonCountersigned("Cheif executive");
        authorizedReportingData.setEMailIDOfAuthorisedReportingOfficial("PrashantS@gmail.com");
        authorizedReportingData.setEMailIDOfPersonCountersigned("Jian@gmail.com");
        authorizedReportingData.setOfficeTelephoneNumberOfAuthorisedReportingOfficial("1234567891");
        authorizedReportingData.setOfficeTelephoneNumberOfPersonCountersigned("5148769213");
        authorizedReportingData.setResidenceTelephoneNumberOfAuthorisedReportingOfficial("8521479630");
        authorizedReportingData.setResidenceTelephoneNumberOfPersonCountersigned("2135486927");
        authorizedReportingData.setFaxNumberOfAuthorisedReportingOfficial("52468");
        authorizedReportingData.setFaxNumberOfPersonCountersigned("84759");
        authorizedReportingData.setPlaceOfSigningByAuthorisedReportingOfficial("Jaipur");
        authorizedReportingData.setPlaceOfSigningByPersonCountersigned("Vashi");
        authorizedReportingData.setDateOfSigningByAuthorisedReportingOfficial("2021-02-22");
        authorizedReportingData.setDateOfSigningByPersonCountersigned("2021-02-22");
        fmrGeneralData.setAuthorizedReporting(authorizedReportingData);
        
        data.setGeneralData(fmrGeneralData);

        
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_FMR_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("file.txt");
        fw.write(sw.toString());
        fw.close();
        
    }
    
}

