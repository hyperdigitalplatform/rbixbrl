package in.armedu.banking.report.rbixbrl.part.fmr;

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
import org.xbrl._2006.xbrldi.TypedMember;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class FMRUtil {
    
    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";
    public static final String FROMTOBRANCH = "fromtocontextbranch";
    public static final String FROMTOSTAFF = "fromtocontextstaff";
    public static final String FROMTOROBBER = "fromtocontextrobber";
    public static final String FROMTOOTHERCRIMINAL = "fromtocontextothercriminal";
    
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

    public static Context createAsOfContext(String bankCode, String reportDate, String contextRefAsOf){
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
            contextRefAsOf = AsOfContext.getId("asof", reportDate);
        asOfContext.setId(contextRefAsOf);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(reportDate);
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        return asOfContext;
    }

    public static Context createFromToContextForBranch(String bankCode, String startDate, String endDate, String typeOfCriminal, String branchCode, String nameOfBranch, String dateAndTimeOfOccurrence){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromTo = FromToContext.getId("fromto", startDate, endDate, typeOfCriminal, branchCode, nameOfBranch, dateAndTimeOfOccurrence);
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromTo);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<TypedMember> typeMembers = createTypedMembers(typeOfCriminal, branchCode, nameOfBranch, dateAndTimeOfOccurrence); 
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static List<TypedMember> createTypedMembers(String typeOfCriminal, String branchCode, String nameOfBranch, String dateAndTimeOfOccurrence) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        if(typeOfCriminal != null && !typeOfCriminal.isEmpty()){
            TypedMember typeOfCriminalType = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typeOfCriminalType.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "TypeOfCriminalAxis"));
            typeOfCriminalType.setAny(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", typeOfCriminal));
            typedMembers.add(typeOfCriminalType);
        }
        if(branchCode != null && !branchCode.isEmpty()){
            TypedMember typedMemberForBranchCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBranchCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BranchCodeAxis"));
            typedMemberForBranchCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createBranchCodeDomain(branchCode));
            typedMembers.add(typedMemberForBranchCode);
        }
        if(nameOfBranch != null && !nameOfBranch.isEmpty()){
            TypedMember typedMemberFornameOfBranch = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberFornameOfBranch.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfBranchAxis"));
            typedMemberFornameOfBranch.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfBranchDomain(nameOfBranch));
            typedMembers.add(typedMemberFornameOfBranch);
        }
        if(dateAndTimeOfOccurrence != null && !dateAndTimeOfOccurrence.isEmpty()){
            TypedMember typedMemberFordateAndTimeOfOccurrence = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberFordateAndTimeOfOccurrence.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DateAndTimeOfOccurrenceTypeAxis"));
            typedMemberFordateAndTimeOfOccurrence.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createDateAndTimeOfOccurrenceTypeDomain(toXMLGeo(dateAndTimeOfOccurrence)));   
            typedMembers.add(typedMemberFordateAndTimeOfOccurrence);
        }
        
        return typedMembers;
    }

        
}
