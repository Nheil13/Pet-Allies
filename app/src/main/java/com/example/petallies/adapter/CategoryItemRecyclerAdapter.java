package com.example.petallies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petallies.R;
import com.example.petallies.model.CategoryItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    /**
     * Constructor for CategoryItemRecyclerAdapter.
     *
     * @param context The context in which the adapter is used.
     * @param categoryItemList List of CategoryItem objects to be displayed in the RecyclerView.
     */
    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    /**
     * Inflates the RecyclerView item layout and returns a new instance of CategoryItemViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new CategoryItemViewHolder that holds the View for each list item.
     */
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    /**
     * Binds data to the views in the RecyclerView item at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {

        // Use Picasso to load the image from the URL into the ImageView
        Picasso.get().load(categoryItemList.get(position).getImageURL()).into(holder.itemImage, new Callback() {
            @Override
            public void onSuccess() {
                // Image loaded successfully, remove background
                holder.itemImage.setBackground(null); // or holder.itemImage.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void onError(Exception e) {
                // Handle error if the image fails to load
            }
        });

        // Set productDescription and productPrice
        holder.productDescription.setText(categoryItemList.get(position).getProductDescription());
        holder.productPrice.setText(categoryItemList.get(position).getProductPrice());
        holder.productStocks.setText(String.valueOf(categoryItemList.get(position).getProductStocks()));

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the data set.
     */
    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    /**
     * CategoryItemViewHolder represents a single item view in the RecyclerView.
     * It holds references to the ImageView, TextViews for product description, price, and stocks.
     */
    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView productDescription, productPrice, productStocks;

        /**
         * Constructor for CategoryItemViewHolder.
         *
         * @param itemView The View representing the RecyclerView item.
         */

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the item layout
            itemImage = itemView.findViewById(R.id.productImage);
            productDescription = itemView.findViewById(R.id.productDescription);
            productPrice = itemView.findViewById(R.id.productPrice);
            productStocks = itemView.findViewById(R.id.productStocks);

        }
    }

}
