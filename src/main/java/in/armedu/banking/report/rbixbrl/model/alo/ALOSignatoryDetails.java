package in.armedu.banking.report.rbixbrl.model.alo;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter

public class ALOSignatoryDetails {
    
    private String nameOfSignatory;
    private String designationOfSignatory;
    private String authorisedSignatoryMobileNumber;
    private String authorisedSignatoryLandlineNumber;
    private String eMailIDOfAuthorisedReportingOfficial;
    private String placeOfSignature;
    private String dateOfDocumentAuthorisation;

}
