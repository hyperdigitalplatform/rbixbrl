package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.pci.PCIReportData;
import in.armedu.banking.report.rbixbrl.model.pci.GeneralInformation_Lyt_Page1;
import in.armedu.banking.report.rbixbrl.model.pci.PARTA_lyt_PartA;
import in.armedu.banking.report.rbixbrl.model.pci.CustomerCreditLimitAxis;
import in.armedu.banking.report.rbixbrl.model.pci.CustomerCreditLimitAxisEnum;
import in.armedu.banking.report.rbixbrl.model.pci.TypeOfProblemCreditAndInvestmentCustomerAxis;
import in.armedu.banking.report.rbixbrl.model.pci.TypeOfProblemCreditAndInvestmentCustomerAxisEnum;
import in.armedu.banking.report.rbixbrl.model.pci.AuthorisedSignatory_Signatory;

public class PCIXBRLApplication {
    
    public static void main(String[] args) throws Exception {
    PCIReportData data = new PCIReportData();

    data.setBankCode("00A");
    data.setStartDate("2019-04-01");
    data.setEndDate("2019-06-30");
    data.setPeriodDate("2019-06-30");

    GeneralInformation_Lyt_Page1 generalInfo = new GeneralInformation_Lyt_Page1();
    generalInfo.setReturnName("Problem Credit and Investments");
    generalInfo.setReturnCode("PCI");
    generalInfo.setNameOfReportingInstitution("Kookmin Bank");
    generalInfo.setBankCode("00A");
    generalInfo.setReportForTheYearEnded("2019-06-30");
    generalInfo.setReportingFrequency("Quarterly");
    generalInfo.setDateOfReport("2019-08-01");
    generalInfo.setReportStatus("Audited");
    generalInfo.setDateOfAudit("2019-08-02");
    generalInfo.setValidationStatus("Validated");
    generalInfo.setToolName("iFile");
    generalInfo.setReturnVersion("V2.1");
    generalInfo.setReportingPeriodStartDate("2019-04-01");
    data.setGeneralInformation_Lyt_Page1(generalInfo);

    PARTA_lyt_PartA partA = new PARTA_lyt_PartA();
    partA.setCountryCode("IN");
    partA.setBranchCode("592");
    partA.setNameOfBorrower("Borrower 1");
    partA.setBorrowerGroupName("Borrower Group 1");
    partA.setIndustryCode("Service");
    CustomerCreditLimitAxis customerCreditLimitAxis = new CustomerCreditLimitAxis();
    TypeOfProblemCreditAndInvestmentCustomerAxis typeProblemCredit = new TypeOfProblemCreditAndInvestmentCustomerAxis();
    typeProblemCredit.setType(TypeOfProblemCreditAndInvestmentCustomerAxisEnum.ProblemCreditMember);
    typeProblemCredit.setValue("WDRWLYPQAE");
    List<TypeOfProblemCreditAndInvestmentCustomerAxis> typePCIC = new ArrayList<TypeOfProblemCreditAndInvestmentCustomerAxis>();
    typePCIC.add(typeProblemCredit);
    customerCreditLimitAxis.setType(CustomerCreditLimitAxisEnum.MoreThanUSD2MillionMember);
    customerCreditLimitAxis.setTypeOfProblemCreditAndInvestmentCustomerAxis(typePCIC);
    List<CustomerCreditLimitAxis> customerCLA = new ArrayList<CustomerCreditLimitAxis>();
    customerCLA.add(customerCreditLimitAxis);

    partA.setSoverignCharacter(customerCLA);

    // CustomerCreditLimitAxis customerCreditLimitAxis = new CustomerCreditLimitAxis();
    // TypeOfProblemCreditAndInvestmentCustomerAxis typeProblemCredit = new TypeOfProblemCreditAndInvestmentCustomerAxis();
    // typeProblemCredit.setType(TypeOfProblemCreditAndInvestmentCustomerAxisEnum.ProblemCreditMember);
    // typeProblemCredit.setValue("WDRWLYPQAE");
    // List<TypeOfProblemCreditAndInvestmentCustomerAxis> typePCIC = new ArrayList<TypeOfProblemCreditAndInvestmentCustomerAxis>();
    // typePCIC.add(typeProblemCredit);
    // customerCreditLimitAxis.setType(CustomerCreditLimitAxisEnum.MoreThanUSD2MillionMember);
    // customerCreditLimitAxis.setTypeOfProblemCreditAndInvestmentCustomerAxis(typePCIC);
    // List<CustomerCreditLimitAxis> customerCLA = new ArrayList<CustomerCreditLimitAxis>();
    // customerCLA.add(customerCreditLimitAxis);
    // partA.setCategoryOfBorrower(customerCLA);
    // partA.setAggregateAmountOfLimitsSanctioned(customerCLA);
    // partA.setAmountOfFundedLimitsSanctioned(customerCLA);
    // partA.setAmountOfNonFundedLimitsSanctioned(customerCLA);
    // partA.setAmountOutstandingOfCustomerCreditLimitSenctioned(customerCLA);
    // partA.setSecurityValue(customerCLA);
    // partA.setAssetsClassification(customerCLA);
    // partA.setAssetsClassificationHostCountry(customerCLA);
    // partA.setAmountOfProvisionsHeldAtBranch(customerCLA);
    // partA.setAmountOfProvisionsHeldAtHeadOffice(customerCLA);
    // partA.setAmountOfInterestSuspense(customerCLA);
    // partA.setAggregateAmountOfProvisionAndInterestSuspense(customerCLA);
    // partA.setAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(customerCLA);
    // partA.setAmountOfShortFall(customerCLA);
    // partA.setAmountOfHeadOfficeSupportFund(customerCLA);
    // partA.setDevelopmentsDuringQuarter(customerCLA);

    // customerCreditLimitAxis.setSoverignCharacter("WDRWLYPQAE");
    // customerCreditLimitAxis.setCategoryOfBorrower("Existing");
    // customerCreditLimitAxis.setAggregateAmountOfLimitsSanctioned("16950000");
    // customerCreditLimitAxis.setAmountOfFundedLimitsSanctioned("8350000");
    // customerCreditLimitAxis.setAmountOfNonFundedLimitsSanctioned("8600000");
    // customerCreditLimitAxis.setAmountOutstandingOfCustomerCreditLimitSenctioned("8850000");
    // customerCreditLimitAxis.setSecurityValue("9100000");
    // customerCreditLimitAxis.setAssetsClassification("Sub-standard");
    // customerCreditLimitAxis.setAssetsClassificationHostCountry("Performing Asset");
    // customerCreditLimitAxis.setAmountOfProvisionsHeldAtBranch("29350000");
    // customerCreditLimitAxis.setAmountOfProvisionsHeldAtHeadOffice("9600000");
    // customerCreditLimitAxis.setAmountOfInterestSuspense("9850000");
    // customerCreditLimitAxis.setAggregateAmountOfProvisionAndInterestSuspense("48800000");
    // customerCreditLimitAxis.setAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities("64000000");
    // customerCreditLimitAxis.setAmountOfShortFall("15200000");
    // customerCreditLimitAxis.setAmountOfHeadOfficeSupportFund("13600000");
    // customerCreditLimitAxis.setDevelopmentsDuringQuarter("CXTZKHAPVK");
    // partA.setPARTA_lyt_PartA().add(customerCreditLimitAxis);
    List<PARTA_lyt_PartA> partAList = new ArrayList<PARTA_lyt_PartA>();
    partAList.add(partA);
    data.setPARTA_lyt_PartA(partAList);
   

    // AuthorisedSignatory_Signatory signatoryDetails = new AuthorisedSignatory_Signatory();
    // signatoryDetails.setNameOfSignatory("");    
    // signatoryDetails.setDesignationOfSignatory("");
    // signatoryDetails.setAuthorisedSignatoryMobileNumber("");
    // signatoryDetails.setAuthorisedSignatoryLandlineNumber("");
    // signatoryDetails.setEMailIDOfAuthorisedReportingOfficial("");
    // signatoryDetails.setPlaceOfSignature("");
    // signatoryDetails.setDateOfSigning("");



    ReportGenerationEngine engine = new XBRLReportGenerationEngine();
    StringWriter sw = engine.execute(ReportGenerationFactory.RBI_PCI_XBRL_REPORT, data);
    FileWriter fw = new FileWriter("file.txt");
    fw.write(sw.toString());
    fw.close();
        
    }
}
