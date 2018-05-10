package win.nicecode.banwagong.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eason.Ren on 5/10/2018 14:46
 * Email: eason.ren@outlook.com
 */
public class VpsDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String VPS_DATABASE_NAME = "vps.db";
    public static final String VPSINFO_TABLE_NAME = "vpsinfo";
    public static final String CREATE_VPSINFO_TABLE = "create table if not exists "
            + VPSINFO_TABLE_NAME
            + " (id integer primary key autoincrement, veid text, api_key text, hostname text, node_ip text,"
            + " node_alias text, node_location text, [plan] text, plan_monthly_data text, plan_disk text, plan_ram text,"
            + " plan_swap text, os text, email text, data_counter text, data_next_reset text, ip_address text, status text"
            + ")";

    public VpsDbHelper(Context context) {
        super(context, VPS_DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_VPSINFO_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //db.execSQL(CREATE_VPSINFO_TABLE);
    }
}
