package in.armedu.banking.report.rbixbrl.part.vmr.impl;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;

public class VMRUnit implements UnitInterface {
 
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public Map<String, Unit> getUnits(GeneralData generalData) {
        Map<String, Unit> units = new HashMap<String, Unit>();
        // create units 
        
        Unit pureUnit = xbrlObjectFactory.createUnit();
        pureUnit.setId("PURE");
        QName pureMeasureValue = new QName("xbrli:pure");
        pureUnit.getMeasure().add(pureMeasureValue);
        units.put(VMRUtil.PERCENTAGE, pureUnit);
        return units;
    }

}
