package org.ieee.ltsc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, Date> {
    
    /* 
     * Zie ook: http://wiki.surffoundation.nl/display/nllom/datetime 
     * 
     * De implementatie is verre van perfect (timezone issues) ...
     * maar jaar/maand/dag wordt in ieder geval wel goed gemarshalled/unmarshalled.
     */
    private SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");

    /*
     * @see
     * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public synchronized String marshal(Date date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat timeZoneFormatter = new SimpleDateFormat("Z");
        String timezone = timeZoneFormatter.format(date);
        
        final int lastYearCharIndex = 3;
        return formatter.format(date) + timezone.substring(0, lastYearCharIndex) + ":" 
                + timezone.substring(lastYearCharIndex);
    }

    /*
     * @see
     * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public synchronized Date unmarshal(String dateString) throws ParseException {
        Date result = null;
        
        try {
            result = df1.parse(dateString);
        } catch (ParseException pe) {
            // ignore 
            return null;
        }
        
        if (result == null) {
            try {
                result = df2.parse(dateString);
            } catch (ParseException pe) {
                // ignore
                return null;
            }
        }
        
        if (result == null) {
            result = df3.parse(dateString);
        }
        
        return result;
    }
}