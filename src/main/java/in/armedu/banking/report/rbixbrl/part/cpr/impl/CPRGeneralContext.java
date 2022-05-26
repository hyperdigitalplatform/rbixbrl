package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class CPRGeneralContext implements ContextInterface {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        Map<String, Context> contexts = new HashMap<String, Context>();

        // create fromto context
        Context fromToContext = CPRUtil.createFromToContext(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), null);
        contexts.put(CPRUtil.FROMTO, fromToContext);
        // create asof context
        Context asOfContext = CPRUtil.createAsOfContext(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), null);
        contexts.put(CPRUtil.ASOF , asOfContext);
      
        // create asof BookValueMember
        Context asOfBookValueMemberContext = CPRUtil.createAsOfContextForMember(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "BookValueMember");
        contexts.put(CPRUtil.ASOFBOOKVALUEMEMBER, asOfBookValueMemberContext);

        // create asof MarketValueMember
        Context asOfMarketValueMemberContext = CPRUtil.createAsOfContextForMember(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "MarketValueMember");
        contexts.put( CPRUtil.ASOFMARKETVALUEMEMBER, asOfMarketValueMemberContext);
        // create asof fundedmember individual borrower
        Context asOfFundedMemberIndividualBorrowerMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "IndividualBorrowerMember");
        contexts.put(CPRUtil.ASOFFUNDEDMEMBERINDIVIDUALBORROWER, asOfFundedMemberIndividualBorrowerMemberContext);
        // create asof nonfundedmemberindividualborrower
        Context asOfNonFundedMemberIndividualBorrowerMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "IndividualBorrowerMember");
        contexts.put(CPRUtil.ASOFNONFUNDEDMEMBERINDIVIDUALBORROWER , asOfNonFundedMemberIndividualBorrowerMemberContext);
        // create fromto onlyindividualborrower
        Context fromToOnlyIndividualBorrowerMemberContext = CPRUtil.createFromToContextForOnlyBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "IndividualBorrowerMember");
        contexts.put(CPRUtil.FROMTOINDIVIDUALBORROWER , fromToOnlyIndividualBorrowerMemberContext);
        
        // create asof fundedmemberborrowergroup
        Context asOfFundedMemberBorrowerGroupMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", "BorrowerGroupMember");
        contexts.put(CPRUtil.ASOFFUNDEDMEMBERBORROWERGROUP , asOfFundedMemberBorrowerGroupMemberContext);
        // create asof nonfundedmemberborrowergroup
        Context asOfNonFundedMemberBorrowerGroupMemberContext = CPRUtil.createAsOfContextForFundTypeAndBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", "BorrowerGroupMember");
        contexts.put(CPRUtil.ASOFNONFUNDEDMEMBERBORROWERGROUP, asOfNonFundedMemberBorrowerGroupMemberContext);
         // create fromto onlyborrowergroupmember
         Context fromToOnlyBorrowerGroupMemberContext = CPRUtil.createFromToContextForOnlyBorrowerType(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), "BorrowerGroupMember");
         contexts.put(CPRUtil.FROMTOBORROWERGROUP, fromToOnlyBorrowerGroupMemberContext);
        // create asof fundedmember
        Context asOfFundedMemberContext = CPRUtil.createAsOfContextForFundType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember");
        contexts.put(CPRUtil.ASOFFUNDEDMEMBER , asOfFundedMemberContext);
        // create asof nonfundedmember
        Context asOfNonFundedMemberContext = CPRUtil.createAsOfContextForFundType(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember");
        contexts.put(CPRUtil.ASOFNONFUNDEDMEMBER, asOfNonFundedMemberContext);

        return contexts;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
        return null;
    }

    
}
    