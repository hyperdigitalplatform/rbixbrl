package in.armedu.banking.report.rbixbrl.model.ros;

import java.util.ArrayList;
import java.util.List;

import in.armedu.banking.report.rbixbrl.model.ReportData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSData implements ReportData {
    private ROSGeneralInfoData rosGeneralInfo;
    private List<ROSItem> rosItems = new ArrayList<ROSItem>();
}
