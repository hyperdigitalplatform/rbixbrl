package in.armedu.banking.report.rbixbrl.part;

import java.util.List;
import java.util.Map;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;


public interface BodyIntf {

    public List<Object> getReportBodyItem(List<Context> contexts, GeneralInfoData generalInfoData);
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralInfoData generalInfoData, ROSItem rosItem);
    
}
