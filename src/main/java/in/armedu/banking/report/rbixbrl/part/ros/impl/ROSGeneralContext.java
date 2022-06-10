package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class ROSGeneralContext implements ContextInterface {

        @Override
        public Map<String, Context> getContext(GeneralData generalData) {
        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        Map<String, Context> contexts = new HashMap<String, Context>();

        // create fromto context
        Context fromToContext = ROSUtil.createFromToContext(generalInfoData.getBankCode(), generalInfoData.getStartDate(), generalInfoData.getEndDate(), null);
        contexts.put(ROSUtil.FROMTO, fromToContext);

        // create asof context
        Context asOfContext = ROSUtil.createAsOfContext(generalInfoData.getBankCode(), generalInfoData.getEndDate(), null);
        contexts.put(ROSUtil.ASOF , asOfContext);

        return contexts;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
     ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        ROSItem rosItem = (ROSItem) itemData;
        Map<String, Context> contexts = new HashMap<String, Context>();

 
        // create fromto context subsidiary
        Context fromtoContextForSubsidiary = ROSUtil.createFromToContextForSubsidiary(generalInfoData.getBankCode(), generalInfoData.getStartDate(), generalInfoData.getEndDate(), rosItem.getSubsidiaryInfo().getSubsidiaryName());
        contexts.put(ROSUtil.FROMTOCONTEXTSUBSIDIARY, fromtoContextForSubsidiary);

        // create asof context subsidiary
        Context asofContextForSubsidiary = ROSUtil.createAsOfContextForSubsidiary(generalInfoData.getBankCode(), generalInfoData.getDateOfReport(), rosItem.getSubsidiaryInfo().getSubsidiaryName());
        contexts.put(ROSUtil.ASOFCONTEXTSUBSIDIARY , asofContextForSubsidiary);
      
        // create asof BookValueMember
        Context fromtoContextBookMember = ROSUtil.createAsOfContextForBookValueMember(generalInfoData.getBankCode(), generalInfoData.getEndDate(), "BookValueMember", rosItem.getSubsidiaryInfo().getSubsidiaryName());
        contexts.put(ROSUtil.ASOFBOOKVALUEMEMBER, fromtoContextBookMember);

        // create asof MarketValueMember
        Context asofContextMarketMember = ROSUtil.createAsOfContextForMarketValueMember(generalInfoData.getBankCode(), generalInfoData.getEndDate(), "MarketValueMember", rosItem.getSubsidiaryInfo().getSubsidiaryName());
        contexts.put( ROSUtil.ASOFMARKETVALUEMEMBER, asofContextMarketMember);

        return contexts;

        }

}
