package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.pci.PCIGeneralData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIReportData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIItemData;

public class PCIXBRLApplication {
    
    public static void main(String[] args) throws Exception {
    PCIReportData data = new PCIReportData();

    PCIGeneralData pciGeneralData = new PCIGeneralData();
    //model for general data
    pciGeneralData.setReturnName("Problem Credit and Investments");
    pciGeneralData.setReturnCode("PCI");
    pciGeneralData.setNameOfReportingInstitution("Kookmin Bank");
    pciGeneralData.setBankCode("00A");
    pciGeneralData.setReportForTheYearEnded("2019-06-30");
    pciGeneralData.setReportingFrequency("Quarterly");
    pciGeneralData.setDateOfReport("2019-08-01");
    pciGeneralData.setReportStatus("Audited");
    pciGeneralData.setDateOfAudit("2019-08-02");
    pciGeneralData.setValidationStatus("Validated");
    pciGeneralData.setToolName("iFile");
    pciGeneralData.setReturnVersion("V2.1");
    pciGeneralData.setReportingPeriodStartDate("2019-04-01");
    
    //model for signatory data
    pciGeneralData.setNameOfSignatory("RTIRJNCVXRJJFG");
    pciGeneralData.setDesignationOfSignatory("FGUGTIKREUTRU");
    pciGeneralData.setAuthorisedSignatoryMobileNumber("5241789363");
    pciGeneralData.setAuthorisedSignatoryLandlineNumber("5236125874");
    pciGeneralData.setEMailIDOfAuthorisedReportingOfficial("FSDHRUESY@dfsf.com");
    pciGeneralData.setPlaceOfSignature("WE4RY4WA3Q546");
    pciGeneralData.setDateOfSigning("2019-08-05");

    data.setGeneralData(pciGeneralData);


    // PCI Item
    //  PCI Item MoreThanUSD2MillionMember

    PCIItemData pciItemDataMoreThanUSD2MillionMember = new PCIItemData();

    //item data for general context
    pciItemDataMoreThanUSD2MillionMember.setCustomerCreditLimitAxis("MoreThanUSD2MillionMember");
    pciItemDataMoreThanUSD2MillionMember.setTypeOfProblemCreditAndInvestmentCustomerAxis("ProblemCreditMember");
    pciItemDataMoreThanUSD2MillionMember.setCountryCodeAxis("IN");
    pciItemDataMoreThanUSD2MillionMember.setBranchCodeAxis("592");
    pciItemDataMoreThanUSD2MillionMember.setNameOfBorrowerAxis("Borrower 1");
    pciItemDataMoreThanUSD2MillionMember.setBorrowerGroupNameAxis("Borrower Group 1");
    pciItemDataMoreThanUSD2MillionMember.setIndustryCodeAxis("Service");
    // pciItemDataMoreThanUSD2MillionMember.setNameOfIssuerAxis("Borrower 3");
    // pciItemDataMoreThanUSD2MillionMember.setIssuerGroupNameAxis("Borrower Group 3");

    //item data for body
    pciItemDataMoreThanUSD2MillionMember.setSoverignCharacter("WDRWLYPQAE");
    pciItemDataMoreThanUSD2MillionMember.setCategoryOfBorrower("Existing");
    pciItemDataMoreThanUSD2MillionMember.setAggregateAmountOfLimitsSanctioned("16950000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfFundedLimitsSanctioned("8350000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfNonFundedLimitsSanctioned("8600000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOutstandingOfCustomerCreditLimitSenctioned("8850000");
    pciItemDataMoreThanUSD2MillionMember.setSecurityValue("9100000");
    pciItemDataMoreThanUSD2MillionMember.setAssetsClassification("Sub-standard");
    pciItemDataMoreThanUSD2MillionMember.setAssetsClassificationHostCountry("Performing Asset");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfProvisionsHeldAtBranch("29350000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfProvisionsHeldAtHeadOffice("9600000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfInterestSuspense("9850000");
    pciItemDataMoreThanUSD2MillionMember.setAggregateAmountOfProvisionAndInterestSuspense("48800000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities("64000000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfShortFall("15200000");
    pciItemDataMoreThanUSD2MillionMember.setAmountOfHeadOfficeSupportFund("13600000");
    pciItemDataMoreThanUSD2MillionMember.setDevelopmentsDuringQuarter("CXTZKHAPVK");

    //  PCI Item LessThanUSD2MillionMember

    PCIItemData pciItemDataLessThanUSD2MillionMember = new PCIItemData();

    //item data for general context
    pciItemDataMoreThanUSD2MillionMember.setCustomerCreditLimitAxis("LessThanUSD2MillionMember");
    pciItemDataLessThanUSD2MillionMember.setTypeOfProblemCreditAndInvestmentCustomerAxis("ProblemCreditMember");
    pciItemDataLessThanUSD2MillionMember.setCountryCodeAxis("IN");
    pciItemDataLessThanUSD2MillionMember.setBranchCodeAxis("592");

    // item data for body
    pciItemDataLessThanUSD2MillionMember.setAggregateAmountOfLimitsSanctioned("14850000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfFundedLimitsSanctioned("7300000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfNonFundedLimitsSanctioned("7550000");
    pciItemDataLessThanUSD2MillionMember.setAmountOutstandingOfCustomerCreditLimitSenctioned("7800000");
    pciItemDataLessThanUSD2MillionMember.setSecurityValue("8050000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfProvisionsHeldAtBranch("8300000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfProvisionsHeldAtHeadOffice("8550000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfInterestSuspense("8800000");
    pciItemDataLessThanUSD2MillionMember.setAggregateAmountOfProvisionAndInterestSuspense("25650000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities("68200000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfShortFall("42550000");
    pciItemDataLessThanUSD2MillionMember.setAmountOfHeadOfficeSupportFund("8850000");
    pciItemDataLessThanUSD2MillionMember.setDevelopmentsDuringQuarter("OTUWXXFIXT");
    
    data.getItemDatas().add(pciItemDataMoreThanUSD2MillionMember);

    data.getItemDatas().add(pciItemDataLessThanUSD2MillionMember);

    ReportGenerationEngine engine = new XBRLReportGenerationEngine();
    StringWriter sw = engine.execute(ReportGenerationFactory.RBI_PCI_XBRL_REPORT, data);
    FileWriter fw = new FileWriter("file.txt");
    fw.write(sw.toString());
    fw.close();
        
    }
}
