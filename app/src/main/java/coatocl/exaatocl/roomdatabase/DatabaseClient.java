package coatocl.exaatocl.roomdatabase;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient
{
    private Context mCtx;
    private static DatabaseClient mInstance;

    //our app database object
    private Database appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        appDatabase = Room.databaseBuilder(mCtx, Database.class, "Student Details").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public Database getAppDatabase() {
        return appDatabase;
    }
}
