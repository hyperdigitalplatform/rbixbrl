package in.armedu.banking.report.rbixbrl.part;

import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;

public interface ContextInterface {
    public Map<String, Context> getContext(GeneralData generalData);
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData);
}
