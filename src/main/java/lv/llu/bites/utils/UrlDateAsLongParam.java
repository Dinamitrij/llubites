package lv.llu.bites.utils;

import javax.ws.rs.WebApplicationException;
import java.util.Date;

/**
 * Custom parser for date params passed via URL as Long integers
 */
public class UrlDateAsLongParam {

    /**
     * Time Difference between OpenShift's US/Eastern Time and GMT+2 of Latvia
     */
    public static final int PLUS_6_HOURS_FOR_LATVIA = 21600000;
    private Date date;

    public UrlDateAsLongParam(String in) throws WebApplicationException {
        try {
            final Long incomingMilliseconds = Long.valueOf(in);
            date = new Date(incomingMilliseconds + PLUS_6_HOURS_FOR_LATVIA);
        } catch (Exception exception) {
            throw new WebApplicationException(400);
        }
    }

    public Date getDate() {
        return date;
    }

}
