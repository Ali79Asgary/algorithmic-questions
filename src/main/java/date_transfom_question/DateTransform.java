package date_transfom_question;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTransform {

    public static List<String> transformDateFormat(List<String> dates) {

        ArrayList<String> transformedDates = new ArrayList<String>();
        Pattern yyyymmdd = Pattern.compile("^(\\d{4})/(\\d{2})/(\\d{2})$");
        Pattern ddmmyyyy = Pattern.compile("^(\\d{2})/(\\d{2})/(\\d{4})$");
        Pattern mmddyyyy = Pattern.compile("^(\\d{2})-(\\d{2})-(\\d{4})$");

        for (String date : dates) {
            Matcher yyyymmddMatcher = yyyymmdd.matcher(date);
            if (yyyymmddMatcher.matches()) {
                transformedDates.add(yyyymmddMatcher.group(1) + yyyymmddMatcher.group(2) + yyyymmddMatcher.group(3));
                continue;
            }

            Matcher ddmmyyyyMatcher = ddmmyyyy.matcher(date);
            if (ddmmyyyyMatcher.matches()) {
                transformedDates.add(ddmmyyyyMatcher.group(3) + ddmmyyyyMatcher.group(2) + ddmmyyyyMatcher.group(1));
                continue;
            }

            Matcher mmddyyyyMatcher = mmddyyyy.matcher(date);
            if (mmddyyyyMatcher.matches()) {
                transformedDates.add(mmddyyyyMatcher.group(3) + mmddyyyyMatcher.group(1) + mmddyyyyMatcher.group(2));
                continue;
            }
        }

        return transformedDates;
    }
}
