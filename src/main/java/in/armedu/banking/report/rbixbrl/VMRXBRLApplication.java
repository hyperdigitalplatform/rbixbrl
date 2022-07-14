package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralInfo;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRReportData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRReportingDetails;


public class VMRXBRLApplication {
    public static void main(String[] args) throws Exception {
        VMRReportData data = new VMRReportData();

        VMRGeneralData vmrGeneralData = new VMRGeneralData();
        vmrGeneralData.setNameOfReportingInstitution("Lead Bank-Others");
        vmrGeneralData.setDateOfQuarterEnded("2020-12-31");              
        vmrGeneralData.setDateOfSubmission("2021-01-28");
        vmrGeneralData.setReturnName("VMR-2");
        vmrGeneralData.setReturnCode("VMR2");
        vmrGeneralData.setBankCode("444");
        vmrGeneralData.setReportingPeriodStartDate("2020-10-01");
        vmrGeneralData.setReportingFrequency("Quarterly");
        vmrGeneralData.setReturnVersion("1.0");
        //data.setGeneralData(vmrGeneralData);

        // VMRGeneralInfo

        VMRGeneralInfo vmrGeneralInfo = new VMRGeneralInfo();

        vmrGeneralInfo.setTotalNumberOfBranchesIncludingExtensionCounters("1785");
        vmrGeneralInfo.setHighRiskVulnerabilityBranches("1425");
        vmrGeneralInfo.setNormalRiskVulnerabilityBranches("1143");
        vmrGeneralInfo.setTotalNumberOfVulnerableBranches("2568");
        vmrGeneralInfo.setArmedGuards("354");
        vmrGeneralInfo.setUnArmedGuards("451");
        vmrGeneralInfo.setNumberOfBranchesInWhichAlarmSystemHasBeenProvided("126");
        vmrGeneralInfo.setCollapsibleDoorsAndShuttersAtTheMainEntrance("847");
        vmrGeneralInfo.setNightLatchesAutoLockToCashiersCabins("956");
        vmrGeneralInfo.setGrillGatesToStrongRooms("456");
        vmrGeneralInfo.setCashVansForRemittanceOfCash("512");
        vmrGeneralInfo.setArmouredCashVans("148");
        vmrGeneralInfo.setClosedCircuitTVs("146");
        vmrGeneralInfo.setTimeLockDevices("326");
        vmrGeneralInfo.setPoliceArmedGuardsProvided("102");
        vmrGeneralInfo.setCurrencyChestsProvidedWithHotLineTelephone("540");
        vmrGeneralData.setVmrGeneralInfo(vmrGeneralInfo);

        //Authorized Reporting Details
        VMRReportingDetails vmrReportingDetails = new VMRReportingDetails();
        vmrReportingDetails.setNameOfAuthorisedReportingOfficial("asdsds");
        vmrReportingDetails.setNameOfPersonCountersigned("sdad");
        vmrReportingDetails.setDesignationOfAuthorisedReportingOfficial("asdasd");
        vmrReportingDetails.setDesignationOfPersonCountersigned("dasdasd");
        vmrReportingDetails.setEMailIDOfAuthorisedReportingOfficial("asdsdas@m.com");
        vmrReportingDetails.setEMailIDOfPersonCountersigned("sdfsf@m.com");
        vmrReportingDetails.setOfficeTelephoneNumberOfAuthorisedReportingOfficial("1524587555");
        vmrReportingDetails.setOfficeTelephoneNumberOfPersonCountersigned("8565852548");
        vmrReportingDetails.setResidenceTelephoneNumberOfAuthorisedReportingOfficial("2512452147");
        vmrReportingDetails.setResidenceTelephoneNumberOfPersonCountersigned("2154854582");
        vmrReportingDetails.setFaxNumberOfAuthorisedReportingOfficial("1548725485");
        vmrReportingDetails.setFaxNumberOfPersonCountersigned("5215475214");
        vmrReportingDetails.setPlaceOfSigningByAuthorisedReportingOfficial("fdsfd");
        vmrReportingDetails.setPlaceOfSigningByPersonCountersigned("fdfdsf");
        vmrReportingDetails.setDateOfSigningByAuthorisedReportingOfficial("2021-01-29");
        vmrReportingDetails.setDateOfSigningByPersonCountersigned("2021-01-28");
        vmrGeneralData.setVmrReportingDetails(vmrReportingDetails);
        
        data.setGeneralData(vmrGeneralData);

        
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_VMR_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("file.txt");
        fw.write(sw.toString());
        fw.close();
        
    }
    
}

