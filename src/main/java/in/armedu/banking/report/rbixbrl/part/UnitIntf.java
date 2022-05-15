package in.armedu.banking.report.rbixbrl.part;

import java.util.List;

import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;

public interface UnitIntf {
    public List<Unit> getUnits(GeneralData generalData);
}
