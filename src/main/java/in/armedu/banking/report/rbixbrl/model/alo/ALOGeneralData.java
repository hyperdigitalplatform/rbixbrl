package in.armedu.banking.report.rbixbrl.model.alo;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralInfo;
import in.armedu.banking.report.rbixbrl.model.alo.ALOSignatoryDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ALOGeneralData extends GeneralData {
    
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String address;
    private String dateOfQuarterEnded;
    private String dateOfSubmission;
    private String reportingFrequency;
    private String dateOfReport;
    private String reportStatus;
    private String dateOfAudit;
    private String validationStatus;
    private String returnVersion;
    private String generalRemarks;
    private String reportingPeriodStartDate;

    private ALOGeneralInfo aloGeneralInfo;
    private ALOSignatoryDetails aloSignatoryDetails;

}
