package id.zainalfahrudin.orbit.job9;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.model.DataModel;
import java.util.List;

/**
 * Created by zainal on 10/13/16.
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{

    private List<DataModel> data;
    private Context context;
    private final OnItemClickListener listener;


    public AdapterRecyclerView(List<DataModel> data, Context context, OnItemClickListener listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(DataModel item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView desc;
        public ImageView ivIcon;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tvTitle);
            desc = (TextView) v.findViewById(R.id.tvDesc);
            ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
        }

        public void bind(final DataModel data, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(data);
                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_os, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel model = data.get(position);

        holder.title.setText(model.getNama_os());
        holder.desc.setText(model.getDeskripsi());

        int icon = model.getIcon();
        holder.ivIcon.setImageDrawable(context.getResources().getDrawable(icon));
        holder.bind(model, listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
