package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RLCGeneralData extends GeneralData {
    
    //Report Details
    private String ReturnName;
    private String ReturnCode;
    private String NameOfReportingInstitution;
    private String BankCode;
    private String Address;
    private String ReportForTheYearEnded;
    private String ReportingFrequency;
    private String ReportStatus;
    private String WhetherNilReporting;
    private String CategoriesOfBanks;
    private String ReturnVersion;
    private String GeneralRemarks;
    private String ReportingPeriodStartDate;
    private String RegulatoryCapital;
    private String CapitalInfusion;

    //Signatory Details
    private String NameOfSignatory;
    private String DesignationOfSignatory;
    private String AuthorisedSignatoryMobileNumber;
    private String AuthorisedSignatoryLandlineNumber;
    private String EMailIDOfAuthorisedReportingOfficial;

}
