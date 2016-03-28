package lv.llu.bites.utils;

import javax.ws.rs.WebApplicationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Custom parser for date params passed via URL as Long integers
 */
public class UrlDateAsLongParam {

    private Date date;

    public UrlDateAsLongParam(String in) throws WebApplicationException {
        try {
            final Long incomingMilliseconds = Long.valueOf(in);
            date = new Date(incomingMilliseconds);
        } catch (Exception exception) {
            throw new WebApplicationException(400);
        }
    }

    public Date getDate() {
        return date;
    }

}
