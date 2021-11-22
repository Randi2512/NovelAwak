package com.example.novelawak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Novel.Result> results ;
    private OnAdapterListener listener;

    public MainAdapter(List<Novel.Result> results, OnAdapterListener listener){
        this.listener = listener;
        this.results = results;
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_novel,parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        Novel.Result result = results.get(position);
        holder.txtJudul.setText(result.getJudul());
        holder.txtPenerbit.setText(result.getPenerbit());
        holder.txtPenulis.setText(result.getPenulis());

        Picasso.get()
                .load(result.getUrl_gambar())
                .fit().centerCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(result);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtJudul,txtPenerbit,txtPenulis;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageNovel);
            txtJudul = itemView.findViewById(R.id.txtJudulBuku);
            txtPenerbit = itemView.findViewById(R.id.txtPenerbit);
            txtPenulis = itemView.findViewById(R.id.txtPenulis);
        }
    }
    public void setData(List<Novel.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
    interface OnAdapterListener{
        void onClick(Novel.Result result);
    }
}
