package in.armedu.banking.report.rbixbrl.reports.impl;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.xlink.SimpleType;

import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRReportData;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.part.UnitIntf;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBody;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralBody;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralContext;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBICPRXBRLReportImpl implements XBRLReportIntf {
    
    private ContextIntf contextIntf = new CPRGeneralContext();
    private BodyIntf generalBody = new CPRGeneralBody();
    private UnitIntf units = new CPRUnit();
    private BodyIntf body = new CPRBody();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        CPRReportData cprData = (CPRReportData) reportData;

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
            simpleType.setHref("in-rbi-cpr.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();
            //create all contexts
            List<Context> generalContexts = contextIntf.getContext( cprData.getGeneralData());
            generalContexts.forEach(ctx -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });
            
            //bodyElements.addAll(generalBody.getReportBodyItem( generalContexts, rlcData.getRlcGeneralData()));

            cprData.getItemDatas().forEach(item->{
                List<Context> itemContexts = contextIntf.getContext(  cprData.getGeneralData(),  item);
                itemContexts.forEach(ctx -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
            // List<Unit> units = rlcUnits.getUnits( rlcData.getRlcGeneralData());
            // units.forEach(unit -> {
            //     xbrl.getItemOrTupleOrContext().add(unit);
            // });
            // // generate ros element for each subsidiary
            // rlcData.getRlcItems().forEach(item->{
            //     List<Context> rlcItemContexts = contextIntf.getContext( rlcData.getRlcGeneralData(), item);
                
            //     bodyElements.addAll(rlcBody.getReportBodyItem( rlcItemContexts, units, rlcData.getRlcGeneralData(), item));
            // });
            // bodyElements.forEach(bElem->{
            //     xbrl.getItemOrTupleOrContext().add(bElem);
            // });
            
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
