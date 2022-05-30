package in.armedu.banking.report.rbixbrl.model.fmr;

import java.util.ArrayList;
import java.util.List;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorizedReporting extends ItemData {
    private String nameOfAuthorisedReportingOfficial;
    private String nameOfPersonCountersigned;
    private String designationOfAuthorisedReportingOfficial;
    private String designationOfPersonCountersigned;
    private String eMailIDOfAuthorisedReportingOfficial;
    private String eMailIDOfPersonCountersigned;
    private String officeTelephoneNumberOfAuthorisedReportingOfficial;
    private String officeTelephoneNumberOfPersonCountersigned;
    private String residenceTelephoneNumberOfAuthorisedReportingOfficial;
    private String residenceTelephoneNumberOfPersonCountersigned;
    private String faxNumberOfAuthorisedReportingOfficial;
    private String faxNumberOfPersonCountersigned;
    private String placeOfSigningByAuthorisedReportingOfficial;
    private String placeOfSigningByPersonCountersigned;
    private String dateOfSigningByAuthorisedReportingOfficial;
    private String dateOfSigningByPersonCountersigned;
}
