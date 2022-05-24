package in.armedu.banking.report.rbixbrl.model.cpr;

import java.util.ArrayList;
import java.util.List;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
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
public class CPRReportData extends ReportData {
    private GeneralData generalData;
    private List<ItemData> itemDatas = new ArrayList<ItemData>();
}
