package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;

public class ROSUnit implements UnitInterface {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();

    @Override
    public Map<String, Unit> getUnits(GeneralData generalData) {

        Map<String, Unit> units = new HashMap<String, Unit>();
        
        
        // create units 
        Unit unitINR = xbrlObjectFactory.createUnit();
        unitINR.setId("INR");
        QName unitMeasureValue = new QName("iso4217:INR");
        unitINR.getMeasure().add(unitMeasureValue);
        //units.add(unitINR);
        units.put(ROSUtil.CURRENCY, unitINR);
        Unit pureUnit = xbrlObjectFactory.createUnit();
        pureUnit.setId("PURE");
        QName pureMeasureValue = new QName("xbrli:pure");
        pureUnit.getMeasure().add(pureMeasureValue);
        //units.add(pureUnit);
        units.put(ROSUtil.PERCENTAGE, pureUnit);
        return units;

    }
}
