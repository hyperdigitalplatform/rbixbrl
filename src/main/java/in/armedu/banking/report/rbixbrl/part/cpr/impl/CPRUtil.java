package in.armedu.banking.report.rbixbrl.part.cpr.impl;

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

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class CPRUtil {
    
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

    public static Context createAsOfContextForMember(String bankCode, String reportDate, String member){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfBookValueMemberString = AsOfContext.getId("asof", reportDate, member);
        // create segement
        org.xbrl._2003.instance.Segment segBookValueMember = xbrlObjectFactory.createSegment();
        ExplicitMember explicitMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfValueAxis"));
        explicitMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", member));
        segBookValueMember.getAny().add(explicitMember);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfBookValueMemberString);
        context.getEntity().setSegment(segBookValueMember);
        return context;
    }

    public static Context createAsOfContextForFundTypeAndBorrowerType(String bankCode, String reportDate, String fundType, String borrowerType){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfBookValueMemberString = AsOfContext.getId("asof", reportDate, fundType, borrowerType);
        // create segement
        org.xbrl._2003.instance.Segment segFundedMemberBorrowerGroupMember = xbrlObjectFactory.createSegment();
        ExplicitMember explicitMemberForFundedMemberBorrowerGroupMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberForFundedMemberBorrowerGroupMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "ExposureTypeAxis"));
        explicitMemberForFundedMemberBorrowerGroupMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", fundType));;
        segFundedMemberBorrowerGroupMember.getAny().add(explicitMemberForFundedMemberBorrowerGroupMember);
        ExplicitMember explicitMemberForFundedMemberBorrowerGroupMember2 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberForFundedMemberBorrowerGroupMember2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
        explicitMemberForFundedMemberBorrowerGroupMember2.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", borrowerType));;
        segFundedMemberBorrowerGroupMember.getAny().add(explicitMemberForFundedMemberBorrowerGroupMember2);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfBookValueMemberString);
        context.getEntity().setSegment(segFundedMemberBorrowerGroupMember);
        return context;
    }

    public static Context createFromToContextForOnlyBorrowerType(String bankCode, String startDate, String endDate, String borrowerType){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefString = FromToContext.getId("fromto", startDate, endDate, borrowerType);
        Context fromContext = createFromToContext(bankCode, startDate, endDate, contextRefString);
        // create segement
        org.xbrl._2003.instance.Segment segFundedMemberBorrowerGroupMember = xbrlObjectFactory.createSegment();
        ExplicitMember explicitMemberForFundedMemberBorrowerGroupMember2 = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberForFundedMemberBorrowerGroupMember2.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
        explicitMemberForFundedMemberBorrowerGroupMember2.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", borrowerType));;
        segFundedMemberBorrowerGroupMember.getAny().add(explicitMemberForFundedMemberBorrowerGroupMember2);
        fromContext.getEntity().setSegment(segFundedMemberBorrowerGroupMember);
        return fromContext;
    }

    public static Context createAsOfContextForFundType(String bankCode, String reportDate, String fundType){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = AsOfContext.getId("asof", reportDate, fundType);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        ExplicitMember explicitMemberForFundedMember = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
        explicitMemberForFundedMember.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfDisbusalOfAdvancesAxis"));
        explicitMemberForFundedMember.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", fundType));;
        segFundedMember.getAny().add(explicitMemberForFundedMember);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }

    public static Context createFromToContextForBorrower(String bankCode, String startDate, String endDate, String permanentAccountNumber, String nameOfBorrower, String industryCode, String industryName){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = FromToContext.getId("fromto", startDate, endDate,permanentAccountNumber, nameOfBorrower, industryCode, industryName );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<TypedMember> typeMembers = createTypedMembers(permanentAccountNumber, nameOfBorrower, industryCode, industryName); 
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static Context createFromToContextForIndividualBorrower(String bankCode, String startDate, String endDate, String permanentAccountNumber, String nameOfBorrower, String industryCode, String industryName){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = FromToContext.getId("fromto", startDate, endDate, "IndividualBorrowerMember", permanentAccountNumber, nameOfBorrower, industryCode, industryName );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(null, "IndividualBorrowerMember");
        List<TypedMember> typeMembers = createTypedMembers(permanentAccountNumber, nameOfBorrower, industryCode, industryName); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static Context createAsOfContextForIndividualBorrower(String bankCode, String reportDate, String exposureType,  String permanentAccountNumber, String nameOfBorrower, String industryCode, String industryName){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = AsOfContext.getId("asof", reportDate, exposureType, "IndividualBorrowerMember", permanentAccountNumber, nameOfBorrower, industryCode, industryName);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(exposureType, "IndividualBorrowerMember");
        List<TypedMember> typeMembers = createTypedMembers(permanentAccountNumber, nameOfBorrower, industryCode, industryName); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }

    public static List<TypedMember> createTypedMembers(String permanentAccountNumber, String nameOfBorrower, String industryCode, String industryName) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        if(permanentAccountNumber != null && !permanentAccountNumber.isEmpty()){
            TypedMember typedMemberForPermanentAccountNumber = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForPermanentAccountNumber.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "PermanentAccountNumberAxis"));
            typedMemberForPermanentAccountNumber.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createPermanentAccountNumberDomain(permanentAccountNumber));
            typedMembers.add(typedMemberForPermanentAccountNumber);
        }
        if(nameOfBorrower != null && !nameOfBorrower.isEmpty()){
            TypedMember typedMemberForNameOfBorrower = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfBorrower.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfBorrowerAxis"));
            typedMemberForNameOfBorrower.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfBorrowerDomain(nameOfBorrower));
            typedMembers.add(typedMemberForNameOfBorrower);
        }
        if(industryCode != null && !industryCode.isEmpty()){
            TypedMember typedMemberForIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
            typedMemberForIndustryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createIndustryCodeDomain(industryCode));
            typedMembers.add(typedMemberForIndustryCode);
        }
        if(industryName != null && !industryName.isEmpty()){
            TypedMember typedMemberForIndustryName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIndustryName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryNameAxis"));
            typedMemberForIndustryName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createIndustryNameDomain(industryName));   
            typedMembers.add(typedMemberForIndustryName);
        }
        
        return typedMembers;
    }

    public static List<ExplicitMember> createExplicitMembers(String exposureType, String borrowerType) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
        if(exposureType != null && !exposureType.isEmpty()){
            ExplicitMember explicitMemberForExposureType = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForExposureType.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "ExposureTypeAxis"));
            explicitMemberForExposureType.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", exposureType));
            explicitMembers.add(explicitMemberForExposureType);
        }
        if(borrowerType != null && !borrowerType.isEmpty()){
            ExplicitMember explicitMemberForLargeCredit = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForLargeCredit.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
            explicitMemberForLargeCredit.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", borrowerType));
            explicitMembers.add(explicitMemberForLargeCredit);
        }
        
        return explicitMembers;
    }

    public static Context createAsOfContextForBorrowerGroup(String bankCode, String reportDate, String exposureType,  String largeCredit, String nameOfBorrowerGroup, String nameOfGroupCompany){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = AsOfContext.getId("asof", reportDate, exposureType, largeCredit, nameOfBorrowerGroup, nameOfGroupCompany);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembersForBorrowerGroup(exposureType, largeCredit);
        List<TypedMember> typeMembers = createTypedMembersForBorrowerGroup(nameOfBorrowerGroup, nameOfGroupCompany); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }
    public static Context createFromToContextForBorrowerGroup(String bankCode, String startDate, String endDate, String exposureType,  String largeCredit, String nameOfBorrowerGroup, String nameOfGroupCompany){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = FromToContext.getId("fromto", startDate, endDate, exposureType, largeCredit, nameOfBorrowerGroup, nameOfGroupCompany );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembersForBorrowerGroup(exposureType, largeCredit);
        List<TypedMember> typeMembers = createTypedMembersForBorrowerGroup(nameOfBorrowerGroup, nameOfGroupCompany); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static List<TypedMember> createTypedMembersForBorrowerGroup(String nameOfBorrowerGroup, String nameOfGroupCompany) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        if(nameOfBorrowerGroup != null && !nameOfBorrowerGroup.isEmpty()){
            TypedMember typedMemberForNameOfBorrowerGroupDomain = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfBorrowerGroupDomain.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfBorrowerGroupAxis"));
            typedMemberForNameOfBorrowerGroupDomain.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfBorrowerGroupDomain(nameOfBorrowerGroup));
            typedMembers.add(typedMemberForNameOfBorrowerGroupDomain);
        }
        if(nameOfGroupCompany != null && !nameOfGroupCompany.isEmpty()){
            TypedMember typedMemberForNameOfGroupCompany = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfGroupCompany.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfGroupCompanyAxis"));
            typedMemberForNameOfGroupCompany.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfGroupCompanyDomain(nameOfGroupCompany));
            typedMembers.add(typedMemberForNameOfGroupCompany);
        }
        
        return typedMembers;
    }

    public static List<ExplicitMember> createExplicitMembersForBorrowerGroup(String exposureType, String borrowerType) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
        if(exposureType != null && !exposureType.isEmpty()){
            ExplicitMember explicitMemberForExposureType = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForExposureType.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "ExposureTypeAxis"));
            explicitMemberForExposureType.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", exposureType));
            explicitMembers.add(explicitMemberForExposureType);
        }
        if(borrowerType != null && !borrowerType.isEmpty()){
            ExplicitMember explicitMemberForLargeCredit = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForLargeCredit.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "LargeCreditAxis"));
            explicitMemberForLargeCredit.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", borrowerType));
            explicitMembers.add(explicitMemberForLargeCredit);
        }
        
        return explicitMembers;
    }
    
}
