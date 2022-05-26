package in.armedu.banking.report.rbixbrl.model.cpr;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CPRGeneralData extends GeneralData {
    private String returnName;
    private String returnCode;
    private String reportInstitution;
    private String bankCode;
    private String institutionAddress;
    private String reportingFrequency;
    private String startDate;
    private String endDate;
    private String dateOfReport;
    private String ReportForTheYearEnded;
    private String validationStatus;
    private String reportStatus;
    private String dateOfAudit;
    private String returnVersion;
    private CPRGeneralFinancialForConsolidated financialForConsolidated;
    private ForexExposure forexExposure;
    private CapitalMarketExposure capitalMarketExposure;
    private ExposureToUnsecure exposureToUnsecure;
    private CRRAndSLR crrAndSLR;
}
