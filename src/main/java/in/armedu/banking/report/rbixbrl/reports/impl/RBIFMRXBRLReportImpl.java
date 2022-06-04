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

import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRReportData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRBodyForItem;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRGeneralBody;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRGeneralBodyForAuthorizedReport;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRGeneralContext;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRItemContext;
import in.armedu.banking.report.rbixbrl.part.fmr.FMRUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIFMRXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface generalContext = new FMRGeneralContext();
    private ContextInterface itemContext = new FMRItemContext();
    private BodyInterface generalBody = new FMRGeneralBody();
    private BodyInterface extraBody = new FMRGeneralBodyForAuthorizedReport();
    private BodyInterface bodyForBranch = new FMRBodyForItem();
    private UnitInterface fmrUnits = new FMRUnit();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        FMRReportData fmrData = (FMRReportData) reportData;

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
            simpleType.setHref("in-rbi-rep-fmr4.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            
            Map<String, Unit> units = fmrUnits.getUnits( fmrData.getGeneralData());
            List<Object> bodyElements = new ArrayList<Object>();
            //create all general contexts
            Map<String, Context> generalContexts = generalContext.getContext( fmrData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });
            // create all item contexts
            List<ItemData> fmrItemData = fmrData.getItemDatas();
            fmrItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = itemContext.getContext(fmrData.getGeneralData(), itemData);
                itemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
            
            
            // create fmr generalbody
            bodyElements.addAll(generalBody.getReportBodyItem( generalContexts, units, fmrData.getGeneralData()));
            // create FMR for each branch
            fmrItemData.forEach(itemData -> {
                Map<String, Context> itemContexts = itemContext.getContext(fmrData.getGeneralData(), itemData);
                bodyElements.addAll(bodyForBranch.getReportBodyItem( itemContexts, units, fmrData.getGeneralData(), itemData));
            });
            
            // create FMR authorized reporting
            bodyElements.addAll(extraBody.getReportBodyItem( generalContexts, units, fmrData.getGeneralData()));
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
