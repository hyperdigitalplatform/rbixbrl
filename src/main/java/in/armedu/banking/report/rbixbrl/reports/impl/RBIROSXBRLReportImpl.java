package in.armedu.banking.report.rbixbrl.reports.impl;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.xlink.SimpleType;

import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSBody;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSGeneralBody;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSGeneralContext;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIROSXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface contextIntf = new ROSGeneralContext();
    private BodyInterface rosGeneralBody = new ROSGeneralBody();
    private UnitInterface rosUnits = new ROSUnit();
    private BodyInterface rosBody = new ROSBody();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        ROSData rosData = (ROSData) reportData;

        try {
            jc = JAXBContext.newInstance(ObjectFactory.class,
            org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ObjectFactory.class,
            org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory.class,
            org.rbi.in_rbi_rep_par.ObjectFactory.class,
            org.xbrl._2003.xlink.ObjectFactory.class,
            org.xbrl._2003.instance.ObjectFactory.class,
            org.xbrl._2006.xbrldi.ObjectFactory.class,
            org.xbrl._2003.linkbase.ObjectFactory.class,
            org.xbrl._2005.xbrldt.ObjectFactory.class,
            org.xbrl.dtr.type.non_numeric.ObjectFactory.class,
            org.xbrl.dtr.type.numeric.ObjectFactory.class);

            m = jc.createMarshaller();
            StringWriter writer = new StringWriter();
            Xbrl xbrl = instancObjectFactory.createXbrl();
            
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
            org.xbrl._2003.xlink.ObjectFactory xlinkObjectFactory = new org.xbrl._2003.xlink.ObjectFactory();
            SimpleType simpleType = xlinkObjectFactory.createSimpleType();
            simpleType.setType("simple");
            simpleType.setHref("in-rbi-ros.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();
            Map<String, Unit> units = rosUnits.getUnits(rosData.getRosGeneralInfo());
            
             //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext(rosData.getRosGeneralInfo());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            bodyElements.addAll(rosGeneralBody.getReportBodyItem( generalContexts, units, rosData.getRosGeneralInfo()));

            //  create all item contexts
            List<ROSItem> rosItemData = rosData.getRosItems();
            rosItemData.forEach(item ->{
                Map<String, Context> rosItemContexts = contextIntf.getContext(rosData.getRosGeneralInfo(), item);
                rosItemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
            
                //create units
           units.forEach((key, unit) -> {
            xbrl.getItemOrTupleOrContext().add(unit);
            });
           

            // generate ros element for each subsidiary
            rosData.getRosItems().forEach(item ->{
                Map<String, Context> rosItemContexts = contextIntf.getContext(rosData.getRosGeneralInfo(), item);
                bodyElements.addAll(rosBody.getReportBodyItem( rosItemContexts, units, rosData.getRosGeneralInfo(), item));
            });
           

            bodyElements.forEach(bElem->{
                xbrl.getItemOrTupleOrContext().add(bElem);
            });
            
            m.marshal(xbrl, writer);
            System.out.println("");
            System.out.println(writer.toString());
            System.out.println("");
            return writer;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }
    
}
