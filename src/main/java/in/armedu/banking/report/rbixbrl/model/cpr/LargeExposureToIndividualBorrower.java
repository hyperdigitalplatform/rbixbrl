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
public class LargeExposureToIndividualBorrower {
    private List<IndividualBorrower> individualBorrowers = new ArrayList<IndividualBorrower>();
    private String totalAmountFunded;
    private String totalAmountNonFunded;
    private String totalExposureAsPercToCapitalFunds;
}
