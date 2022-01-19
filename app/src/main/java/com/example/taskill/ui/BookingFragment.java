package com.example.taskill.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.taskill.R;
import com.example.taskill.data.Booking;
import com.example.taskill.data.ServiceProvider;
import com.example.taskill.data.ServiceUser;
import com.example.taskill.databinding.FragmentBookingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentBookingBinding binding;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private EditText textWithTime;
    Bundle bundle = this.getArguments();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String name;
    String service;
    SharedPreferences sp;
    String pathName;
    FirebaseAuth mAuth;
    private String currentUserId;
    private String receiverUserId;

    public BookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
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
            name = getArguments().getString("name");
            service = getArguments().getString("service");
            receiverUserId = getArguments().getString("receiverUserId");
        }
        sp= getActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking, container, false);

        binding = FragmentBookingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button selectTime = (Button) root.findViewById(R.id.date_time_input);
        textWithTime = root.findViewById(R.id.text_with_date);
        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
                                String data = simpleDateFormat.format(calendar.getTime());
                                textWithTime.setText(data);
                                //String path = "bookings/" + name + "/" + data;
                                //StorageReference ref = storage.getReference(path);
                                //UploadTask uploadTask = ref.putBytes(data.getBytes());
                                //date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                                //Botão Confirmar--CHECK
                                //Alterar Storage -> Real Time Database
                                //Obter dados do Real Time Database
                                //Verificar se já existe bookings com menos de uma hora de diferença
                            }
                        };

                        new TimePickerDialog(getActivity(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                    }
                };
                new DatePickerDialog(getActivity(),dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        Button confirm = (Button) root.findViewById(R.id.button_confirm);
        confirm.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            pathName = textWithTime.getText().toString();
            if (!pathName.equals("Data e Hora escolhida") ){
                String path = "bookings/" + name + "/" + pathName;
                //StorageReference ref = storage.getReference(path);
                //UploadTask uploadTask = ref.putBytes(pathName.getBytes());
                SendDataToFirebase();
            }
            args.putString("service",service);
            args.putString("visitUserId", receiverUserId);
            navController.navigate(R.id.navigation_hireServicee, args);
            });

        return root;
    }
    private void SendDataToFirebase() {
        //1-Buscar User à base de dados
        //2-Pesquisar na BD pelo nome de utilizador
        //3-Transformar os bookings para uma lista
        //4-Adicionar o novo booking
        //5-Voltar a enviar para a BD
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        String address = "morada";
        String serviceRequester = sp.getString("user","");
        //String name = "aaaaaa";
        //String email = "aaaaaa@gmail.com";
        //String password = "default";
        mAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        currentUserId= firebaseUser.getUid();
        DatabaseReference serviceProvidersRef = FirebaseDatabase.getInstance().getReference().child("serviceProviders");

        Query query = serviceProvidersRef.orderByKey().equalTo(receiverUserId);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //String name = snapshot.child(currentUserId).child("name").getValue(String.class);
                    //String email = snapshot.child(currentUserId).child("email").getValue(String.class);
                    //String password = snapshot.child(currentUserId).child("password").getValue(String.class);
                    for (DataSnapshot userSnapshot: snapshot.getChildren()) {
                        //List<Booking> bookings = userSnapshot.child("bookings").getValue(List.class);
                        String name = userSnapshot.child("name").getValue(String.class);
                        String email = userSnapshot.child("email").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);
                        String username = userSnapshot.child("username").getValue(String.class);
                        List<Booking> bookings = new ArrayList<>();
                        Map<String,Integer> provided_services = new Map<String, Integer>() {
                            @Override
                            public int size() {
                                return 0;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public boolean containsKey(@Nullable Object o) {
                                return false;
                            }

                            @Override
                            public boolean containsValue(@Nullable Object o) {
                                return false;
                            }

                            @Nullable
                            @Override
                            public Integer get(@Nullable Object o) {
                                return null;
                            }

                            @Nullable
                            @Override
                            public Integer put(String s, Integer integer) {
                                return null;
                            }

                            @Nullable
                            @Override
                            public Integer remove(@Nullable Object o) {
                                return null;
                            }

                            @Override
                            public void putAll(@NonNull Map<? extends String, ? extends Integer> map) {

                            }

                            @Override
                            public void clear() {

                            }

                            @NonNull
                            @Override
                            public Set<String> keySet() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public Collection<Integer> values() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public Set<Entry<String, Integer>> entrySet() {
                                return null;
                            }
                        };
                        //Map<String,Integer> provided_services = userSnapshot.child("provided_services").getValue(Map<String,Integer>.class);
                        String dateAndTime = pathName;
                        Booking newBooking= new Booking(address, receiverUserId, currentUserId,service, dateAndTime,5);
                        //(String name, String username, String email, String password, List<Booking> bookings, Map<String,Integer> provided_services)
                        ServiceProvider newProvider= new ServiceProvider(name,username, email, password, bookings, provided_services);
                        newProvider.addBooking(newBooking);

                        serviceProvidersRef.child(receiverUserId).child("bookings").child(mAuth.getCurrentUser().getUid() + receiverUserId + dateAndTime).setValue(newBooking);
                    }

                    //String serviceProvider = name;

                    //String password = sp.getString("password","");


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        DatabaseReference serviceUsersRef = FirebaseDatabase.getInstance().getReference().child("serviceUsers");

        Query query2 = serviceUsersRef.orderByKey().equalTo(currentUserId);

        query2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //String name = snapshot.child(currentUserId).child("name").getValue(String.class);
                    //String email = snapshot.child(currentUserId).child("email").getValue(String.class);
                    //String password = snapshot.child(currentUserId).child("password").getValue(String.class);
                    for (DataSnapshot userSnapshot: snapshot.getChildren()) {
                        //List<Booking> bookings = userSnapshot.child("bookings").getValue(List.class);
                        String name = userSnapshot.child("name").getValue(String.class);
                        String email = userSnapshot.child("email").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);
                        String username = userSnapshot.child("username").getValue(String.class);
                        String dateAndTime = pathName;
                        List<Booking> bookings = new ArrayList<>();
                        Booking newBooking= new Booking(address, receiverUserId, currentUserId,service, dateAndTime,5);
                        //(String name, String username, String email, String password, List<Booking> bookings, Map<String,Integer> provided_services)
                        ServiceUser newServiceUser= new ServiceUser(name, username, email, password, bookings);
                        newServiceUser.addBooking(newBooking);
                        serviceUsersRef.child(mAuth.getCurrentUser().getUid()).child("bookings").child(mAuth.getCurrentUser().getUid() + receiverUserId + dateAndTime).setValue(newBooking);
                    }

                    //String serviceProvider = name;

                    //String password = sp.getString("password","");


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    /*public void showDateTimeDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                        //date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(getActivity(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        };
    }*/
}