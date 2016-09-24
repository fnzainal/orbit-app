package id.zainalfahrudin.orbit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.model.DataModel;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 24/09/16 8:17.
 */
public class CustomAdapter extends BaseAdapter{

    private final List<DataModel> data;
    private final Context context;
    private final LayoutInflater inflater;

    public CustomAdapter(Context context, List<DataModel> dataModels) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = dataModels;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_os,null);

        TextView title = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView desc = (TextView) convertView.findViewById(R.id.tvDesc);
        ImageView ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);

        title.setText(data.get(position).getNama_os());
        desc.setText(data.get(position).getDeskripsi());
//        ivIcon.setImageResource(data.get(position).getIcon());
        int icon = data.get(position).getIcon();
        ivIcon.setImageDrawable(context.getResources().getDrawable(icon));
        return convertView;
    }
}
