package com.example.taskill.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskill.R;
import com.example.taskill.data.Booking;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mFirestoreList;
    private FirebaseDatabase firebaseDatabase;
    private BookingModelAdapter adapter;

    FirebaseAuth mAuth;
    SharedPreferences sp;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();

        mFirestoreList = v.findViewById(R.id.firestore_booking_list);

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(v.getContext())); // Insted of this since it's a fragment

        sp=getActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String userType = sp.getString("type", "");

        DatabaseReference bookingsRef = firebaseDatabase.getReference();
        Query query = bookingsRef;
        //String cc = mAuth.getInstance().getCurrentUser().getUid();
        //if(mAuth.getInstance().getCurrentUser().getUid().isEmpty())

        if(userType.equals("service_provider")){
            //Query
            query = bookingsRef.child("serviceProviders").child(mAuth.getInstance().getCurrentUser().getUid()).child("bookings");
        } else {
            query = bookingsRef.child("serviceUsers").child(mAuth.getInstance().getCurrentUser().getUid()).child("bookings");
        }

        //RecyclerOptions

        FirebaseRecyclerOptions<BookingModel> options = new FirebaseRecyclerOptions.Builder<BookingModel>()
                .setQuery(query,BookingModel.class)
                .build();


        adapter = new BookingModelAdapter(options,v.getContext());

        mFirestoreList.setAdapter(adapter);

        return v;
    }
}