package in.armedu.banking.report.rbixbrl.model.fmr;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FMRItemData extends ItemData {
    private String branchCode;
    private String branchName;
    private String dateTimeOfOccurrence;
    private String typeOfBranch;

    private String riskClassificationPhishing;
    private String whetherCurrencyChestBranch;
    private String numberOfArmedGuards;
    private String typeOfCase;
    private String placeOfOccurence;
    private String amountInvolvedInCases;
    private String amountRecovered;
    private String insuranceClaimSettled;
    private String numberOfArrestedStaffs;
    private String numberOfArrestedRobbers;
    private String numberOfKilledStaffs;
    private String numberOfKilledRobbers;
    private String numberOfKilledOtherCriminals;
    private String numberOfInjuredStaffs;
    private String numberOfInjuredOtherCriminals;
    private String numberOfConvictedStaffs;
    private String numberOfConvictedRobbers;
    private String compensationPaidStaffs;
    private String compensationPaidOtherCriminal;
    private String actionTaken;
    private String crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered;
    private String modusOperandi;
}