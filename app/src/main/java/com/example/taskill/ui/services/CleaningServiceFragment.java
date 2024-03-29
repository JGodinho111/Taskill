package com.example.taskill.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentCleaningServiceBinding;
import com.example.taskill.ui.ServicesModel;
import com.example.taskill.ui.ServicesModelAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class CleaningServiceFragment extends Fragment {

    private RecyclerView mFirestoreList;
    private FirebaseDatabase firebaseDatabase;
    private ServicesModelAdapter adapter;

    private FragmentCleaningServiceBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String service ;

    public CleaningServiceFragment() {
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
    public CleaningServiceFragment newInstance(String param1, String param2) {
        CleaningServiceFragment fragment = new CleaningServiceFragment();
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
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCleaningServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firebaseDatabase = FirebaseDatabase.getInstance();

        mFirestoreList = root.findViewById(R.id.firestore_list_cleaning);

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(getActivity())); // Instead of this since it's a fragment

        //Query
        DatabaseReference serviceProvidersRef = firebaseDatabase.getReference().child("serviceProviders");
        Query query = serviceProvidersRef.orderByChild("provided_services/cleaning");

        //RecyclerOptions
        FirebaseRecyclerOptions<ServicesModel> options = new FirebaseRecyclerOptions.Builder<ServicesModel>()
                .setQuery(query,ServicesModel.class)
                .build();

        adapter = new ServicesModelAdapter(options,getContext(), "cleaning");

        mFirestoreList.setAdapter(adapter);

        View v = inflater.inflate(R.layout.fragment_cleaning_service, container, false);

        return root;

    }

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
