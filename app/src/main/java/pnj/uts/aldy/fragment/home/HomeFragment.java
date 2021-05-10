package pnj.uts.aldy.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pnj.uts.aldy.LoginActivity;
import pnj.uts.aldy.R;
import pnj.uts.aldy.adapter.AdapterBerita;
import pnj.uts.aldy.fragment.alumni.AlumniFragment;
import pnj.uts.aldy.fragment.alumni.TAlumniFragment;

public class HomeFragment extends Fragment {
    ListView listView;
    AdapterBerita adapterBerita;
    AlumniFragment alumniFragment = new AlumniFragment();
    TAlumniFragment tAlumniFragment = new TAlumniFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionMenu1:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, tAlumniFragment);
                ft.commit();
                break;
            case R.id.actionMenu2:
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.container, alumniFragment);
                ft2.commit();
                break;
            case R.id.actionMenu3:
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LatihanAndroid", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                Toast.makeText(getActivity(),"Berhasil Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}