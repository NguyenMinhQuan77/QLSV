package com.example.btl_qlsv.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHeplper extends SQLiteOpenHelper {
    public DBHeplper(@Nullable Context context) {
        super(context, "QUANLYSINHVIENQNUDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //tạo table lớp
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
//        sql = " INSERT INTO LOP VALUES ('LT1','Lap Trinh Android')";
//        db.execSQL(sql);
//        sql = " INSERT INTO LOP VALUES ('LT2','Lap Trinh PHP')";
//        db.execSQL(sql);
//        sql = " INSERT INTO LOP VALUES ('LT3','Lap Trinh C#')";
//        db.execSQL(sql);
        //tạo table sinh viên
        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT ," + " email TEXT ,hinh TEXT, maLop TEXT REFERENCES LOP(maLop))";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('001','Lê Trung Hậu','haule123@gmail.com','hau','LT1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('002','Nguyễn Nọc Khoan','khoannguyen2202@gmail.com','khon','LT2')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('003','Nguyễn Hoàng Vũ','hoangvubtx@gmail.com','vu','LT3')";
        db.execSQL(sql);
        //tạo table taikhoan
        sql = "CREATE TABLE taiKhoan(tenTaiKhoan text primary key, matKhau text)";
        db.execSQL(sql);
        //tai khoan mac dinh admin
        sql = "INSERT INTO taiKhoan VALUES('admin','admin')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
