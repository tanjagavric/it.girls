package com.example.platidatisedobrimvrati;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.platidatisedobrimvrati.model.Organizacija;

public class OrganizacijaListAdapter extends ListAdapter<Organizacija, OrganizacijaViewHolder> {
    public OrganizacijaListAdapter(@NonNull DiffUtil.ItemCallback<Organizacija> diffCallback) {
        super(diffCallback);
    }

    @Override
    public OrganizacijaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OrganizacijaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(OrganizacijaViewHolder holder, int position) {
        Organizacija current = getItem(position);
        holder.bind(current.getIme());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Organizacija> {

        @Override
        public boolean areItemsTheSame(@NonNull Organizacija oldItem, @NonNull Organizacija newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Organizacija oldItem, @NonNull Organizacija newItem) {
            return oldItem.getIme().equals(newItem.getIme());
        }
    }
}