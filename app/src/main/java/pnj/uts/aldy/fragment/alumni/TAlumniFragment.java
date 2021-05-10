package pnj.uts.aldy.fragment.alumni;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldy.R;
import pnj.uts.aldy.database.DatabaseHelper;

public class TAlumniFragment extends Fragment implements View.OnClickListener  {
    EditText edtNIM, edtNama, edtTglhr, edtTmplhr, edtThnlulus, edtThnmsk, edtPekerjaan, edtJabatan,edtNotlp,edtAgama,edtAlamat;
    Button addButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tambah_alumni, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addButton){
            simpan();
        }
    }

    void simpan(){
        SQLiteDatabase database = new DatabaseHelper(getActivity()).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NIM",edtNIM.getText().toString());
        contentValues.put("nama_alumni",edtNama.getText().toString());
        contentValues.put("tgl_lhr",edtTglhr.getText().toString());
        contentValues.put("tempat_lhr",edtTmplhr.getText().toString());
        contentValues.put("alamat",edtAlamat.getText().toString());
        contentValues.put("agama",edtAgama.getText().toString());
        contentValues.put("no_tlp",edtNotlp.getText().toString());
        contentValues.put("thn_masuk",edtThnmsk.getText().toString());
        contentValues.put("thn_lulus","1");
        contentValues.put("pekerjaan","1");
        contentValues.put("jabatan","1");

        long insert = database.insert("tb_alumni",null,contentValues);
        database.close();
    }
}
