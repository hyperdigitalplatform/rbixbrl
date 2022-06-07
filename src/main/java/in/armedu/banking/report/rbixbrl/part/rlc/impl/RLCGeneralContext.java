package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
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
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class RLCGeneralContext implements ContextInterface {

  private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
  @Override
  public Map<String, Context> getContext(GeneralData generalData) {
      RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
      Map<String, Context> contexts = new HashMap<String, Context>();

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
        contexts.put(RLCUtil.FROMTO, fromToContext);

        // create asof context
        Context asOfContext = xbrlObjectFactory.createContext();
        String contextRefAsOfString = AsOfContext.getId("asof", rlcGeneralData.getEndDate());
        asOfContext.setId(contextRefAsOfString);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(rlcGeneralData.getEndDate());
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        contexts.put(RLCUtil.ASOF, asOfContext);


        // create asof2 context
        Context asOfContext2 = xbrlObjectFactory.createContext();
        String contextRefAsOfString2 = AsOfContext.getId("asof", rlcGeneralData.getLastEndDate());
        asOfContext2.setId(contextRefAsOfString2);
        ContextPeriodType periodInstant2 = xbrlObjectFactory.createContextPeriodType();
        periodInstant2.setInstant(rlcGeneralData.getLastEndDate());
        asOfContext2.setEntity(contextEntityType);
        asOfContext2.setPeriod(periodInstant2);
        contexts.put(RLCUtil.ASOFLASTDATE, asOfContext2);

        return contexts;

  }
  
  @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {

      RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
      Map<String, Context> contexts = new HashMap<String, Context>();

      //*********************** RLC Global MEMBER IndividualBorrower MEMBER  **************
      RLCItem rlcItem = (RLCItem) itemData;

      // create entity and entity identifier
      ContextEntityType contextEntityTypeGlobalIndividual = xbrlObjectFactory.createContextEntityType();

      // set entity identifier aka bank code
      Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
      identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
      identifier.setValue(rlcGeneralData.getBankCode());
      contextEntityTypeGlobalIndividual.setIdentifier(identifier);

      // set period
      ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
      period.setStartDate(rlcGeneralData.getStartDate());
      period.setEndDate(rlcGeneralData.getEndDate());

      // set instant period
      ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
      periodInstant.setInstant(rlcGeneralData.getEndDate());

      //set explicit members
      ExplicitMember explicitMemberGlobalMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMemberGlobalMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
      explicitMemberGlobalMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GlobalMember"));
       
      ExplicitMember explicitMemberIndividualBorrower = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMemberIndividualBorrower.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMemberIndividualBorrower.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndividualBorrowersMember"));
       
      ExplicitMember explicitMemberBorrowerGroup = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMemberBorrowerGroup.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMemberBorrowerGroup.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BorrowerGroupMember"));

      ExplicitMember explicitMemberCounterParty = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMemberCounterParty.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
      explicitMemberCounterParty.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankMember"));
       
      ExplicitMember explicitMemberDomesticMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
      explicitMemberDomesticMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
      explicitMemberDomesticMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DomesticMember"));

      //set typed members
      TypedMember typedMemberUniqueTransaction = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberUniqueTransaction.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
      typedMemberUniqueTransaction.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(
                            rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis()));
      
      TypedMember typedMemberIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
      typedMemberIndustryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(
                            rlcItem.getRlcBasicInfo().getIndustryCodeAxis()));

      TypedMember typedMemberIndustryName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberIndustryName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
      typedMemberIndustryName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(
                             rlcItem.getRlcBasicInfo().getIndustryNameAxis()));

      TypedMember typedMemberLeadBankName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberLeadBankName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
      typedMemberLeadBankName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(
                            rlcItem.getRlcBasicInfo().getLeadBankNameAxis()));

      TypedMember typedMemberGroupBorrowerCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberGroupBorrowerCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
      typedMemberGroupBorrowerCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(
                            rlcItem.getRlcBasicInfo().getGroupBorrowerCode()));

      TypedMember typedMemberGroupAxis = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberGroupAxis.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
      typedMemberGroupAxis.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(
                            rlcItem.getRlcBasicInfo().getGroupAxis()));
                                                  
// //
  
  if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "GlobalMember" &&
  rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "IndividualBorrowersMember")
{
      // create segement
      org.xbrl._2003.instance.Segment segmentGlobalIndividual = xbrlObjectFactory.createSegment();
      segmentGlobalIndividual.getAny().add(explicitMemberGlobalMember);
      segmentGlobalIndividual.getAny().add(explicitMemberIndividualBorrower);
      segmentGlobalIndividual.getAny().add(typedMemberUniqueTransaction);
      segmentGlobalIndividual.getAny().add(typedMemberIndustryCode);
      segmentGlobalIndividual.getAny().add(typedMemberIndustryName);
      segmentGlobalIndividual.getAny().add(typedMemberLeadBankName);
      
      // add to context Entity
      contextEntityTypeGlobalIndividual.setSegment(segmentGlobalIndividual);

      // create fromto context GlobalIndividual
      Context fromToGlobalIndividual = xbrlObjectFactory.createContext();
      String fromToStringGlobalIndividual = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem.getRlcBasicInfo().getIndustryNameAxis(),
                                rlcItem.getRlcBasicInfo().getLeadBankNameAxis());

      fromToGlobalIndividual.setId(fromToStringGlobalIndividual);
      
      // set all objects to context GlobalIndividual
      fromToGlobalIndividual.setEntity(contextEntityTypeGlobalIndividual);
      fromToGlobalIndividual.setPeriod(period);
      contexts.put(RLCUtil.FROMTOGLOBALINDIVIDUALMEMBER, fromToGlobalIndividual);

      // create asof context
      Context asOfGlobalIndividual = xbrlObjectFactory.createContext();
      String asOfStringGlobalIndividual = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                    rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                    rlcItem.getRlcBasicInfo().getIndustryCodeAxis(),
                                    rlcItem.getRlcBasicInfo().getIndustryNameAxis(),
                                    rlcItem.getRlcBasicInfo().getLeadBankNameAxis());
      asOfGlobalIndividual.setId(asOfStringGlobalIndividual);
      asOfGlobalIndividual.setEntity(contextEntityTypeGlobalIndividual);
      asOfGlobalIndividual.setPeriod(periodInstant);
      contexts.put(RLCUtil.ASOFGLOBALINDIVIDUALMEMBER, asOfGlobalIndividual);
}


      //*********************** RLC GLOBAL MEMBER BORROWERGROUP MEMBER  **************
    
      // create entity and entity identifier
      ContextEntityType contextEntityTypeGlobalBorrower = xbrlObjectFactory.createContextEntityType();

      // set entity identifier aka bank code
      
      contextEntityTypeGlobalBorrower.setIdentifier(identifier);

      if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "GlobalMember" &&
      rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "BorrowerGroupMember")
{
      // create segement
      org.xbrl._2003.instance.Segment segmentGlobalBorrower = xbrlObjectFactory.createSegment();
      segmentGlobalBorrower.getAny().add(explicitMemberBorrowerGroup);
      segmentGlobalBorrower.getAny().add(explicitMemberGlobalMember);
      segmentGlobalBorrower.getAny().add(typedMemberUniqueTransaction);
      segmentGlobalBorrower.getAny().add(typedMemberIndustryCode);
      segmentGlobalBorrower.getAny().add(typedMemberIndustryName);
      segmentGlobalBorrower.getAny().add(typedMemberGroupBorrowerCode);
      segmentGlobalBorrower.getAny().add(typedMemberGroupAxis);
      
      // add to context Entity
      contextEntityTypeGlobalBorrower.setSegment(segmentGlobalBorrower);

      // create fromto context GlobalBorrower
      Context fromToGlobalBorrower = xbrlObjectFactory.createContext();
      String fromToStringGlobalBorrower = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(), rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                rlcItem.getRlcBasicInfo().getIndustryCodeAxis(),
                                rlcItem.getRlcBasicInfo().getIndustryNameAxis(), 
                                rlcItem.getRlcBasicInfo().getGroupBorrowerCode(),
                                rlcItem.getRlcBasicInfo().getGroupAxis());

      fromToGlobalBorrower.setId(fromToStringGlobalBorrower);
      
      // set all objects to context GlobalBorrower
      fromToGlobalBorrower.setEntity(contextEntityTypeGlobalBorrower);
      fromToGlobalBorrower.setPeriod(period);
      contexts.put(RLCUtil.FROMTOGLOBALBORROWERGROUP, fromToGlobalBorrower);

      // create asof context
      Context asOfGlobalBorrower = xbrlObjectFactory.createContext();
      String asOfStringGlobalBorrower = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                    rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                    rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                    rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis(),
                                    rlcItem.getRlcBasicInfo().getIndustryCodeAxis(),
                                    rlcItem.getRlcBasicInfo().getIndustryNameAxis(),
                                    rlcItem.getRlcBasicInfo().getGroupBorrowerCode(),
                                    rlcItem.getRlcBasicInfo().getGroupAxis());
      asOfGlobalBorrower.setId(asOfStringGlobalBorrower);
      asOfGlobalBorrower.setEntity(contextEntityTypeGlobalBorrower);
      asOfGlobalBorrower.setPeriod(periodInstant);
      contexts.put(RLCUtil.ASOFGLOBALBORROWERGROUP, asOfGlobalBorrower);

 }
      //*********************** RLC DOMESTIC MEMBER COUNTERPARTY BANK MEMBER  **************
     
      //set typed members

      TypedMember typedMemberCounterPartyBankName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberCounterPartyBankName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
      typedMemberCounterPartyBankName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(
                            rlcItem.getRlcBasicInfo().getCounterPartyBankNameAxis()));

      TypedMember typedMemberCounterPartyBankDomicile = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
      typedMemberCounterPartyBankDomicile.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
      typedMemberCounterPartyBankDomicile.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(
                            rlcItem.getRlcBasicInfo().getCounterPartyBankDomicileAxis()));

      // create entity and entity identifier
      ContextEntityType contextEntityTypeDomesticCounterParty = xbrlObjectFactory.createContextEntityType();

      // set entity identifier aka bank code
      
      contextEntityTypeDomesticCounterParty.setIdentifier(identifier);

      if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "DomesticMember" &&
      rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "CounterPartyBankMember")
    {
      // create segement
      org.xbrl._2003.instance.Segment segmentDomesticCounterParty = xbrlObjectFactory.createSegment();
      segmentDomesticCounterParty.getAny().add(explicitMemberCounterParty);
      segmentDomesticCounterParty.getAny().add(explicitMemberDomesticMember);
      segmentDomesticCounterParty.getAny().add(typedMemberCounterPartyBankName);
      segmentDomesticCounterParty.getAny().add(typedMemberCounterPartyBankDomicile);
      segmentDomesticCounterParty.getAny().add(typedMemberUniqueTransaction);
      
      // add to context Entity
      contextEntityTypeDomesticCounterParty.setSegment(segmentDomesticCounterParty);

      // create fromto context DomesticCounterParty1
      Context fromToDomesticCounterParty = xbrlObjectFactory.createContext();
      String fromToStringDomesticCounterParty = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(),rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis());

      fromToDomesticCounterParty.setId(fromToStringDomesticCounterParty);
      
      // set all objects to context DomesticCounterParty
      fromToDomesticCounterParty.setEntity(contextEntityTypeDomesticCounterParty);
      fromToDomesticCounterParty.setPeriod(period);
      contexts.put(RLCUtil.FROMTODOMESTICCOUNTERPARTY, fromToDomesticCounterParty);

      // create asof context
      Context asOfDomesticCounterParty = xbrlObjectFactory.createContext();
      String asOfStringDomesticCounterParty = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                  rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis());
      asOfDomesticCounterParty.setId(asOfStringDomesticCounterParty);
      asOfDomesticCounterParty.setEntity(contextEntityTypeDomesticCounterParty);
      asOfDomesticCounterParty.setPeriod(periodInstant);
      contexts.put(RLCUtil.ASOFDOMESTICCOUNTERPARTY, asOfDomesticCounterParty);

    }
 

      //*********************** RLC GLOBAL MEMBER COUNTERPARTY BANK MEMBER  **************
     
      // create entity and entity identifier
      ContextEntityType contextEntityTypeGlobalCounterParty = xbrlObjectFactory.createContextEntityType();

      // set entity identifier aka bank code
      
      contextEntityTypeGlobalCounterParty.setIdentifier(identifier);

      if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "GlobalMember" &&
      rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "CounterPartyBankMember")
    {

      // create segement
      org.xbrl._2003.instance.Segment segmentGlobalCounterParty = xbrlObjectFactory.createSegment();
      segmentGlobalCounterParty.getAny().add(explicitMemberGlobalMember);
      segmentGlobalCounterParty.getAny().add(explicitMemberCounterParty);
      segmentGlobalCounterParty.getAny().add(typedMemberCounterPartyBankName);
      segmentGlobalCounterParty.getAny().add(typedMemberCounterPartyBankDomicile);
      segmentGlobalCounterParty.getAny().add(typedMemberUniqueTransaction);
      
      // add to context Entity
      contextEntityTypeGlobalCounterParty.setSegment(segmentGlobalCounterParty);

      // create fromto context GlobalCounterParty1
      Context fromToGlobalCounterParty = xbrlObjectFactory.createContext();
      String fromToStringGlobalCounterParty = FromToContext.getId("fromto", rlcGeneralData.getStartDate(),
                                rlcGeneralData.getEndDate(),    rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis());

      fromToGlobalCounterParty.setId(fromToStringGlobalCounterParty);
      
      // set all objects to context GlobalCounterParty
      fromToGlobalCounterParty.setEntity(contextEntityTypeGlobalCounterParty);
      fromToGlobalCounterParty.setPeriod(period);
      contexts.put(RLCUtil.FROMTOGLOBALCOUNTERPARTY, fromToGlobalCounterParty);

      // create asof context
      Context asOfGlobalCounterParty = xbrlObjectFactory.createContext();
      String asOfStringGlobalCounterParty = AsOfContext.getId("asof", rlcGeneralData.getEndDate(),
                                      rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis(),
                                rlcItem.getRlcBasicInfo().getLargeCreditAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankNameAxis(),
                                rlcItem.getRlcBasicInfo().getCounterPartyBankDomicileAxis(),
                                rlcItem.getRlcBasicInfo().getUniqueTransactionCodeAxis());
      asOfGlobalCounterParty.setId(asOfStringGlobalCounterParty);
      asOfGlobalCounterParty.setEntity(contextEntityTypeGlobalCounterParty);
      asOfGlobalCounterParty.setPeriod(periodInstant);
      contexts.put(RLCUtil.ASOFGLOBALCOUNTERPARTY, asOfGlobalCounterParty);
    }
      return contexts;
    }

  }

    

