package lv.llu.bites.utils;

import javax.ws.rs.WebApplicationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Custom parser for date params passed via URL
 */
public class UrlDateParam {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private Calendar date;

    public UrlDateParam(String in) throws WebApplicationException {
        try {
            date = Calendar.getInstance();
            date.setTime(format.parse(in));
        } catch (ParseException exception) {
            throw new WebApplicationException(400);
        }
    }

    public Date getDate() {
        return date.getTime();
    }

}
