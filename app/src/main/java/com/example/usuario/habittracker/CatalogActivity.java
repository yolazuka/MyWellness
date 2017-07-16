package com.example.usuario.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.usuario.habittracker.data.HabitsContract;
import com.example.usuario.habittracker.data.HabitsDbHelper;

public class CatalogActivity extends AppCompatActivity {

    HabitsDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new HabitsDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    /**
     * Temporary helper method to display information and get the data readable through the
     * method getReadableDatabase
     */
    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query. In this case, I,ll include them all.
        String[] projection = {
                HabitsContract.HabitsEntry._ID,
                HabitsContract.HabitsEntry.COLUMN_DATE,
                HabitsContract.HabitsEntry.COLUMN_SLEEP,
                HabitsContract.HabitsEntry.COLUMN_FRUIT,
                HabitsContract.HabitsEntry.COLUMN_SPORT,};

        // Perform a query on the user,s habit table
        Cursor cursor = db.query(
                HabitsContract.HabitsEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return and the conditional filters if wanted.
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order
    }

    /**
     * Helper method to insert hardcoded habits registration data into the database. It,s for debugging purposes only.
     */
    private void insertHabits() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and the date, amount of sleep hours, pieces of fruit and yoga practicing are the values.
        ContentValues values = new ContentValues();
        values.put(HabitsContract.HabitsEntry._ID, "4");
        values.put(HabitsContract.HabitsEntry.COLUMN_DATE, "01/07/2017");
        values.put(HabitsContract.HabitsEntry.COLUMN_SLEEP, "4");
        values.put(HabitsContract.HabitsEntry.COLUMN_SLEEP, "4");
        values.put(HabitsContract.HabitsEntry.COLUMN_FRUIT, "5");
        values.put(HabitsContract.HabitsEntry.COLUMN_SPORT, "Basket");

        // Insert a new row for the user habit in the database, returning the ID of that new row.
        // The first argument is the habits table.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the habits information.
        long newRowId = db.insert(HabitsContract.HabitsEntry.TABLE_NAME, null, values);
    }
}