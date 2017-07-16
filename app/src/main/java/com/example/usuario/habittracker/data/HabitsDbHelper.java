package com.example.usuario.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 15/7/17.
 */



// Here I create a subclass extended from SQLiteOpenHelper that override the methods onCreate and upOnGrade
public class HabitsDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = HabitsDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "myhabits.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of the helper HabitsDbHelper
     *
     * @param context of the app
     */
    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * We create the  database for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE =  "CREATE TABLE " + HabitsContract.HabitsEntry.TABLE_NAME + " ("
                + HabitsContract.HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsContract.HabitsEntry.COLUMN_DATE + "INTEGER NOT NULL, "
                + HabitsContract.HabitsEntry.COLUMN_SLEEP + " INTEGER NOT NULL, "
                + HabitsContract.HabitsEntry.COLUMN_FRUIT + " INTEGER NOT NULL, "
                + HabitsContract.HabitsEntry.COLUMN_SPORT + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    /**
     * This is called ONLY when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}