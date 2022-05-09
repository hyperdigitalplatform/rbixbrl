package in.armedu.banking.report.rbixbrl.util;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link NamespacePrefixMapper} that maps the schema
 * namespaces more to readable names. Used by the jaxb marshaller. Requires
 * setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
 * of this class.
 * <p>
 * Requires dependency on JAXB implementation jars
 * </p>
 */
public class DefaultNamespacePrefixMapper extends NamespacePrefixMapper {

    private Map<String, String> namespaceMap = new HashMap<>();

    /**
     * Create mappings.
     */
    public DefaultNamespacePrefixMapper() {
        namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        namespaceMap.put("http://www.w3.org/2003/05/soap-envelope/", "soap");
        namespaceMap.put("http://www.xbrl.org/2003/instance", "xbrli");
        namespaceMap.put("http://www.xbrl.org/2003/linkbase", "link");
        namespaceMap.put("http://www.w3.org/1999/xlink", "xlink");
        namespaceMap.put("http://www.xbrl.org/2003/XLink", "xl");
        namespaceMap.put("http://www.rbi.org/in/xbrl/2013-01-11/rbi/ros/role", "ros");
        namespaceMap.put("http://www.rbi.org/in/xbrl/2013-01-11/rbi/ros", "in-rbi-ros");
        namespaceMap.put(
                "http://www.rbi.org/in/xbrl/2012-04-25/rbi",
                "in-rbi-rep");
        namespaceMap.put("http://xbrl.org/2006/xbrldi", "xbrldi");
        namespaceMap.put("http://xbrl.org/2005/xbrldt", "xbrldt");
        namespaceMap.put("http://www.rbi.org/in-rbi-rep-par", "in-rbi-rep-par");
        
    }

    /*
     * (non-Javadoc)
     * Returning null when not found based on spec.
     * 
     * @see
     * com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.
     * lang.String, java.lang.String, boolean)
     */
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}