package in.armedu.banking.report.rbixbrl;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCReportData;

public class RLCXBRLApplication {
    public static void main(String[] args) throws Exception {
        RLCReportData data = new RLCReportData();

        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        engine.execute(ReportGenerationFactory.RBI_RLC_XBRL_REPORT, data);
        
    }
    
}
