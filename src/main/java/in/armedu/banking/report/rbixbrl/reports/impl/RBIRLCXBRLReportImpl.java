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
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.xlink.SimpleType;

import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCReportData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCBodyIndividual;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCBodyBorrowerGroup;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCBodyCounterPartyDomestic;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCBodyCounterPartyGlobal;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBody;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBodyIndividual;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBodyGroupBorrower;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralCounterParty;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralContext;
// import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBodyContext;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBodyExtra;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBIRLCXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface contextIntf = new RLCGeneralContext();
    // private ContextInterface contextOnlyIntf = new RLCGeneralBodyContext();
    private BodyInterface rlcGeneralBody = new RLCGeneralBody();
    private BodyInterface rlcBodyIndividual = new RLCBodyIndividual();
    private BodyInterface rlcBodyBorrowerGroup = new RLCBodyBorrowerGroup();
    private BodyInterface rlcBodyCounterPartyDomestic = new RLCBodyCounterPartyDomestic();
    private BodyInterface rlcBodyCounterPartyGlobal = new RLCBodyCounterPartyGlobal();
    private BodyInterface rlcGeneralBodyIndividual = new RLCGeneralBodyIndividual();
    private BodyInterface rlcGeneralBodyGroupBorrower = new RLCGeneralBodyGroupBorrower();
    private BodyInterface rlcGeneralCounterParty = new RLCGeneralCounterParty();
    private BodyInterface rlcGeneralBodyExtra = new RLCGeneralBodyExtra();
    private UnitInterface rlcUnits = new RLCUnit();
    private ObjectFactory instancObjectFactory = new ObjectFactory();
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        RLCReportData rlcReportData = (RLCReportData) reportData;

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
           
           // Map<String, Unit> units = rlcUnits.getUnits( rlcReportData.getRlcGeneralData());

            List<Object> bodyElements = new ArrayList<Object>();
  
            //create all general contexts
            Map<String, Context> generalContexts = contextIntf.getContext(rlcReportData.getRlcGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });

            //  create all contexts
            List<RLCItem> rlcItemData = rlcReportData.getRlcItem();
            rlcItemData.forEach(item ->{
                Map<String, Context> rlcItemContexts = contextIntf.getContext(rlcReportData.getRlcGeneralData(), item);
                rlcItemContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });

            // //create all only general contexts
            // Map<String, Context> generalOnlyContexts = contextOnlyIntf.getContext(rlcReportData.getRlcGeneralData());
            // generalOnlyContexts.forEach((key, ctx) -> {
            //     xbrl.getItemOrTupleOrContext().add(ctx);
            // });

   
        
        // create units
        Map<String, Unit> units = rlcUnits.getUnits( rlcReportData.getRlcGeneralData());
        units.forEach((key, unit) -> {
        xbrl.getItemOrTupleOrContext().add(unit);
        });
    
        // create general body
        bodyElements.addAll(rlcGeneralBody.getReportBodyItem( generalContexts, units, rlcReportData.getRlcGeneralData()));

        // generate RLCBody Individual
        rlcItemData.forEach(item ->{
            Map<String, Context> rlcItemIndividual = contextIntf.getContext(rlcReportData.getRlcGeneralData(), item);
            bodyElements.addAll(rlcBodyIndividual.getReportBodyItem( rlcItemIndividual, units, rlcReportData.getRlcGeneralData(), item));
        });

        // create rlc General Body Individual
        bodyElements.addAll(rlcGeneralBodyIndividual.getReportBodyItem( generalContexts, units, rlcReportData.getRlcGeneralData()));
                 
        //  RLCBodyBorrowerGroup
        rlcItemData.forEach(item ->{
            Map<String, Context> rlcItemBorrower = contextIntf.getContext(rlcReportData.getRlcGeneralData(), item);
            bodyElements.addAll(rlcBodyBorrowerGroup.getReportBodyItem( rlcItemBorrower, units, rlcReportData.getRlcGeneralData(), item));
        });

        // create general body
        bodyElements.addAll(rlcGeneralBodyGroupBorrower.getReportBodyItem( generalContexts, units, rlcReportData.getRlcGeneralData()));

        //  RLCBodyCounterParty Domestic
        rlcItemData.forEach(item ->{
            Map<String, Context> rlcItemCounterDomestic = contextIntf.getContext(rlcReportData.getRlcGeneralData(), item);
            bodyElements.addAll(rlcBodyCounterPartyDomestic.getReportBodyItem( rlcItemCounterDomestic, units, rlcReportData.getRlcGeneralData(), item));
        });

         //  RLCBodyCounterParty Global
        rlcItemData.forEach(item ->{
            Map<String, Context> rlcItemCounterGlobal = contextIntf.getContext(rlcReportData.getRlcGeneralData(), item);
            bodyElements.addAll(rlcBodyCounterPartyGlobal.getReportBodyItem( rlcItemCounterGlobal, units, rlcReportData.getRlcGeneralData(), item));
        });

        // create general body
        bodyElements.addAll(rlcGeneralCounterParty.getReportBodyItem( generalContexts, units, rlcReportData.getRlcGeneralData()));
        
        // signatory details
        bodyElements.addAll(rlcGeneralBodyExtra.getReportBodyItem( generalContexts, units, rlcReportData.getRlcGeneralData()));

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
