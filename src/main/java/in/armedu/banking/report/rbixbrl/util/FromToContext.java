package in.armedu.banking.report.rbixbrl.util;

import org.apache.commons.lang3.StringUtils;

public class FromToContext {
    public static String getId(String type, String... args) {
        StringBuilder generateId = new StringBuilder(StringUtils.defaultIfEmpty(type, "fromto"));
        for (String arg : args) {
            if(arg == null || arg.isEmpty()) continue;
            String argValue = arg.replaceAll("[()\\s-.:]+", "");
            generateId.append("_" + argValue);
        }
        return generateId.toString();
    }
}
