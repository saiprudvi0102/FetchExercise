package com.exam.fetchexercise.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.exam.fetchexercise.R;
import com.exam.fetchexercise.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> items = new ArrayList<>();

    public void updateItems(List<Item> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView listIdView;
        private final TextView nameView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            listIdView = itemView.findViewById(R.id.listIdTextView);
            nameView = itemView.findViewById(R.id.nameTextView);
        }

        public void bind(Item item) {
            listIdView.setText("List ID: " + item.getListId());
            nameView.setText(item.getName());
        }
    }
}