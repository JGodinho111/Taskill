package com.example.taskill;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.taskill.databinding.FragmentHireBinding;
import com.example.taskill.databinding.FragmentSettingsBinding;

import java.util.Calendar;

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
    private View v = null;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentHireBinding binding;

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
    public static HireFragment newInstance(String param1, String param2) {
        HireFragment fragment = new HireFragment();
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
        v = inflater.inflate(R.layout.fragment_hire, container, false);
        binding = FragmentHireBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View bGoToBooking = root.findViewById(R.id.buttonBooking);
        bGoToBooking.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            TextView textView = root.findViewById(R.id.textViewHireServiceeName);
            args.putString("name", textView.getText().toString());
            navController.navigate(R.id.navigation_booking, args);
        });

        Button bHireChat = (Button) v.findViewById(R.id.buttonHireChat);
        bHireChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO - Abrir chat firebase que não permite a partilha de dados pessoais,
                // para garantir que o serviço é feito pela app, mas
                // que permite que o servicee crie novos blocos de disponibilidade dentro do chat
                // para utilizadores poderem depois usar isso para marcar
            }
        });

        return root;
    }
}