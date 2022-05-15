package in.armedu.banking.report.rbixbrl.part;

import java.util.List;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;

public interface ContextIntf {
    public List<Context> getContext(GeneralData generalData);
    public List<Context> getContext(GeneralData generalData, ItemData itemData);
}
