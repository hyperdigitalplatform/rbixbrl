package in.armedu.banking.report.rbixbrl.model.vmr;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralInfo;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRReportingDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VMRGeneralData  extends GeneralData {
    
    // model for general data
    private String nameOfReportingInstitution;
    private String dateOfQuarterEnded;
    private String dateOfSubmission;

    private String returnName;
    private String returnCode;
    private String bankCode;
    private String reportingPeriodStartDate;
    private String reportingFrequency;
    private String returnVersion;

    private VMRGeneralInfo vmrGeneralInfo;
    private VMRReportingDetails vmrReportingDetails;

}
