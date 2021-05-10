package pnj.uts.aldy.fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldy.LoginActivity;
import pnj.uts.aldy.R;

public class ProfileFragment extends Fragment {
    TextView edtKls,edtNama,edtEmail,edtNim;
    Button actionLogout;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("LatihanAndroid", Context.MODE_PRIVATE);
        edtNim = view.findViewById(R.id.edtNim);
        edtKls = view.findViewById(R.id.edtKls);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtNama = view.findViewById(R.id.edtNama);
        actionLogout = view.findViewById(R.id.actionLogout);

        edtNim.setText(sharedPreferences.getString("nim",""));
        edtEmail.setText(sharedPreferences.getString("email",""));
        edtNama.setText(sharedPreferences.getString("nama",""));
        edtKls.setText(sharedPreferences.getString("kelas",""));

        actionLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LatihanAndroid", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                Toast.makeText(getActivity(),"Berhasil Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
