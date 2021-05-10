package pnj.uts.aldy.fragment.alumni;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldy.R;
import pnj.uts.aldy.adapter.AdapterAlumni;
import pnj.uts.aldy.database.DatabaseHelper;
import pnj.uts.aldy.model.AlumniModel;

public class AlumniFragment extends Fragment {
    ListView listView;
    AdapterAlumni adapterAlumni;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        simpanData();
        getData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alumni,container,false);
    }

    void simpanData(){
        SQLiteDatabase database = new DatabaseHelper(getActivity()).getWritableDatabase();
        Cursor cursor = database.rawQuery("INSERT INTO tb_alumni VALUES (1,1,1,1,1,1,1,1,1,1,1)",null);
    }

    void getData(){
        SQLiteDatabase database = new DatabaseHelper(getActivity()).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);
        if (cursor.moveToFirst()){
            do{
                AlumniModel model = new AlumniModel();
//                model.setNama_alumni(cursor.getString(1));
                model.setNIM(cursor.getString(0));
            } while (cursor.moveToNext());
        }
    }


}
