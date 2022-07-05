package in.armedu.banking.report.rbixbrl.part.vmr.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class VMRGeneralContext implements ContextInterface {

    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
    VMRGeneralData vmrGeneralData = (VMRGeneralData) generalData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context
    Context fromToContext = VMRUtil.createFromToContext(vmrGeneralData.getBankCode(), vmrGeneralData.getReportingPeriodStartDate(), vmrGeneralData.getDateOfQuarterEnded(), null);
    contexts.put(VMRUtil.FROMTO, fromToContext);

    // create asof context
    Context asOfContext = VMRUtil.createAsOfContext(vmrGeneralData.getBankCode(), vmrGeneralData.getDateOfQuarterEnded(), null);
    contexts.put(VMRUtil.ASOF , asOfContext);


    return contexts;
}
@Override
public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
   
    return null;
}

}

