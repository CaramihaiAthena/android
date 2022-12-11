package ro.csie.en.g1096s04;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Movie.class}, exportSchema = false, version = 1)
//add TypeConverters annotation, so that Room knows about converteer class that I have defined
@TypeConverters({DateConverter.class})

public abstract class DatabaseManager extends RoomDatabase {

    private static final String DB_NAME = "g1096_db";
    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context)
    {
        if(databaseManager == null)
        {
            synchronized (DatabaseManager.class)
            {
                //creates the db
                databaseManager = Room.databaseBuilder(context, DatabaseManager.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();  //Creates the databases and initializes it.
            }
        }
        return databaseManager;
    }
    public abstract MovieDao getMovieDao();
}
