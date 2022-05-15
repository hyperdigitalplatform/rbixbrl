package in.armedu.banking.report.rbixbrl.part;

import java.util.List;
import java.util.Map;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;


public interface BodyIntf {

    public List<Object> getReportBodyItem(List<Context> contexts, GeneralData generalInfoData);
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralData generalInfoData, ItemData rosItem);
    
}
