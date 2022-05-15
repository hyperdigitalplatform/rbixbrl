package in.armedu.banking.report.rbixbrl.model.ros;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSItem extends ItemData {
    private ROSSubsidiaryData subsidiaryInfo;
    private ROSFinancialParameters partAFinancialParameters;
    private ROSExposureAndOwnership partBExposureAndOwnership;
}
