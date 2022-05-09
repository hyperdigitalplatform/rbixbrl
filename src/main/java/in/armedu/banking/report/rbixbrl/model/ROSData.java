package in.armedu.banking.report.rbixbrl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ROSData {
    private GeneralInfoData rosGeneralInfo;
    private List<ROSItem> rosItems = new ArrayList<ROSItem>();
}
