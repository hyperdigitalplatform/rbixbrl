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

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSData;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.part.impl.ROSBody;
import in.armedu.banking.report.rbixbrl.part.impl.ROSGeneralBody;
import in.armedu.banking.report.rbixbrl.part.impl.ROSGeneralContext;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;

public class RBIROSXBRLReportImpl {
    private List<ContextIntf> contexts = new ArrayList<ContextIntf>();
    private List<BodyIntf> bodies = new ArrayList<BodyIntf>();
    private ContextIntf contextIntf = new ROSGeneralContext();
    private BodyIntf rosGeneralBody = new ROSGeneralBody();
    private BodyIntf rosBody = new ROSBody();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    private String outFolder;
    private String reportName;
    
    public StringWriter generateReport(ROSData rosData){
        JAXBContext jc;
        Marshaller m;
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
            //create all contexts
            List<Context> generalContexts = contextIntf.getContext(instancObjectFactory, rosData.getRosGeneralInfo());
            generalContexts.forEach(ctx -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });
            
            bodyElements.addAll(rosGeneralBody.getReportBodyItem( generalContexts, rosData.getRosGeneralInfo()));

            rosData.getRosItems().forEach(item->{
                List<Context> rosItemContexts = contextIntf.getContext(instancObjectFactory, rosData.getRosGeneralInfo(), item);
                rosItemContexts.forEach(ctx -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
                //xbrl.getItemOrTupleOrContext().add(rosItemContexts);
                //bodyElements.addAll(rosBody.getReportBodyItem( rosItemContexts, rosData.getRosGeneralInfo(), item));
            });
            bodyElements.forEach(bElem->{
                xbrl.getItemOrTupleOrContext().add(bElem);
            });
            
            m.marshal(xbrl, writer);
            System.out.println("");
            System.out.println(writer.toString());
            return writer;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public void prepareReport(ROSData rosData){
        contexts.add(new ROSGeneralContext());
        bodies.add(new ROSGeneralBody());
        bodies.add(new ROSBody());
    }
    
}
