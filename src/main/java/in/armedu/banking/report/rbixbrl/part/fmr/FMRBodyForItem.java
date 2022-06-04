package in.armedu.banking.report.rbixbrl.part.fmr;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ActionTaken;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.PlaceOfOccurenceItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.RiskClassificationPhishing;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.TypeOfBranch;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.TypeOfCase;
import org.xbrl._2003.instance.BooleanItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl.dtr.type.non_numeric.TextBlockItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRItemData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class FMRBodyForItem implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {
        FMRGeneralData fmrGeneralData = (FMRGeneralData) generalData;
        FMRItemData fmrItemData = (FMRItemData) itemData;
        
        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create SectorCode
        Context fromToContextForBranch = contexts.get(FMRUtil.FROMTOBRANCH);
        Context fromToContextForStaff = contexts.get(FMRUtil.FROMTOSTAFF);
        Context fromToContextForRobber = contexts.get(FMRUtil.FROMTOROBBER);
        Context fromToContextForOtherCriminal = contexts.get(FMRUtil.FROMTOOTHERCRIMINAL);
        
        Unit currency = units.get(FMRUtil.CURRENCY);
        Unit percentage = units.get(FMRUtil.PERCENTAGE);
        // create TypeOfBranch
        TypeOfBranch typeOfBranch = new TypeOfBranch();
        typeOfBranch.setContextRef(fromToContextForBranch);
        typeOfBranch.setValue(fmrItemData.getTypeOfBranch());
        JAXBElement<TypeOfBranch> typeOfBranchElement = rbiObjectFactory.createTypeOfBranch(typeOfBranch);
        bodyItems.add(typeOfBranchElement);
        // create RiskClassificationPhishing
        RiskClassificationPhishing riskClassificationPhishing = new RiskClassificationPhishing();
        riskClassificationPhishing.setContextRef(fromToContextForBranch);
        riskClassificationPhishing.setValue(fmrItemData.getRiskClassificationPhishing());
        JAXBElement<RiskClassificationPhishing> riskClassificationPhisingElement = rbiObjectFactory.createRiskClassificationPhishing(riskClassificationPhishing);
        bodyItems.add(riskClassificationPhisingElement);
        // create WhetherCurrencyChestBranch
        BooleanItemType whetherCurrencyChestBranchType = new BooleanItemType();
        whetherCurrencyChestBranchType.setContextRef(fromToContextForBranch);
        whetherCurrencyChestBranchType.setValue(Boolean.valueOf(fmrGeneralData.getWhetherNilReporting()));
        JAXBElement<BooleanItemType> whetherCurrencyChestBranch = rbiObjectFactory.createWhetherCurrencyChestBranch(whetherCurrencyChestBranchType);
        bodyItems.add(whetherCurrencyChestBranch);
        // create NumberOfArmedGuards
        IntegerItemType numberOfArmedGuardsType = new IntegerItemType();
        numberOfArmedGuardsType.setContextRef(fromToContextForBranch);
        numberOfArmedGuardsType.setDecimals("INF");
        numberOfArmedGuardsType.setUnitRef(percentage);
        numberOfArmedGuardsType.setValue(new BigInteger(fmrItemData.getNumberOfArmedGuards()));
        JAXBElement<IntegerItemType> numberOfArmedGuards = rbiObjectFactory.createNumberOfArmedGuards(numberOfArmedGuardsType);
        bodyItems.add(numberOfArmedGuards);
        // create TypeOfCase
        TypeOfCase typeOfCaseType = new TypeOfCase();
        typeOfCaseType.setContextRef(fromToContextForBranch);
        typeOfCaseType.setValue(fmrItemData.getTypeOfCase());
        JAXBElement<TypeOfCase> typeOfCase = rbiObjectFactory.createTypeOfCase(typeOfCaseType);
        bodyItems.add(typeOfCase);
        // create PlaceOfOccurrence
        PlaceOfOccurenceItemType placeOfOccurenceItemType = new PlaceOfOccurenceItemType();
        placeOfOccurenceItemType.setContextRef(fromToContextForBranch);
        placeOfOccurenceItemType.setValue(fmrItemData.getTypeOfCase());
        JAXBElement<PlaceOfOccurenceItemType> placeOfOccurenceItem = rbiObjectFactory.createPlaceOfOccurence(placeOfOccurenceItemType);
        bodyItems.add(placeOfOccurenceItem);
        // create AmountInvolvedInCases
        MonetaryItemType amountInvolvedInCasesType = new MonetaryItemType();
        amountInvolvedInCasesType.setContextRef(fromToContextForBranch);
        amountInvolvedInCasesType.setUnitRef(currency);
        amountInvolvedInCasesType.setDecimals(String.format("%s", CommonFns.getDecimals(fmrItemData.getAmountInvolvedInCases())));
        amountInvolvedInCasesType.setValue(new BigDecimal(fmrItemData.getAmountInvolvedInCases()));
        JAXBElement<MonetaryItemType> amountInvolvedInCases = rbiObjectFactory.createAmountInvolvedInCases(amountInvolvedInCasesType);
        bodyItems.add(amountInvolvedInCases);
        // create AmountRecovered
        MonetaryItemType amountRecoveredType = new MonetaryItemType();
        amountRecoveredType.setContextRef(fromToContextForBranch);
        amountRecoveredType.setUnitRef(currency);
        amountRecoveredType.setDecimals(String.format("%s", CommonFns.getDecimals(fmrItemData.getAmountRecovered())));
        amountRecoveredType.setValue(new BigDecimal(fmrItemData.getAmountRecovered()));
        JAXBElement<MonetaryItemType> amountRecovered = rbiObjectFactory.createAmountRecovered(amountRecoveredType);
        bodyItems.add(amountRecovered);
        // create InsuranceClaimSettled
        MonetaryItemType insuranceClaimSettledType = new MonetaryItemType();
        insuranceClaimSettledType.setContextRef(fromToContextForBranch);
        insuranceClaimSettledType.setUnitRef(currency);
        insuranceClaimSettledType.setDecimals(String.format("%s", CommonFns.getDecimals(fmrItemData.getInsuranceClaimSettled())));
        insuranceClaimSettledType.setValue(new BigDecimal(fmrItemData.getInsuranceClaimSettled()));
        JAXBElement<MonetaryItemType> insuranceClaimSettled = rbiObjectFactory.createInsuranceClaimSettled(insuranceClaimSettledType);
        bodyItems.add(insuranceClaimSettled);
        // create NumberOfArrested for Staff
        IntegerItemType numberOfArrestedType = new IntegerItemType();
        numberOfArrestedType.setContextRef(fromToContextForStaff);
        numberOfArrestedType.setUnitRef(percentage);
        numberOfArrestedType.setDecimals("INF");
        numberOfArrestedType.setValue(new BigInteger(fmrItemData.getNumberOfArrestedRobbers()));
        JAXBElement<IntegerItemType>  numberOfArrested = rbiObjectFactory.createNumberOfArrested(numberOfArrestedType);
        bodyItems.add(numberOfArrested);
        // create NumberOfArrested for Robbers
        IntegerItemType numberOfArrestedTypeForRobbers = new IntegerItemType();
        numberOfArrestedTypeForRobbers.setContextRef(fromToContextForStaff);
        numberOfArrestedTypeForRobbers.setUnitRef(percentage);
        numberOfArrestedTypeForRobbers.setDecimals("INF");
        numberOfArrestedTypeForRobbers.setValue(new BigInteger(fmrItemData.getNumberOfArrestedRobbers()));
        JAXBElement<IntegerItemType>  numberOfArrestedRobbers = rbiObjectFactory.createNumberOfArrested(numberOfArrestedTypeForRobbers);
        bodyItems.add(numberOfArrestedRobbers);
        // create NumberOfKilled for Staff
        IntegerItemType numberOfKilledTypeForStaff = new IntegerItemType();
        numberOfKilledTypeForStaff.setContextRef(fromToContextForStaff);
        numberOfKilledTypeForStaff.setUnitRef(percentage);
        numberOfKilledTypeForStaff.setDecimals("INF");
        numberOfKilledTypeForStaff.setValue(new BigInteger(fmrItemData.getNumberOfKilledStaffs()));
        JAXBElement<IntegerItemType>  numberOfKilledStaff = rbiObjectFactory.createNumberOfKilled(numberOfKilledTypeForStaff);
        bodyItems.add(numberOfKilledStaff);
        // create NumberOfKilled for Robbers
        IntegerItemType numberOfKilledTypeForRobbers = new IntegerItemType();
        numberOfKilledTypeForRobbers.setContextRef(fromToContextForRobber);
        numberOfKilledTypeForRobbers.setUnitRef(percentage);
        numberOfKilledTypeForRobbers.setDecimals("INF");
        numberOfKilledTypeForRobbers.setValue(new BigInteger(fmrItemData.getNumberOfKilledRobbers()));
        JAXBElement<IntegerItemType>  numberOfKilledRobbers = rbiObjectFactory.createNumberOfKilled(numberOfKilledTypeForRobbers);
        bodyItems.add(numberOfKilledRobbers);
        // create NumberOfKilled for OtherCriminals
        IntegerItemType numberOfKilledTypeForOtherCriminals = new IntegerItemType();
        numberOfKilledTypeForOtherCriminals.setContextRef(fromToContextForOtherCriminal);
        numberOfKilledTypeForOtherCriminals.setUnitRef(percentage);
        numberOfKilledTypeForOtherCriminals.setDecimals("INF");
        numberOfKilledTypeForOtherCriminals.setValue(new BigInteger(fmrItemData.getNumberOfKilledOtherCriminals()));
        JAXBElement<IntegerItemType>  numberOfKilledOtherCriminals = rbiObjectFactory.createNumberOfKilled(numberOfKilledTypeForOtherCriminals);
        bodyItems.add(numberOfKilledOtherCriminals);
        // create NumberOfInjured for Staff
        IntegerItemType numberOfInjuredTypeForStaff = new IntegerItemType();
        numberOfInjuredTypeForStaff.setContextRef(fromToContextForStaff);
        numberOfInjuredTypeForStaff.setUnitRef(percentage);
        numberOfInjuredTypeForStaff.setDecimals("INF");
        numberOfInjuredTypeForStaff.setValue(new BigInteger(fmrItemData.getNumberOfInjuredStaffs()));
        JAXBElement<IntegerItemType>  numberOfInjuredStaff = rbiObjectFactory.createNumberOfInjured(numberOfInjuredTypeForStaff);
        bodyItems.add(numberOfInjuredStaff);
        // create NumberOfInjured for OtherCriminals
        IntegerItemType numberOfInjuredTypeForOtherCriminals = new IntegerItemType();
        numberOfInjuredTypeForOtherCriminals.setContextRef(fromToContextForOtherCriminal);
        numberOfInjuredTypeForOtherCriminals.setUnitRef(percentage);
        numberOfInjuredTypeForOtherCriminals.setDecimals("INF");
        numberOfInjuredTypeForOtherCriminals.setValue(new BigInteger(fmrItemData.getNumberOfInjuredOtherCriminals()));
        JAXBElement<IntegerItemType>  numberOfInjuredOtherCriminals = rbiObjectFactory.createNumberOfInjured(numberOfInjuredTypeForOtherCriminals);
        bodyItems.add(numberOfInjuredOtherCriminals);
        // create NumberOfConvicted for Staff
        IntegerItemType numberOfConvictedType = new IntegerItemType();
        numberOfConvictedType.setContextRef(fromToContextForStaff);
        numberOfConvictedType.setUnitRef(percentage);
        numberOfConvictedType.setDecimals("INF");
        numberOfConvictedType.setValue(new BigInteger(fmrItemData.getNumberOfConvictedRobbers()));
        JAXBElement<IntegerItemType>  numberOfConvicted = rbiObjectFactory.createNumberOfConvicted(numberOfConvictedType);
        bodyItems.add(numberOfConvicted);
        // create NumberOfConvicted for Robbers
        IntegerItemType numberOfConvictedTypeForRobbers = new IntegerItemType();
        numberOfConvictedTypeForRobbers.setContextRef(fromToContextForStaff);
        numberOfConvictedTypeForRobbers.setUnitRef(percentage);
        numberOfConvictedTypeForRobbers.setDecimals("INF");
        numberOfConvictedTypeForRobbers.setValue(new BigInteger(fmrItemData.getNumberOfConvictedRobbers()));
        JAXBElement<IntegerItemType>  numberOfConvictedRobbers = rbiObjectFactory.createNumberOfConvicted(numberOfConvictedTypeForRobbers);
        bodyItems.add(numberOfConvictedRobbers);       
        // create CompensationPaid for Staff
        MonetaryItemType CompensationPaidTypeForStaff = new MonetaryItemType();
        CompensationPaidTypeForStaff.setContextRef(fromToContextForStaff);
        CompensationPaidTypeForStaff.setUnitRef(currency);
        CompensationPaidTypeForStaff.setDecimals(String.format("%s", CommonFns.getDecimals(fmrItemData.getCompensationPaidStaffs())));
        CompensationPaidTypeForStaff.setValue(new BigDecimal(fmrItemData.getCompensationPaidStaffs()));
        JAXBElement<MonetaryItemType>  CompensationPaidStaff = rbiObjectFactory.createCompensationPaid(CompensationPaidTypeForStaff);
        bodyItems.add(CompensationPaidStaff);
        // create CompensationPaid for OtherCriminals
        MonetaryItemType CompensationPaidTypeForOtherCriminals = new MonetaryItemType();
        CompensationPaidTypeForOtherCriminals.setContextRef(fromToContextForOtherCriminal);
        CompensationPaidTypeForOtherCriminals.setUnitRef(currency);
        CompensationPaidTypeForOtherCriminals.setDecimals(String.format("%s", CommonFns.getDecimals(fmrItemData.getCompensationPaidOtherCriminal())));
        CompensationPaidTypeForOtherCriminals.setValue(new BigDecimal(fmrItemData.getCompensationPaidOtherCriminal()));
        JAXBElement<MonetaryItemType>  CompensationPaidOtherCriminals = rbiObjectFactory.createCompensationPaid(CompensationPaidTypeForOtherCriminals);
        bodyItems.add(CompensationPaidOtherCriminals);
        // create ActionTaken
        ActionTaken actionTakenType = new ActionTaken();
        actionTakenType.setContextRef(fromToContextForBranch);
        actionTakenType.setValue(fmrItemData.getActionTaken());
        JAXBElement<ActionTaken> actionTaken = rbiObjectFactory.createActionTaken(actionTakenType);
        bodyItems.add(actionTaken);
        // create CrimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered
        StringItemType crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegisteredType = new StringItemType();
        crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegisteredType.setContextRef(fromToContextForBranch);
        crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegisteredType.setValue(fmrItemData.getCrimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered());
        JAXBElement<StringItemType> crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered =  rbiObjectFactory.createCrimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered(crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegisteredType);
        bodyItems.add(crimeNumberAndNameOfPoliceStationAtWhichOffenceIsegistered);
        // create TextBlockItemType
        TextBlockItemType textBlockItem = new TextBlockItemType();
        textBlockItem.setContextRef(fromToContextForBranch);
        textBlockItem.setValue(fmrItemData.getModusOperandi());
        JAXBElement<TextBlockItemType> modusOperandi = rbiObjectFactory.createModusOperandi(textBlockItem);
        bodyItems.add(modusOperandi);

        return bodyItems;
    }    
    
}