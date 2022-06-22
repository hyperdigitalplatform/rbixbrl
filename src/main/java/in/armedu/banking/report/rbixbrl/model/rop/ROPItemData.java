package in.armedu.banking.report.rbixbrl.model.rop;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ROPItemData  extends ItemData  {

    private ROPReportingPeriod ropReportingPeriod;
    private ROPDateOfReport ropDateOfReport;

}
