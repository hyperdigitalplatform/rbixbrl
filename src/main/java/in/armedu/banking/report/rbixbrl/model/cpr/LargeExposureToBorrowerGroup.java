package in.armedu.banking.report.rbixbrl.model.cpr;

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
public class LargeExposureToBorrowerGroup {
    private List<BorrowerGroup> borrowerGroups = new ArrayList<BorrowerGroup>();
    private String totalAmountFunded;
    private String totalAmountNonFunded;
    private String totalExposureAsPercToCapitalFunds;
}
