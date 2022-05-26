package in.armedu.banking.report.rbixbrl.part;

import java.util.List;
import java.util.Map;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;

public interface BodyInterface {

    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalInfoData);
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalInfoData, ItemData rosItem);
    
}
