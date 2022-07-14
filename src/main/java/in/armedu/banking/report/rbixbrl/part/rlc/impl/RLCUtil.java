package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class  RLCUtil {

    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";
    public static final String ASOFLASTDATE = "asoflastdate";

    public static final String FROMTOGLOBALINDIVIDUALMEMBER = "fromtoglobalindividualmember";
    public static final String ASOFGLOBALINDIVIDUALMEMBER = "asofglobalindividualmember";
    public static final String FROMTOONLYGLOBALINDIVIDUALMEMBER = "fromtoonlyglobalindividualmember";
    public static final String ASOFONLYGLOBALINDIVIDUALMEMBER = "asofonlyglobalindividualmember";

    public static final String FROMTOGLOBALBORROWERGROUP = "fromtoglobalborrowergroup";
    public static final String ASOFGLOBALBORROWERGROUP= "asofglobalborrowergroup";
    public static final String FROMTOONLYGLOBALBORROWERGROUP= "fromtoonlyglobalborrowergroup";
    public static final String ASOFONLYGLOBALBORROWERGROUP= "asofonlyglobalborrowergroup";

    public static final String FROMTODOMESTICCOUNTERPARTY = "fromtodomesticcounterparty";
    public static final String ASOFDOMESTICCOUNTERPARTY = "asofdomesticcounterparty";
    public static final String FROMTOONLYDOMESTICCOUNTERPARTY = "fromtoonlydomesticcounterparty";
    public static final String ASOFONLYDOMESTICCOUNTERPARTY = "asofonlydomesticcounterparty";

    public static final String FROMTOGLOBALCOUNTERPARTY = "fromtoglobalcounterparty";
    public static final String ASOFGLOBALCOUNTERPARTY = "asofglobalcounterparty";
    public static final String FROMTOONLYGLOBALCOUNTERPARTY = "fromtoonlyglobalcounterparty";
    public static final String ASOFONLYGLOBALCOUNTERPARTY = "asofonlyglobalcounterparty";

    public static final String CURRENCY = "currency";
    public static final String PERCENTAGE = "percentage";

    public static XMLGregorianCalendar toXMLGeo(String dateInStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        XMLGregorianCalendar xmlGregCal = null;
        try {
            Date date = format.parse(dateInStr);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            xmlGregCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return xmlGregCal;
    }

// create fromtocontext
    public static Context createFromToContext(String bankCode, String startDate, String endDate, String contextRefFromTo){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(bankCode);
        contextEntityType.setIdentifier(identifier);
        // create fromto context
        Context fromToContext = xbrlObjectFactory.createContext();
        if(contextRefFromTo == null || contextRefFromTo.isEmpty())
            contextRefFromTo = FromToContext.getId("fromto", startDate,  endDate);

        fromToContext.setId(contextRefFromTo);
        ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
        period.setStartDate(startDate);
        period.setEndDate(endDate);
        fromToContext.setEntity(contextEntityType);
        fromToContext.setPeriod(period);
        return fromToContext;
    }

    // create asof context
    public static Context createAsOfContext(String bankCode, String endDate, String contextRefAsOf){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(bankCode);
        contextEntityType.setIdentifier(identifier);
        // create fromto context
        Context asOfContext = xbrlObjectFactory.createContext();
        if(contextRefAsOf == null || contextRefAsOf.isEmpty())
            contextRefAsOf = AsOfContext.getId("asof", endDate);
        asOfContext.setId(contextRefAsOf);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(endDate);
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        return asOfContext;
    }

    //create asof enddate context
    public static Context createAsOfEndDateContext(String bankCode, String yearEndDate, String contextRefAsOfEndDate){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(bankCode);
        contextEntityType.setIdentifier(identifier);
        // create fromto context
        Context asOfContext = xbrlObjectFactory.createContext();
        if(contextRefAsOfEndDate == null || contextRefAsOfEndDate.isEmpty())
        contextRefAsOfEndDate = AsOfContext.getId("asof", yearEndDate);
        asOfContext.setId(contextRefAsOfEndDate);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(yearEndDate);
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        return asOfContext;
    }

// create fromto context for individual global member
    public static Context createFromToContextForIndividualGlobal(String bankCode, String startDate, String endDate, String globalmember, String individualMember,
        String uniqueTransaction, String industryCode, String industryName, String leadBankName ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String fromtoContextForIndividualGlobal = FromToContext.getId("fromto", startDate, endDate, globalmember, individualMember, uniqueTransaction, industryCode, industryName, leadBankName);
        Context context = createFromToContext(bankCode, startDate, endDate, fromtoContextForIndividualGlobal);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitIndividualGlobalMembers(globalmember, individualMember);
        List<TypedMember> typeMembers = createTypedIndividualGlobalMembers(uniqueTransaction, industryCode, industryName, leadBankName); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segMembers);
        return context;
}

// create asof context for individual global member
    public static Context createAsOfContextIndividualGlobal(String bankCode, String endDate, String globalmember, String individualMember,
        String uniqueTransaction, String industryCode, String industryName, String leadBankName ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextForIndividualGlobal = AsOfContext.getId("asof", endDate, globalmember, individualMember, uniqueTransaction, industryCode, industryName, leadBankName);
        Context context = createAsOfContext(bankCode, endDate, asofContextForIndividualGlobal);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitIndividualGlobalMembers(globalmember, individualMember);
        List<TypedMember> typeMembers = createTypedIndividualGlobalMembers( uniqueTransaction, industryCode, industryName, leadBankName ); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segMembers);
        return context;
    }

    // create fromto context for borrower group global member
    public static Context createFromToContextForBorrowerGroupGlobal(String bankCode, String startDate, String endDate, String borrowerGroup, String globalMember,
        String uniqueTransaction, String groupBorrowerCode, String groupAxis, String industryCode, String industryName, String leadBankName){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String fromtoContextForBorrowerGroupGlobal = FromToContext.getId("fromto", startDate, endDate, borrowerGroup, globalMember, uniqueTransaction, groupBorrowerCode, groupAxis, industryCode, industryName, leadBankName);
        Context context = createFromToContext(bankCode, startDate, endDate, fromtoContextForBorrowerGroupGlobal);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitBorrowerGlobalMember(borrowerGroup, globalMember);
        List<TypedMember> typeMembers = createTypedBorrowerGlobalMember(uniqueTransaction, groupBorrowerCode, groupAxis, industryCode, industryName, leadBankName); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);

        context.getEntity().setSegment(segMembers);
        return context;
    }

    // create asof context for borrower group global member
    public static Context createAsOfContextBorrowerGroupGlobal(String bankCode, String endDate, String borrowerGroup, String globalMember,
    String uniqueTransaction, String groupBorrowerCode, String groupAxis, String industryCode, String industryName, String leadBankName){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextForBorrowerGroupGlobal = AsOfContext.getId("asof", endDate, borrowerGroup, globalMember,uniqueTransaction, groupBorrowerCode, groupAxis, industryCode, industryName, leadBankName);
        Context context = createAsOfContext(bankCode, endDate, asofContextForBorrowerGroupGlobal);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitBorrowerGlobalMember(borrowerGroup, globalMember);
        List<TypedMember> typeMembers = createTypedBorrowerGlobalMember(uniqueTransaction, groupBorrowerCode, groupAxis, industryCode, industryName, leadBankName); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);

        context.getEntity().setSegment(segMembers);
        return context;
    }

    // create fromto context for Counter Party member
    public static Context createFromToContextForCounterParty(String bankCode, String startDate, String endDate, String counterParty, String domesticMember, 
        String globalMember, String counterPartyBankName, String counterPartyBankDomicile, String uniqueTransaction){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String fromtoContextForCounterParty = FromToContext.getId("fromto", startDate, endDate, counterParty, domesticMember, globalMember, counterPartyBankName, counterPartyBankDomicile, uniqueTransaction);
        Context context = createFromToContext(bankCode, startDate, endDate, fromtoContextForCounterParty);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitCounterPartyMember(counterParty, domesticMember, globalMember);
        List<TypedMember> typeMembers = createTypedCounterPartyMember(counterPartyBankName, counterPartyBankDomicile, uniqueTransaction); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);

        context.getEntity().setSegment(segMembers);
        return context;
    }

    // create asof context for CounterParty global member
    public static Context createAsOfContextCounterParty(String bankCode, String endDate, String counterParty, String domesticMember, 
    String globalMember, String counterPartyBankName, String counterPartyBankDomicile, String uniqueTransaction){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextForCounterParty = AsOfContext.getId("asof", endDate, counterParty, domesticMember, globalMember, counterPartyBankName, counterPartyBankDomicile, uniqueTransaction);
        Context context = createAsOfContext(bankCode, endDate, asofContextForCounterParty);
        // create segement
        org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitCounterPartyMember(counterParty, domesticMember, globalMember);
        List<TypedMember> typeMembers = createTypedCounterPartyMember(counterPartyBankName, counterPartyBankDomicile, uniqueTransaction); 
        segMembers.getAny().addAll(explicitMembers);
        segMembers.getAny().addAll(typeMembers);

        context.getEntity().setSegment(segMembers);
        return context;
    }

// create explicit members IndividualGlobalMembers
    public static List<ExplicitMember> createExplicitIndividualGlobalMembers(String globalmember, String individualMember) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
        if(globalmember != null && !globalmember.isEmpty()){
            ExplicitMember explicitMemberGlobalMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberGlobalMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
            explicitMemberGlobalMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GlobalMember"));
            explicitMembers.add(explicitMemberGlobalMember);
        }
        if(globalmember != null && !globalmember.isEmpty()){
            ExplicitMember explicitMemberIndividualBorrower = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberIndividualBorrower.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
            explicitMemberIndividualBorrower.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndividualBorrowersMember"));
            explicitMembers.add(explicitMemberIndividualBorrower);
        }
        return explicitMembers;
    }


// create typed members IndividualGlobalMembers
    public static List<TypedMember> createTypedIndividualGlobalMembers(String uniqueTransaction, String industryCode, String industryName, String leadBankName) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();

        if(uniqueTransaction != null && !uniqueTransaction.isEmpty()){
            TypedMember typedMemberUniqueTransaction = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberUniqueTransaction.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
            typedMemberUniqueTransaction.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(uniqueTransaction));
            typedMembers.add(typedMemberUniqueTransaction);
        }
        if(industryCode != null && !industryCode.isEmpty()){
            TypedMember typedMemberIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
            typedMemberIndustryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(industryCode));
            typedMembers.add(typedMemberIndustryCode);
        }
        if(industryName != null && !industryName.isEmpty()){
            TypedMember typedMemberIndustryName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberIndustryName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
            typedMemberIndustryName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(industryName));
            typedMembers.add(typedMemberIndustryName);
        }
        if(leadBankName != null && !leadBankName.isEmpty()){
            TypedMember typedMemberLeadBankName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberLeadBankName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
            typedMemberLeadBankName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(leadBankName));
            typedMembers.add(typedMemberLeadBankName);
        }
        
        return typedMembers;
    }


// create explicit members BorrowerGlobalMember
public static List<ExplicitMember> createExplicitBorrowerGlobalMember(String borrowerGroup, String globalMember) {
    List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
    if(borrowerGroup != null && !borrowerGroup.isEmpty()){
        ExplicitMember explicitMemberBorrowerGroup = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberBorrowerGroup.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
        explicitMemberBorrowerGroup.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BorrowerGroupMember"));
        explicitMembers.add(explicitMemberBorrowerGroup);
    }
    if(globalMember != null && !globalMember.isEmpty()){
        ExplicitMember explicitMemberGlobalMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberGlobalMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
        explicitMemberGlobalMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GlobalMember"));
        explicitMembers.add(explicitMemberGlobalMember);
    }
    return explicitMembers;
}


// create typed members BorrowerGlobalMember
public static List<TypedMember> createTypedBorrowerGlobalMember(String uniqueTransaction, String groupBorrowerCode, String groupAxis, String industryCode, String industryName, String leadBankName) {
    List<TypedMember> typedMembers = new ArrayList<TypedMember>();

    if(uniqueTransaction != null && !uniqueTransaction.isEmpty()){
        TypedMember typedMemberUniqueTransaction = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberUniqueTransaction.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
        typedMemberUniqueTransaction.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(uniqueTransaction));
        typedMembers.add(typedMemberUniqueTransaction);
    }
    if(groupBorrowerCode != null && !groupBorrowerCode.isEmpty()){
        TypedMember typedMemberGroupBorrowerCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberGroupBorrowerCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupBorrowerCode"));
        typedMemberGroupBorrowerCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupBorrowerCodeDomain(groupBorrowerCode));
       typedMembers.add(typedMemberGroupBorrowerCode);
    }
    if(groupAxis != null && !groupAxis.isEmpty()){
        TypedMember typedMemberGroupAxis = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberGroupAxis.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GroupAxis"));
        typedMemberGroupAxis.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createGroupDomain(groupAxis));
        typedMembers.add(typedMemberGroupAxis);
    }
    
    if(industryCode != null && !industryCode.isEmpty()){
        TypedMember typedMemberIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
        typedMemberIndustryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryCodeDomain(industryCode));
        typedMembers.add(typedMemberIndustryCode);
    }
    if(industryName != null && !industryName.isEmpty()){
        TypedMember typedMemberIndustryName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberIndustryName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
        typedMemberIndustryName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createIndustryNameDomain(industryName));
        typedMembers.add(typedMemberIndustryName);
    }
    if(leadBankName != null && !leadBankName.isEmpty()){
        TypedMember typedMemberLeadBankName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberLeadBankName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LeadBankNameAxis"));
        typedMemberLeadBankName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createLeadBankNameDomain(leadBankName));
        typedMembers.add(typedMemberLeadBankName);
    }
    
    return typedMembers;
}


// create explicit members CounterPartyMember
public static List<ExplicitMember> createExplicitCounterPartyMember(String counterParty, String domesticMember, String globalMember) {
    List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
    if(counterParty != null && !counterParty.isEmpty()){
        ExplicitMember explicitMemberCounterParty = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberCounterParty.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
        explicitMemberCounterParty.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankMember"));
        explicitMembers.add(explicitMemberCounterParty);
    }
    if(domesticMember != null && !domesticMember.isEmpty()){
        ExplicitMember explicitMemberDomesticMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberDomesticMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
        explicitMemberDomesticMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DomesticMember"));
        explicitMembers.add(explicitMemberDomesticMember);
    }
    if(globalMember != null && !globalMember.isEmpty()){
        ExplicitMember explicitMemberGlobalMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberGlobalMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RegionOfBusinessAxis"));
        explicitMemberGlobalMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "GlobalMember"));
        explicitMembers.add(explicitMemberGlobalMember);
    }    
    return explicitMembers;
}


// create typed members CounterPartyMember
public static List<TypedMember> createTypedCounterPartyMember(String counterPartyBankName, String counterPartyBankDomicile, String uniqueTransaction) {
    List<TypedMember> typedMembers = new ArrayList<TypedMember>();

    if(counterPartyBankName != null && !counterPartyBankName.isEmpty()){
        TypedMember typedMemberCounterPartyBankName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberCounterPartyBankName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankNameAxis"));
        typedMemberCounterPartyBankName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankNameDomain(counterPartyBankName));
        typedMembers.add(typedMemberCounterPartyBankName);
    }
    if(counterPartyBankDomicile != null && !counterPartyBankDomicile.isEmpty()){
        TypedMember typedMemberCounterPartyBankDomicile = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberCounterPartyBankDomicile.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CounterPartyBankDomicileAxis"));
        typedMemberCounterPartyBankDomicile.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createCounterPartyBankDomicileDomain(counterPartyBankDomicile));
       typedMembers.add(typedMemberCounterPartyBankDomicile);
    } 
    if(uniqueTransaction != null && !uniqueTransaction.isEmpty()){
        TypedMember typedMemberUniqueTransaction = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
        typedMemberUniqueTransaction.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "UniqueTransactionCodeAxis"));
        typedMemberUniqueTransaction.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory().createUniqueTransactionCodeDomain(uniqueTransaction));
        typedMembers.add(typedMemberUniqueTransaction);
    }
    return typedMembers;
}

}