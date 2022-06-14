package in.armedu.banking.report.rbixbrl.model.cem;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CEMGeneralData extends GeneralData {

    // model for general data
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String reportingDate;
    private String reportingFrequency;
    private String dateOfReport;
    private String reportStatus;
    private String validationStatus;
    private String returnVersion;
    private String toolName;
    private String reportingPeriodStartDate;
    
    //model for signatory data
    private String nameOfSignatory;
    private String designationOfSignatory;
    private String authorisedSignatoryMobileNumber;
    private String authorisedSignatoryLandlineNumber;
    private String eMailIDOfAuthorisedReportingOfficial;
    private String placeOfSignature;
    private String dateOfSigning;

}
