package in.armedu.banking.report.rbixbrl.part.rop.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPGeneralData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPItemData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class ROPGeneralContext implements ContextInterface {

    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
    ROPGeneralData ropGeneralData = (ROPGeneralData) generalData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context
    Context fromToContext = ROPUtil.createFromToContext(ropGeneralData.getBankCode(), ropGeneralData.getReportingPeriodStartDate(), ropGeneralData.getDateOfQuarterEnded(), null);
    contexts.put(ROPUtil.FROMTO, fromToContext);

    // create asof context
    Context asOfContext = ROPUtil.createAsOfContext(ropGeneralData.getBankCode(), ropGeneralData.getDateOfQuarterEnded(), null);
    contexts.put(ROPUtil.ASOF , asOfContext);


    return contexts;
}
@Override
public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
    ROPGeneralData ropGeneralData = (ROPGeneralData) generalData;
    ROPItemData ropItemData = (ROPItemData) itemData;
    Map<String, Context> itemContexts = new HashMap<String, Context>();

    // create context for fromto
    Context fromToContextForReportingPeriod = ROPUtil.createFromToContextForReportingPeriod(ropGeneralData.getBankCode(), ropGeneralData.getReportingPeriodStartDate(), ropGeneralData.getDateOfQuarterEnded(), ropItemData.getRopReportingPeriod().getCountryCodeAxis(),  ropItemData.getRopReportingPeriod().getBranchCodeAxis());
    itemContexts.put(ROPUtil.FROMTOREPORTINGPERIOD ,fromToContextForReportingPeriod);

    Context fromToContextForDateOfReport = ROPUtil.createFromToContextForReportingPeriod(ropGeneralData.getBankCode(), ropGeneralData.getDateOfReport(), ropGeneralData.getDateOfQuarterEnded(), ropItemData.getRopDateOfReport().getCountryCodeAxis(), ropItemData.getRopDateOfReport().getBranchCodeAxis());
    itemContexts.put(ROPUtil.FROMTODATEOFREPORT ,fromToContextForDateOfReport);
    
    return itemContexts;
}

}
