package com.example.taskill;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServicesFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicesFragment newInstance(String param1, String param2) {
        ServicesFragment fragment = new ServicesFragment();
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
        View v = inflater.inflate(R.layout.fragment_services, container, false);
        ImageButton b1 = v.findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b2 = v.findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b3 = v.findViewById(R.id.imageButton3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b4 = v.findViewById(R.id.imageButton4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b5 = v.findViewById(R.id.imageButton5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b6 = v.findViewById(R.id.imageButton6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b7 = v.findViewById(R.id.imageButton7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b8 = v.findViewById(R.id.imageButton8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b9 = v.findViewById(R.id.imageButton9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b10 = v.findViewById(R.id.imageButton10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SingleServiceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return v;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = new SingleServiceFragment();
        FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
        //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.menu,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}