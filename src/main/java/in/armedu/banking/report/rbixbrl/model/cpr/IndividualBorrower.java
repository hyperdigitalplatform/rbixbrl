package in.armedu.banking.report.rbixbrl.model.cpr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IndividualBorrower {
    private String panNumber;
    private String borrowerName;
    private String industryCode;
    private String industryName;
    private String sector;
    private String amountFunded;
    private String amountNonFunded;
    private String exposureAsPercToCapitalFunds;

}
