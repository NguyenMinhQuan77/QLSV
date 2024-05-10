package com.example.btl_qlsv.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_qlsv.database.DBHeplper;
import com.example.btl_qlsv.model.Lop;

import java.util.ArrayList;

public class LopDao {
    DBHeplper db;

    public LopDao(Context context) {
        db = new DBHeplper(context);
    }
    //Hàm getALL lấy toàn bộ dữ liệu của LOP
    public ArrayList<Lop> getAll() {
        ArrayList<Lop> lsList = new ArrayList<>();
        SQLiteDatabase dtb = db.getReadableDatabase();
        Cursor cs = dtb.rawQuery("SELECT * FROM LOP", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            String maLop = cs.getString(0);
            String tenLop = cs.getString(1);
            Lop s = new Lop(maLop, tenLop);
            lsList.add(s);
            cs.moveToNext();
        }
        cs.close();
        return lsList;
    }
    public boolean insert(Lop lop) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maLop", lop.getMaLop());
        contentValues.put("tenLop", lop.getTenLop());
        long r = sqLiteDatabase.insert("LOP", null, contentValues);

        if (r <= 0) {
            return false;
        }
        return true;
    }
    public boolean update(Lop lop) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();//tạo phiên bản của lớp ContentValues để lưu trữ các giá trị
        contentValues.put("maLop", lop.getMaLop());
        contentValues.put("tenLop", lop.getTenLop());
        // phương thức put (key, value) được sử dụng để gán các tham số cho cột đích của nó trong cơ sở dữ liệu
        long r = sqLiteDatabase.update("LOP", contentValues, "maLop=?", new String[]{lop.getMaLop()});

        if (r <= 0) {
            return false;
        }
        return true;
    }
    public boolean delete(String malop) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.delete("SINHVIEN", "maLop=?", new String[]{malop});
        int r = sqLiteDatabase.delete("LOP", "maLop=?", new String[]{malop});
        if (r <= 0) {
            return false;
        }
        return true;
    }

}
