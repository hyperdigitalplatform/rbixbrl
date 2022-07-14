package in.armedu.banking.report.rbixbrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2003.linkbase.Linkbase;
import org.xbrl._2003.xlink.SimpleType;

import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.databind.ObjectMapper;   


@Getter
@Setter
class ReportMetaDataNode {
    private String name;
    private String value;
    private List<Object> attributes = new ArrayList<Object>();
    private List<Object> extras = new ArrayList<Object>();
    private List<ReportMetaDataNode> childNodes = new ArrayList<ReportMetaDataNode>();
}

public class Sample {
    
    private static final String CONTEXT_ID = "Msg";
    private static Document xmlScaleDocument;
    // private static final String ISO_EURO = "iso4217:EUR";
    // private static final String UNIT_ID = "u0";
    // private static final String DECIMALS_TYPE = "INF";
    // private static final String PACKAGE_NAME = "TechyTax";
    // private static final String BELASTING_PLICHTIGE = "BPL";

    public static String createXbrlInstance() {
        ObjectFactory xbrlObjectFactory;
        JAXBContext jc;
        Marshaller m;
        try {

            xbrlObjectFactory = new ObjectFactory();
            jc = JAXBContext.newInstance(ObjectFactory.class,
                    org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ObjectFactory.class,
                    org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory.class,
                    org.rbi.in_rbi_rep_par.ObjectFactory.class,
                    org.xbrl._2003.xlink.ObjectFactory.class,
                    org.xbrl._2003.instance.ObjectFactory.class,

                    org.xbrl._2003.linkbase.ObjectFactory.class,
                    org.xbrl._2005.xbrldt.ObjectFactory.class,
                    org.xbrl.dtr.type.non_numeric.ObjectFactory.class,
                    org.xbrl.dtr.type.numeric.ObjectFactory.class);

            m = jc.createMarshaller();
            StringWriter writer = new StringWriter();

            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
            Xbrl xbrl = xbrlObjectFactory.createXbrl();

            org.xbrl._2003.xlink.ObjectFactory xlinkObjectFactory = new org.xbrl._2003.xlink.ObjectFactory();
            SimpleType simpleType = xlinkObjectFactory.createSimpleType();
            simpleType.setType("simple");
            simpleType.setHref("in-rbi-ros.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
            // global variables for ROS report
            ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
            Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
            // identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
            // set entity identifier aka bank code
            identifier.setValue("600");
            contextEntityType.setIdentifier(identifier);
            // create specific variable sensitive to block
            Context context = xbrlObjectFactory.createContext();
            context.setId(CONTEXT_ID);

            ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
            period.setStartDate("2021-04-01");
            period.setEndDate("2021-09-30");

            context.setEntity(contextEntityType);
            context.setPeriod(period);
            xbrl.getItemOrTupleOrContext().add(context);

            // as of context set instant
            Context contextAsOf = xbrlObjectFactory.createContext();
            contextAsOf.setId(CONTEXT_ID);

            ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
            periodInstant.setInstant("2021-09-30");
            contextEntityType.setIdentifier(identifier);
            contextAsOf.setEntity(contextEntityType);
            contextAsOf.setPeriod(periodInstant);
            xbrl.getItemOrTupleOrContext().add(contextAsOf);

            m.marshal(xbrl, writer);
            System.out.println("");
            System.out.println(writer.toString());
            return writer.toString();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    public static void main(String[] args) throws Exception {
        ReportMetaDataNode metaDataNode = new ReportMetaDataNode();
        metaDataNode.setName("linkbase");
        FileInputStream fileIS = new FileInputStream("src/main/resources/xsd/in/xbrl/2012-04-25/rbi/alo/alo-table.xml");
        FileInputStream filescale = new FileInputStream("src/main/resources/xsd/in/xbrl/2012-04-25/rbi/alo/alo-table-Scale.xml");
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(fileIS);
        xmlScaleDocument = builder.parse(filescale);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/linkbase/roleRef/@roleURI";
        
        NodeList nodeList = (NodeList) getNodes(xmlDocument, expression);
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            ReportMetaDataNode roleMetaDataNode = createReportMetaDataNode(node);
            metaDataNode.getChildNodes().add(roleMetaDataNode);
            System.out.printf("roleRef %s\n", node.getNodeValue());
            
            NodeList breakdownList = getNodes(xmlDocument, String.format("/linkbase/link[@role='%s']/table/@label", node.getNodeValue()));
            for(int j = 0; j < breakdownList.getLength(); j++){
                ReportMetaDataNode tableMetaDataNode = createReportMetaDataNode(breakdownList.item(j));
                roleMetaDataNode.getChildNodes().add(tableMetaDataNode);
                System.out.printf("table %s\n", breakdownList.item(j));
                NodeList tableBreakdownList = getNodes(xmlDocument, String.format("/linkbase/link[@role='%s']/tableBreakdownArc[@from='%s']", node.getNodeValue(), breakdownList.item(j).getNodeValue()));
                for(int k = 0; k < tableBreakdownList.getLength(); k++){
                    ReportMetaDataNode tableBreakDownMetaDataNode = createReportMetaDataNode(tableBreakdownList.item(k));
                    tableMetaDataNode.getChildNodes().add(tableBreakDownMetaDataNode);
                    System.out.printf("tableBreakdown %s , %s  , %s\n", tableBreakdownList.item(k).getAttributes().getNamedItem("xlink:from"), tableBreakdownList.item(k).getAttributes().getNamedItem("xlink:to"),tableBreakdownList.item(k).getAttributes().getNamedItem("axis"));
                    Node treeNode = getNodes(xmlDocument, String.format("/linkbase/link[@role='%s']/breakdownTreeArc[@from='%s']", node.getNodeValue(), tableBreakdownList.item(k).getAttributes().getNamedItem("xlink:to").getNodeValue())).item(0);
                    ReportMetaDataNode breakDownTreeMetaDataNode = createReportMetaDataNode(treeNode);
                    tableBreakDownMetaDataNode.getChildNodes().add(breakDownTreeMetaDataNode);
                    System.out.printf("breakdownTreeArc %s , %s  \n", treeNode.getAttributes().getNamedItem("xlink:from"), treeNode.getAttributes().getNamedItem("xlink:to"));
                    //if(tableBreakdownList.item(k).getAttributes().getNamedItem("axis").getNodeValue().equalsIgnoreCase("y") ){
                    getDefinitionNodesTree(xmlDocument, node, treeNode.getAttributes().getNamedItem("xlink:to").getNodeValue(), breakDownTreeMetaDataNode);
                    getAspectNodesTree(xmlDocument, node, treeNode.getAttributes().getNamedItem("xlink:to").getNodeValue(), breakDownTreeMetaDataNode);  
                }
            }
            System.out.println("");            
        }
        System.out.println("Completed");
        ObjectMapper objectMapper = new ObjectMapper();
        String reportMetaDataJson = objectMapper.writeValueAsString(metaDataNode);
        objectMapper.writeValue(new File("reportMetaDataNode.json"), metaDataNode);
        System.out.println(reportMetaDataJson);
    }

    public static NodeList getDefinitionNodesTree(Document xmlDoc, Node linkNode, String fromNodeName, ReportMetaDataNode breakDownTreeMetaDataNode) throws XPathExpressionException {
        NodeList definitionNodeSubtree = getNodes(xmlDoc, 
            String.format("/linkbase/link[@role='%s']/definitionNodeSubtreeArc[@from='%s']", linkNode.getNodeValue(), fromNodeName));
            for(int l = 0; l < definitionNodeSubtree.getLength(); l++){
                ReportMetaDataNode defNodeSubtreeMetaDataNode = createReportMetaDataNode(definitionNodeSubtree.item(l));
                breakDownTreeMetaDataNode.getChildNodes().add(defNodeSubtreeMetaDataNode);
                System.out.printf("definitionNodeSubtree %s , %s  \n", definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:from"), definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to"));
                //NodeList ruleNodeList = getNodes(xmlDoc, String.format("/linkbase/link[@role='%s']/ruleNode[@label='%s']//*", linkNode.getNodeValue(), definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue()));
                Node ruleNodeForExplicitMember = getNodes(xmlDoc, String.format("/linkbase/link[@role='%s']/ruleNode[@label='%s']", linkNode.getNodeValue(), definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue())).item(0);
                ReportMetaDataNode ruleNodeMetaDataNode = createRuleNodeAndChildMetaData(ruleNodeForExplicitMember);
                defNodeSubtreeMetaDataNode.getChildNodes().add(ruleNodeMetaDataNode);
                getDefinitionNodesTree(xmlDoc, linkNode,  definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue(), ruleNodeMetaDataNode);
            }
        return null;
    }
    
    public static NodeList getAspectNodesTree(Document xmlDoc, Node linkNode, String fromNodeName, ReportMetaDataNode breakDownTreeMetaDataNode) throws XPathExpressionException {
        NodeList aspectNodeSubtree = getNodes(xmlDoc, 
            String.format("/linkbase/link[@role='%s']/aspectNode[@label='%s']", linkNode.getNodeValue(), fromNodeName));
            for(int l = 0; l < aspectNodeSubtree.getLength(); l++){
                ReportMetaDataNode aspectNodeSubtreeMetaDataNode = createRuleNodeAndChildMetaData(aspectNodeSubtree.item(l));
                breakDownTreeMetaDataNode.getChildNodes().add(aspectNodeSubtreeMetaDataNode);
                System.out.printf("aspectnNodeSubtree %s  \n", aspectNodeSubtree.item(l).getAttributes().getNamedItem("xlink:label"));
                //NodeList ruleNodeList = getNodes(xmlDoc, String.format("/linkbase/link[@role='%s']/ruleNode[@label='%s']//*", linkNode.getNodeValue(), definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue()));
                // for(int j =0; j < aspectNodeSubtree.item(l).getChildNodes().getLength(); j++){
                //     Node ruleNodeForExplicitMember = aspectNodeSubtree.item(l).getChildNodes().item(j);
                //     //Node ruleNodeForExplicitMember = getNodes(xmlDoc, String.format("/linkbase/link[@role='%s']/ruleNode[@label='%s']", linkNode.getNodeValue(), definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue())).item(0);
                //     ReportMetaDataNode ruleNodeMetaDataNode = createRuleNodeAndChildMetaData(ruleNodeForExplicitMember);
                //     aspectNodeSubtreeMetaDataNode.getChildNodes().add(ruleNodeMetaDataNode);
                //     //getDefinitionNodesTree(xmlDoc, linkNode,  definitionNodeSubtree.item(l).getAttributes().getNamedItem("xlink:to").getNodeValue(), ruleNodeMetaDataNode);
                // }
            }
        return null;
    }

    public static NodeList getNodes(Document xmlDoc, String expression) throws XPathExpressionException{
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPath.compile(expression);
        NodeList nodeList = (NodeList) expr.evaluate(xmlDoc, XPathConstants.NODESET);
        return nodeList;
    }
    public static String getFieldName(Node ruleNode){
        if(ruleNode != null && ruleNode.getNodeValue() != null && !ruleNode.getNodeValue().trim().isEmpty()){
            return ruleNode.getNodeValue().split(":")[1];
        } else if (ruleNode != null && !ruleNode.getTextContent().trim().isEmpty()){
            return ruleNode.getTextContent().split(":")[1];
        }
        return null;
    }
    public static ReportMetaDataNode createRuleNodeAndChildMetaData(Node node) throws XPathExpressionException{
        ReportMetaDataNode metaDataNode = new ReportMetaDataNode();
        metaDataNode.setName(node.getNodeName());
        
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            for(int i = 0 ; node.hasAttributes()  && i < node.getAttributes().getLength(); i++){
                metaDataNode.getAttributes().add(createReportMetaDataAttributeNode(node.getAttributes().item(i)));
            }
            enrichRuleNodeWithScales(metaDataNode);
            for(int k = 0 ; node.hasChildNodes()  && k < node.getChildNodes().getLength(); k++){
                if(node.getChildNodes().item(k).getNodeName().equalsIgnoreCase("#text") && node.getChildNodes().item(k).getTextContent().trim().isEmpty()) continue;
                metaDataNode.getChildNodes().add(createRuleNodeAndChildMetaData(node.getChildNodes().item(k)));
            }
        } else {
            if(node.getNodeValue() != null ) {
                metaDataNode.setValue(node.getNodeValue().trim());
            } else {
                metaDataNode.setValue(node.getTextContent().trim());
            }
        }
        return metaDataNode; 
        
    }
    public static ReportMetaDataNode createReportMetaDataNode(Node node) throws XPathExpressionException{
        ReportMetaDataNode metadDataNode = new ReportMetaDataNode();
        metadDataNode.setName(node.getNodeName());
        if(node.getNodeValue() != null ) {
            metadDataNode.setValue(node.getNodeValue());
        } else {
            metadDataNode.setValue(node.getTextContent().trim());
        }
                
        for(int i = 0 ; node.hasAttributes() && i < node.getAttributes().getLength(); i++){
            metadDataNode.getAttributes().add(createReportMetaDataAttributeNode(node.getAttributes().item(i)));
        }
        return metadDataNode;  
    }
    public static ReportMetaDataNode createReportMetaDataAttributeNode(Node node) throws XPathExpressionException{
        ReportMetaDataNode metadDataNode = new ReportMetaDataNode();
        metadDataNode.setName(node.getNodeName());
        metadDataNode.setValue(node.getNodeValue());
    
        return metadDataNode; 
        
    }
    public static ReportMetaDataNode enrichRuleNodeWithScales(ReportMetaDataNode metaDataNode) throws XPathExpressionException {
        ReportMetaDataNode attributesItem = (ReportMetaDataNode) metaDataNode.getAttributes().stream()
            .filter(att -> "id".equals(((ReportMetaDataNode)att).getName()))
            .findAny()
            .orElse(null);

        if(attributesItem != null) {
            NodeList scaleNodeList = getNodes(xmlScaleDocument, 
            String.format("/ScalesForElelments/Scale[@RuleNodeId='%s']", attributesItem.getValue() ));
            if(scaleNodeList.getLength() == 1){
                Node node = scaleNodeList.item(0);
                for(int i = 0 ; node.hasAttributes() && i < node.getAttributes().getLength(); i++){
                    metaDataNode.getAttributes().add(createReportMetaDataAttributeNode(node.getAttributes().item(i)));
                }            
            }
        }
        
        return metaDataNode;
    }
    
}
