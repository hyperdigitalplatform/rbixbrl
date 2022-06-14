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
import in.armedu.banking.report.rbixbrl.model.alo.ALOReportData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOBody;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOBodyExtra;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOGeneralBody;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOSignatoryDetails;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOGeneralContext;
import in.armedu.banking.report.rbixbrl.part.alo.impl.ALOUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIALOXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface contextIntf = new ALOGeneralContext();
    private BodyInterface aloGeneralBody = new ALOGeneralBody();
    private BodyInterface aloSignatoryDetails = new ALOSignatoryDetails();    
    private BodyInterface aloBody = new ALOBody();
    private BodyInterface aloBodyExtra = new ALOBodyExtra();
    private UnitInterface aloUnits = new ALOUnit();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        ALOReportData aloData = (ALOReportData) reportData;

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
            simpleType.setHref("in-rbi-rlc.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
           
            List<Object> bodyElements = new ArrayList<Object>();

            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext( aloData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            // create all item contexts
            List<ItemData> aloItemData = aloData.getItemDatas();
            aloItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = contextIntf.getContext(aloData.getGeneralData(), itemData);
                itemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
        
        // create units
        Map<String, Unit> units = aloUnits.getUnits( aloData.getGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
    // create general body
   bodyElements.addAll(aloGeneralBody.getReportBodyItem( generalContexts, units, aloData.getGeneralData()));
   
      // generate ALO Body
      aloItemData.forEach(item ->{
        Map<String, Context> aloItem = contextIntf.getContext(aloData.getGeneralData(), item);
        bodyElements.addAll(aloBody.getReportBodyItem( aloItem, units, aloData.getGeneralData(), item));
    });

    
        // //generate ALO General Info Body
        // bodyElements.addAll(aloGeneralInfoBody.getReportBodyItem( generalContexts, units, aloData.getGeneralData()));

      // generate ALO Body Extra
      aloItemData.forEach(item ->{
        Map<String, Context> aloItem = contextIntf.getContext(aloData.getGeneralData(), item);
        bodyElements.addAll(aloBodyExtra.getReportBodyItem( aloItem, units, aloData.getGeneralData(), item));
    });

 

     //signatory details
     bodyElements.addAll(aloSignatoryDetails.getReportBodyItem( generalContexts, units, aloData.getGeneralData()));

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
