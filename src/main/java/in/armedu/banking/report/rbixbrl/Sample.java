package in.armedu.banking.report.rbixbrl;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2003.xlink.SimpleType;

import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;

public class Sample {

    private static final String CONTEXT_ID = "Msg";
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
        Sample xbrlHelper = new Sample();
        xbrlHelper.createTestXbrlInstance();
    }

    private void createTestXbrlInstance() {

        createXbrlInstance();
    }
}
