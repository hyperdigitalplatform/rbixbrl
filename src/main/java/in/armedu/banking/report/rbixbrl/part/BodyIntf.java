package in.armedu.banking.report.rbixbrl.part;

import java.util.List;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;


public interface BodyIntf {

    public List<Object> getReportBodyItem(List<Context> contexts, GeneralInfoData generalInfoData);
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext, GeneralInfoData generalInfoData);
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralInfoData generalInfoData, ROSItem rosItem);
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext, GeneralInfoData generalInfoData, ROSItem rosItem);
}
