package com.example.paymu;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymu.Data.Model.DataTransaksi;
import com.example.paymu.UI.Fragment.HistoryFragmen;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> implements View.OnClickListener{

    ArrayList<DataTransaksi> dataholder;
    HistoryFragmen clicklistener;

    public Adapter(ArrayList<DataTransaksi> dataholder, HistoryFragmen clickListener) {
        this.dataholder = dataholder;
        this.clicklistener = clickListener;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_transaksi,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.transaksi.setText(dataholder.get(position).getJenis());
        holder.tanggal.setText(dataholder.get(position).getTanggal());
        holder.status.setText(dataholder.get(position).getStatus());

        String status = dataholder.get(position).getStatus();
        if(status.equalsIgnoreCase("Success")){
            holder.status.setText("Success");
            holder.status.setTextColor(Color.parseColor("#5CC615"));
        }else{
            holder.status.setText("Failed");
            holder.status.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }


    public class viewholder extends RecyclerView.ViewHolder {
        TextView transaksi, tanggal, status;

         public viewholder(@NonNull View itemView){
             super(itemView);
             transaksi = itemView.findViewById(R.id.Transaksi);
             tanggal = itemView.findViewById(R.id.Tanggal);
             status = itemView.findViewById(R.id.Status);
         }

    }
}

