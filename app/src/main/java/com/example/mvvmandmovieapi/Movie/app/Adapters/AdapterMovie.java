package com.example.mvvmandmovieapi.Movie.app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovie;
import com.example.mvvmandmovieapi.databinding.ItemRecyclerMovieBinding;
import com.example.mvvmandmovieapi.Movie.app.helper.Const;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.Holder> {
    ArrayList<ModelMovie.ResultsBean> list;
    onItemListener onItemListener ;

    public void setList(ArrayList<ModelMovie.ResultsBean> list) {
        this.list = list;
    }

    public void setOnItemListener(AdapterMovie.onItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerMovieBinding binding = ItemRecyclerMovieBinding.
                inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.textTitle.setText(list.get(position).getTitle());
        Glide.with(holder.itemView.getContext())
                .load(Const.BASE_URL_IMAGE+list.get(position).getPoster_path())
                .into(holder.binding.imageMovie);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ItemRecyclerMovieBinding binding;
        public Holder(ItemRecyclerMovieBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(onItemListener!=null){
                       onItemListener.onItemClick(list.get(getLayoutPosition()).getId());
                   }
               }
           });
        }
    }

    public interface onItemListener {
        void onItemClick(int movieId);
    }
}
