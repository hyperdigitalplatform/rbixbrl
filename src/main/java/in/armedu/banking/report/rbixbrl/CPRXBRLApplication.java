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

        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        engine.execute(ReportGenerationFactory.RBI_CPR_XBRL_REPORT, data);
        
    }
    
}
