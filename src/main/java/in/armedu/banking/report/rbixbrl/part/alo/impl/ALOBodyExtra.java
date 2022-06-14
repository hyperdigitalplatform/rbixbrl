package in.armedu.banking.report.rbixbrl.part.alo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class ALOBodyExtra  implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {

        ALOGeneralData aloGeneralData = (ALOGeneralData) generalData;
        ALOItemData aloItem = (ALOItemData) itemData;

        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromToContext = contexts.get(ALOUtil.FROMTO);
        Context asOfContext = contexts.get(ALOUtil.ASOF);
        Unit currency = units.get(ALOUtil.CURRENCY);
        Unit percentage = units.get(ALOUtil.PERCENTAGE);
        Context asofaccountwithmember = contexts.get(ALOUtil.ASOFACCOUNTWITHMEMBER);


///     For Account with members
        // create DebitNumberOfEntriesInAccount
        IntegerItemType debitNumberOfEntriesInAccountValue = new IntegerItemType();
        debitNumberOfEntriesInAccountValue.setContextRef(asofaccountwithmember); 
        debitNumberOfEntriesInAccountValue.setDecimals("INF");
        debitNumberOfEntriesInAccountValue.setUnitRef(percentage);
        debitNumberOfEntriesInAccountValue.setValue(new BigInteger(aloItem.getDebitNumberOfEntriesInAccount()));
        JAXBElement<IntegerItemType> debitNumberOfEntriesInAccount = rbiObjectFactory.createDebitNumberOfEntriesInAccount(debitNumberOfEntriesInAccountValue);
        bodyItems.add(debitNumberOfEntriesInAccount);

        // create DebitAmountOfEntriesInAccount
        MonetaryItemType debitAmountOfEntriesInAccountValue = new MonetaryItemType();
        debitAmountOfEntriesInAccountValue.setContextRef(asofaccountwithmember);  
        debitAmountOfEntriesInAccountValue.setUnitRef(currency);
        debitAmountOfEntriesInAccountValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getDebitAmountOfEntriesInAccount())));
        debitAmountOfEntriesInAccountValue.setValue(new BigDecimal(aloItem.getDebitAmountOfEntriesInAccount()));
        JAXBElement<MonetaryItemType> debitAmountOfEntriesInAccount = rbiObjectFactory.createDebitAmountOfEntriesInAccount(debitAmountOfEntriesInAccountValue);
        bodyItems.add(debitAmountOfEntriesInAccount);

        // create CreditNumberOfEntriesInAccount
        IntegerItemType creditNumberOfEntriesInAccountValue = new IntegerItemType();
        creditNumberOfEntriesInAccountValue.setContextRef(asofaccountwithmember); 
        creditNumberOfEntriesInAccountValue.setDecimals("INF");
        creditNumberOfEntriesInAccountValue.setUnitRef(percentage);
        creditNumberOfEntriesInAccountValue.setValue(new BigInteger(aloItem.getCreditNumberOfEntriesInAccount()));
        JAXBElement<IntegerItemType> creditNumberOfEntriesInAccount = rbiObjectFactory.createCreditNumberOfEntriesInAccount(creditNumberOfEntriesInAccountValue);
        bodyItems.add(creditNumberOfEntriesInAccount);

        // create CreditAmountOfEntriesInAccount
        MonetaryItemType creditAmountOfEntriesInAccountValue = new MonetaryItemType();
        creditAmountOfEntriesInAccountValue.setContextRef(asofaccountwithmember); 
        creditAmountOfEntriesInAccountValue.setUnitRef(currency);
        creditAmountOfEntriesInAccountValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCreditAmountOfEntriesInAccount())));
        creditAmountOfEntriesInAccountValue.setValue(new BigDecimal(aloItem.getCreditAmountOfEntriesInAccount()));
        JAXBElement<MonetaryItemType> creditAmountOfEntriesInAccount = rbiObjectFactory.createCreditAmountOfEntriesInAccount(creditAmountOfEntriesInAccountValue);
        bodyItems.add(creditAmountOfEntriesInAccount);

        return bodyItems;
            
        }
    
}