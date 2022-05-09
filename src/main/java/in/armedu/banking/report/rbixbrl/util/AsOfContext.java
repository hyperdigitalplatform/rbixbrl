package in.armedu.banking.report.rbixbrl.util;

import org.apache.commons.lang3.StringUtils;

public class AsOfContext {
    public static String getId(String type, String... args) {
        StringBuilder generateId = new StringBuilder(StringUtils.defaultIfEmpty(type, "asof"));
        for (String arg : args) {
            generateId.append("_" + arg);
        }
        return generateId.toString();
    }
}
