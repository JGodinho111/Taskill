package com.example.taskill;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.io.ObjectInputStream;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        View v = inflater.inflate(R.layout.fragment_hire, container, false);
        Button bHireCalendar = (Button) v.findViewById(R.id.buttonHireCalendar);
        bHireCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO - Abrir calendario com datas disponíveis e
                // poder selecionar e avançar para o pagamento
                DatePickerDialog datePickerDialog = new DatePickerDialog(((MainActivity)getActivity()), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                        //edittext.setText("" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year)

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
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

        return v;
    }
}