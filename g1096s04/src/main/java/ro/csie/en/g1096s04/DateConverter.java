package ro.csie.en.g1096s04;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    //converts date to long
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }
    //converts long to date
    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
