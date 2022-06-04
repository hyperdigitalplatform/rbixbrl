package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import java.util.ArrayList;

public class RLCUnit implements UnitInterface{

    private ObjectFactory xbrlObjectFactory = new ObjectFactory();

    @Override
    public Map<String, Unit> getUnits(GeneralData generalData) {

        Map<String, Unit> units = new HashMap<String, Unit>();
        
        //RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        
        // create units 
        Unit unitINR = xbrlObjectFactory.createUnit();
        unitINR.setId("INR");
        QName unitMeasureValue = new QName("iso4217:INR");
        unitINR.getMeasure().add(unitMeasureValue);
        //units.add(unitINR);
        units.put(RLCUtil.CURRENCY, unitINR);
        Unit pureUnit = xbrlObjectFactory.createUnit();
        pureUnit.setId("PURE");
        QName pureMeasureValue = new QName("xbrli:pure");
        pureUnit.getMeasure().add(pureMeasureValue);
        //units.add(pureUnit);
        units.put(RLCUtil.PERCENTAGE, pureUnit);
        return units;

    }
}
