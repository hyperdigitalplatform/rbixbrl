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
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRReportData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.UnitInterface;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBodyForGroup;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBodyForIndividual;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBodyForTotalGroup;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBodyForTotalIndividual;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRBorrowerGroupContext;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralBody;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralContext;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralExtraBody;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRGeneralOtherBody;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRIndividualContext;
import in.armedu.banking.report.rbixbrl.part.cpr.impl.CPRUnit;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

@Setter
public class RBICPRXBRLReportImpl implements XBRLReportIntf {
    
    private ContextInterface generalContext = new CPRGeneralContext();
    private ContextInterface individualContext = new CPRIndividualContext();
    private ContextInterface groupContext = new CPRBorrowerGroupContext();
    private BodyInterface generalBody = new CPRGeneralBody();
    private BodyInterface extraBody = new CPRGeneralExtraBody();
    private BodyInterface bodyForIndividual = new CPRBodyForIndividual();
    private BodyInterface bodyForTotalIndividual = new CPRBodyForTotalIndividual();
    private BodyInterface bodyForGroup = new CPRBodyForGroup();
    private BodyInterface bodyForTotalGroup = new CPRBodyForTotalGroup();
    private BodyInterface otherBody = new CPRGeneralOtherBody();
    private UnitInterface cprUnits = new CPRUnit();
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
            
            Map<String, Unit> units = cprUnits.getUnits( cprData.getGeneralData());
            List<Object> bodyElements = new ArrayList<Object>();
            //create all general contexts
            Map<String, Context> generalContexts = generalContext.getContext( cprData.getGeneralData());
            generalContexts.forEach((key, ctx) -> {
                xbrl.getItemOrTupleOrContext().add(ctx);
            });
            // create all individual borrower contexts
            CPRItemData cprItemData = (CPRItemData) cprData.getItemDatas().get(0);
            cprItemData.getLargeExposuresToIndividualBorrower().getIndividualBorrowers().forEach(indBorrower -> {
                Map<String, Context> indvContexts = individualContext.getContext(cprData.getGeneralData(), indBorrower);
                indvContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
            
            // create all group borrower contexts  
            cprItemData.getLargeExposureToBorrowerGroup().getBorrowerGroups().forEach(group ->{
                Map<String, Context> groupContexts = groupContext.getContext(cprData.getGeneralData(), group);
                groupContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
            });
            // create cpr generalbody
            bodyElements.addAll(generalBody.getReportBodyItem( generalContexts, units, cprData.getGeneralData()));
            // create cpr general extra body
            bodyElements.addAll(extraBody.getReportBodyItem( generalContexts, units, cprData.getGeneralData()));
            // create cpr individualbody
            cprItemData.getLargeExposuresToIndividualBorrower().getIndividualBorrowers().forEach(indBorrower -> {
                Map<String, Context> indvContexts = individualContext.getContext(cprData.getGeneralData(), indBorrower);
                indvContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
                bodyElements.addAll(bodyForIndividual.getReportBodyItem( indvContexts, units, cprData.getGeneralData(), indBorrower));
            });
            // create cpr total individualbody
            bodyElements.addAll(bodyForTotalIndividual.getReportBodyItem( generalContexts, units, cprData.getGeneralData(), cprItemData.getLargeExposuresToIndividualBorrower()));
            
            // create cpr borrower group body
            cprItemData.getLargeExposureToBorrowerGroup().getBorrowerGroups().forEach(group ->{
                Map<String, Context> groupContexts = groupContext.getContext(cprData.getGeneralData(), group);
                groupContexts.forEach((key, ctx) -> {
                    xbrl.getItemOrTupleOrContext().add(ctx);
                });
                bodyElements.addAll(bodyForGroup.getReportBodyItem( groupContexts, units, cprData.getGeneralData(), group));
            });
            // create cpr total borrowergroup
            bodyElements.addAll(bodyForTotalGroup.getReportBodyItem( generalContexts, units, cprData.getGeneralData(), cprItemData.getLargeExposureToBorrowerGroup()));
            
            // create cpr general other body
            bodyElements.addAll(otherBody.getReportBodyItem( generalContexts, units, cprData.getGeneralData()));
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
