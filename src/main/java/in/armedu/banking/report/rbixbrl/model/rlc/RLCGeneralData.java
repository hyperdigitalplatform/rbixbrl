package in.armedu.banking.report.rbixbrl.model.rlc;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
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
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String address;
    private String endDate;                //ReportForTheYearEnded
    private String reportingFrequency;
    private String reportStatus;
    private String whetherNilReporting;
    private String categoriesOfBanks;
    private String returnVersion;
    private String generalRemarks;
    private String startDate;               //ReportingPeriodStartDate
    private String regulatoryCapital;
    private String capitalInfusion;
    private String lastEndDate;             //LastYearEndDate
    private String currentDate;         //BeginingOfCurrentYear

    //Signatory Details
    private String nameOfSignatory;
    private String designationOfSignatory;
    private String authorisedSignatoryMobileNumber;
    private String authorisedSignatoryLandlineNumber;
    private String eMailIDOfAuthorisedReportingOfficial;

}
