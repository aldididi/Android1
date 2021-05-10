package pnj.uts.aldy.fragment.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldy.R;
import pnj.uts.aldy.adapter.AdapterUser;

public class NotificationFragment extends Fragment {
    ListView listView;
    AdapterUser adapterUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification,container,false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        listView = view.findViewById(R.id.listView);
//        adapterUser = new AdapterUser(getActivity(), R.layout.layout_item_user);
//        listView.setAdapter(adapterUser);
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                UserModel model = (UserModel) parent.getAdapter().getItem(position);
//                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//                alert.setMessage("Apakah Anda yakin menghapus data "+model.getNama());
//                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        SQLiteDatabase database = new DatabaseHelper(getActivity()).getWritableDatabase();
//                       long delete =  database.delete("tb_alumni","NIM=?", new String[]{""+model.getId()});
//                        if (delete != -1){
//                            Toast.makeText(getActivity(),"Hapus Berhasil",Toast.LENGTH_SHORT).show();
//                            getData();
//                        } else {
//                            Toast.makeText(getActivity(),"Hapus Gagal",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                alert.show();
//
//                return true;
//            }
//        });
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        getData();
//    }
//
//    void getData(){
//        adapterUser.clear();
//        ArrayList<UserModel> datas = new ArrayList<>();
//        SQLiteDatabase database = new DatabaseHelper(getActivity()).getReadableDatabase();
//        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);
//
//        if (cursor.moveToFirst()){
//            do {
//                UserModel model = new UserModel();
//                model.setId(cursor.getInt(0));
//                model.setNama(cursor.getString(1));
//                model.setBod(cursor.getString(2));
//                model.setJam_lahir(cursor.getString(3));
//                model.setEmail(cursor.getString(4));
//                datas.add(model);
//            } while (cursor.moveToNext());
//        }
//        adapterUser.addAll(datas);
//        adapterUser.notifyDataSetChanged();
//    }
}
