package com.example.petallies.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petallies.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    private Context context;
    private List<EDataClass> dataList;

    /**
     * Constructor for EmployeeAdapter.
     *
     * @param context The context in which the adapter is used.
     * @param dataList List of AboutUsCategory items to be displayed in the RecyclerView.
     */

    public EmployeeAdapter(Context context, List<EDataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * Inflates the RecyclerView item layout and returns a new instance of EmployeeViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new EmployeeViewHolder that holds the View for each list item.
     */

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employees_recycler_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    /**
     * Binds data to the views in the RecyclerView item at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        // Load image using Picasso library, handle success and error cases
        Picasso.get()
                .load(dataList.get(position).geteDataImage())
                .resize(1500, 1000) // Set your desired width and height
                .centerCrop()     // Crop the image to fit the specified dimensions
                .into(holder.staffImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, remove background
                        holder.staffImage.setBackground(null); // or holder.itemImage.setBackgroundColor(Color.TRANSPARENT);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if the image fails to load
                    }
                });
        // Set text data to corresponding TextViews
        holder.staffName.setText(dataList.get(position).geteDataName());
        holder.staffRole.setText(dataList.get(position).geteDataRole());
        holder.staffAvailable.setChecked(dataList.get(position).geteDataAvailable());

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
 * EmployeeViewHolder represents a single item view in the RecyclerView.
 * It holds references to the ImageView, TextViews, and SwitchCompat used to display
 * the data for each EDataClass item.
 */
class EmployeeViewHolder extends RecyclerView.ViewHolder{

    ImageView staffImage;
    TextView staffName, staffRole;
    SwitchCompat staffAvailable;

    /**
     * Constructor for EmployeeViewHolder.
     *
     * @param itemView The View representing the RecyclerView item.
     */
    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);

        staffImage = itemView.findViewById(R.id.staffImage);
        staffName = itemView.findViewById(R.id.staffName);
        staffRole = itemView.findViewById(R.id.staffRole);
        staffAvailable = itemView.findViewById(R.id.staffAvailable);
    }
}
