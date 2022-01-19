package com.example.taskill.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View v = null;
    private FragmentProfileBinding binding;
    private String activeUserId;

    String emailFromDB;
    String nameFromDB;
    String usernameFromDB;

    private String currentUserId;

    FirebaseAuth mAuth;
    SharedPreferences sp;

    ImageView logout_btn;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
            activeUserId = getArguments().getString("activeUserId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout layout = root.findViewById(R.id.bookings_button);

        mAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        currentUserId= firebaseUser.getUid();

        TextView nameToShow = root.findViewById(R.id.profile_username);
        TextView emailToShow = root.findViewById(R.id.profile_email);

        sp=getActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String userType = sp.getString("type", "");

        //TODO - Deixou de funcionar para providers não sei pq
        if(userType.equals("service_provider")){
            DatabaseReference serviceProvidersRef = FirebaseDatabase.getInstance().getReference().child("serviceProviders");
            Query query = serviceProvidersRef.orderByKey().equalTo(currentUserId);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                        emailFromDB = userSnapshot.child("email").getValue(String.class);
                        nameFromDB = userSnapshot.child("name").getValue(String.class);
                        usernameFromDB = userSnapshot.child("username").getValue(String.class);
                        nameToShow.setText(nameFromDB);
                        emailToShow.setText(emailFromDB);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    throw databaseError.toException();
                }
            });
        } else {
            DatabaseReference serviceProvidersRef = FirebaseDatabase.getInstance().getReference().child("serviceUsers");
            Query query = serviceProvidersRef.orderByKey().equalTo(currentUserId);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                        emailFromDB = userSnapshot.child("email").getValue(String.class);
                        nameFromDB = userSnapshot.child("name").getValue(String.class);
                        usernameFromDB = userSnapshot.child("username").getValue(String.class);
                        nameToShow.setText(nameFromDB);
                        emailToShow.setText(emailFromDB);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    throw databaseError.toException();
                }
            });


            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getActivity(), UserBookingsActivity.class);
                    //intent.putExtra("userId", currentUserId);
                    startActivity(intent);
                }
            });

            logout_btn= root.findViewById(R.id.logout_button);
            logout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAuth.signOut();
                    Intent intent= new Intent(getActivity(), SplashActivity.class);
                    startActivity(intent);


                }
            });

        }

        //emailToShow.setText(firebaseUser.getEmail());
        //nameToShow.setText(currentUserId);





        //nameToShow.setText(currentUserId);
        //emailToShow.setText(emailFromDB);

        return root;
    }
}