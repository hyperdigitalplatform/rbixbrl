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

import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPReportData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.rop.impl.ROPGeneralContext;
import in.armedu.banking.report.rbixbrl.part.rop.impl.ROPBody;
import in.armedu.banking.report.rbixbrl.part.rop.impl.ROPBodyExtra;
import in.armedu.banking.report.rbixbrl.part.rop.impl.ROPGeneralBody;
import in.armedu.banking.report.rbixbrl.part.rop.impl.ROPUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIROPXBRLReportImpl implements XBRLReportIntf  {
    
    
    private ContextInterface contextIntf = new ROPGeneralContext();
    private BodyInterface ropGeneralBody = new ROPGeneralBody();
    private UnitInterface ropUnits = new ROPUnit();
    private BodyInterface ropBody = new ROPBody();
    private BodyInterface ropBodyExtra = new ROPBodyExtra();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        ROPReportData ropData = (ROPReportData) reportData;

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
            simpleType.setHref("in-rbi-rep-rop.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();

            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext( ropData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            // create all item contexts
            List<ItemData> ropItemData = ropData.getItemDatas();
            ropItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = contextIntf.getContext(ropData.getGeneralData(), itemData);
                itemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
        
        // create units
        Map<String, Unit> units = ropUnits.getUnits( ropData.getGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
        // create ROP general body
        bodyElements.addAll(ropGeneralBody.getReportBodyItem( generalContexts, units, ropData.getGeneralData()));
    
        // // create ROP general body
        // bodyElements.addAll(ropBody.getReportBodyItem( generalContexts, units, ropData.getGeneralData(), ropItemData));
    
        // // create ROP general body
        // bodyElements.addAll(ropBodyExtra.getReportBodyItem( generalContexts, units, ropData.getGeneralData(), ropItemData));
    
        // generate ROP Body
        ropItemData.forEach(itemReportingPeriod ->{
        Map<String, Context> ropItemReportingDate = contextIntf.getContext(ropData.getGeneralData(), itemReportingPeriod);
        bodyElements.addAll(ropBody.getReportBodyItem( ropItemReportingDate, units, ropData.getGeneralData(), itemReportingPeriod));
        });

        // generate ROP Body Extra
        ropItemData.forEach(itemDateOfReport ->{
            Map<String, Context> ropItemDateOfReport = contextIntf.getContext(ropData.getGeneralData(), itemDateOfReport);
            bodyElements.addAll(ropBodyExtra.getReportBodyItem( ropItemDateOfReport, units, ropData.getGeneralData(), itemDateOfReport));
            });

        // add all element into xbrl
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
