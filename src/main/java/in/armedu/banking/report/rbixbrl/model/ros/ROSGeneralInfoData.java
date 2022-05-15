package in.armedu.banking.report.rbixbrl.model.ros;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSGeneralInfoData extends GeneralData {
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
