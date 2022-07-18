package in.armedu.banking.report.rbixbrl.model.pci;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.pci.*;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PCIReportData implements ReportData {
    private String bankCode;
    private String startDate;
    private String endDate;
    private String periodDate;
    private GeneralInformation_Lyt_Page1 generalInformation_Lyt_Page1;
    private List<PARTA_lyt_PartA> pARTA_lyt_PartA;
    private List<PARTA_lyt_PartA_Total> pARTA_lyt_PartA_Total;
    private List<PARTA_lyt_PartA_Sect2> pARTA_lyt_PartA_Sect2;
    private List<PARTA_lyt_PartA_Gross> pARTA_lyt_PartA_Gross;
    private List<PARTB_lyt_PartB1> pARTB_lyt_PartB1;
    private List<PARTB_lyt_PartB1_total> pARTB_lyt_PartB1_total;
    private List<PARTB_lyt_PartB1_Sect2> pARTB_lyt_PartB1_Sect2;
    private List<PARTB_lyt_PartB_Gross> pARTB_lyt_PartB_Gross;
    private AuthorisedSignatory_Signatory authorisedSignatory_Signatory;
}
