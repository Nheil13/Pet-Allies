package com.example.petallies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petallies.R;
import com.example.petallies.model.AllCategory;
import com.example.petallies.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private static Context context;
    private List<AllCategory> allCategoryList;

    /**
     * Constructor for MainRecyclerAdapter.
     *
     * @param context The context in which the adapter is used.
     * @param allCategoryList List of AllCategory objects to be displayed in the RecyclerView.
     */
    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }


    /**
     * Inflates the RecyclerView item layout and returns a new instance of MainViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new MainViewHolder that holds the View for each list item.
     */
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    /**
     * Binds data to the views in the RecyclerView item at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        // Set category title
        holder.categoryTitle.setText(allCategoryList.get(position).getCategoryTitle());

        // Initialize nested RecyclerView for CategoryItem objects
        holder.setCatItemRecycler(allCategoryList.get(position).getCategoryItemList());
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the data set.
     */
    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView itemRecycler;

        /**
         * MainViewHolder represents a single item view in the RecyclerView.
         * It holds references to the TextView for the category title and the nested RecyclerView for CategoryItem objects.
         */
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the item layout
            categoryTitle = itemView.findViewById(R.id.cat_title);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }

        /**
         * Initializes a CategoryItemRecyclerAdapter for the nested RecyclerView.
         *
         * @param categoryItemList List of CategoryItem objects to be displayed in the nested RecyclerView.
         */
        public void setCatItemRecycler(List<CategoryItem> categoryItemList) {
            CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context, categoryItemList);
            itemRecycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            itemRecycler.setAdapter(itemRecyclerAdapter);
        }
    }
}
