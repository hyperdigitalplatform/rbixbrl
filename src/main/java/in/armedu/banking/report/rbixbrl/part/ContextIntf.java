package in.armedu.banking.report.rbixbrl.part;

import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;

public interface ContextIntf {
    public List<Context> getContext(ObjectFactory xbrlObjectFactory, GeneralInfoData generalInfoData);

    public List<Context> getContext(ObjectFactory xbrlObjectFactory, GeneralInfoData generalInfoData, ROSItem rosItem);
}
