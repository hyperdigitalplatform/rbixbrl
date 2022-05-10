package in.armedu.banking.report.rbixbrl.part.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AreaOfOperationOfRelatedPartyItemTypeROS;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl.dtr.type.non_numeric.DomainItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ROSItem;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;


public class ROSBody implements BodyIntf {

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralInfoData generalInfoData) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext,   GeneralInfoData generalInfoData) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralInfoData generalInfoData, ROSItem rosItem) {
        return getReportBodyItemOnlyForFromToAndASOF(contexts.get(0), contexts.get(1), generalInfoData, rosItem);
    }

    @Override
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext,  GeneralInfoData generalInfoData, ROSItem rosItem) {
        
        List<Object> bodyItems = new ArrayList<Object>();
        
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
            // create subsidiary category
        DomainItemType domainItemType = new DomainItemType();
        domainItemType.setContextRef(fromToContext);
        domainItemType.setValue(rosItem.getSubsidiaryInfo().getCategory());
        JAXBElement<DomainItemType> subsidiaryCategory = rbiObjectFactory.createSubsidiaryJointVentureAssociateMember(domainItemType);
        bodyItems.add(subsidiaryCategory);
        
        // create AreaOfOperationOfRelatedParty
        AreaOfOperationOfRelatedPartyItemTypeROS relatedPartyType = new AreaOfOperationOfRelatedPartyItemTypeROS();
        relatedPartyType.setContextRef(fromToContext);
        relatedPartyType.setValue(rosItem.getSubsidiaryInfo().getAreaOfOperations());
        JAXBElement<AreaOfOperationOfRelatedPartyItemTypeROS> relatedParty = rbiObjectFactory.createAreaOfOperationOfRelatedParty(relatedPartyType);
        bodyItems.add(relatedParty);
        // create SubsidiaryAssociateJointVentureCode
        StringItemType ventureCodeType = new StringItemType();
        ventureCodeType.setContextRef(fromToContext);
        ventureCodeType.setValue(rosItem.getSubsidiaryInfo().getSubsidiaryCode());
        JAXBElement<StringItemType> ventureCode = rbiObjectFactory.createSubsidiaryAssociateJointVentureCode(ventureCodeType);      
        bodyItems.add(ventureCode);

        return bodyItems;
    }

}
