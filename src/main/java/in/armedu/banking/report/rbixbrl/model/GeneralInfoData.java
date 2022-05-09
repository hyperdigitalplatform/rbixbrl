package in.armedu.banking.report.rbixbrl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GeneralInfoData {
    private String returnName;
    private String returnCode;
    private String reportInstitution;
    private String bankCode;
    private String institutionAddress;
    private String reportingFrequency;
    private String startDate;
    private String endDate;
    private String dateOfReport;
    private String validationStatus;
    private String returnVersion;
}
