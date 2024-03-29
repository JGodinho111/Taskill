package com.example.taskill.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.taskill.databinding.FragmentHireBinding;
import com.example.taskill.databinding.FragmentSettingsBinding;

//<<<<<<< HEAD:app/src/main/java/com/example/taskill/ui/HireFragment.java
import com.example.taskill.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//=======
//>>>>>>> booking:app/src/main/java/com/example/taskill/HireFragment.java
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HireFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HireFragment extends Fragment {


    Calendar calendar = Calendar.getInstance();
    int year=calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH);
    int day=calendar.get(Calendar.DAY_OF_MONTH);
    String edittext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String name;
    private View v = null;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String service;
    private FragmentHireBinding binding;

    private String receiverUserID;
    private FirebaseDatabase firebaseDatabase;

    String emailFromDB;
    String nameFromDB;
    String servicesFromDB;
    String usernameFromDB;

    public HireFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HireFragment.
     */
    // TODO: Rename and change types and number of parameters
    public HireFragment newInstance(String param1, String param2, String receiverUserID) {
        HireFragment fragment = new HireFragment();
        Bundle args = getArguments();
        args.putString(ARG_PARAM1, param1);
        name = ARG_PARAM1;
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
            receiverUserID = getArguments().getString("visitUserId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_hire, container, false);
        binding = FragmentHireBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //TextView nameKey = root.findViewById(R.id.textViewHireServiceeName2);
        //nameKey.setText(receiverUserID);

        TextView nameToShow = root.findViewById(R.id.textViewHireServiceeName);
        TextView serviceProvidedToShow = root.findViewById(R.id.textViewHireService);
        TextView servicePrice = root.findViewById(R.id.textViewHirePrice);

        DatabaseReference serviceProvidersRef = FirebaseDatabase.getInstance().getReference().child("serviceProviders");
        Query query = serviceProvidersRef.orderByKey().equalTo(receiverUserID);
        firebaseDatabase = FirebaseDatabase.getInstance();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    emailFromDB = userSnapshot.child("email").getValue(String.class);
                    Iterable<DataSnapshot> map = userSnapshot.child("provided_services").getChildren();
                    nameFromDB = userSnapshot.child("name").getValue(String.class);
                    servicesFromDB = userSnapshot.child("services").getValue(String.class);
                    usernameFromDB = userSnapshot.child("username").getValue(String.class);
                    nameToShow.setText(nameFromDB);


                    //test code -> edit
                    for (DataSnapshot s : map) {
                        if(s.getKey().equals(service)){
                            serviceProvidedToShow.equals(s);
                            serviceProvidedToShow.setText(s.getKey());
                            servicePrice.setText(s.getValue().toString() + " €");

                        }
                    }
                    //serviceProvidedToShow.setText(servicesFromDB);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

        View bGoToBooking = root.findViewById(R.id.buttonBooking);
        bGoToBooking.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            TextView textView = root.findViewById(R.id.textViewHireServiceeName);
            args.putString("name", textView.getText().toString());
            args.putString("service", service);
            args.putString("receiverUserId", receiverUserID);
            navController.navigate(R.id.navigation_booking, args);
        });

       /* Button bHireChat = (Button) v.findViewById(R.id.buttonHireChat);
        bHireChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO - Abrir chat firebase que não permite a partilha de dados pessoais,
                // para garantir que o serviço é feito pela app, mas
                // que permite que o servicee crie novos blocos de disponibilidade dentro do chat
                // para utilizadores poderem depois usar isso para marcar
            }
        });*/

        return root;
    }
}