package com.example.standard.mvvmbinding.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.*;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.FrameLayout;

import com.example.standard.mvvmbinding.R;
import com.example.standard.mvvmbinding.datamodel.DataModel;
import com.example.standard.mvvmbinding.viewmodel.MainActivityViewModel;
import com.example.standard.mvvmbinding.databinding.ItemDataBinding;

import java.util.*;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    private static final String TAG = "DataAdapter";
    private List<DataModel> data;

    public DataAdapter() {
        this.data = new ArrayList<>();
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()),false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        DataModel dataModel = data.get(position);
        dataViewHolder.setViewModel(new MainActivityViewModel(dataModel));

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<DataModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
        /* package */ ItemDataBinding binding;

        /* package */ DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        /* package */ void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        /* package */ void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        /* package */ void setViewModel(MainActivityViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }
}
