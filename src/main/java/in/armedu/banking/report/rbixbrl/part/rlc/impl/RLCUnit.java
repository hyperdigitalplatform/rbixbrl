package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.List;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.UnitIntf;
import java.util.ArrayList;



public class RLCUnit implements UnitIntf{

    private ObjectFactory xbrlObjectFactory = new ObjectFactory();

    @Override
    public List<Unit> getUnits(GeneralData generalData) {
       
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        
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
