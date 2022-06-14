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

public class ALOGeneralData extends GeneralData {
    
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String address;
    private String dateOfQuarterEnded;
    private String reportingFrequency;
    private String dateOfReport;
    private String reportStatus;
    private String dateOfAudit;
    private String validationStatus;
    private String returnVersion;
    private String generalRemarks;
    private String reportingPeriodStartDate;

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
    
    private String nameOfSignatory;
    private String designationOfSignatory;
    private String authorisedSignatoryMobileNumber;
    private String authorisedSignatoryLandlineNumber;
    private String eMailIDOfAuthorisedReportingOfficial;
    private String placeOfSignature;
    private String dateOfDocumentAuthorisation;

}
