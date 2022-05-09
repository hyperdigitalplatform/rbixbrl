package in.armedu.banking.report.rbixbrl;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;
import in.armedu.banking.report.rbixbrl.model.SubsidiaryData;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIROSXBRLReportImpl;

public class XBRLApplication {
    public static void main(String[] args) throws Exception {
        ROSData data = new ROSData();
        SubsidiaryData sData = new SubsidiaryData();
        sData.setActivityName("activityName");
        sData.setAreaOfOperations("areaOfOperations");
        sData.setCategory("category");
        sData.setRegulatorName("regulatorName");
        sData.setSubsidiaryCode("subsidiaryCode");
        sData.setSubsidiaryName("subsidiaryName");
        
        GeneralInfoData genInfoData = new GeneralInfoData();
        genInfoData.setBankCode("bankCode");
        genInfoData.setDateOfReport("2022-12-01");
        genInfoData.setEndDate("2025-12-01");
        genInfoData.setInstitutionAddress("institutionAddress");
        genInfoData.setReportInstitution("reportInstitution");
        genInfoData.setReportingFrequency("reportingFrequency");
        genInfoData.setReturnCode("returnCode");
        genInfoData.setReturnName("returnName");
        genInfoData.setReturnVersion("returnVersion");
        genInfoData.setStartDate("2021-12-01");
        genInfoData.setValidationStatus("validationStatus");
        data.setRosGeneralInfo(genInfoData);

        ROSItem rosItem = new ROSItem();
        rosItem.setSubsidiaryInfo(sData);

        data.getRosItems().add(rosItem);

        RBIROSXBRLReportImpl report = new RBIROSXBRLReportImpl();
        report.generateReport(data);
        
    }
    
}
