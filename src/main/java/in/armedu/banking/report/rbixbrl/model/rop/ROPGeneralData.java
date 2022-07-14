package in.armedu.banking.report.rbixbrl.model.rop;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROPGeneralData  extends GeneralData {
    
    // model for general data
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String address;
    private String dateOfQuarterEnded;
    private String reportingFrequency;
    private String dateOfReport;
    private String reportStatus;
    private String dateOfAudit;
    private String validationStatus;
    private String returnVersion;
    private String generalRemarks;
    private String reportingPeriodStartDate;

}
