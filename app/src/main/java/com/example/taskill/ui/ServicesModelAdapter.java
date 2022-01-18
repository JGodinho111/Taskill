package com.example.taskill.ui;
import android.app.Activity;
import android.app.Service;
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
import com.example.taskill.ui.services.BabysitingServiceFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class ServicesModelAdapter extends FirebaseRecyclerAdapter<
        ServicesModel, ServicesModelAdapter.ServicesModelsViewholder> {

    private ArrayList<ServicesModel> mProviders = new ArrayList<>();

    private Context context;

    public ServicesModelAdapter(
            @NonNull FirebaseRecyclerOptions<ServicesModel> options, Context context)
    {
        super(options);
        this.context = context;
    }

    // Function to bind the view in Card view(here
    // "person.xml") with data in
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visitUserId = getRef(holder.getLayoutPosition()).getKey(); //or just position

                NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("visitUserId", visitUserId);
                navController.navigate(R.id.navigation_hireServicee, args);
            }
        });
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

    // Sub Class to create references of the views in Card
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