package com.dnteam.medkit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dnteam.medkit.R;
import com.dnteam.medkit.pojo.Country;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.PlaceHolder> {

    static class PlaceHolder extends RecyclerView.ViewHolder {

        ImageView flag;
        TextView name;
        RadioButton selected;

        public PlaceHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.country_img);
            name = itemView.findViewById(R.id.country_name);
            selected = itemView.findViewById(R.id.selection);
        }

        public void bind(@NotNull Country item) {
            name.setText(item.getName());
            flag.setImageResource(item.getImgId());
            selected.setChecked(item.isSelected());
        }
    }

    private ArrayList<Country> dataList;
    private Context context;



    private int lastPosition = 1;

    public CountryAdapter(ArrayList<Country> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public CountryAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.country_list_item, parent, false);
        return new PlaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        holder.bind(dataList.get(position));
        holder.selected.setOnClickListener((cl) -> {
            for (Country country : dataList) {
                country.setSelected(false);
            }
            dataList.get(position).setSelected(true);
            lastPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public ArrayList<Country> getDataList() {
        return dataList;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    @NotNull
    public static CountryAdapter getInstance(Context context) {
        CountryAdapter adapter = new CountryAdapter(context);
        ArrayList<Country> countries = adapter.dataList;

        String s1 = context.getString(R.string.ksa);
        countries.add(new Country(R.drawable.ic_saudi_arabia_flag, s1,"KSA"));

        String s2 = context.getString(R.string.eg);
        countries.add(new Country(R.drawable.ic_egypt_flag, s2,"EG" ,true));

        String s3 = context.getString(R.string.jr);
        countries.add(new Country(R.drawable.ic_jordan_flag, s3,"JR"));


        String s4 = context.getString(R.string.lb);
        countries.add(new Country(R.drawable.ic_lebanon_flag, s4,"LB"));


        String s5 = context.getString(R.string.ng);
        countries.add(new Country(R.drawable.ic_nigeria_flag, s5,"NG"));

        String s6 = context.getString(R.string.ke);
        countries.add(new Country(R.drawable.ic_kenya_flag, s6,"KE"));

        return adapter;
    }

}
