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

public class RLCGeneralInfo  {

    //  Signatory Details
    private String nameOfSignatory;
    private String designationOfSignatory;
    private String authorisedSignatoryMobileNumber;
    private String authorisedSignatoryLandlineNumber;
    private String eMailIDOfAuthorisedReportingOfficial;

}
