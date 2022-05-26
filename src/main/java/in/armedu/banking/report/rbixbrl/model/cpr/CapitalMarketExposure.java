package in.armedu.banking.report.rbixbrl.model.cpr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CapitalMarketExposure {
    private String advances;
    private String fundBased;
    private String nonFundBased;
    private String equityInvestment;
    private String totalExposure;
    private String totalAssetsLastYear;
    private String totalExposureLastYear;
    private String netWorth;
    private String equityInvestmentPerc;

}
