package in.armedu.banking.report.rbixbrl.part.fmr;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRItemData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class FMRItemContext implements ContextInterface {
    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
        
        return null;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
        FMRGeneralData frmGeneralData = (FMRGeneralData) generalData;
        FMRItemData fmrItemData = (FMRItemData) itemData;
        Map<String, Context> itemContexts = new HashMap<String, Context>();
        // create context for individual borrower
        Context fromToContextForBranch = FMRUtil.createFromToContextForBranch(frmGeneralData.getBankCode(), frmGeneralData.getReportingPeriodStartDate(), frmGeneralData.getQuarterEndDate(), null, fmrItemData.getBranchCode(), fmrItemData.getBranchName(), fmrItemData.getDateTimeOfOccurrence());
        itemContexts.put(FMRUtil.FROMTOBRANCH ,fromToContextForBranch);
        Context fromToContextForStaff = FMRUtil.createFromToContextForBranch(frmGeneralData.getBankCode(), frmGeneralData.getReportingPeriodStartDate(), frmGeneralData.getQuarterEndDate(), "StaffMember", fmrItemData.getBranchCode(), fmrItemData.getBranchName(), fmrItemData.getDateTimeOfOccurrence());
        itemContexts.put(FMRUtil.FROMTOSTAFF ,fromToContextForStaff);
        Context fromToContextForRobber = FMRUtil.createFromToContextForBranch(frmGeneralData.getBankCode(), frmGeneralData.getReportingPeriodStartDate(), frmGeneralData.getQuarterEndDate(), "RobbersMember", fmrItemData.getBranchCode(), fmrItemData.getBranchName(), fmrItemData.getDateTimeOfOccurrence());
        itemContexts.put(FMRUtil.FROMTOROBBER ,fromToContextForRobber);
        Context fromToContextForOtherCriminal = FMRUtil.createFromToContextForBranch(frmGeneralData.getBankCode(), frmGeneralData.getReportingPeriodStartDate(), frmGeneralData.getQuarterEndDate(), "OtherCriminalMember", fmrItemData.getBranchCode(), fmrItemData.getBranchName(), fmrItemData.getDateTimeOfOccurrence());
        itemContexts.put(FMRUtil.FROMTOOTHERCRIMINAL ,fromToContextForOtherCriminal);
        
        return itemContexts;
    }

    
}
    