package sample.UIParser;

import java.time.LocalDateTime;

public class TimeParser {
        public static String dateTimeToString(LocalDateTime localDateTime) {
            if (localDateTime == null) {
                return "No end";
            }
            String time = localDateTime.getYear() + "/" + localDateTime.getMonth().getValue() + "/" + localDateTime.getDayOfMonth() + "\t" + localDateTime.getHour() + ":";
            if (localDateTime.getMinute() < 10)
                return time + "0" + localDateTime.getMinute();
            return time + localDateTime.getMinute();

        }
}
