package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class ROSGeneralContext implements ContextIntf {
        private ObjectFactory xbrlObjectFactory = new ObjectFactory();

        @Override
        public List<Context> getContext( GeneralData generalData) {
                ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;

                ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
                Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
                identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
                // set entity identifier aka bank code
                identifier.setValue(generalInfoData.getBankCode());
                contextEntityType.setIdentifier(identifier);
                // create fromto context
                Context fromToContext = xbrlObjectFactory.createContext();
                String contextRefFromTo = FromToContext.getId("fromto", generalInfoData.getStartDate(),  generalInfoData.getEndDate());
                fromToContext.setId(contextRefFromTo);
                ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
                period.setStartDate(generalInfoData.getStartDate());
                period.setEndDate(generalInfoData.getEndDate());

                fromToContext.setEntity(contextEntityType);
                fromToContext.setPeriod(period);
                // create asof context
                Context asOfContext = xbrlObjectFactory.createContext();
                String contextRefAsOfString = AsOfContext.getId("asof", generalInfoData.getDateOfReport());
                asOfContext.setId(contextRefAsOfString);
                ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
                periodInstant.setInstant(generalInfoData.getDateOfReport());
                asOfContext.setEntity(contextEntityType);
                asOfContext.setPeriod(periodInstant);

                return Arrays.asList(fromToContext, asOfContext);
        }

        @Override
        public List<Context> getContext( GeneralData generalData,   ItemData itemData) {
                
        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        ROSItem rosItem = (ROSItem) itemData;

        // create entity and entity identifier
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        TypedMember typedMember = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfSubsidiaryAssociateJointVenturesAxis"));
        typedMember.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                        .createNameOfSubsidiaryAssociateJointVenturesDomain(
                                                        rosItem.getSubsidiaryInfo().getSubsidiaryName()));
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(generalInfoData.getBankCode());
        contextEntityType.setIdentifier(identifier);
        // create segement
        org.xbrl._2003.instance.Segment seg = xbrlObjectFactory.createSegment();
        seg.getAny().add(typedMember);
        // add to context Entity
        contextEntityType.setSegment(seg);

                // set all objects to context
                fromToContext.setEntity(contextEntityType);
                fromToContext.setPeriod(period);
                
                // create asof context
                Context asOfContext = xbrlObjectFactory.createContext();
                String contextRefAsOfString = AsOfContext.getId("asof", generalInfoData.getDateOfReport(),
                                rosItem.getSubsidiaryInfo().getSubsidiaryName());
                asOfContext.setId(contextRefAsOfString);
                ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
                periodInstant.setInstant(generalInfoData.getDateOfReport());
                asOfContext.setEntity(contextEntityType);
                asOfContext.setPeriod(periodInstant);
                // create asof context for bookvaluemember
                // create entity and entity identifier
                ContextEntityType contextEntityTypeForBookValueMember = xbrlObjectFactory.createContextEntityType();
                contextEntityTypeForBookValueMember.setIdentifier(identifier);
                // create segement
                org.xbrl._2003.instance.Segment segBookValueMember = xbrlObjectFactory.createSegment();
                
                ExplicitMember explicitMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
                explicitMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfValueAxis"));
                explicitMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BookValueMember"));;
                segBookValueMember.getAny().add(explicitMember);
                segBookValueMember.getAny().add(typedMember);
                // add to context Entity
                contextEntityTypeForBookValueMember.setSegment(segBookValueMember);
                Context asOfBookValueMemberContext = xbrlObjectFactory.createContext();
                String contextRefAsOfBookValueMemberString = AsOfContext.getId("asof", generalInfoData.getDateOfReport(),
                                "BookValueMember", rosItem.getSubsidiaryInfo().getSubsidiaryName());
                                asOfBookValueMemberContext.setId(contextRefAsOfBookValueMemberString);
                asOfBookValueMemberContext.setEntity(contextEntityTypeForBookValueMember);
                asOfBookValueMemberContext.setPeriod(periodInstant);
                // create asof context for MarketValueMember
                // create entity and entity identifier
                ContextEntityType contextEntityTypeForMarketValueMember = xbrlObjectFactory.createContextEntityType();
                contextEntityTypeForMarketValueMember.setIdentifier(identifier);
                // create segement
                org.xbrl._2003.instance.Segment segMarketValueMember = xbrlObjectFactory.createSegment();
                
                ExplicitMember explicitMemberForMarketValueMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
                explicitMemberForMarketValueMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfValueAxis"));
                explicitMemberForMarketValueMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "MarketValueMember"));;
                segMarketValueMember.getAny().add(explicitMemberForMarketValueMember);
                //segMarketValueMember.getAny().add(typedMember);
                // add to context Entity
                contextEntityTypeForMarketValueMember.setSegment(segMarketValueMember);
                Context asOfMarketValueMemberContext = xbrlObjectFactory.createContext();
                String contextRefAsOfMarketValueMemberString = AsOfContext.getId("asof", generalInfoData.getDateOfReport(),
                                "MarketValueMember", rosItem.getSubsidiaryInfo().getSubsidiaryName());
                asOfMarketValueMemberContext.setId(contextRefAsOfMarketValueMemberString);
                asOfMarketValueMemberContext.setEntity(contextEntityTypeForMarketValueMember);
                asOfMarketValueMemberContext.setPeriod(periodInstant);

                

                return Arrays.asList(fromToContext, asOfContext, asOfBookValueMemberContext, asOfMarketValueMemberContext);
        }

}
