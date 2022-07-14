package in.armedu.banking.report.rbixbrl.util;

public class CommonFns {
    public static String getDecimals(String amount){
        int trailingZeros = String.valueOf(amount).chars()
        .reduce(0, (count, ch) -> (ch == '0') ? count + 1 : 0);
        if(trailingZeros >= 5) {
            return "-5";
        } else if (trailingZeros >=3 ) {
            return "-3";
        } else {
            return "0";     
        }        
    }
    public static String getDecimals(String amount, String scaleMeasures){
        int trailingZeros = String.valueOf(amount).chars()
        .reduce(0, (count, ch) -> (ch == '0') ? count + 1 : 0);
        int trailingZerosScaleMeasures = String.valueOf(scaleMeasures).chars()
        .reduce(0, (count, ch) -> (ch == '0') ? count + 1 : 0);
        
        if(trailingZeros >= trailingZerosScaleMeasures) {
            return String.format("-%d", trailingZerosScaleMeasures);
        } else if (trailingZeros >=(trailingZerosScaleMeasures-2) ) {
            return String.format("-%d", (trailingZerosScaleMeasures-2));
        } else {
            return "0";     
        }        
    }
    public static String getPrecisions(String amount) {
        String[] splits= amount.split("\\.");
        if(splits.length > 1)
            return String.valueOf(splits[1].length());
        return "0";
    }
    

    // public static void main(String[] args) {
    //     int count = 0;
    //     count = CommonFns.getDecimals("123");
    //     System.out.println("1 . "+count);
    //     count = CommonFns.getDecimals("1230");
    //     System.out.println("2 . "+count);
    //     count = CommonFns.getDecimals("12300");
    //     System.out.println("3 . "+count);
    //     count = CommonFns.getDecimals("123000");
    //     System.out.println("4 . "+count);
    //     count = CommonFns.getDecimals("12300000");
    //     System.out.println("5 . "+count);
    //     count = CommonFns.getDecimals("123000000000");
    //     System.out.println("6 . "+count);
    // }
}
