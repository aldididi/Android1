package pnj.uts.aldy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static  String _NAMA_DATABASE="alumniapps";
    public static int _VERSION = 1;
    public static String _CREATE_TABLE = "create table tb_alumni ( NIM TEXT, nama_alumni TEXT, tempat_lhr TEXT, tgl_lhr TEXT, alamat TEXT, agama TEXT, no_tlp TEXT, thn_masuk INTEGER, thn_lulus INTEGER, pekerjaan TEXT, jabatan TEXT, PRIMARY KEY(NIM) )";

    public DatabaseHelper(@Nullable Context context) {
        super(context, _NAMA_DATABASE, null, _VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_alumni");
        onCreate(db);
    }
}
