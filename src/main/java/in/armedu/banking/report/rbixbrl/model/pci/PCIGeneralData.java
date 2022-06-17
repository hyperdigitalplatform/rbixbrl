package in.armedu.banking.report.rbixbrl.model.pci;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PCIGeneralData extends GeneralData {
    
        // model for general data
        private String returnName;
        private String returnCode;
        private String nameOfReportingInstitution;
        private String bankCode;
        private String reportForTheYearEnded;
        private String reportingFrequency;
        private String dateOfReport;
        private String reportStatus;
        private String dateOfAudit;
        private String validationStatus;
        private String toolName;
        private String returnVersion;
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
