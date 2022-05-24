package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.util.ArrayList;
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
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class CPRGeneralContext implements ContextIntf {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public List<Context> getContext(GeneralData generalData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        List<Context> contexts = new ArrayList<Context>();

        // create fromto context
        Context fromToContext = CPRUtil.createFromToContext(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), null);
        contexts.add(fromToContext);
        // create asof context
        Context asOfContext = CPRUtil.createAsOfContext(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), null);
        contexts.add(asOfContext);
      
        // create asof BookValueMember
        Context asOfBookValueMemberContext = CPRUtil.createAsOfContextForMember(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "BookValueMember");
        contexts.add(asOfBookValueMemberContext);

        // create asof MarketValueMember
        Context asOfMarketValueMemberContext = CPRUtil.createAsOfContextForMember(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "MarketValueMember");
        contexts.add(asOfMarketValueMemberContext);
        // create asof fundedmember individual borrower
        Context asOfFundedMemberIndividualBorrowerMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "IndividualBorrowerMember");
        contexts.add(asOfFundedMemberIndividualBorrowerMemberContext);
        // create asof nonfundedmemberindividualborrower
        Context asOfNonFundedMemberIndividualBorrowerMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "IndividualBorrowerMember");
        contexts.add(asOfNonFundedMemberIndividualBorrowerMemberContext);
        // create fromto onlyindividualborrower
        Context fromToOnlyIndividualBorrowerMemberContext = CPRUtil.createFromToContextForOnlyBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "IndividualBorrowerMember");
        contexts.add(fromToOnlyIndividualBorrowerMemberContext);
        
        // create asof fundedmemberborrowergroup
        Context asOfFundedMemberBorrowerGroupMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember");
        contexts.add(asOfFundedMemberBorrowerGroupMemberContext);
        // create asof nonfundedmemberborrowergroup
        Context asOfNonFundedMemberBorrowerGroupMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember");
        contexts.add(asOfNonFundedMemberBorrowerGroupMemberContext);
         // create fromto onlyborrowergroupmember
         Context fromToOnlyBorrowerGroupMemberContext = CPRUtil.createFromToContextForOnlyBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "BorrowerGroupMember");
         contexts.add(fromToOnlyBorrowerGroupMemberContext);
        // create asof fundedmember
        Context asOfFundedMemberContext = CPRUtil.createAsOfContextForFundType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember");
        contexts.add(asOfFundedMemberContext);
        // create asof nonfundedmember
        Context asOfNonFundedMemberContext = CPRUtil.createAsOfContextForFundType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember");
        contexts.add(asOfNonFundedMemberContext);

        return contexts;
    }

    @Override
    public List<Context> getContext(GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        CPRItemData cprItemData = (CPRItemData) itemData;
        List<Context> itemContexts = new ArrayList<Context>();

        cprItemData.getLargeExposuresToIndividualBorrower().getIndividualBorrowers().forEach(individualBorrower -> {
            // create context for individual borrower
            Context fromToContextForItemWithoutIndividual = CPRUtil.createFromToContextForBorrower(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
            itemContexts.add(fromToContextForItemWithoutIndividual);
            Context asOfContextForFundedForIndividual = CPRUtil.createAsOfContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
            itemContexts.add(asOfContextForFundedForIndividual);
            Context asOfContextForNonFundedForIndividual = CPRUtil.createAsOfContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
            itemContexts.add(asOfContextForNonFundedForIndividual);
            Context fromToContextForItemForIndividual = CPRUtil.createFromToContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
            itemContexts.add(fromToContextForItemForIndividual);
        });
        
        cprItemData.getLargeExposureToBorrowerGroup().getBorrowerGroups().forEach(borrowerGroup->{
            // create context for borrower group
            borrowerGroup.getGroupCompanies().forEach(groupCompany->{
                Context asOfContextForFundedWithBorrowerGroupAndGroupCompany = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
                itemContexts.add(asOfContextForFundedWithBorrowerGroupAndGroupCompany);
                Context asOfContextForNonFundedWithBorrowerGroupAndGroupCompany = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
                itemContexts.add(asOfContextForNonFundedWithBorrowerGroupAndGroupCompany);
                Context fromToContextWithBorrowerGroupAndGroupCompany = CPRUtil.createFromToContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
                itemContexts.add(fromToContextWithBorrowerGroupAndGroupCompany);
                
            });
            Context asOfContextForFundedWithBorrowerGroup = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), null);
            itemContexts.add(asOfContextForFundedWithBorrowerGroup);
            Context asOfContextForNonFundedWithBorrowerGroup = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), "");
            itemContexts.add(asOfContextForNonFundedWithBorrowerGroup);
            Context fromToContextWithBorrowerGroup = CPRUtil.createFromToContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), null);
            itemContexts.add(fromToContextWithBorrowerGroup);
        });
        
        return itemContexts;
    }

    
}
    