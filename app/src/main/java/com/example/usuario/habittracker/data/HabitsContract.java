package com.example.usuario.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Usuario on 15/7/17. CLASS TO DECLARE THE STATIC INFO OF THE TABLE
 */

public class HabitsContract {

        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        private HabitsContract() {}

        /**
         * Inner class that defines constant values for the user habits database table.
         * Each entry in the table represents a single habit
         */
        public static final class HabitsEntry implements BaseColumns {

            /**
             * Name of database table for the user habits
             */
            public final static String TABLE_NAME = "habits";

            /**
             * Unique ID number for each entry (only for use in the database table).
             *
             * Type: INTEGER
             */
            public final static String _ID = BaseColumns._ID;

            /**
             * date of the Entry
             *
             * Type: INT
             */

            public final static String COLUMN_DATE = "date";

            /**
             * How many pieces of fruit the user consumes that day
             * <
             * Type: INT
             */

            public final static String COLUMN_SLEEP = "sleep";

            /**
             * How many pieces of fruit the user consumes that day
             * <
             * Type: INT
             */
            public final static String COLUMN_FRUIT = "fruit";

            /**
             * What sport has the user practiced today
             *
             * Type: TEXT
             */
            public final static String COLUMN_SPORT = "sport";

        }

    }
