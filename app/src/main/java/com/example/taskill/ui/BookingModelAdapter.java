package com.example.taskill.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskill.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class BookingModelAdapter extends FirebaseRecyclerAdapter<
        BookingModel, BookingModelAdapter.BookingModelsViewholder> {

    private Context context;

    public BookingModelAdapter(
            @NonNull FirebaseRecyclerOptions<BookingModel> options, Context context)
    {
        super(options);
        this.context = context;

    }

    // Function to bind the view in Card view(here
    // "person.xml") with data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull BookingModelsViewholder holder,
                     int position, @NonNull BookingModel model)
    {

        holder.list_booking_name.setText(model.getServiceProvider());
        holder.list_booking_service.setText(model.getService());
        holder.list_booking_status.setText(model.getStatus().toString());
        holder.list_booking_date.setText(model.getDateAndTime());
        holder.list_booking_price.setText(model.getPrice());
        holder.list_booking_address.setText(model.getAddress());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public BookingModelsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_booking_single, parent, false);
        return new BookingModelAdapter.BookingModelsViewholder(view);
    }

    // Sub Class to create references of the views in Card
    // view (here "person.xml")
    class BookingModelsViewholder
            extends RecyclerView.ViewHolder {

        TextView list_booking_name, list_booking_service,list_booking_status, list_booking_date,list_booking_price,list_booking_address;

        public BookingModelsViewholder(@NonNull View itemView)
        {
            super(itemView);

            list_booking_name = itemView.findViewById(R.id.list_booking_name);
            list_booking_service = itemView.findViewById(R.id.list_booking_service);
            list_booking_status = itemView.findViewById(R.id.list_booking_status);
            list_booking_date = itemView.findViewById(R.id.list_booking_date);
            list_booking_price = itemView.findViewById(R.id.list_booking_price);
            list_booking_address = itemView.findViewById(R.id.list_booking_address);

        }
    }
}