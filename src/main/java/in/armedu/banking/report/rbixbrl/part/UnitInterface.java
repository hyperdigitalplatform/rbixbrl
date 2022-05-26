package in.armedu.banking.report.rbixbrl.part;

import java.util.Map;

import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;

public interface UnitInterface {
    public Map<String, Unit> getUnits(GeneralData generalData);
}
