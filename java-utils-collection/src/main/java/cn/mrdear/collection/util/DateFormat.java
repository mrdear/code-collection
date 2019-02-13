package cn.mrdear.collection.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Quding Ding
 * @since 2019-02-12
 */
public enum DateFormat {

    YMD("yyyyMMdd"),

    YMD_("yyyy-MM-dd"),

    YMDHMS("yyyyMMddHHmmss"),

    YMDHMS_("yyyy-MM-dd HH:mm:ss"),

    ;

    private String pattern;

    DateFormat(String pattern) {
        this.pattern = pattern;
    }


    public String format(Date date) {
        FastDateFormat instance = FastDateFormat.getInstance(this.pattern);
        return instance.format(date);
    }


    public String format(Date date, String timeZone) {
        FastDateFormat instance = FastDateFormat.getInstance(this.pattern, TimeZone.getTimeZone(timeZone));
        return instance.format(date);
    }


    public Date parse(String date) {
        FastDateFormat instance = FastDateFormat.getInstance(this.pattern);
        try {
            return instance.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date parse(String date, String timezone) {
        FastDateFormat instance = FastDateFormat.getInstance(this.pattern, TimeZone.getTimeZone(timezone));
        try {
            return instance.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
