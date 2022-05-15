package in.armedu.banking.report.rbixbrl.part.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.part.UnitIntf;

public class ROSUnit implements UnitIntf {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public List<Unit> getUnits( GeneralData generalData) {
        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        
        List<Unit> units = new ArrayList<Unit>();
        // create units 
        Unit unitINR = xbrlObjectFactory.createUnit();
        unitINR.setId("INR");
        QName unitMeasureValue = new QName("iso4217:INR");
        unitINR.getMeasure().add(unitMeasureValue);
        units.add(unitINR);
        Unit pureUnit = xbrlObjectFactory.createUnit();
        pureUnit.setId("PURE");
        QName pureMeasureValue = new QName("xbrli:pure");
        pureUnit.getMeasure().add(pureMeasureValue);
        units.add(pureUnit);
        return units;
    }
    
}
