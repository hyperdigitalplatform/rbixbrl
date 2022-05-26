package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;

public class CPRUnit implements UnitInterface{
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public Map<String, Unit> getUnits(GeneralData generalData) {
        Map<String, Unit> units = new HashMap<String, Unit>();
        // create units 
        Unit unitINR = xbrlObjectFactory.createUnit();
        unitINR.setId("INR");
        QName unitMeasureValue = new QName("iso4217:INR");
        unitINR.getMeasure().add(unitMeasureValue);
        units.put(CPRUtil.CURRENCY, unitINR);
        Unit pureUnit = xbrlObjectFactory.createUnit();
        pureUnit.setId("PURE");
        QName pureMeasureValue = new QName("xbrli:pure");
        pureUnit.getMeasure().add(pureMeasureValue);
        units.put(CPRUtil.PERCENTAGE, pureUnit);
        return units;
    }

   
    
}
