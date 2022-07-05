package in.armedu.banking.report.rbixbrl.part.vmr.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.IntegerItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class VMRBody implements BodyInterface    {
    
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        
        VMRGeneralData vmrGeneralData = (VMRGeneralData) generalData;
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(VMRUtil.FROMTO);
        Context asOfContext = contexts.get(VMRUtil.ASOF);

        Unit percentage = units.get(VMRUtil.PERCENTAGE);
     

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create TotalNumberOfBranchesIncludingExtensionCounters
        IntegerItemType totalNumberOfBranchesIncludingExtensionCountersType = new IntegerItemType();
        totalNumberOfBranchesIncludingExtensionCountersType.setContextRef(asOfContext);
        totalNumberOfBranchesIncludingExtensionCountersType.setDecimals("INF");
        totalNumberOfBranchesIncludingExtensionCountersType.setUnitRef(percentage);
        totalNumberOfBranchesIncludingExtensionCountersType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getTotalNumberOfBranchesIncludingExtensionCounters()));
        JAXBElement<IntegerItemType> totalNumberOfBranchesIncludingExtensionCounters = rbiObjectFactory.createTotalNumberOfBranchesIncludingExtensionCounters(totalNumberOfBranchesIncludingExtensionCountersType);
        generalItems.add(totalNumberOfBranchesIncludingExtensionCounters);

        // create highRiskVulnerabilityBranches
        IntegerItemType highRiskVulnerabilityBranchesType = new IntegerItemType();
        highRiskVulnerabilityBranchesType.setContextRef(asOfContext);
        highRiskVulnerabilityBranchesType.setDecimals("INF");
        highRiskVulnerabilityBranchesType.setUnitRef(percentage);
        highRiskVulnerabilityBranchesType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getHighRiskVulnerabilityBranches()));
        JAXBElement<IntegerItemType> highRiskVulnerabilityBranches = rbiObjectFactory.createHighRiskVulnerabilityBranches(highRiskVulnerabilityBranchesType);
        generalItems.add(highRiskVulnerabilityBranches);

        // create normalRiskVulnerabilityBranches
        IntegerItemType normalRiskVulnerabilityBranchesType = new IntegerItemType();
        normalRiskVulnerabilityBranchesType.setContextRef(asOfContext);
        normalRiskVulnerabilityBranchesType.setDecimals("INF");
        normalRiskVulnerabilityBranchesType.setUnitRef(percentage);
        normalRiskVulnerabilityBranchesType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getNormalRiskVulnerabilityBranches()));
        JAXBElement<IntegerItemType> normalRiskVulnerabilityBranches = rbiObjectFactory.createNormalRiskVulnerabilityBranches(normalRiskVulnerabilityBranchesType);
        generalItems.add(normalRiskVulnerabilityBranches);

        // create totalNumberOfVulnerableBranches
        IntegerItemType totalNumberOfVulnerableBranchesType = new IntegerItemType();
        totalNumberOfVulnerableBranchesType.setContextRef(asOfContext);
        totalNumberOfVulnerableBranchesType.setDecimals("INF");
        totalNumberOfVulnerableBranchesType.setUnitRef(percentage);
        totalNumberOfVulnerableBranchesType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getTotalNumberOfVulnerableBranches()));
        JAXBElement<IntegerItemType> totalNumberOfVulnerableBranches = rbiObjectFactory.createTotalNumberOfVulnerableBranches(totalNumberOfVulnerableBranchesType);
        generalItems.add(totalNumberOfVulnerableBranches);

        // create armedGuards
        IntegerItemType armedGuardsType = new IntegerItemType();
        armedGuardsType.setContextRef(asOfContext);
        armedGuardsType.setDecimals("INF");
        armedGuardsType.setUnitRef(percentage);
        armedGuardsType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getArmedGuards()));
        JAXBElement<IntegerItemType> armedGuards = rbiObjectFactory.createArmedGuards(armedGuardsType);
        generalItems.add(armedGuards);

        // create unArmedGuards
        IntegerItemType unArmedGuardsType = new IntegerItemType();
        unArmedGuardsType.setContextRef(asOfContext);
        unArmedGuardsType.setDecimals("INF");
        unArmedGuardsType.setUnitRef(percentage);
        unArmedGuardsType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getUnArmedGuards()));
        JAXBElement<IntegerItemType> unArmedGuards = rbiObjectFactory.createUnArmedGuards(unArmedGuardsType);
        generalItems.add(unArmedGuards);

        // create numberOfBranchesInWhichAlarmSystemHasBeenProvided
        IntegerItemType numberOfBranchesInWhichAlarmSystemHasBeenProvidedType = new IntegerItemType();
        numberOfBranchesInWhichAlarmSystemHasBeenProvidedType.setContextRef(asOfContext);
        numberOfBranchesInWhichAlarmSystemHasBeenProvidedType.setDecimals("INF");
        numberOfBranchesInWhichAlarmSystemHasBeenProvidedType.setUnitRef(percentage);
        numberOfBranchesInWhichAlarmSystemHasBeenProvidedType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getNumberOfBranchesInWhichAlarmSystemHasBeenProvided()));
        JAXBElement<IntegerItemType> numberOfBranchesInWhichAlarmSystemHasBeenProvided = rbiObjectFactory.createNumberOfBranchesInWhichAlarmSystemHasBeenProvided(numberOfBranchesInWhichAlarmSystemHasBeenProvidedType);
        generalItems.add(numberOfBranchesInWhichAlarmSystemHasBeenProvided);

        // create collapsibleDoorsAndShuttersAtTheMainEntrance
        IntegerItemType collapsibleDoorsAndShuttersAtTheMainEntranceType = new IntegerItemType();
        collapsibleDoorsAndShuttersAtTheMainEntranceType.setContextRef(asOfContext);
        collapsibleDoorsAndShuttersAtTheMainEntranceType.setDecimals("INF");
        collapsibleDoorsAndShuttersAtTheMainEntranceType.setUnitRef(percentage);
        collapsibleDoorsAndShuttersAtTheMainEntranceType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getCollapsibleDoorsAndShuttersAtTheMainEntrance()));
        JAXBElement<IntegerItemType> collapsibleDoorsAndShuttersAtTheMainEntrance = rbiObjectFactory.createCollapsibleDoorsAndShuttersAtTheMainEntrance(collapsibleDoorsAndShuttersAtTheMainEntranceType);
        generalItems.add(collapsibleDoorsAndShuttersAtTheMainEntrance);

        // create nightLatchesAutoLockToCashiersCabins
        IntegerItemType nightLatchesAutoLockToCashiersCabinsType = new IntegerItemType();
        nightLatchesAutoLockToCashiersCabinsType.setContextRef(asOfContext);
        nightLatchesAutoLockToCashiersCabinsType.setDecimals("INF");
        nightLatchesAutoLockToCashiersCabinsType.setUnitRef(percentage);
        nightLatchesAutoLockToCashiersCabinsType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getNightLatchesAutoLockToCashiersCabins()));
        JAXBElement<IntegerItemType> nightLatchesAutoLockToCashiersCabins = rbiObjectFactory.createNightLatchesAutoLockToCashiersCabins(nightLatchesAutoLockToCashiersCabinsType);
        generalItems.add(nightLatchesAutoLockToCashiersCabins);

        // create grillGatesToStrongRooms
        IntegerItemType grillGatesToStrongRoomsType = new IntegerItemType();
        grillGatesToStrongRoomsType.setContextRef(asOfContext);
        grillGatesToStrongRoomsType.setDecimals("INF");
        grillGatesToStrongRoomsType.setUnitRef(percentage);
        grillGatesToStrongRoomsType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getGrillGatesToStrongRooms()));
        JAXBElement<IntegerItemType> grillGatesToStrongRooms = rbiObjectFactory.createGrillGatesToStrongRooms(grillGatesToStrongRoomsType);
        generalItems.add(grillGatesToStrongRooms);

        // create cashVansForRemittanceOfCash
        IntegerItemType cashVansForRemittanceOfCashType = new IntegerItemType();
        cashVansForRemittanceOfCashType.setContextRef(asOfContext);
        cashVansForRemittanceOfCashType.setDecimals("INF");
        cashVansForRemittanceOfCashType.setUnitRef(percentage);
        cashVansForRemittanceOfCashType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getCashVansForRemittanceOfCash()));
        JAXBElement<IntegerItemType> cashVansForRemittanceOfCash = rbiObjectFactory.createCashVansForRemittanceOfCash(cashVansForRemittanceOfCashType);
        generalItems.add(cashVansForRemittanceOfCash);

        // create armouredCashVans
        IntegerItemType armouredCashVansType = new IntegerItemType();
        armouredCashVansType.setContextRef(asOfContext);
        armouredCashVansType.setDecimals("INF");
        armouredCashVansType.setUnitRef(percentage);
        armouredCashVansType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getArmouredCashVans()));
        JAXBElement<IntegerItemType> armouredCashVans = rbiObjectFactory.createArmouredCashVans(armouredCashVansType);
        generalItems.add(armouredCashVans);


        // create closedCircuitTVs
        IntegerItemType closedCircuitTVsType = new IntegerItemType();
        closedCircuitTVsType.setContextRef(asOfContext);
        closedCircuitTVsType.setDecimals("INF");
        closedCircuitTVsType.setUnitRef(percentage);
        closedCircuitTVsType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getClosedCircuitTVs()));
        JAXBElement<IntegerItemType> closedCircuitTVs = rbiObjectFactory.createClosedCircuitTVs(closedCircuitTVsType);
        generalItems.add(closedCircuitTVs);

        // create timeLockDevices
        IntegerItemType timeLockDevicesType = new IntegerItemType();
        timeLockDevicesType.setContextRef(asOfContext);
        timeLockDevicesType.setDecimals("INF");
        timeLockDevicesType.setUnitRef(percentage);
        timeLockDevicesType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getTimeLockDevices()));
        JAXBElement<IntegerItemType> timeLockDevices = rbiObjectFactory.createTimeLockDevices(timeLockDevicesType);
        generalItems.add(timeLockDevices);

        // create policeArmedGuardsProvided
        IntegerItemType policeArmedGuardsProvidedType = new IntegerItemType();
        policeArmedGuardsProvidedType.setContextRef(asOfContext);
        policeArmedGuardsProvidedType.setDecimals("INF");
        policeArmedGuardsProvidedType.setUnitRef(percentage);
        policeArmedGuardsProvidedType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getPoliceArmedGuardsProvided()));
        JAXBElement<IntegerItemType> policeArmedGuardsProvided = rbiObjectFactory.createPoliceArmedGuardsProvided(policeArmedGuardsProvidedType);
        generalItems.add(policeArmedGuardsProvided);

        // create currencyChestsProvidedWithHotLineTelephone
        IntegerItemType currencyChestsProvidedWithHotLineTelephoneType = new IntegerItemType();
        currencyChestsProvidedWithHotLineTelephoneType.setContextRef(asOfContext);
        currencyChestsProvidedWithHotLineTelephoneType.setDecimals("INF");
        currencyChestsProvidedWithHotLineTelephoneType.setUnitRef(percentage);
        currencyChestsProvidedWithHotLineTelephoneType.setValue(new BigInteger(vmrGeneralData.getVmrGeneralInfo().getCurrencyChestsProvidedWithHotLineTelephone()));
        JAXBElement<IntegerItemType> currencyChestsProvidedWithHotLineTelephone = rbiObjectFactory.createCurrencyChestsProvidedWithHotLineTelephone(currencyChestsProvidedWithHotLineTelephoneType);
        generalItems.add(currencyChestsProvidedWithHotLineTelephone);

        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }


}
