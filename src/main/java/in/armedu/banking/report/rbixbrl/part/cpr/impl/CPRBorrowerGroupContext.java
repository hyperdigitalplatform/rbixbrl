package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.BorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class CPRBorrowerGroupContext implements ContextInterface {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
        return null;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        BorrowerGroup borrowerGroup = (BorrowerGroup) itemData;
        Map<String, Context> itemContexts = new HashMap<String, Context>();

        // create context for borrower group
        borrowerGroup.getGroupCompanies().forEach(groupCompany->{
            Context asOfContextForFundedWithBorrowerGroupAndGroupCompany = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
            itemContexts.put(CPRUtil.ASOFFUNDEDWITHBORROWERGROUPANDGROUPCOMPANY , asOfContextForFundedWithBorrowerGroupAndGroupCompany);
            Context asOfContextForNonFundedWithBorrowerGroupAndGroupCompany = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
            itemContexts.put(CPRUtil.ASOFNONFUNDEDWITHBORROWERGROUPANDGROUPCOMPANY , asOfContextForNonFundedWithBorrowerGroupAndGroupCompany);
            Context fromToContextWithBorrowerGroupAndGroupCompany = CPRUtil.createFromToContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), groupCompany.getGroupCompanyName());
            itemContexts.put(CPRUtil.FROMTOWITHBORROWERGROUPANDGROUPCOMPANY , fromToContextWithBorrowerGroupAndGroupCompany);
            
        });
        Context asOfContextForFundedWithBorrowerGroup = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), null);
        itemContexts.put(CPRUtil.ASOFFUNDEDWITHBORROWERGROUP , asOfContextForFundedWithBorrowerGroup);
        Context asOfContextForNonFundedWithBorrowerGroup = CPRUtil.createAsOfContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), "");
        itemContexts.put(CPRUtil.ASOFNONFUNDEDWITHBORROWERGROUP ,asOfContextForNonFundedWithBorrowerGroup);
        Context fromToContextWithBorrowerGroup = CPRUtil.createFromToContextForBorrowerGroup(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "", "BorrowerGroupMember", borrowerGroup.getBorrowerGroupName(), null);
        itemContexts.put(CPRUtil.FROMTOBORROWERGROUP , fromToContextWithBorrowerGroup);
        
        
        return itemContexts;
    }

    
}
    