package com.example.petallies.services;

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

import com.example.petallies.ServicesAD;
import com.example.petallies.R;
import com.example.petallies.ServicesAD;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * ServicesAdapter is a RecyclerView Adapter used to display a list of SDataClass objects representing services.
 * It inflates the services_recycler_item layout for each item, loads images using Picasso, and sets
 * service title, description, and subject information. Additionally, it handles the click event on items,
 * launching an Intent to AboutUsDA activity with relevant data.
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesViewHolder> {

    private Context context;
    private List<SDataClass> dataList;

    /**
     * Constructor for ServicesAdapter.
     *
     * @param context The context in which the adapter is used.
     * @param dataList List of SDataClass objects representing services to be displayed in the RecyclerView.
     */
    public ServicesAdapter(Context context, List<SDataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * Inflates the RecyclerView item layout and returns a new instance of ServicesViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new ServicesViewHolder that holds the View for each list item.
     */
    @NonNull
    @Override
    public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_recycler_item, parent, false);
        return new ServicesViewHolder(view);
    }

    /**
     * Binds data to the views in the RecyclerView item at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {

        // Use Picasso to load the image from the URL into the ImageView
        Picasso.get()
                .load(dataList.get(position).getsDataImage())
                .resize(1500, 1000) // Set your desired width and height
                .centerCrop()     // Crop the image to fit the specified dimensions
                .into(holder.sRecImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, remove background
                        holder.sRecImage.setBackground(null); // or holder.itemImage.setBackgroundColor(Color.TRANSPARENT);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if the image fails to load
                    }
                });

        // Set service title, description, and language
        holder.sRecTitle.setText(dataList.get(position).getsDataTitle());
        holder.sRecDesc.setText(dataList.get(position).getsDataDesc());
        holder.sRecLang.setText(dataList.get(position).getsDataLang());

        // Set click listener to launch an Intent to AboutUsDA activity with relevant data
        holder.sRecCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ServicesAD.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getsDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getsDataTitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getsDataDesc());

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
 * ServicesViewHolder represents a single item view in the RecyclerView for services.
 * It holds references to the ImageView, TextViews for service title, description, language, and the CardView.
 */
class ServicesViewHolder extends RecyclerView.ViewHolder{

    ImageView sRecImage;
    TextView sRecTitle, sRecDesc, sRecLang;
    CardView sRecCard;

    /**
     * Constructor for ServicesViewHolder.
     *
     * @param itemView The View representing the RecyclerView item.
     */
    public ServicesViewHolder(@NonNull View itemView) {
        super(itemView);

        // Initialize views from the item layout
        sRecImage = itemView.findViewById(R.id.sRecImage);
        sRecTitle = itemView.findViewById(R.id.sRecTitle);
        sRecDesc = itemView.findViewById(R.id.sRecDesc);
        sRecLang = itemView.findViewById(R.id.sRecLang);
        sRecCard = itemView.findViewById(R.id.sRecCard);
    }
}
