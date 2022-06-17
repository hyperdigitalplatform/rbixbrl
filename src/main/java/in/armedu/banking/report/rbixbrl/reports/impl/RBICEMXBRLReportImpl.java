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
import in.armedu.banking.report.rbixbrl.model.cem.CEMReportData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMItemData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.cem.impl.CEMGeneralContext;
import in.armedu.banking.report.rbixbrl.part.cem.impl.CEMBody;
import in.armedu.banking.report.rbixbrl.part.cem.impl.CEMGeneralBody;
import in.armedu.banking.report.rbixbrl.part.cem.impl.CEMSignatoryDetails;
import in.armedu.banking.report.rbixbrl.part.cem.impl.CEMUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBICEMXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface contextIntf = new CEMGeneralContext();
    private BodyInterface cemGeneralBody = new CEMGeneralBody();
    private BodyInterface cemSignatoryDetails = new CEMSignatoryDetails();    
    private BodyInterface cemBody = new CEMBody();
    private UnitInterface cemUnits = new CEMUnit();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        CEMReportData cemData = (CEMReportData) reportData;

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
            simpleType.setHref("../schemas/cem/in-rbi-cem.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();

            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext( cemData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            // create all item contexts
            List<ItemData> cemItemData = cemData.getItemDatas();
            cemItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = contextIntf.getContext(cemData.getGeneralData(), itemData);
                itemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
        
        // create units
        Map<String, Unit> units = cemUnits.getUnits( cemData.getGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
    // create general body
    bodyElements.addAll(cemGeneralBody.getReportBodyItem( generalContexts, units, cemData.getGeneralData()));
    
        // generate CEM Body
        cemItemData.forEach(item ->{
        Map<String, Context> cemItem = contextIntf.getContext(cemData.getGeneralData(), item);
        bodyElements.addAll(cemBody.getReportBodyItem( cemItem, units, cemData.getGeneralData(), item));
    });

    
        //generate CEM SignatoryDetails
        bodyElements.addAll(cemSignatoryDetails.getReportBodyItem( generalContexts, units, cemData.getGeneralData()));

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
