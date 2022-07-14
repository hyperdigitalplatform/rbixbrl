package in.armedu.banking.report.rbixbrl.reports;

// import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCBody;
// import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralBody;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCGeneralContext;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSBody;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSGeneralBody;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSGeneralContext;
import in.armedu.banking.report.rbixbrl.part.ros.impl.ROSUnit;
import in.armedu.banking.report.rbixbrl.reports.impl.RBICPRXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIFMRXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIRLCXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIROSXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIALOXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBICEMXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIPCIXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIROPXBRLReportImpl;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIVMRXBRLReportImpl;

public class XBRLReportBuilder {
    public XBRLReportIntf buildROSReport(){
        RBIROSXBRLReportImpl report = new RBIROSXBRLReportImpl();
        report.setContextIntf(new ROSGeneralContext());
        report.setRosUnits(new ROSUnit());
        report.setRosGeneralBody(new ROSGeneralBody());
        report.setRosBody(new ROSBody());
        return report;
    }
    public XBRLReportIntf buildRLCReport(){
         RBIRLCXBRLReportImpl report = new RBIRLCXBRLReportImpl();
        // report.setContextIntf(new RLCGeneralContext());
        // report.setRlcUnits(new RLCUnit());
        // report.setRlcGeneralBody(new RLCGeneralBody());
        // report.setRlcBody(new RLCBody());
       return report;
    }
    public XBRLReportIntf buildCPRReport(){
        RBICPRXBRLReportImpl report = new RBICPRXBRLReportImpl();
        // report.setContextIntf(new CPRGeneralContext());
        // report.setUnits(new CPRUnit());
        // report.setGeneralBody(new CPRGeneralBody());
        // report.setBody(new CPRBodyForIndividual());
        return report;
    }
    public XBRLReportIntf buildFMRReport(){
        RBIFMRXBRLReportImpl report = new RBIFMRXBRLReportImpl();
        return report;
    }
    public XBRLReportIntf buildALOReport(){
        RBIALOXBRLReportImpl report = new RBIALOXBRLReportImpl();
        return report;
    }
    public XBRLReportIntf buildCEMReport(){
        RBICEMXBRLReportImpl report = new RBICEMXBRLReportImpl();
        return report;
    }
    public XBRLReportIntf buildPCIReport(){
        RBIPCIXBRLReportImpl report = new RBIPCIXBRLReportImpl();
        return report;
    }
    public XBRLReportIntf buildROPReport(){
        RBIROPXBRLReportImpl report = new RBIROPXBRLReportImpl();
        return report;
    }
    public XBRLReportIntf buildVMRReport(){
        RBIVMRXBRLReportImpl report = new RBIVMRXBRLReportImpl();
        return report;
    }
}
