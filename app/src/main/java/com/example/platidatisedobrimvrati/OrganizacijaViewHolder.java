package com.example.platidatisedobrimvrati;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class OrganizacijaViewHolder extends RecyclerView.ViewHolder {
        private final TextView orgItemView;

        private OrganizacijaViewHolder(View itemView) {
            super(itemView);
            orgItemView = itemView.findViewById(R.id.textView);
        }

        public void bind(String text) {
            orgItemView.setText(text);
        }

        static OrganizacijaViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
            return new OrganizacijaViewHolder(view);
        }
}
