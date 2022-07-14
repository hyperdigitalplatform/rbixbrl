package in.armedu.banking.report.rbixbrl.model.vmr;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VMRGeneralInfo{
    
    // model for general info
    private String totalNumberOfBranchesIncludingExtensionCounters;
    private String highRiskVulnerabilityBranches;
    private String normalRiskVulnerabilityBranches;
    private String totalNumberOfVulnerableBranches;
    private String armedGuards;
    private String unArmedGuards;
    private String numberOfBranchesInWhichAlarmSystemHasBeenProvided;
    private String collapsibleDoorsAndShuttersAtTheMainEntrance;
    private String nightLatchesAutoLockToCashiersCabins;
    private String grillGatesToStrongRooms;
    private String cashVansForRemittanceOfCash;
    private String armouredCashVans;
    private String closedCircuitTVs;
    private String timeLockDevices;
    private String policeArmedGuardsProvided;
    private String currencyChestsProvidedWithHotLineTelephone;

}
