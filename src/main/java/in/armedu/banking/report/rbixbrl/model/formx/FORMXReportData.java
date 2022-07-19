package in.armedu.banking.report.rbixbrl.model.formx;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.formx.*;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FORMXReportData implements ReportData {
    private String bankCode;
    private String startDate;
    private String endDate;
    private String periodDate;
    private GeneralInformation_GenInfo generalInformation_GenInfo;
    private PartI_PartI partI_PartI;
    private PartI_Layout1 partI_Layout1;
    private PartII_PartII partII_PartII;
    private PartIII_PartIII partIII_PartIII;
    private ForeignliabilitiesAndassets_Foreignliabilitiesassets foreignliabilitiesAndassets_Foreignliabilitiesassets;
    private Signatory_Signatory signatory_Signatory;
}
