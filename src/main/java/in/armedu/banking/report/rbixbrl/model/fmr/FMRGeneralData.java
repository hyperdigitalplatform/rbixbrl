package in.armedu.banking.report.rbixbrl.model.fmr;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FMRGeneralData extends GeneralData {
    private String returnName;
    private String returnCode;
    private String reportInstitution;
    private String bankCode;
    private String institutionAddress;
    private String QuarterEndDate;
    private String DateOfSubmission;
    private String reportingFrequency;
    private String returnVersion;
    private String whetherNilReporting;
    private String reportStatus;
    private String ReportingPeriodStartDate;
    private AuthorizedReporting authorizedReporting;
}
