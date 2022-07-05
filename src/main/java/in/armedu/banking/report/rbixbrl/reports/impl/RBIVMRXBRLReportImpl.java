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
import in.armedu.banking.report.rbixbrl.model.vmr.VMRReportData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralData;
// import in.armedu.banking.report.rbixbrl.model.vmr.VMRItemData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.vmr.impl.VMRGeneralContext;
import in.armedu.banking.report.rbixbrl.part.vmr.impl.VMRBody;
import in.armedu.banking.report.rbixbrl.part.vmr.impl.VMRReportingData;
import in.armedu.banking.report.rbixbrl.part.vmr.impl.VMRGeneralBody;
import in.armedu.banking.report.rbixbrl.part.vmr.impl.VMRUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIVMRXBRLReportImpl implements XBRLReportIntf  {
    
    
    private ContextInterface contextIntf = new VMRGeneralContext();
    private BodyInterface vmrGeneralBody = new VMRGeneralBody();
    private UnitInterface vmrUnits = new VMRUnit();
    private BodyInterface vmrBody = new VMRBody();
    private BodyInterface vmrReportingData = new VMRReportingData();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        VMRReportData vmrData = (VMRReportData) reportData;

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
            simpleType.setHref("in-rbi-rep-vmr.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();

            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext( vmrData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

        
        // create units
        Map<String, Unit> units = vmrUnits.getUnits( vmrData.getGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
        // create VMR general body
        bodyElements.addAll(vmrGeneralBody.getReportBodyItem( generalContexts, units, vmrData.getGeneralData()));
    
        // create VMR general body
        bodyElements.addAll(vmrBody.getReportBodyItem( generalContexts, units, vmrData.getGeneralData()));
    
        // create VMR general body
        bodyElements.addAll(vmrReportingData.getReportBodyItem( generalContexts, units, vmrData.getGeneralData()));


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
