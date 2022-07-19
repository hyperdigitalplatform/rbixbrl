package in.armedu.banking.report.rbixbrl.util;

import java.util.Collection;
import org.apache.commons.lang3.StringUtils;

public class ContextUtil {
    
    public static String getIdForFromTo(String type, String startDate, String endDate, Collection<String>  collections, String... args) {
        StringBuilder generateId = new StringBuilder(StringUtils.defaultIfEmpty(type, "fromto"));
        generateId.append("_" + startDate.replaceAll("[()\\s-.:]+", ""));
        generateId.append("_" + endDate.replaceAll("[()\\s-.:]+", ""));
        collections.forEach(item->{
            generateId.append("_" + item);
        });
        for (String arg : args) {
            if(arg == null || arg.isEmpty()) continue;
            String argValue = arg.replaceAll("[()\\s-.:]+", "");
            generateId.append("_" + argValue);
        }
        return generateId.toString();
    }
    public static String getIdForAsOf(String type, String periodDate, Collection<String>  collections, String... args) {
        StringBuilder generateId = new StringBuilder(StringUtils.defaultIfEmpty(type, "asof"));
        generateId.append("_" + periodDate.replaceAll("[()\\s-.:]+", ""));
        collections.forEach(item->{
            generateId.append("_" + item);
        });
        for (String arg : args) {
            if(arg == null || arg.isEmpty()) continue;
            String argValue = arg.replaceAll("[()\\s-.:]+", "");
            generateId.append("_" + argValue);
        }
        return generateId.toString();
    }
    
}
