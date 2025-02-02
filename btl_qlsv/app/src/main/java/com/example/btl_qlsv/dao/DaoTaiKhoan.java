package com.example.btl_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_qlsv.database.DBHeplper;
import com.example.btl_qlsv.model.TaikhoanMatKhau;

import java.util.ArrayList;

public class DaoTaiKhoan {
    DBHeplper dtbRegister;

    public DaoTaiKhoan(Context context) {

        dtbRegister = new DBHeplper(context);
    }

    public ArrayList<TaikhoanMatKhau> getALl() {
        ArrayList<TaikhoanMatKhau> listTK = new ArrayList<>();
        SQLiteDatabase dtb = dtbRegister.getReadableDatabase();
        Cursor cs = dtb.rawQuery("SELECT * FROM taiKhoan", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            try {
                String tk = cs.getString(0);
                String mk = cs.getString(1);
                TaikhoanMatKhau t = new TaikhoanMatKhau(tk, mk);
                listTK.add(t);
                cs.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        cs.close();
        return listTK;
    }
    public boolean Them(TaikhoanMatKhau tk) {
        SQLiteDatabase db = dtbRegister.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenTaiKhoan", tk.getTenTaiKhoan());
        values.put("matKhau", tk.getMatKhau());
        long r = db.insert("taiKhoan", null, values);
        if (r <= 0) {
            return false;
        }
        return true;
    }

}
