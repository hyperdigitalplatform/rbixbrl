package in.armedu.banking.report.rbixbrl.part.fmr;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class FMRGeneralContext implements ContextInterface {
    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
        FMRGeneralData fmrGeneralData = (FMRGeneralData) generalData;
        Map<String, Context> contexts = new HashMap<String, Context>();

        // create fromto context
        Context fromToContext = FMRUtil.createFromToContext(fmrGeneralData.getBankCode(), fmrGeneralData.getReportingPeriodStartDate(), fmrGeneralData.getQuarterEndDate(), null);
        contexts.put(FMRUtil.FROMTO, fromToContext);
        // create asof context
        Context asOfContext = FMRUtil.createAsOfContext(fmrGeneralData.getBankCode(), fmrGeneralData.getReportingPeriodStartDate(), null);
        contexts.put(FMRUtil.ASOF , asOfContext);
      
        return contexts;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
        return null;
    }

    
}
    