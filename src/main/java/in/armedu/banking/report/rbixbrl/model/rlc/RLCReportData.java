package in.armedu.banking.report.rbixbrl.model.rlc;

import java.util.ArrayList;
import java.util.List;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RLCReportData extends ReportData {
    
    private RLCGeneralData rlcGeneralData;
    private List<ItemData> rlcItems = new ArrayList<ItemData>();

}
