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
import in.armedu.banking.report.rbixbrl.model.pci.PCIReportData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIItemData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.pci.impl.PCIGeneralContext;
import in.armedu.banking.report.rbixbrl.part.pci.impl.PCIBodyMoreThanUSD2MillionMember;
import in.armedu.banking.report.rbixbrl.part.pci.impl.PCIBodyLessThanUSD2MillionMember;
import in.armedu.banking.report.rbixbrl.part.pci.impl.PCIGeneralBody;
// import in.armedu.banking.report.rbixbrl.part.pci.impl.PCISignatoryDetails;
import in.armedu.banking.report.rbixbrl.part.pci.impl.PCIUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter

public class RBIPCIXBRLReportImpl implements XBRLReportIntf {
    
        
    private ContextInterface contextIntf = new PCIGeneralContext();
    private BodyInterface pciGeneralBody = new PCIGeneralBody();
    // private BodyInterface pciSignatoryDetails = new PCISignatoryDetails();    
    private BodyInterface pciBodyMoreThanUSD2MillionMember = new PCIBodyMoreThanUSD2MillionMember();
    private BodyInterface pciBodyLessThanUSD2MillionMember = new PCIBodyLessThanUSD2MillionMember();
    private UnitInterface pciUnits = new PCIUnit();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        PCIReportData pciData = (PCIReportData) reportData;

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
            simpleType.setHref("in-rbi-pci.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            List<Object> bodyElements = new ArrayList<Object>();

            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext( pciData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            // create all item contexts
            List<ItemData> pciItemData = pciData.getItemDatas();
            pciItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = contextIntf.getContext(pciData.getGeneralData(), itemData);
                itemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
        
        // create units
        Map<String, Unit> units = pciUnits.getUnits( pciData.getGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
        // create general body
        bodyElements.addAll(pciGeneralBody.getReportBodyItem( generalContexts, units, pciData.getGeneralData()));
        
            // generate PCI Body for MoreThanUSD2MillionMember
            pciItemData.forEach(item ->{
            Map<String, Context> pciItem = contextIntf.getContext(pciData.getGeneralData(), item);
            bodyElements.addAll(pciBodyMoreThanUSD2MillionMember.getReportBodyItem( pciItem, units, pciData.getGeneralData(), item));
        });

            // generate PCI Body for LessThanUSD2MillionMember
            pciItemData.forEach(item ->{
            Map<String, Context> pciItem = contextIntf.getContext(pciData.getGeneralData(), item);
            bodyElements.addAll(pciBodyLessThanUSD2MillionMember.getReportBodyItem( pciItem, units, pciData.getGeneralData(), item));
        });

    
    //     //generate PCI SignatoryDetails
    //     bodyElements.addAll(pciSignatoryDetails.getReportBodyItem( generalContexts, units, pciData.getGeneralData()));

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
