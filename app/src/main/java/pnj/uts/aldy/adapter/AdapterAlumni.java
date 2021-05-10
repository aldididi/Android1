package pnj.uts.aldy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pnj.uts.aldy.R;
import pnj.uts.aldy.model.AlumniModel;

public class AdapterAlumni extends ArrayAdapter<AlumniModel> {
    int resource;
    Context context;

    public AdapterAlumni(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = null;
        if (convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource,parent, false);
            holder.txtNIM = convertView.findViewById(R.id.txtNIM);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        AlumniModel model = getItem(position);
        holder.txtNIM.setText(model.getNIM());
        holder.txtNama.setText(model.getNama_alumni());
        return convertView;
    }

    class Holder{
        TextView txtNama, txtNIM;
    }
}
