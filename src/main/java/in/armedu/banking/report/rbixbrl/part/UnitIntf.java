package in.armedu.banking.report.rbixbrl.part;

import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;

public interface UnitIntf {
    public List<Unit> getUnits(ObjectFactory xbrlObjectFactory, GeneralInfoData generalInfoData);
}
