package in.armedu.banking.report.rbixbrl.part.pci.impl;

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
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationHostCountryItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.CategoryStatusItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIItemData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class PCIBodyMoreThanUSD2MillionMember  implements BodyInterface {

@Override
public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
        GeneralData generalData) {
    return null;
}

@Override
public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
        GeneralData generalData, ItemData itemData) {

    PCIGeneralData pciGeneralData = (PCIGeneralData) generalData;
    PCIItemData pciItem = (PCIItemData) itemData;

    List<Object> bodyItems = new ArrayList<Object>();
    org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
    rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

    Context fromToContext = contexts.get(PCIUtil.FROMTO);
    Context asOfContext = contexts.get(PCIUtil.ASOF);
    Unit currency = units.get(PCIUtil.CURRENCY);
    Unit percentage = units.get(PCIUtil.PERCENTAGE);
    Context fromtomorethanusd2millionmember = contexts.get(PCIUtil.FROMTOMORETHANUSD2MILLIONMEMBER);
    Context asofmorethanusd2millionmember = contexts.get(PCIUtil.ASOFMORETHANUSD2MILLIONMEMBER);

    //    For Account with MoreThanUSD2MillionMember
    if(pciItem.getCustomerCreditLimitAxis() == "MoreThanUSD2MillionMember")
{
    // create SoverignCharacter
    StringItemType soverignCharacterValue = new StringItemType();
    soverignCharacterValue.setContextRef(fromtomorethanusd2millionmember); 
    soverignCharacterValue.setValue(pciItem.getSoverignCharacter());
    JAXBElement<StringItemType> soverignCharacter = rbiObjectFactory.createSoverignCharacter(soverignCharacterValue);
    bodyItems.add(soverignCharacter);

    // create CategoryOfBorrower
    CategoryStatusItemType categoryOfBorrowerValue = new CategoryStatusItemType();
    categoryOfBorrowerValue.setContextRef(fromtomorethanusd2millionmember); 
    categoryOfBorrowerValue.setValue(pciItem.getCategoryOfBorrower());
    JAXBElement<CategoryStatusItemType> categoryOfBorrower = rbiObjectFactory.createCategoryOfBorrower(categoryOfBorrowerValue);
    bodyItems.add(categoryOfBorrower);

    // create AggregateAmountOfLimitsSanctioned
    MonetaryItemType aggregateAmountOfLimitsSanctionedValue = new MonetaryItemType();
    aggregateAmountOfLimitsSanctionedValue.setContextRef(asofmorethanusd2millionmember);  
    aggregateAmountOfLimitsSanctionedValue.setUnitRef(currency);
    aggregateAmountOfLimitsSanctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAggregateAmountOfLimitsSanctioned())));
    aggregateAmountOfLimitsSanctionedValue.setValue(new BigDecimal(pciItem.getAggregateAmountOfLimitsSanctioned()));
    JAXBElement<MonetaryItemType> aggregateAmountOfLimitsSanctioned = rbiObjectFactory.createAggregateAmountOfLimitsSanctioned(aggregateAmountOfLimitsSanctionedValue);
    bodyItems.add(aggregateAmountOfLimitsSanctioned);

    // create AmountOfFundedLimitsSanctioned
    MonetaryItemType amountOfFundedLimitsSanctionedValue = new MonetaryItemType();
    amountOfFundedLimitsSanctionedValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfFundedLimitsSanctionedValue.setUnitRef(currency);
    amountOfFundedLimitsSanctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfFundedLimitsSanctioned())));
    amountOfFundedLimitsSanctionedValue.setValue(new BigDecimal(pciItem.getAmountOfFundedLimitsSanctioned()));
    JAXBElement<MonetaryItemType> amountOfFundedLimitsSanctioned = rbiObjectFactory.createAmountOfFundedLimitsSanctioned(amountOfFundedLimitsSanctionedValue);
    bodyItems.add(amountOfFundedLimitsSanctioned);

    // create AmountOfNonFundedLimitsSanctioned
    MonetaryItemType amountOfNonFundedLimitsSanctionedValue = new MonetaryItemType();
    amountOfNonFundedLimitsSanctionedValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfNonFundedLimitsSanctionedValue.setUnitRef(currency);
    amountOfNonFundedLimitsSanctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfNonFundedLimitsSanctioned())));
    amountOfNonFundedLimitsSanctionedValue.setValue(new BigDecimal(pciItem.getAmountOfNonFundedLimitsSanctioned()));
    JAXBElement<MonetaryItemType> amountOfNonFundedLimitsSanctioned = rbiObjectFactory.createAmountOfNonFundedLimitsSanctioned(amountOfNonFundedLimitsSanctionedValue);
    bodyItems.add(amountOfNonFundedLimitsSanctioned);

    // create AmountOutstandingOfCustomerCreditLimitSenctioned
    MonetaryItemType amountOutstandingOfCustomerCreditLimitSenctionedValue = new MonetaryItemType();
    amountOutstandingOfCustomerCreditLimitSenctionedValue.setContextRef(asofmorethanusd2millionmember);  
    amountOutstandingOfCustomerCreditLimitSenctionedValue.setUnitRef(currency);
    amountOutstandingOfCustomerCreditLimitSenctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOutstandingOfCustomerCreditLimitSenctioned())));
    amountOutstandingOfCustomerCreditLimitSenctionedValue.setValue(new BigDecimal(pciItem.getAmountOutstandingOfCustomerCreditLimitSenctioned()));
    JAXBElement<MonetaryItemType> amountOutstandingOfCustomerCreditLimitSenctioned = rbiObjectFactory.createAmountOutstandingOfCustomerCreditLimitSenctioned(amountOutstandingOfCustomerCreditLimitSenctionedValue);
    bodyItems.add(amountOutstandingOfCustomerCreditLimitSenctioned);

    // create SecurityValue
    MonetaryItemType securityValueType = new MonetaryItemType();
    securityValueType.setContextRef(asofmorethanusd2millionmember);  
    securityValueType.setUnitRef(currency);
    securityValueType.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getSecurityValue())));
    securityValueType.setValue(new BigDecimal(pciItem.getSecurityValue()));
    JAXBElement<MonetaryItemType> securityValue = rbiObjectFactory.createSecurityValue(securityValueType);
    bodyItems.add(securityValue);

    // create AssetsClassification
    AssetsClassificationItemType assetsClassificationValue = new AssetsClassificationItemType();
    assetsClassificationValue.setContextRef(asofmorethanusd2millionmember); 
    assetsClassificationValue.setValue(pciItem.getAssetsClassification());
    JAXBElement<AssetsClassificationItemType> assetsClassification = rbiObjectFactory.createAssetsClassification(assetsClassificationValue);
    bodyItems.add(assetsClassification);

    // create AssetsClassificationHostCountry
    AssetsClassificationHostCountryItemType assetsClassificationHostCountryValue = new AssetsClassificationHostCountryItemType();
    assetsClassificationHostCountryValue.setContextRef(asofmorethanusd2millionmember); 
    assetsClassificationHostCountryValue.setValue(pciItem.getAssetsClassificationHostCountry());
    JAXBElement<AssetsClassificationHostCountryItemType> assetsClassificationHostCountry = rbiObjectFactory.createAssetsClassificationHostCountry(assetsClassificationHostCountryValue);
    bodyItems.add(assetsClassificationHostCountry);

    // create AmountOfProvisionsHeldAtBranch
    MonetaryItemType amountOfProvisionsHeldAtBranchValue = new MonetaryItemType();
    amountOfProvisionsHeldAtBranchValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfProvisionsHeldAtBranchValue.setUnitRef(currency);
    amountOfProvisionsHeldAtBranchValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfProvisionsHeldAtBranch())));
    amountOfProvisionsHeldAtBranchValue.setValue(new BigDecimal(pciItem.getAmountOfProvisionsHeldAtBranch()));
    JAXBElement<MonetaryItemType> amountOfProvisionsHeldAtBranch = rbiObjectFactory.createAmountOfProvisionsHeldAtBranch(amountOfProvisionsHeldAtBranchValue);
    bodyItems.add(amountOfProvisionsHeldAtBranch);

    // create AmountOfProvisionsHeldAtHeadOffice
    MonetaryItemType amountOfProvisionsHeldAtHeadOfficeValue = new MonetaryItemType();
    amountOfProvisionsHeldAtHeadOfficeValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfProvisionsHeldAtHeadOfficeValue.setUnitRef(currency);
    amountOfProvisionsHeldAtHeadOfficeValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfProvisionsHeldAtHeadOffice())));
    amountOfProvisionsHeldAtHeadOfficeValue.setValue(new BigDecimal(pciItem.getAmountOfProvisionsHeldAtHeadOffice()));
    JAXBElement<MonetaryItemType> amountOfProvisionsHeldAtHeadOffice = rbiObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(amountOfProvisionsHeldAtHeadOfficeValue);
    bodyItems.add(amountOfProvisionsHeldAtHeadOffice);

    // create AmountOfInterestSuspense
    MonetaryItemType amountOfInterestSuspenseValue = new MonetaryItemType();
    amountOfInterestSuspenseValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfInterestSuspenseValue.setUnitRef(currency);
    amountOfInterestSuspenseValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfInterestSuspense())));
    amountOfInterestSuspenseValue.setValue(new BigDecimal(pciItem.getAmountOfInterestSuspense()));
    JAXBElement<MonetaryItemType> amountOfInterestSuspense = rbiObjectFactory.createAmountOfInterestSuspense(amountOfInterestSuspenseValue);
    bodyItems.add(amountOfInterestSuspense);

    // create AggregateAmountOfProvisionAndInterestSuspense
    MonetaryItemType aggregateAmountOfProvisionAndInterestSuspenseValue = new MonetaryItemType();
    aggregateAmountOfProvisionAndInterestSuspenseValue.setContextRef(asofmorethanusd2millionmember);  
    aggregateAmountOfProvisionAndInterestSuspenseValue.setUnitRef(currency);
    aggregateAmountOfProvisionAndInterestSuspenseValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAggregateAmountOfProvisionAndInterestSuspense())));
    aggregateAmountOfProvisionAndInterestSuspenseValue.setValue(new BigDecimal(pciItem.getAggregateAmountOfProvisionAndInterestSuspense()));
    JAXBElement<MonetaryItemType> aggregateAmountOfProvisionAndInterestSuspense = rbiObjectFactory.createAggregateAmountOfProvisionAndInterestSuspense(aggregateAmountOfProvisionAndInterestSuspenseValue);
    bodyItems.add(aggregateAmountOfProvisionAndInterestSuspense);

    // create AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
    MonetaryItemType amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue = new MonetaryItemType();
    amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue.setUnitRef(currency);
    amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities())));
    amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue.setValue(new BigDecimal(pciItem.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities()));
    JAXBElement<MonetaryItemType> amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities = rbiObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(amountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesValue);
    bodyItems.add(amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities);

    // create AmountOfShortFall
    MonetaryItemType amountOfShortFallValue = new MonetaryItemType();
    amountOfShortFallValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfShortFallValue.setUnitRef(currency);
    amountOfShortFallValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfShortFall())));
    amountOfShortFallValue.setValue(new BigDecimal(pciItem.getAmountOfShortFall()));
    JAXBElement<MonetaryItemType> amountOfShortFall = rbiObjectFactory.createAmountOfShortFall(amountOfShortFallValue);
    bodyItems.add(amountOfShortFall);

    // create AmountOfHeadOfficeSupportFund
    MonetaryItemType amountOfHeadOfficeSupportFundValue = new MonetaryItemType();
    amountOfHeadOfficeSupportFundValue.setContextRef(asofmorethanusd2millionmember);  
    amountOfHeadOfficeSupportFundValue.setUnitRef(currency);
    amountOfHeadOfficeSupportFundValue.setDecimals(String.format("%s", CommonFns.getDecimals(pciItem.getAmountOfHeadOfficeSupportFund())));
    amountOfHeadOfficeSupportFundValue.setValue(new BigDecimal(pciItem.getAmountOfHeadOfficeSupportFund()));
    JAXBElement<MonetaryItemType> amountOfHeadOfficeSupportFund = rbiObjectFactory.createAmountOfHeadOfficeSupportFund(amountOfHeadOfficeSupportFundValue);
    bodyItems.add(amountOfHeadOfficeSupportFund);

    // create DevelopmentsDuringQuarter
    StringItemType developmentsDuringQuarterValue = new StringItemType();
    developmentsDuringQuarterValue.setContextRef(fromtomorethanusd2millionmember); 
    developmentsDuringQuarterValue.setValue(pciItem.getDevelopmentsDuringQuarter());
    JAXBElement<StringItemType> developmentsDuringQuarter = rbiObjectFactory.createDevelopmentsDuringQuarter(developmentsDuringQuarterValue);
    bodyItems.add(developmentsDuringQuarter);
}
    return bodyItems;
        
    }

}