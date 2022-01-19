package com.example.taskill.ui;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskill.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.Map;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class ServicesModelAdapter extends FirebaseRecyclerAdapter<
        ServicesModel, ServicesModelAdapter.ServicesModelsViewholder> {

    private Context context;

    private String service;

    public ServicesModelAdapter(
            @NonNull FirebaseRecyclerOptions<ServicesModel> options, Context context, String service)
    {
        super(options);
        this.context = context;
        this.service = service;
    }

    @Override
    protected void
    onBindViewHolder(@NonNull ServicesModelsViewholder holder,
                     int position, @NonNull ServicesModel model)
    {

        if(!model.getProvided_services().keySet().isEmpty()){
            for (String s : model.getProvided_services().keySet()) {
                if(s.equals(service)){

                    holder.list_name.setText(model.getName());

                    holder.list_email.setText(model.getEmail());

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String visitUserId = getRef(holder.getLayoutPosition()).getKey(); //or just position

                            NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment_activity_main_bot);
                            Bundle args = new Bundle();
                            args.putString("visitUserId", visitUserId);
                            args.putString("service", service);
                            navController.navigate(R.id.navigation_hireServicee, args);
                        }
                    });
                } else {
                    //holder.itemView.setVisibility(View.GONE);
                }
            }
        }
        if(!model.getProvided_services().keySet().contains(service)){
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }
        else{
            holder.itemView.setVisibility(View.VISIBLE);
        }
    }

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