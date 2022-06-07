package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class  RLCUtil {

    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";
    public static final String ASOFLASTDATE = "asoflastdate";
    public static final String FROMTOGLOBALINDIVIDUALMEMBER = "fromtoglobalindividualmember";
    public static final String ASOFGLOBALINDIVIDUALMEMBER = "asofglobalindividualmember";
    public static final String FROMTOGLOBALBORROWERGROUP = "fromtoglobalborrowergroup";
    public static final String ASOFGLOBALBORROWERGROUP= "asofglobalborrowergroup";
    public static final String FROMTODOMESTICCOUNTERPARTY = "fromtodomesticcounterparty";
    public static final String ASOFDOMESTICCOUNTERPARTY = "asofdomesticcounterparty";
    public static final String FROMTOGLOBALCOUNTERPARTY = "fromtoglobalcounterparty";
    public static final String ASOFGLOBALCOUNTERPARTY = "asofglobalcounterparty";
    public static final String CURRENCY = "currency";
    public static final String PERCENTAGE = "percentage";


}
