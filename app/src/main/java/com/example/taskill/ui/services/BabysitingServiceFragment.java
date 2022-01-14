package com.example.taskill.ui.services;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentBabysitingServiceBinding;

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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
    public static BabysitingServiceFragment newInstance(String param1, String param2) {
        BabysitingServiceFragment fragment = new BabysitingServiceFragment();
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
        View v =  inflater.inflate(R.layout.fragment_babysiting_service, container, false);
//TODO - Meter este ficheiro bem no formato Home/Dashboard/Notifications
        binding = FragmentBabysitingServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ConstraintLayout cServicee1 = root.findViewById(R.id.constraintLayoutSS1);
        cServicee1.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_hireServicee, args);
        });
        ConstraintLayout cServicee2 = root.findViewById(R.id.constraintLayoutSS2);
        cServicee2.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_hireServicee, args);
        });
        ConstraintLayout cServicee3 = root.findViewById(R.id.constraintLayoutSS3);
        cServicee3.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_hireServicee, args);
        });

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
}