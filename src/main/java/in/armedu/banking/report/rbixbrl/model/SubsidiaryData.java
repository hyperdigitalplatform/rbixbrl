package in.armedu.banking.report.rbixbrl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubsidiaryData {
    private String category;
    private String areaOfOperations;
    private String subsidiaryCode;
    private String subsidiaryName;
    private String activityName;
    private String regulatorName;

}
