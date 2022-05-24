package in.armedu.banking.report.rbixbrl.model.cpr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupCompany {

    private String groupCompanyName;
    private String amountFunded;
    private String amountNonFunded;
    private String exposureAsPercToCapitalFunds;

}
