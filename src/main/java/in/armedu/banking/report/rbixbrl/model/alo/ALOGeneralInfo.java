package in.armedu.banking.report.rbixbrl.model.alo;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ALOGeneralInfo {

    private String documentaryCreditsCommitted;
    private String documentaryCreditsCommittedIssuedOnClientAccount;
    private String documentaryCreditsCommittedIssuedOnBanksAccount;
    private String paymentGuaranteesOrAcceptances;
    private String performanceGuaranteesIssued;
    private String loanCommitments;
    private String offBalanceSheetExposures;
    private String outstandingForexContracts;
    private String outstandingInterestRateSwaps;
    private String forwardRateAgreements;
    private String otherFutureAndForwardContracts;
    private String currencyOptionsBought;
    private String currencyOptionsWritten;
    private String otherOffBalanceSheetExposure;
    private String aggregateOffBalanceSheetExposures;
    
}
