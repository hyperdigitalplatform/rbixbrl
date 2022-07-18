package in.armedu.banking.report.rbixbrl.model.rle;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.rle.*;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RLEReportData implements ReportData {
    private String bankCode;
    private String startDate;
    private String endDate;
    private String periodDate;
    private GeneralInformation_Lyt_Page1 generalInformation_Lyt_Page1;
    private List<SectionI_lyt_1_Section1> sectionI_lyt_1_Section1;
    private List<SectionI_lyt_2_Section1> sectionI_lyt_2_Section1;
    private List<SectionII_lyt_1_Section2> sectionII_lyt_1_Section2;
    private List<SectionII_lyt_2_Section2> sectionII_lyt_2_Section2;
    private List<SectionIII_lyt_1_Section3> sectionIII_lyt_1_Section3;
}
