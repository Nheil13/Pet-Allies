package com.example.petallies.aboutus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petallies.AboutUsDA;
import com.example.petallies.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AboutUsAdapter extends RecyclerView.Adapter<AdapterViewHolder> {

    private Context context;
    private List<AboutUsCategory> dataList;

    /**
     * Constructor for AboutUsAdapter.
     *
     * @param context The context in which the adapter is used.
     * @param dataList List of AboutUsCategory items to be displayed in the RecyclerView.
     */

    public AboutUsAdapter(Context context, List<AboutUsCategory> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * Inflates the RecyclerView item layout and returns a new instance of AdapterViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new AdapterViewHolder that holds the View for each list item.
     */

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_us_recycler_item, parent, false);
        return new AdapterViewHolder(view);
    }

    /**
     * Binds data to the views in the RecyclerView item at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        // Load image using Picasso library, handle success and error cases
        Picasso.get()
                .load(dataList.get(position).getDataImage())
                .resize(1500, 1000) // Set your desired width and height
                .centerCrop()     // Crop the image to fit the specified dimensions
                .into(holder.recImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, remove background
                        holder.recImage.setBackground(null); // or holder.itemImage.setBackgroundColor(Color.TRANSPARENT);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if the image fails to load
                    }
                });

        // Set text data to corresponding TextViews
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recLang.setText(dataList.get(position).getDataLang());

        // Set click listener to handle item click events
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch intent to AboutUsDA activity with relevant data
                Intent intent = new Intent(context, AboutUsDA.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the data set.
     */

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

/**
 * AdapterViewHolder represents a single item view in the RecyclerView.
 * It holds references to the ImageView, TextViews, and CardView used to display
 * the data for each AboutUsCategory item.
 */

class AdapterViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;

    /**
     * Constructor for AdapterViewHolder.
     *
     * @param itemView The View representing the RecyclerView item.
     */

    public AdapterViewHolder(@NonNull View itemView) {
        super(itemView);

        // Initialize views from the item layout
        recImage = itemView.findViewById(R.id.recImage);
        recTitle = itemView.findViewById(R.id.recTitle);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recCard = itemView.findViewById(R.id.recCard);
    }
}
