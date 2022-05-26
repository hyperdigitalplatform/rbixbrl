package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRGeneralExtraBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        // TODO add general items related to cpr report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(CPRUtil.FROMTO);
        Context asOfContext = contexts.get(CPRUtil.ASOF);
        Context asOfBookValue = contexts.get(CPRUtil.ASOFBOOKVALUEMEMBER);
        Context asOfMarketValue = contexts.get(CPRUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        
        // TODO add remaining fields that are report level
        
        // create Assets
        MonetaryItemType assetsType = new MonetaryItemType();
        assetsType.setContextRef(asOfContext);
        assetsType.setUnitRef(currency);
        assetsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getAssets()) )  );
        assetsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getAssets()));
        JAXBElement<MonetaryItemType> assets = rbiObjectFactory.createAssets(assetsType);
        generalItems.add(assets);
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }

    
}