package in.armedu.banking.report.rbixbrl.model.ros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSExposureAndOwnership {
    private String noOfCounterparties;
    private String aggregateExposureAmount;
    private String aggregateExposurePercentage;
    private String investmentInCapitalByParentBank;
    private String sharesHeldByParentBank;
    private String totalCapitalHeldByParentBank;

}
