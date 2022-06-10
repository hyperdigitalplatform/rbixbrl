package in.armedu.banking.report.rbixbrl.part.ros.impl;

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
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;

public class ROSUtil {
    
    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";

    public static final String FROMTOCONTEXTSUBSIDIARY = "fromtocontextsubsidiary";
    public static final String ASOFCONTEXTSUBSIDIARY = "asofcontextsubsidiary";

    public static final String ASOFBOOKVALUEMEMBER = "asofbookvaluemember";
    public static final String ASOFMARKETVALUEMEMBER = "asofmarketvaluemember";
    
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

// create fromto
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
            contextRefFromTo = FromToContext.getId("fromto", startDate, endDate);

        fromToContext.setId(contextRefFromTo);
        ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
        period.setStartDate(startDate);
        period.setEndDate(endDate);
        fromToContext.setEntity(contextEntityType);
        fromToContext.setPeriod(period);
        return fromToContext;
    }

// create asof
    public static Context createAsOfContext(String bankCode,  String endDate, String contextRefAsOf){
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


// create fromtoForSubsidiary
public static Context createFromToContextForSubsidiary(String bankCode, String startDate, String endDate, String nameOfSubsidiaryAssociate){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromtoContextForSubsidiary = FromToContext.getId("fromto", startDate, endDate, nameOfSubsidiaryAssociate);
    Context context = createFromToContext(bankCode, startDate, endDate, fromtoContextForSubsidiary);
    // create segement
    org.xbrl._2003.instance.Segment segForMember = xbrlObjectFactory.createSegment();
   
    List<TypedMember> typeMembers = createTypedMembers(nameOfSubsidiaryAssociate); 

    segForMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segForMember);
    return context;
}

// create asofForSubsidiary
    public static Context createAsOfContextForSubsidiary(String bankCode, String endDate, String nameOfSubsidiaryAssociate){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextForSubsidiary = AsOfContext.getId("asof", endDate, nameOfSubsidiaryAssociate);
        Context context = createAsOfContext(bankCode, endDate, asofContextForSubsidiary);

        // create segement
        org.xbrl._2003.instance.Segment segForMember = xbrlObjectFactory.createSegment();
       
        List<TypedMember> typeMembers = createTypedMembers(nameOfSubsidiaryAssociate); 
  
        segForMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segForMember);
        return context;
    }

// create asofForBookMember
    public static Context createAsOfContextForBookValueMember(String bankCode, String endDate, String detailsOfValue, String nameOfSubsidiaryAssociate){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromtoContextBookMember = AsOfContext.getId("asof", endDate, "BookValueMember", nameOfSubsidiaryAssociate );
    Context context = createAsOfContext(bankCode, endDate, fromtoContextBookMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segBookValueMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers("BookValueMember");
    List<TypedMember> typeMembers = createTypedMembers(nameOfSubsidiaryAssociate); 
    segBookValueMember.getAny().addAll(explicitMembers);
    segBookValueMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segBookValueMember);
    return context;
}

// create asofForMarketMember
public static Context createAsOfContextForMarketValueMember(String bankCode, String endDate, String detailsOfValue,  String nameOfSubsidiaryAssociate){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asofContextMarketMember = AsOfContext.getId("asof", endDate, "MarketValueMember", nameOfSubsidiaryAssociate);
    Context context = createAsOfContext(bankCode, endDate, asofContextMarketMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segMarketValueMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers("MarketValueMember");
    List<TypedMember> typeMembers = createTypedMembers(nameOfSubsidiaryAssociate); 
    segMarketValueMember.getAny().addAll(explicitMembers);
    segMarketValueMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMarketValueMember);
    
    return context;

}

// create explicit members
    public static List<ExplicitMember> createExplicitMembers(String detailsOfValue) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
        if(detailsOfValue != null && !detailsOfValue.isEmpty()){
            ExplicitMember explicitMemberForDetailsOfValue = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForDetailsOfValue.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfValueAxis"));
            explicitMemberForDetailsOfValue.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", detailsOfValue));
            explicitMembers.add(explicitMemberForDetailsOfValue);
        }
        
        return explicitMembers;
    }


// create typed members
    public static List<TypedMember> createTypedMembers(String nameOfSubsidiaryAssociate) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();

        if(nameOfSubsidiaryAssociate != null && !nameOfSubsidiaryAssociate.isEmpty()){
            TypedMember typedMemberForSubsidiary = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForSubsidiary.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfSubsidiaryAssociateJointVenturesAxis"));
            typedMemberForSubsidiary.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfSubsidiaryAssociateJointVenturesDomain(nameOfSubsidiaryAssociate));
            typedMembers.add(typedMemberForSubsidiary);
        }
        
        return typedMembers;
    }


}
