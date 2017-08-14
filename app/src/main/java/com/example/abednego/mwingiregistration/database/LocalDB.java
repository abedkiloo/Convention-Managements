package com.example.abednego.mwingiregistration.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by abednego on 8/12/17.
 */

public class LocalDB extends SQLiteOpenHelper {
    private static final String Db_name = "Mwingi_Convention";
    private String Table_name = "Mwingi_Convention_Registry";
    private String first_name = "First_Name";
    private String second_name = "Second_Name";
    private String home_church = "Home_Church";
    private String gender = "Gender";
    private String age_group = "Age_group";
    private String amount_paid = "Amount_paid";
    private String border_State = "Border_state";
    String Create_Tbl_Registry = "CREATE TABLE " + Table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            first_name + " TEXT," + second_name + " TEXT," + home_church + " TEXT," +
            gender + " TEXT," + age_group + " TEXT," + amount_paid + " TEXT," + border_State + " TEXT)";
    Context context;

    public LocalDB(Context context) {
        super(context, Db_name, null, 1);
        this.context = context;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Toast.makeText(context, "DB_CREATED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Tbl_Registry);
        Toast.makeText(context, "Created Table", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + Table_name);
    }


    /**
     * method to register users
     *
     * @param s_first_name
     * @param S_second_namw
     * @param S_gender
     * @param S_age_group
     * @param S_home_church
     * @param S_border_state
     * @param S_amount_paid
     * @return
     */
    public boolean insert_values(String S_first_name, String S_second_namw, String S_gender, String S_age_group,
                                 String S_home_church, String S_border_state, String S_amount_paid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(first_name, S_first_name);
        contentValues.put(second_name, S_second_namw);
        contentValues.put(gender, S_gender);
        contentValues.put(age_group, S_age_group);
        contentValues.put(home_church, S_home_church);
        contentValues.put(border_State,S_border_state);
        contentValues.put(amount_paid,S_amount_paid);

        long result = db.insert(Table_name, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor get_all_data(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+ Table_name,null);
        return cursor;

    }
}
