package win.nicecode.banwagong.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import win.nicecode.banwagong.bean.VpsInfoData;

/**
 * Created by Eason.Ren on 5/10/2018 15:45
 * Email: eason.ren@outlook.com
 */
public class VpsInfoDb {
    private final VpsDbHelper dbHelper;

    public VpsInfoDb(Context context) {
        dbHelper = new VpsDbHelper(context);
    }

    public void insert(VpsInfoData data) {
        String sql = "insert into " + VpsDbHelper.VPSINFO_TABLE_NAME;

        sql += "(veid,api_key,hostname,node_ip,node_alias,node_location," +
                "[plan],plan_monthly_data,plan_disk,plan_ram,plan_swap,os," +
                "email,data_counter,data_next_reset,ip_address,status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteDatabase sqlite = dbHelper.getWritableDatabase();
        sqlite.execSQL(sql, new String[]{data.getVeid(), data.getApi_key(), data.getHostname(), data.getNode_ip(), data.getNode_alias(),
                data.getNode_location(), data.getPlan(), data.getPlan_monthly_data(), data.getPlan_disk(), data.getPlan_ram(), data.getPlan_swap(),
                data.getOs(), data.getEmail(), data.getData_counter(), data.getData_next_reset(), data.getIp_address(), data.getStatus()});
        sqlite.close();
    }

    public void delete(int id) {
        SQLiteDatabase sqlite = dbHelper.getWritableDatabase();
        String sql = ("delete from " + VpsDbHelper.VPSINFO_TABLE_NAME + " where _id=?");
        sqlite.execSQL(sql, new Integer[]{id});
        sqlite.close();
    }

    public void update(VpsInfoData data) {
        SQLiteDatabase sqlite = dbHelper.getWritableDatabase();
        String sql = "update " + VpsDbHelper.VPSINFO_TABLE_NAME + " set veid=?, api_key=?, hostname=?, node_ip=?, node_alias=?,node_location=?,"
                + "[plan]=?,plan_monthly_data=?,plan_disk=?,plan_ram=?,plan_swap=?,os=?,email=?,data_counter=?,data_next_reset=?,ip_address=?,status=? where id=?";
        sqlite.execSQL(sql,
                new String[]{data.getVeid(), data.getApi_key(), data.getHostname(), data.getNode_ip(), data.getNode_alias(),
                        data.getNode_location(), data.getPlan(), data.getPlan_monthly_data(), data.getPlan_disk(), data.getPlan_ram(), data.getPlan_swap(),
                        data.getOs(), data.getEmail(), data.getData_counter(), data.getData_next_reset(), data.getIp_address(), data.getStatus(), data.getId() + ""});
        sqlite.close();
    }

    public List<VpsInfoData> query(String where) {
        SQLiteDatabase sqlite = dbHelper.getReadableDatabase();
        ArrayList<VpsInfoData> data = null;
        VpsInfoData vpsInfoData = null;
        data = new ArrayList<VpsInfoData>();

        Cursor cursor = sqlite.rawQuery("select * from "
                + VpsDbHelper.VPSINFO_TABLE_NAME + where, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            vpsInfoData = new VpsInfoData();

            vpsInfoData.setId(cursor.getInt(0));
            vpsInfoData.setVeid(cursor.getString(1));
            vpsInfoData.setApi_key(cursor.getString(2));
            vpsInfoData.setHostname(cursor.getString(3));
            vpsInfoData.setNode_ip(cursor.getString(4));
            vpsInfoData.setNode_alias(cursor.getString(5));
            vpsInfoData.setNode_location(cursor.getString(6));
            vpsInfoData.setPlan(cursor.getString(7));
            vpsInfoData.setPlan_monthly_data(cursor.getString(8));
            vpsInfoData.setPlan_disk(cursor.getString(9));
            vpsInfoData.setPlan_ram(cursor.getString(10));
            vpsInfoData.setPlan_swap(cursor.getString(11));
            vpsInfoData.setOs(cursor.getString(12));
            vpsInfoData.setEmail(cursor.getString(13));
            vpsInfoData.setData_counter(cursor.getString(14));
            vpsInfoData.setData_next_reset(cursor.getString(15));
            vpsInfoData.setIp_address(cursor.getString(16));
            vpsInfoData.setStatus(cursor.getString(17));

            data.add(vpsInfoData);
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        sqlite.close();

        return data;
    }


    public void destroy() {
        dbHelper.close();
    }
}
