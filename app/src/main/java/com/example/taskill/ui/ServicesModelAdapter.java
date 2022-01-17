package com.example.taskill.ui;
import android.app.Service;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskill.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class ServicesModelAdapter extends FirebaseRecyclerAdapter<
        ServicesModel, ServicesModelAdapter.ServicesModelsViewholder> {

    public ServicesModelAdapter(
            @NonNull FirebaseRecyclerOptions<ServicesModel> options)
    {
        super(options);
    }


    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull ServicesModelsViewholder holder,
                     int position, @NonNull ServicesModel model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.list_name.setText(model.getName());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.list_email.setText(model.getEmail());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public ServicesModelsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_single, parent, false);
        return new ServicesModelAdapter.ServicesModelsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class ServicesModelsViewholder
            extends RecyclerView.ViewHolder {
        TextView list_name, list_email;
        public ServicesModelsViewholder(@NonNull View itemView)
        {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_email = itemView.findViewById(R.id.list_email);
        }
    }
}