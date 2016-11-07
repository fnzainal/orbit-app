package id.zainalfahrudin.orbit.job10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.zainalfahrudin.orbit.R;

/**
 * Created by zainal on 10/20/16.
 */
public class AdapterPantai extends BaseAdapter{

    private final Context context1;
    private final List<ModelPantai> dataList;
    LayoutInflater inflanter;


    public AdapterPantai(Context context, List<ModelPantai> dataList) {
        this.context1 = context;
        this.dataList = dataList;
        inflanter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderPantai vh ;

        if (convertView==null){
            convertView = inflanter.inflate(R.layout.item_pantai, null);
            vh = new ViewHolderPantai();
            vh.ivPantai = (ImageView) convertView.findViewById(R.id.ivPicPantai);
            vh.tvNamaPantai = (TextView) convertView.findViewById(R.id.tvNamaPantai);
            vh.tvDesk= (TextView) convertView.findViewById(R.id.tvDesk);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolderPantai)convertView.getTag();
        }

        vh.tvNamaPantai.setText(dataList.get(position).getNama_pantai());
        vh.tvDesk.setText(dataList.get(position).getDeskripsi());

        String URL = dataList.get(position).getUrl_photo();

        Glide.with(context1)
                .load(URL)
                .placeholder(R.drawable.ic_image_white_48dp)
                .into(vh.ivPantai);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolderPantai {
        ImageView ivPantai;
        TextView tvNamaPantai;
        TextView tvDesk;
    }
}
