package in.armedu.banking.report.rbixbrl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSItem {
    private SubsidiaryData subsidiaryInfo;
    private FinancialParameters partAFinancialParameters;
    private ExposureAndOwnership partBExposureAndOwnership;
}
