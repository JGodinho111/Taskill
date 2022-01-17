package com.example.taskill.ui.services;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentBabysitingServiceBinding;
import com.example.taskill.ui.ServicesModel;
import com.example.taskill.ui.ServicesModelAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BabysitingServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BabysitingServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mFirestoreList;
    private FirebaseDatabase firebaseDatabase;
    private ServicesModelAdapter adapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String service ;
    EditText serviceText;
    private FragmentBabysitingServiceBinding binding;

    public BabysitingServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingleServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public BabysitingServiceFragment newInstance(String param1, String param2) {
        BabysitingServiceFragment fragment = new BabysitingServiceFragment();
        Bundle args = getArguments();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            service = getArguments().getString("service");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBabysitingServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        firebaseDatabase = FirebaseDatabase.getInstance();

        mFirestoreList = root.findViewById(R.id.firestore_list);

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(getActivity())); // Insted of this since it's a fragment

        //Query
        DatabaseReference query = firebaseDatabase.getReference().child("serviceProviders");

        //RecyclerOptions
        FirebaseRecyclerOptions<ServicesModel> options = new FirebaseRecyclerOptions.Builder<ServicesModel>()
                .setQuery(query,ServicesModel.class)
                .build();

        adapter = new ServicesModelAdapter(options);

        mFirestoreList.setAdapter(adapter);


        /*
        adapter = new FirebaseRecyclerAdapter<ServicesModel, ServicesViewHolder>(options) {

            @NonNull
            @Override
            public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new ServicesViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ServicesViewHolder holder, int position, @NonNull ServicesModel model) {
                holder.list_name.setText(model.getName());
                //holder.list_email.setText(model.getEmail());
            }
        };
         */


        //FirestoreRecyclerOptions<ServicesModel> options = new FirestoreRecyclerOptions.Builder<>();
        //View Holder


        //serviceText = root.findViewById(R.id.viewerBaby);
        //serviceText.setText(service);
        View v =  inflater.inflate(R.layout.fragment_babysiting_service, container, false);
//TODO - Meter este ficheiro bem no formato Home/Dashboard/Notifications


       /* ConstraintLayout cServicee1 = root.findViewById(R.id.constraintLayoutSS1);
        cServicee1.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service", service);
            navController.navigate(R.id.navigation_hireServicee, args);


        });
        ConstraintLayout cServicee2 = root.findViewById(R.id.constraintLayoutSS2);
        cServicee2.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service", service);
            navController.navigate(R.id.navigation_hireServicee, args);
        });
        ConstraintLayout cServicee3 = root.findViewById(R.id.constraintLayoutSS3);
        cServicee3.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service", service);
            navController.navigate(R.id.navigation_hireServicee, args);
        });*/

        /*
        ConstraintLayout c = v.findViewById(R.id.constraintLayout2);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c3 = v.findViewById(R.id.constraintLayout3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c4 = v.findViewById(R.id.constraintLayout4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c5 = v.findViewById(R.id.constraintLayout5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c6 = v.findViewById(R.id.constraintLayout6);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c7 = v.findViewById(R.id.constraintLayout7);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ConstraintLayout c8 = v.findViewById(R.id.constraintLayout8);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HireFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
         */
        return root;
    }

    /*
    private class ServicesViewHolder extends RecyclerView.ViewHolder{

        private TextView list_name;
        //private TextView list_email;

        public ServicesViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            //list_email = itemView.findViewById(R.id.list_email);
        }
    }

     */

    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
}