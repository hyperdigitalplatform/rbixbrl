package in.armedu.banking.report.rbixbrl.part.rlc.impl;

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
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class RLCGeneralContext implements ContextIntf {

    private ObjectFactory xbrlObjectFactory = new ObjectFactory();

    @Override
    public List<Context> getContext(GeneralData generalData) {
    
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;

        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(rlcGeneralData.getBankCode());
        contextEntityType.setIdentifier(identifier);
        
        // create fromto context
        Context fromToContext = xbrlObjectFactory.createContext();
        String contextRefFromTo = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),  rlcGeneralData.getEndDate());
        fromToContext.setId(contextRefFromTo);
        ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
        period.setStartDate(rlcGeneralData.getStartDate());
        period.setEndDate(rlcGeneralData.getEndDate());
        fromToContext.setEntity(contextEntityType);
        fromToContext.setPeriod(period);

        // create asof context
        Context asOfContext = xbrlObjectFactory.createContext();
        String contextRefAsOfString = AsOfContext.getId("asof", rlcGeneralData.getEndDate());
        asOfContext.setId(contextRefAsOfString);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(rlcGeneralData.getEndDate());
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);

        // create asof2 context
        Context asOfContext2 = xbrlObjectFactory.createContext();
        String contextRefAsOfString2 = AsOfContext.getId("asof", rlcGeneralData.getLastEndDate());
        asOfContext2.setId(contextRefAsOfString2);
        ContextPeriodType periodInstant2 = xbrlObjectFactory.createContextPeriodType();
        periodInstant2.setInstant(rlcGeneralData.getLastEndDate());
        asOfContext2.setEntity(contextEntityType);
        asOfContext2.setPeriod(periodInstant2);

        // create fromto2 context
        Context fromToContext2 = xbrlObjectFactory.createContext();
        String contextRefFromTo2 = FromToContext.getId("fromto", rlcGeneralData.getCurrentDate(),  rlcGeneralData.getEndDate());
        fromToContext2.setId(contextRefFromTo2);
        ContextPeriodType period2 = xbrlObjectFactory.createContextPeriodType();
        period2.setStartDate(rlcGeneralData.getCurrentDate());
        period2.setEndDate(rlcGeneralData.getEndDate());
        fromToContext2.setEntity(contextEntityType);
        fromToContext2.setPeriod(period2);

      return Arrays.asList(fromToContext, asOfContext, asOfContext2, fromToContext2);

    }

    @Override
    public List<Context> getContext(GeneralData generalData, ItemData itemData) {
       
      RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;


      //*********************** RLC SET1 **************
      RLCItem rlcItem1 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType1 = xbrlObjectFactory.createContextEntityType();

      // set entity identifier aka bank code
      Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
      identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
      identifier.setValue(rlcGeneralData.getBankCode());
      contextEntityType1.setIdentifier(identifier);

      // set period
      ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
      period.setStartDate(rlcGeneralData.getStartDate());
      period.setEndDate(rlcGeneralData.getEndDate());

      // set instant period
      ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
      periodInstant.setInstant(rlcGeneralData.getEndDate());

      //set explicit members
      ExplicitMember explicitMember1 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember1.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
      explicitMember1.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GlobalMember"));
       
      ExplicitMember explicitMember2 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMember2.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndividualBorrowersMember"));
       
      ExplicitMember explicitMember3 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember3.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMember3.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BorrowerGroupMember"));

      ExplicitMember explicitMember4 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember4.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMember4.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankMember"));
       
      ExplicitMember explicitMember5 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember5.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
      explicitMember5.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DomesticMember"));

      ExplicitMember explicitMember6 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMember6.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
      explicitMember6.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "OverseasMember"));
       
      //set typed members
      TypedMember typedMemberA1 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA1.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA1.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem1.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB1 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB1.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberB1.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem1.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberC1 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC1.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberC1.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                             rlcItem1.getRlcBasicInfo().getIndustryNameAxis()));

      TypedMember typedMemberD1 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberD1.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
      typedMemberD1.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                            rlcItem1.getRlcBasicInfo().getLeadBankNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment1 = xbrlObjectFactory.createSegment();
      segment1.getAny().add(explicitMember1);
      segment1.getAny().add(explicitMember2);
      segment1.getAny().add(typedMemberA1);
      segment1.getAny().add(typedMemberB1);
      segment1.getAny().add(typedMemberC1);
      segment1.getAny().add(typedMemberD1);
      
      // add to context Entity
      contextEntityType1.setSegment(segment1);

      // create fromto context rlcSet1
      Context fromToRlcSet1 = xbrlObjectFactory.createContext();
      String fromToString1 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), rlcItem1.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem1.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem1.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem1.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem1.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem1.getRlcBasicInfo().getLeadBankNameAxis());
      fromToRlcSet1.setId(fromToString1);
      
      // set all objects to context rlcSet1
      fromToRlcSet1.setEntity(contextEntityType1);
      fromToRlcSet1.setPeriod(period);

      // create asof context
      Context asOfRlcSet1 = xbrlObjectFactory.createContext();
      String asOfString1 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem1.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                    rlcItem1.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem1.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                    rlcItem1.getRlcBasicInfo().getIndustryCodeAxis(),
                                    rlcItem1.getRlcBasicInfo().getIndustryNameAxis(),
                                    rlcItem1.getRlcBasicInfo().getLeadBankNameAxis());
      asOfRlcSet1.setId(asOfString1);
      asOfRlcSet1.setEntity(contextEntityType1);
      asOfRlcSet1.setPeriod(periodInstant);

      //*********************** RLC SET2 **************
      RLCItem rlcItem2 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType2 = xbrlObjectFactory.createContextEntityType();
      contextEntityType2.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA2 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA2.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem2.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB2 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberB2.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem2.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberC2 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberC2.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem2.getRlcBasicInfo().getIndustryNameAxis()));

      TypedMember typedMemberD2 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberD2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
      typedMemberD2.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                            rlcItem2.getRlcBasicInfo().getLeadBankNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment2 = xbrlObjectFactory.createSegment();
      segment2.getAny().add(explicitMember1);
      segment2.getAny().add(explicitMember2);
      segment2.getAny().add(typedMemberA2);
      segment2.getAny().add(typedMemberB2);
      segment2.getAny().add(typedMemberC2);
      segment2.getAny().add(typedMemberD2);
      
      // add to context Entity
      contextEntityType2.setSegment(segment2);

      // create fromto context rlcSet1
      Context fromToRlcSet2 = xbrlObjectFactory.createContext();
      String fromToString2 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), rlcItem2.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem2.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem2.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem2.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem2.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem2.getRlcBasicInfo().getLeadBankNameAxis());
      fromToRlcSet2.setId(fromToString2);
      
      // set all objects to context rlcSet1
      fromToRlcSet2.setEntity(contextEntityType2);
      fromToRlcSet2.setPeriod(period);

      // create asof context
      Context asOfRlcSet2 = xbrlObjectFactory.createContext();
      String asOfString2 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                rlcItem2.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem2.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem2.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem2.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem2.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem2.getRlcBasicInfo().getLeadBankNameAxis());
      asOfRlcSet2.setId(asOfString2);
      asOfRlcSet2.setEntity(contextEntityType2);
      asOfRlcSet2.setPeriod(periodInstant);


      //*********************** RLC SET3 **************
      RLCItem rlcItem3 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType3 = xbrlObjectFactory.createContextEntityType();
      contextEntityType3.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA3 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA3.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA3.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem3.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB3 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB3.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberB3.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem3.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberC3 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC3.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberC3.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem3.getRlcBasicInfo().getIndustryNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment3 = xbrlObjectFactory.createSegment();
      segment3.getAny().add(explicitMember1);
      segment3.getAny().add(explicitMember2);
      segment3.getAny().add(typedMemberA3);
      segment3.getAny().add(typedMemberB3);
      segment3.getAny().add(typedMemberC3);
      
      // add to context Entity
      contextEntityType3.setSegment(segment3);

      // create fromto context rlcSet1
      Context fromToRlcSet3 = xbrlObjectFactory.createContext();
      String fromToString3 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), 
                                rlcItem3.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem3.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem3.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem3.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem3.getRlcBasicInfo().getIndustryNameAxis());
      fromToRlcSet3.setId(fromToString3);
      
      // set all objects to context rlcSet1
      fromToRlcSet3.setEntity(contextEntityType3);
      fromToRlcSet3.setPeriod(period);

      // create asof context
      Context asOfRlcSet3 = xbrlObjectFactory.createContext();
      String asOfString3 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                rlcItem3.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem3.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem3.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem3.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem3.getRlcBasicInfo().getIndustryNameAxis());
      asOfRlcSet3.setId(asOfString3);
      asOfRlcSet3.setEntity(contextEntityType3);
      asOfRlcSet3.setPeriod(periodInstant);


      //*********************** RLC SET4 **************
      RLCItem rlcItem4 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType4 = xbrlObjectFactory.createContextEntityType();
      contextEntityType4.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA4 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA4.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA4.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem4.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB4 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB4.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberB4.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem4.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberC4 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC4.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberC4.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem4.getRlcBasicInfo().getIndustryNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment4 = xbrlObjectFactory.createSegment();
      segment4.getAny().add(explicitMember1);
      segment4.getAny().add(explicitMember2);
      segment4.getAny().add(typedMemberA4);
      segment4.getAny().add(typedMemberB4);
      segment4.getAny().add(typedMemberC4);
      
      // add to context Entity
      contextEntityType4.setSegment(segment4);

      // create fromto context rlcSet1
      Context fromToRlcSet4 = xbrlObjectFactory.createContext();
      String fromToString4 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), 
                                rlcItem4.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem4.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem4.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem4.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem4.getRlcBasicInfo().getIndustryNameAxis());
      fromToRlcSet4.setId(fromToString4);
      
      // set all objects to context rlcSet1
      fromToRlcSet4.setEntity(contextEntityType4);
      fromToRlcSet4.setPeriod(period);

      // create asof context
      Context asOfRlcSet4 = xbrlObjectFactory.createContext();
      String asOfString4 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                rlcItem4.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem4.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem4.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem4.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem4.getRlcBasicInfo().getIndustryNameAxis());
      asOfRlcSet4.setId(asOfString4);
      asOfRlcSet4.setEntity(contextEntityType4);
      asOfRlcSet4.setPeriod(periodInstant);


      //*********************** RLC SET5 **************
      RLCItem rlcItem5 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType5 = xbrlObjectFactory.createContextEntityType();
      contextEntityType5.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA5 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA5.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA5.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem5.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB5 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB5.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberB5.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem5.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberC5 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC5.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberC5.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem5.getRlcBasicInfo().getIndustryNameAxis()));

      TypedMember typedMemberD5 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberD5.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
      typedMemberD5.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                            rlcItem5.getRlcBasicInfo().getLeadBankNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment5 = xbrlObjectFactory.createSegment();
      segment5.getAny().add(explicitMember1);
      segment5.getAny().add(explicitMember2);
      segment5.getAny().add(typedMemberA5);
      segment5.getAny().add(typedMemberB5);
      segment5.getAny().add(typedMemberC5);
      segment5.getAny().add(typedMemberD5);
      
      // add to context Entity
      contextEntityType5.setSegment(segment5);

      // create fromto context rlcSet1
      Context fromToRlcSet5 = xbrlObjectFactory.createContext();
      String fromToString5 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), 
                                rlcItem5.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem5.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem5.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem5.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem5.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem5.getRlcBasicInfo().getLeadBankNameAxis());
      fromToRlcSet5.setId(fromToString5);
      
      // set all objects to context rlcSet1
      fromToRlcSet5.setEntity(contextEntityType5);
      fromToRlcSet5.setPeriod(period);

      // create asof context
      Context asOfRlcSet5 = xbrlObjectFactory.createContext();
      String asOfString5 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem5.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                    rlcItem5.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem5.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                    rlcItem5.getRlcBasicInfo().getIndustryCodeAxis(),
                                    rlcItem5.getRlcBasicInfo().getIndustryNameAxis(),
                                    rlcItem5.getRlcBasicInfo().getLeadBankNameAxis());
      asOfRlcSet5.setId(asOfString5);
      asOfRlcSet5.setEntity(contextEntityType5);
      asOfRlcSet5.setPeriod(periodInstant);

      //*********************** RLC SET6 **************
      RLCItem rlcItem6 = (RLCItem) itemData;

      //****************** create asof1 context ****************

      // create entity and entity identifier
      ContextEntityType contextEntityType6 = xbrlObjectFactory.createContextEntityType();
      contextEntityType6.setIdentifier(identifier);

      // create segement
      org.xbrl._2003.instance.Segment segment6 = xbrlObjectFactory.createSegment();
      segment6.getAny().add(explicitMember3);
      segment6.getAny().add(explicitMember1);
      
      // add to context Entity
      contextEntityType6.setSegment(segment6);

      Context asOfRlcSet6 = xbrlObjectFactory.createContext();
      String asOfString6 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem6.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem6.getRlcBasicInfo().getRegionOfBusinessAxis());
      asOfRlcSet6.setId(asOfString6);
      asOfRlcSet6.setEntity(contextEntityType6);
      asOfRlcSet6.setPeriod(periodInstant);

    // create fromto context rlcSet6
      Context fromToRlcSet6 = xbrlObjectFactory.createContext();
      String fromToString6 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(),
                                rlcItem6.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem6.getRlcBasicInfo().getRegionOfBusinessAxis());
      fromToRlcSet6.setId(fromToString6);
      
      // set all objects to context rlcSet1
      fromToRlcSet6.setEntity(contextEntityType6);
      fromToRlcSet6.setPeriod(period);

      //*********************** RLC SET7 **************
      RLCItem rlcItem7 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType7 = xbrlObjectFactory.createContextEntityType();
      contextEntityType7.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA7 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA7.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA7.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem7.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB7 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB7.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
      typedMemberB7.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                            rlcItem7.getRlcBasicInfo().getGroupBorrowerCode()));

      TypedMember typedMemberC7 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC7.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
      typedMemberC7.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                            rlcItem7.getRlcBasicInfo().getGroupAxis()));
      
      TypedMember typedMemberD7 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberD7.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberD7.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem7.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberE7 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberE7.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberE7.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem7.getRlcBasicInfo().getIndustryNameAxis()));

      // create segement
      org.xbrl._2003.instance.Segment segment7 = xbrlObjectFactory.createSegment();
      segment7.getAny().add(explicitMember3);
      segment7.getAny().add(explicitMember1);
      segment7.getAny().add(typedMemberA7);
      segment7.getAny().add(typedMemberB7);
      segment7.getAny().add(typedMemberC7);
      segment7.getAny().add(typedMemberD7);
      segment7.getAny().add(typedMemberE7);
      
      // add to context Entity
      contextEntityType7.setSegment(segment7);

      // create fromto context rlcSet1
      Context fromToRlcSet7 = xbrlObjectFactory.createContext();
      String fromToString7 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(),
                                rlcItem7.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem7.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem7.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem7.getRlcBasicInfo().getGroupBorrowerCode(),
                                rlcItem7.getRlcBasicInfo().getGroupAxis(),
                                rlcItem7.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem7.getRlcBasicInfo().getIndustryNameAxis());

      fromToRlcSet7.setId(fromToString7);
      
      // set all objects to context rlcSet1
      fromToRlcSet7.setEntity(contextEntityType7);
      fromToRlcSet7.setPeriod(period);

      // create asof context
      Context asOfRlcSet7 = xbrlObjectFactory.createContext();
      String asOfString7 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                        rlcItem7.getRlcBasicInfo().getLargeCreditAxis(),
                                        rlcItem7.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                        rlcItem7.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                        rlcItem7.getRlcBasicInfo().getGroupBorrowerCode(),
                                        rlcItem7.getRlcBasicInfo().getGroupAxis(),
                                        rlcItem7.getRlcBasicInfo().getIndustryCodeAxis(),
                                        rlcItem7.getRlcBasicInfo().getIndustryNameAxis());
      asOfRlcSet7.setId(asOfString7);
      asOfRlcSet7.setEntity(contextEntityType7);
      asOfRlcSet7.setPeriod(periodInstant);


      //*********************** RLC SET8 **************

      RLCItem rlcItem8 = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityType8 = xbrlObjectFactory.createContextEntityType();
      contextEntityType8.setIdentifier(identifier);

      //set typed members
      TypedMember typedMemberA8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberA8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberA8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem8.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberB8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberB8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
      typedMemberB8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                            rlcItem8.getRlcBasicInfo().getGroupBorrowerCode()));

      TypedMember typedMemberC8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberC8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
      typedMemberC8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                            rlcItem8.getRlcBasicInfo().getGroupAxis()));
      
      TypedMember typedMemberD8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberD8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberD8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem8.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberE8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberE8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberE8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                              rlcItem8.getRlcBasicInfo().getIndustryNameAxis()));

      TypedMember typedMemberF8 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberF8.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
      typedMemberF8.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                            rlcItem8.getRlcBasicInfo().getLeadBankNameAxis()));
      // create segement
      org.xbrl._2003.instance.Segment segment8 = xbrlObjectFactory.createSegment();
      segment8.getAny().add(explicitMember3);
      segment8.getAny().add(explicitMember1);
      segment8.getAny().add(typedMemberA8);
      segment8.getAny().add(typedMemberB8);
      segment8.getAny().add(typedMemberC8);
      segment8.getAny().add(typedMemberD8);
      segment8.getAny().add(typedMemberE8);
      segment8.getAny().add(typedMemberF8);
      
      // add to context Entity
      contextEntityType8.setSegment(segment8);

      // create fromto context rlcSet1
      Context fromToRlcSet8 = xbrlObjectFactory.createContext();
      String fromToString8 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), 
                                rlcItem8.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem8.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem8.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem8.getRlcBasicInfo().getGroupBorrowerCode(),
                                rlcItem8.getRlcBasicInfo().getGroupAxis(),
                                rlcItem8.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem8.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem8.getRlcBasicInfo().getLeadBankNameAxis());

      fromToRlcSet8.setId(fromToString8);
      
      // set all objects to context rlcSet8
      fromToRlcSet8.setEntity(contextEntityType8);
      fromToRlcSet8.setPeriod(period);

      // create asof context
      Context asOfRlcSet8 = xbrlObjectFactory.createContext();
      String asOfString8 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                        rlcItem8.getRlcBasicInfo().getLargeCreditAxis(),
                                        rlcItem8.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                        rlcItem8.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                        rlcItem8.getRlcBasicInfo().getGroupBorrowerCode(),
                                        rlcItem8.getRlcBasicInfo().getGroupAxis(),
                                        rlcItem8.getRlcBasicInfo().getIndustryCodeAxis(),
                                        rlcItem8.getRlcBasicInfo().getIndustryNameAxis(),
                                        rlcItem8.getRlcBasicInfo().getLeadBankNameAxis());
      asOfRlcSet8.setId(asOfString8);
      asOfRlcSet8.setEntity(contextEntityType8);
      asOfRlcSet8.setPeriod(periodInstant);


    //*********************** RLC SET9 **************

    RLCItem rlcItem9 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType9 = xbrlObjectFactory.createContextEntityType();
    contextEntityType9.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA9 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA9.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberA9.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem9.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
    
    TypedMember typedMemberB9 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB9.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
    typedMemberB9.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                          rlcItem9.getRlcBasicInfo().getGroupBorrowerCode()));

    TypedMember typedMemberC9 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC9.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
    typedMemberC9.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                          rlcItem9.getRlcBasicInfo().getGroupAxis()));
    
    TypedMember typedMemberD9 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberD9.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
    typedMemberD9.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                          rlcItem9.getRlcBasicInfo().getIndustryCodeAxis()));

    TypedMember typedMemberE9 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberE9.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
    typedMemberE9.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                            rlcItem9.getRlcBasicInfo().getIndustryNameAxis()));

    // create segement
    org.xbrl._2003.instance.Segment segment9 = xbrlObjectFactory.createSegment();
    segment9.getAny().add(explicitMember3);
    segment9.getAny().add(explicitMember1);
    segment9.getAny().add(typedMemberA9);
    segment9.getAny().add(typedMemberB9);
    segment9.getAny().add(typedMemberC9);
    segment9.getAny().add(typedMemberD9);
    segment9.getAny().add(typedMemberE9);
    
    // add to context Entity
    contextEntityType9.setSegment(segment9);

    // create fromto context rlcSet1
    Context fromToRlcSet9 = xbrlObjectFactory.createContext();
    String fromToString9 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem9.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem9.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem9.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem9.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem9.getRlcBasicInfo().getGroupAxis(),
                              rlcItem9.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem9.getRlcBasicInfo().getIndustryNameAxis());

    fromToRlcSet9.setId(fromToString9);
    fromToRlcSet9.setEntity(contextEntityType9);
    fromToRlcSet9.setPeriod(period);

    // create asof context
    Context asOfRlcSet9 = xbrlObjectFactory.createContext();
    String asOfString9 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem9.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem9.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem9.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem9.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem9.getRlcBasicInfo().getGroupAxis(),
                              rlcItem9.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem9.getRlcBasicInfo().getIndustryNameAxis());
    asOfRlcSet9.setId(asOfString9);
    asOfRlcSet9.setEntity(contextEntityType9);
    asOfRlcSet9.setPeriod(periodInstant);

    //*********************** RLC SET10**************

    RLCItem rlcItem10 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType10 = xbrlObjectFactory.createContextEntityType();
    contextEntityType10.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberA10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem10.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
    
    TypedMember typedMemberB10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
    typedMemberB10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                          rlcItem10.getRlcBasicInfo().getGroupBorrowerCode()));

    TypedMember typedMemberC10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
    typedMemberC10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                          rlcItem10.getRlcBasicInfo().getGroupAxis()));
    
    TypedMember typedMemberD10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberD10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
    typedMemberD10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                          rlcItem10.getRlcBasicInfo().getIndustryCodeAxis()));

    TypedMember typedMemberE10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberE10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
    typedMemberE10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                            rlcItem10.getRlcBasicInfo().getIndustryNameAxis()));

    TypedMember typedMemberF10 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberF10.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
    typedMemberF10.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                          rlcItem10.getRlcBasicInfo().getLeadBankNameAxis()));
    // create segement
    org.xbrl._2003.instance.Segment segment10 = xbrlObjectFactory.createSegment();
    segment10.getAny().add(explicitMember3);
    segment10.getAny().add(explicitMember1);
    segment10.getAny().add(typedMemberA10);
    segment10.getAny().add(typedMemberB10);
    segment10.getAny().add(typedMemberC10);
    segment10.getAny().add(typedMemberD10);
    segment10.getAny().add(typedMemberE10);
    segment10.getAny().add(typedMemberF10);
    
    // add to context Entity
    contextEntityType10.setSegment(segment10);

    // create fromto context rlcSet1
    Context fromToRlcSet10 = xbrlObjectFactory.createContext();
    String fromToString10 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem10.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem10.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem10.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem10.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem10.getRlcBasicInfo().getGroupAxis(),
                              rlcItem10.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem10.getRlcBasicInfo().getIndustryNameAxis(),
                              rlcItem10.getRlcBasicInfo().getLeadBankNameAxis());

    fromToRlcSet10.setId(fromToString10);
    fromToRlcSet10.setEntity(contextEntityType10);
    fromToRlcSet10.setPeriod(period);

    // create asof context
    Context asOfRlcSet10 = xbrlObjectFactory.createContext();
    String asOfString10 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem10.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem10.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem10.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem10.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem10.getRlcBasicInfo().getGroupAxis(),
                              rlcItem10.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem10.getRlcBasicInfo().getIndustryNameAxis(),
                              rlcItem10.getRlcBasicInfo().getLeadBankNameAxis());
    asOfRlcSet10.setId(asOfString10);
    asOfRlcSet10.setEntity(contextEntityType10);
    asOfRlcSet10.setPeriod(periodInstant);    
   
    //*********************** RLC SET11**************

    RLCItem rlcItem11 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType11 = xbrlObjectFactory.createContextEntityType();
    contextEntityType11.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberA11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem11.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
    
    TypedMember typedMemberB11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
    typedMemberB11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                          rlcItem11.getRlcBasicInfo().getGroupBorrowerCode()));

    TypedMember typedMemberC11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
    typedMemberC11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                          rlcItem11.getRlcBasicInfo().getGroupAxis()));
    
    TypedMember typedMemberD11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberD11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
    typedMemberD11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                          rlcItem11.getRlcBasicInfo().getIndustryCodeAxis()));

    TypedMember typedMemberE11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberE11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
    typedMemberE11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                            rlcItem11.getRlcBasicInfo().getIndustryNameAxis()));

    TypedMember typedMemberF11 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberF11.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
    typedMemberF11.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                          rlcItem11.getRlcBasicInfo().getLeadBankNameAxis()));
    // create segement
    org.xbrl._2003.instance.Segment segment11 = xbrlObjectFactory.createSegment();
    segment11.getAny().add(explicitMember3);
    segment11.getAny().add(explicitMember1);
    segment11.getAny().add(typedMemberA11);
    segment11.getAny().add(typedMemberB11);
    segment11.getAny().add(typedMemberC11);
    segment11.getAny().add(typedMemberD11);
    segment11.getAny().add(typedMemberE11);
    segment11.getAny().add(typedMemberF11);
    
    // add to context Entity
    contextEntityType11.setSegment(segment11);

    // create fromto context rlcSet1
    Context fromToRlcSet11 = xbrlObjectFactory.createContext();
    String fromToString11 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem11.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem11.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem11.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem11.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem11.getRlcBasicInfo().getGroupAxis(),
                              rlcItem11.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem11.getRlcBasicInfo().getIndustryNameAxis(),
                              rlcItem11.getRlcBasicInfo().getLeadBankNameAxis());

    fromToRlcSet11.setId(fromToString11);
    fromToRlcSet11.setEntity(contextEntityType11);
    fromToRlcSet11.setPeriod(period);

    // create asof context
    Context asOfRlcSet11 = xbrlObjectFactory.createContext();
    String asOfString11 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem11.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem11.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem11.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                              rlcItem11.getRlcBasicInfo().getGroupBorrowerCode(),
                              rlcItem11.getRlcBasicInfo().getGroupAxis(),
                              rlcItem11.getRlcBasicInfo().getIndustryCodeAxis(),
                              rlcItem11.getRlcBasicInfo().getIndustryNameAxis(),
                              rlcItem11.getRlcBasicInfo().getLeadBankNameAxis());
    asOfRlcSet11.setId(asOfString11);
    asOfRlcSet11.setEntity(contextEntityType11);
    asOfRlcSet11.setPeriod(periodInstant);

      //*********************** RLC SET12 **************

      RLCItem rlcItem12 = (RLCItem) itemData;

      //****************** create asof2 context ****************

      // create entity and entity identifier
      ContextEntityType contextEntityType12 = xbrlObjectFactory.createContextEntityType();
      contextEntityType12.setIdentifier(identifier);

      // create segement
      org.xbrl._2003.instance.Segment segment12 = xbrlObjectFactory.createSegment();
      segment12.getAny().add(explicitMember3);
      segment12.getAny().add(explicitMember1);
      
      // add to context Entity
      contextEntityType12.setSegment(segment12);

      Context asOfRlcSet12 = xbrlObjectFactory.createContext();
      String asOfString12 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem12.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem12.getRlcBasicInfo().getRegionOfBusinessAxis());
      asOfRlcSet12.setId(asOfString12);
      asOfRlcSet12.setEntity(contextEntityType12);
      asOfRlcSet12.setPeriod(periodInstant);

    // create fromto context rlcSet12
      Context fromToRlcSet12 = xbrlObjectFactory.createContext();
      String fromToString12 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), 
                                rlcItem12.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem12.getRlcBasicInfo().getRegionOfBusinessAxis());
      fromToRlcSet12.setId(fromToString12);
      fromToRlcSet12.setEntity(contextEntityType12);
      fromToRlcSet12.setPeriod(period);

    //*********************** RLC SET13 **************

    RLCItem rlcItem13 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType13 = xbrlObjectFactory.createContextEntityType();
    contextEntityType13.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA13 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA13.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
    typedMemberA13.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                          rlcItem13.getRlcBasicInfo().getCounterPartyBankNameAxis()));
    
    TypedMember typedMemberB13 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB13.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
    typedMemberB13.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                          rlcItem13.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
      
    TypedMember typedMemberC13 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC13.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberC13.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem13.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


    // create segement
    org.xbrl._2003.instance.Segment segment13 = xbrlObjectFactory.createSegment();
    segment13.getAny().add(explicitMember4);
    segment13.getAny().add(explicitMember5);
    segment13.getAny().add(typedMemberA13);
    segment13.getAny().add(typedMemberB13);
    segment13.getAny().add(typedMemberC13);

    // add to context Entity
    contextEntityType13.setSegment(segment13);

    // create asof context
    Context asOfRlcSet13 = xbrlObjectFactory.createContext();
    String asOfString13 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem13.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem13.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem13.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem13.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem13.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    asOfRlcSet13.setId(asOfString13);
    asOfRlcSet13.setEntity(contextEntityType13);
    asOfRlcSet13.setPeriod(periodInstant);  

    // create fromto context rlcSet13
    Context fromToRlcSet13 = xbrlObjectFactory.createContext();
    String fromToString13 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem13.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem13.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem13.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem13.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem13.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    fromToRlcSet13.setId(fromToString13);
    fromToRlcSet13.setEntity(contextEntityType13);
    fromToRlcSet13.setPeriod(period);

        //*********************** RLC SET14 **************

    RLCItem rlcItem14 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType14 = xbrlObjectFactory.createContextEntityType();
    contextEntityType14.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA14 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA14.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
    typedMemberA14.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                          rlcItem14.getRlcBasicInfo().getCounterPartyBankNameAxis()));
    
    TypedMember typedMemberB14 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB14.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
    typedMemberB14.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                          rlcItem14.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
      
    TypedMember typedMemberC14 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC14.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberC14.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem14.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


    // create segement
    org.xbrl._2003.instance.Segment segment14 = xbrlObjectFactory.createSegment();
    segment14.getAny().add(explicitMember4);
    segment14.getAny().add(explicitMember5);
    segment14.getAny().add(typedMemberA14);
    segment14.getAny().add(typedMemberB14);
    segment14.getAny().add(typedMemberC14);

    // add to context Entity
    contextEntityType14.setSegment(segment14);

    // create asof context
    Context asOfRlcSet14 = xbrlObjectFactory.createContext();
    String asOfString14 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem14.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem14.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem14.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem14.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem14.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    asOfRlcSet14.setId(asOfString14);
    asOfRlcSet14.setEntity(contextEntityType14);
    asOfRlcSet14.setPeriod(periodInstant);  

    // create fromto context rlcSet14
    Context fromToRlcSet14 = xbrlObjectFactory.createContext();
    String fromToString14 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem14.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem14.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem14.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem14.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem14.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    fromToRlcSet14.setId(fromToString14);
    fromToRlcSet14.setEntity(contextEntityType14);
    fromToRlcSet14.setPeriod(period);

     //*********************** RLC SET15 **************

    RLCItem rlcItem15 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType15 = xbrlObjectFactory.createContextEntityType();
    contextEntityType15.setIdentifier(identifier);

    //set typed members
    TypedMember typedMemberA15 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberA15.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
    typedMemberA15.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                          rlcItem15.getRlcBasicInfo().getCounterPartyBankNameAxis()));
    
    TypedMember typedMemberB15 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberB15.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
    typedMemberB15.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                          rlcItem15.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
      
    TypedMember typedMemberC15 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
    typedMemberC15.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
    typedMemberC15.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                          rlcItem15.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


    // create segement
    org.xbrl._2003.instance.Segment segment15 = xbrlObjectFactory.createSegment();
    segment15.getAny().add(explicitMember4);
    segment15.getAny().add(explicitMember5);
    segment15.getAny().add(typedMemberA15);
    segment15.getAny().add(typedMemberB15);
    segment15.getAny().add(typedMemberC15);

    // add to context Entity
    contextEntityType15.setSegment(segment15);

    // create asof context
    Context asOfRlcSet15 = xbrlObjectFactory.createContext();
    String asOfString15 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem15.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem15.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem15.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem15.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem15.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    asOfRlcSet15.setId(asOfString15);
    asOfRlcSet15.setEntity(contextEntityType15);
    asOfRlcSet15.setPeriod(periodInstant);  

    // create fromto context rlcSet15
    Context fromToRlcSet15 = xbrlObjectFactory.createContext();
    String fromToString15 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem15.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem15.getRlcBasicInfo().getRegionOfBusinessAxis(),
                              rlcItem15.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                              rlcItem15.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                              rlcItem15.getRlcBasicInfo().getUniqueTransactionCodeAxis());

    fromToRlcSet15.setId(fromToString15);
    fromToRlcSet15.setEntity(contextEntityType15);
    fromToRlcSet15.setPeriod(period);

     //*********************** RLC SET16 **************

     RLCItem rlcItem16 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType16 = xbrlObjectFactory.createContextEntityType();
     contextEntityType16.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA16 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA16.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA16.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem16.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB16 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB16.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB16.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem16.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC16 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC16.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC16.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem16.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment16 = xbrlObjectFactory.createSegment();
     segment16.getAny().add(explicitMember4);
     segment16.getAny().add(explicitMember5);
     segment16.getAny().add(typedMemberA16);
     segment16.getAny().add(typedMemberB16);
     segment16.getAny().add(typedMemberC16);
 
     // add to context Entity
     contextEntityType16.setSegment(segment16);
 
     // create asof context
     Context asOfRlcSet16 = xbrlObjectFactory.createContext();
     String asOfString16 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem16.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem16.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem16.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem16.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem16.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet16.setId(asOfString16);
     asOfRlcSet16.setEntity(contextEntityType16);
     asOfRlcSet16.setPeriod(periodInstant);  
 
     // create fromto context rlcSet16
     Context fromToRlcSet16 = xbrlObjectFactory.createContext();
     String fromToString16 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem16.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem16.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem16.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem16.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem16.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet16.setId(fromToString16);
     fromToRlcSet16.setEntity(contextEntityType16);
     fromToRlcSet16.setPeriod(period);
  
     //*********************** RLC SET17 **************

     RLCItem rlcItem17 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType17 = xbrlObjectFactory.createContextEntityType();
     contextEntityType17.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA17 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA17.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA17.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem17.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB17 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB17.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB17.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem17.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC17 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC17.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC17.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem17.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment17 = xbrlObjectFactory.createSegment();
     segment17.getAny().add(explicitMember4);
     segment17.getAny().add(explicitMember5);
     segment17.getAny().add(typedMemberA17);
     segment17.getAny().add(typedMemberB17);
     segment17.getAny().add(typedMemberC17);
 
     // add to context Entity
     contextEntityType17.setSegment(segment17);
 
     // create asof context
     Context asOfRlcSet17 = xbrlObjectFactory.createContext();
     String asOfString17 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem17.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem17.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem17.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem17.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem17.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet17.setId(asOfString17);
     asOfRlcSet17.setEntity(contextEntityType17);
     asOfRlcSet17.setPeriod(periodInstant);  
 
     // create fromto context rlcSet17
     Context fromToRlcSet17 = xbrlObjectFactory.createContext();
     String fromToString17 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem17.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem17.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem17.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem17.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem17.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet17.setId(fromToString17);
     fromToRlcSet17.setEntity(contextEntityType17);
     fromToRlcSet17.setPeriod(period);

    //*********************** RLC SET18 **************

     RLCItem rlcItem18 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType18 = xbrlObjectFactory.createContextEntityType();
     contextEntityType18.setIdentifier(identifier); 
 
     // create segement
     org.xbrl._2003.instance.Segment segment18 = xbrlObjectFactory.createSegment();
     segment18.getAny().add(explicitMember4);
     segment18.getAny().add(explicitMember5);

     // add to context Entity
     contextEntityType18.setSegment(segment18);
 
     // create asof context
     Context asOfRlcSet18 = xbrlObjectFactory.createContext();
     String asOfString18 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem18.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem18.getRlcBasicInfo().getRegionOfBusinessAxis());
 
     asOfRlcSet18.setId(asOfString18);
     asOfRlcSet18.setEntity(contextEntityType18);
     asOfRlcSet18.setPeriod(periodInstant);  
 
     // create fromto context rlcSet18
     Context fromToRlcSet18 = xbrlObjectFactory.createContext();
     String fromToString18 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem18.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem18.getRlcBasicInfo().getRegionOfBusinessAxis());
 
     fromToRlcSet18.setId(fromToString18);
     fromToRlcSet18.setEntity(contextEntityType18);
     fromToRlcSet18.setPeriod(period);

     //*********************** RLC SET19 **************

     RLCItem rlcItem19 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType19 = xbrlObjectFactory.createContextEntityType();
     contextEntityType19.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA19 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA19.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA19.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem19.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB19 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB19.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB19.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem19.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC19 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC19.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC19.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem19.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment19 = xbrlObjectFactory.createSegment();
     segment19.getAny().add(explicitMember4);
     segment19.getAny().add(explicitMember6);
     segment19.getAny().add(typedMemberA17);
     segment19.getAny().add(typedMemberB17);
     segment19.getAny().add(typedMemberC17);
 
     // add to context Entity
     contextEntityType19.setSegment(segment19);
 
     // create asof context
     Context asOfRlcSet19 = xbrlObjectFactory.createContext();
     String asOfString19 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem19.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem19.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem19.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem19.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem19.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet19.setId(asOfString19);
     asOfRlcSet19.setEntity(contextEntityType19);
     asOfRlcSet19.setPeriod(periodInstant);  
 
     // create fromto context rlcSet19
     Context fromToRlcSet19 = xbrlObjectFactory.createContext();
     String fromToString19 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem19.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem19.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem19.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem19.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem19.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet19.setId(fromToString19);
     fromToRlcSet19.setEntity(contextEntityType19);
     fromToRlcSet19.setPeriod(period);

     //*********************** RLC SET20 **************

     RLCItem rlcItem20 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType20 = xbrlObjectFactory.createContextEntityType();
     contextEntityType20.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA20 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA20.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA20.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem20.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB20 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB20.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB20.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem20.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC20 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC20.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC20.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem20.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment20 = xbrlObjectFactory.createSegment();
     segment20.getAny().add(explicitMember4);
     segment20.getAny().add(explicitMember6);
     segment20.getAny().add(typedMemberA20);
     segment20.getAny().add(typedMemberB20);
     segment20.getAny().add(typedMemberC20);
 
     // add to context Entity
     contextEntityType20.setSegment(segment20);
 
     // create asof context
     Context asOfRlcSet20 = xbrlObjectFactory.createContext();
     String asOfString20 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem20.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem20.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem20.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem20.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem20.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet20.setId(asOfString20);
     asOfRlcSet20.setEntity(contextEntityType20);
     asOfRlcSet20.setPeriod(periodInstant);  
 
     // create fromto context rlcSet20
     Context fromToRlcSet20 = xbrlObjectFactory.createContext();
     String fromToString20 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem20.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem20.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem20.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem20.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem20.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet20.setId(fromToString20);
     fromToRlcSet20.setEntity(contextEntityType20);
     fromToRlcSet20.setPeriod(period);

     //*********************** RLC SET21 **************

     RLCItem rlcItem21 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType21 = xbrlObjectFactory.createContextEntityType();
     contextEntityType21.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA21 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA21.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA21.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem21.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB21 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB21.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB21.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem21.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC21 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC21.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC21.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem21.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment21 = xbrlObjectFactory.createSegment();
     segment21.getAny().add(explicitMember4);
     segment21.getAny().add(explicitMember6);
     segment21.getAny().add(typedMemberA21);
     segment21.getAny().add(typedMemberB21);
     segment21.getAny().add(typedMemberC21);
 
     // add to context Entity
     contextEntityType21.setSegment(segment21);
 
     // create asof context
     Context asOfRlcSet21 = xbrlObjectFactory.createContext();
     String asOfString21 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem21.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem21.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem21.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem21.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem21.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet21.setId(asOfString21);
     asOfRlcSet21.setEntity(contextEntityType21);
     asOfRlcSet21.setPeriod(periodInstant);  
 
     // create fromto context rlcSet21
     Context fromToRlcSet21 = xbrlObjectFactory.createContext();
     String fromToString21 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem21.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem21.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem21.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem21.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem21.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet21.setId(fromToString21);
     fromToRlcSet21.setEntity(contextEntityType21);
     fromToRlcSet21.setPeriod(period);


     //*********************** RLC SET22 **************

     RLCItem rlcItem22 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType22 = xbrlObjectFactory.createContextEntityType();
     contextEntityType22.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA22 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA22.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA22.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem22.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB22 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB22.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB22.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem22.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC22 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC22.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC22.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem22.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment22 = xbrlObjectFactory.createSegment();
     segment22.getAny().add(explicitMember4);
     segment22.getAny().add(explicitMember6);
     segment22.getAny().add(typedMemberA22);
     segment22.getAny().add(typedMemberB22);
     segment22.getAny().add(typedMemberC22);
 
     // add to context Entity
     contextEntityType22.setSegment(segment22);
 
     // create asof context
     Context asOfRlcSet22 = xbrlObjectFactory.createContext();
     String asOfString22 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem22.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem22.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem22.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem22.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem22.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet22.setId(asOfString22);
     asOfRlcSet22.setEntity(contextEntityType22);
     asOfRlcSet22.setPeriod(periodInstant);  
 
     // create fromto context rlcSet22
     Context fromToRlcSet22 = xbrlObjectFactory.createContext();
     String fromToString22 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(), 
                               rlcItem22.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem22.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem22.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem22.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem22.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet22.setId(fromToString22);
     fromToRlcSet22.setEntity(contextEntityType22);
     fromToRlcSet22.setPeriod(period);

     //*********************** RLC SET23 **************

     RLCItem rlcItem23 = (RLCItem) itemData;

     // create entity and entity identifier
     ContextEntityType contextEntityType23 = xbrlObjectFactory.createContextEntityType();
     contextEntityType23.setIdentifier(identifier);
 
     //set typed members
     TypedMember typedMemberA23 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberA23.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
     typedMemberA23.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                           rlcItem23.getRlcBasicInfo().getCounterPartyBankNameAxis()));
     
     TypedMember typedMemberB23 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberB23.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
     typedMemberB23.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                           rlcItem23.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
       
     TypedMember typedMemberC23 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
     typedMemberC23.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
     typedMemberC23.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                           rlcItem23.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
 
 
     // create segement
     org.xbrl._2003.instance.Segment segment23 = xbrlObjectFactory.createSegment();
     segment23.getAny().add(explicitMember4);
     segment23.getAny().add(explicitMember6);
     segment23.getAny().add(typedMemberA23);
     segment23.getAny().add(typedMemberB23);
     segment23.getAny().add(typedMemberC23);
 
     // add to context Entity
     contextEntityType23.setSegment(segment23);
 
     // create asof context
     Context asOfRlcSet23 = xbrlObjectFactory.createContext();
     String asOfString23 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                               rlcItem23.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem23.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem23.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem23.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem23.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     asOfRlcSet23.setId(asOfString23);
     asOfRlcSet23.setEntity(contextEntityType23);
     asOfRlcSet23.setPeriod(periodInstant);  
 
     // create fromto context rlcSet23
     Context fromToRlcSet23 = xbrlObjectFactory.createContext();
     String fromToString23 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                               rlcGeneralData.getEndDate(),
                               rlcItem23.getRlcBasicInfo().getLargeCreditAxis(),
                               rlcItem23.getRlcBasicInfo().getRegionOfBusinessAxis(),
                               rlcItem23.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                               rlcItem23.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                               rlcItem23.getRlcBasicInfo().getUniqueTransactionCodeAxis());
 
     fromToRlcSet23.setId(fromToString23);
     fromToRlcSet23.setEntity(contextEntityType23);
     fromToRlcSet23.setPeriod(period);

    //*********************** RLC SET24 **************

    RLCItem rlcItem24 = (RLCItem) itemData;

    // create entity and entity identifier
    ContextEntityType contextEntityType24 = xbrlObjectFactory.createContextEntityType();
    contextEntityType24.setIdentifier(identifier); 

    // create segement
    org.xbrl._2003.instance.Segment segment24 = xbrlObjectFactory.createSegment();
    segment24.getAny().add(explicitMember4);
    segment24.getAny().add(explicitMember6);

    // add to context Entity
    contextEntityType24.setSegment(segment24);

    // create asof context
    Context asOfRlcSet24 = xbrlObjectFactory.createContext();
    String asOfString24 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                              rlcItem24.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem24.getRlcBasicInfo().getRegionOfBusinessAxis());

    asOfRlcSet24.setId(asOfString24);
    asOfRlcSet24.setEntity(contextEntityType24);
    asOfRlcSet24.setPeriod(periodInstant);  

    // create fromto context rlcSet24
    Context fromToRlcSet24 = xbrlObjectFactory.createContext();
    String fromToString24 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                              rlcGeneralData.getEndDate(), 
                              rlcItem24.getRlcBasicInfo().getLargeCreditAxis(),
                              rlcItem24.getRlcBasicInfo().getRegionOfBusinessAxis());

    fromToRlcSet24.setId(fromToString24);
    fromToRlcSet24.setEntity(contextEntityType24);
    fromToRlcSet24.setPeriod(period);

   //*********************** RLC SET25 **************

   RLCItem rlcItem25 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType25 = xbrlObjectFactory.createContextEntityType();
   contextEntityType25.setIdentifier(identifier);

   //set typed members
   TypedMember typedMemberA25 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberA25.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
   typedMemberA25.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                         rlcItem25.getRlcBasicInfo().getCounterPartyBankNameAxis()));
   
   TypedMember typedMemberB25 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberB25.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
   typedMemberB25.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                         rlcItem25.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
     
   TypedMember typedMemberC25 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberC25.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
   typedMemberC25.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                         rlcItem25.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


   // create segement
   org.xbrl._2003.instance.Segment segment25 = xbrlObjectFactory.createSegment();
   segment25.getAny().add(explicitMember1);
   segment25.getAny().add(explicitMember4);
   segment25.getAny().add(typedMemberA25);
   segment25.getAny().add(typedMemberB25);
   segment25.getAny().add(typedMemberC25);

   // add to context Entity
   contextEntityType25.setSegment(segment25);

   // create asof context
   Context asOfRlcSet25 = xbrlObjectFactory.createContext();
   String asOfString25 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem25.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem25.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem25.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem25.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem25.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   asOfRlcSet25.setId(asOfString25);
   asOfRlcSet25.setEntity(contextEntityType25);
   asOfRlcSet25.setPeriod(periodInstant);  

   // create fromto context rlcSet25
   Context fromToRlcSet25 = xbrlObjectFactory.createContext();
   String fromToString25 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem25.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem25.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem25.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem25.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem25.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   fromToRlcSet25.setId(fromToString25);
   fromToRlcSet25.setEntity(contextEntityType25);
   fromToRlcSet25.setPeriod(period);

   //*********************** RLC SET26 **************

   RLCItem rlcItem26 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType26 = xbrlObjectFactory.createContextEntityType();
   contextEntityType26.setIdentifier(identifier);

   //set typed members
   TypedMember typedMemberA26 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberA26.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
   typedMemberA26.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                         rlcItem26.getRlcBasicInfo().getCounterPartyBankNameAxis()));
   
   TypedMember typedMemberB26 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberB26.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
   typedMemberB26.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                         rlcItem26.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
     
   TypedMember typedMemberC26 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberC26.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
   typedMemberC26.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                         rlcItem26.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


   // create segement
   org.xbrl._2003.instance.Segment segment26 = xbrlObjectFactory.createSegment();
   segment26.getAny().add(explicitMember1);
   segment26.getAny().add(explicitMember4);
   segment26.getAny().add(typedMemberA26);
   segment26.getAny().add(typedMemberB26);
   segment26.getAny().add(typedMemberC26);

   // add to context Entity
   contextEntityType26.setSegment(segment26);

   // create asof context
   Context asOfRlcSet26 = xbrlObjectFactory.createContext();
   String asOfString26 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem26.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem26.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem26.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem26.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem26.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   asOfRlcSet26.setId(asOfString26);
   asOfRlcSet26.setEntity(contextEntityType26);
   asOfRlcSet26.setPeriod(periodInstant);  

   // create fromto context rlcSet26
   Context fromToRlcSet26 = xbrlObjectFactory.createContext();
   String fromToString26 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem26.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem26.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem26.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem26.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem26.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   fromToRlcSet26.setId(fromToString26);
   fromToRlcSet26.setEntity(contextEntityType26);
   fromToRlcSet26.setPeriod(period);

   //*********************** RLC SET27 **************

   RLCItem rlcItem27 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType27 = xbrlObjectFactory.createContextEntityType();
   contextEntityType27.setIdentifier(identifier);

   //set typed members
   TypedMember typedMemberA27 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberA27.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
   typedMemberA27.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                         rlcItem27.getRlcBasicInfo().getCounterPartyBankNameAxis()));
   
   TypedMember typedMemberB27 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberB27.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
   typedMemberB27.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                         rlcItem27.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
     
   TypedMember typedMemberC27 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberC27.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
   typedMemberC27.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                         rlcItem27.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


   // create segement
   org.xbrl._2003.instance.Segment segment27 = xbrlObjectFactory.createSegment();
   segment27.getAny().add(explicitMember1);
   segment27.getAny().add(explicitMember4);
   segment27.getAny().add(typedMemberA27);
   segment27.getAny().add(typedMemberB27);
   segment27.getAny().add(typedMemberC27);

   // add to context Entity
   contextEntityType27.setSegment(segment27);

   // create asof context
   Context asOfRlcSet27 = xbrlObjectFactory.createContext();
   String asOfString27 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem27.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem27.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem27.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem27.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem27.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   asOfRlcSet27.setId(asOfString27);
   asOfRlcSet27.setEntity(contextEntityType27);
   asOfRlcSet27.setPeriod(periodInstant);  

   // create fromto context rlcSet27
   Context fromToRlcSet27 = xbrlObjectFactory.createContext();
   String fromToString27 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem27.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem27.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem27.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem27.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem27.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   fromToRlcSet27.setId(fromToString27);
   fromToRlcSet27.setEntity(contextEntityType27);
   fromToRlcSet27.setPeriod(period);

   //*********************** RLC SET28 **************

   RLCItem rlcItem28 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType28 = xbrlObjectFactory.createContextEntityType();
   contextEntityType28.setIdentifier(identifier);

   //set typed members
   TypedMember typedMemberA28 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberA28.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
   typedMemberA28.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                         rlcItem28.getRlcBasicInfo().getCounterPartyBankNameAxis()));
   
   TypedMember typedMemberB28 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberB28.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
   typedMemberB28.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                         rlcItem28.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
     
   TypedMember typedMemberC28 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberC28.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
   typedMemberC28.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                         rlcItem28.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


   // create segement
   org.xbrl._2003.instance.Segment segment28 = xbrlObjectFactory.createSegment();
   segment28.getAny().add(explicitMember1);
   segment28.getAny().add(explicitMember4);
   segment28.getAny().add(typedMemberA28);
   segment28.getAny().add(typedMemberB28);
   segment28.getAny().add(typedMemberC28);

   // add to context Entity
   contextEntityType28.setSegment(segment28);

   // create asof context
   Context asOfRlcSet28 = xbrlObjectFactory.createContext();
   String asOfString28 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem28.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem28.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem28.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem28.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem28.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   asOfRlcSet28.setId(asOfString28);
   asOfRlcSet28.setEntity(contextEntityType28);
   asOfRlcSet28.setPeriod(periodInstant);  

   // create fromto context rlcSet28
   Context fromToRlcSet28 = xbrlObjectFactory.createContext();
   String fromToString28 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem28.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem28.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem28.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem28.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem28.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   fromToRlcSet28.setId(fromToString28);
   fromToRlcSet28.setEntity(contextEntityType28);
   fromToRlcSet28.setPeriod(period);

   //*********************** RLC SET29 **************

   RLCItem rlcItem29 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType29 = xbrlObjectFactory.createContextEntityType();
   contextEntityType29.setIdentifier(identifier);

   //set typed members
   TypedMember typedMemberA29 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberA29.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
   typedMemberA29.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                         rlcItem29.getRlcBasicInfo().getCounterPartyBankNameAxis()));
   
   TypedMember typedMemberB29 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberB29.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
   typedMemberB29.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                         rlcItem29.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));
     
   TypedMember typedMemberC29 = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
   typedMemberC29.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
   typedMemberC29.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                         rlcItem29.getRlcBasicInfo().getUniqueTransactionCodeAxis()));


   // create segement
   org.xbrl._2003.instance.Segment segment29 = xbrlObjectFactory.createSegment();
   segment29.getAny().add(explicitMember1);
   segment29.getAny().add(explicitMember4);
   segment29.getAny().add(typedMemberA29);
   segment29.getAny().add(typedMemberB29);
   segment29.getAny().add(typedMemberC29);

   // add to context Entity
   contextEntityType28.setSegment(segment29);

   // create asof context
   Context asOfRlcSet29 = xbrlObjectFactory.createContext();
   String asOfString29 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem29.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem29.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem29.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem29.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem29.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   asOfRlcSet29.setId(asOfString29);
   asOfRlcSet29.setEntity(contextEntityType29);
   asOfRlcSet29.setPeriod(periodInstant);  

   // create fromto context rlcSet29
   Context fromToRlcSet29 = xbrlObjectFactory.createContext();
   String fromToString29 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem29.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem29.getRlcBasicInfo().getLargeCreditAxis(),
                             rlcItem29.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                             rlcItem29.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                             rlcItem29.getRlcBasicInfo().getUniqueTransactionCodeAxis());

   fromToRlcSet29.setId(fromToString29);
   fromToRlcSet29.setEntity(contextEntityType29);
   fromToRlcSet29.setPeriod(period);

   //*********************** RLC SET30 **************

   RLCItem rlcItem30 = (RLCItem) itemData;

   // create entity and entity identifier
   ContextEntityType contextEntityType30 = xbrlObjectFactory.createContextEntityType();
   contextEntityType30.setIdentifier(identifier);

   // create segement
   org.xbrl._2003.instance.Segment segment30 = xbrlObjectFactory.createSegment();
   segment30.getAny().add(explicitMember1);
   segment30.getAny().add(explicitMember4);

   // add to context Entity
   contextEntityType30.setSegment(segment30);

   // create asof context
   Context asOfRlcSet30 = xbrlObjectFactory.createContext();
   String asOfString30 = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                             rlcItem30.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem30.getRlcBasicInfo().getLargeCreditAxis());

   asOfRlcSet30.setId(asOfString30);
   asOfRlcSet30.setEntity(contextEntityType30);
   asOfRlcSet30.setPeriod(periodInstant);  

   // create fromto context rlcSet30
   Context fromToRlcSet30 = xbrlObjectFactory.createContext();
   String fromToString30 = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                             rlcGeneralData.getEndDate(),
                             rlcItem30.getRlcBasicInfo().getRegionOfBusinessAxis(),
                             rlcItem30.getRlcBasicInfo().getLargeCreditAxis());

   fromToRlcSet30.setId(fromToString30);
   fromToRlcSet30.setEntity(contextEntityType30);
   fromToRlcSet30.setPeriod(period);


      return Arrays.asList(fromToRlcSet1, asOfRlcSet1, fromToRlcSet2, asOfRlcSet2,fromToRlcSet3, asOfRlcSet3,
      fromToRlcSet4, asOfRlcSet4, fromToRlcSet5, asOfRlcSet5, fromToRlcSet6, asOfRlcSet6, fromToRlcSet7,
      asOfRlcSet7, fromToRlcSet8, asOfRlcSet8, fromToRlcSet9, asOfRlcSet9, fromToRlcSet10, asOfRlcSet10,
      fromToRlcSet11, asOfRlcSet11, asOfRlcSet12, fromToRlcSet12, asOfRlcSet13, fromToRlcSet13,
      asOfRlcSet14, fromToRlcSet14, asOfRlcSet15, fromToRlcSet15, asOfRlcSet16, fromToRlcSet16,
      asOfRlcSet17, fromToRlcSet17, asOfRlcSet18, fromToRlcSet18, asOfRlcSet19, fromToRlcSet19,
      asOfRlcSet20, fromToRlcSet20, asOfRlcSet21, fromToRlcSet21, asOfRlcSet22, fromToRlcSet22,
      asOfRlcSet23, fromToRlcSet23, asOfRlcSet24, fromToRlcSet24, asOfRlcSet25, fromToRlcSet25,
      asOfRlcSet26, fromToRlcSet26, asOfRlcSet27, fromToRlcSet27, asOfRlcSet28, fromToRlcSet28,
      asOfRlcSet29, fromToRlcSet29, asOfRlcSet30, fromToRlcSet30 );

    }

}
    
    

