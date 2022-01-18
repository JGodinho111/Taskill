package com.example.taskill.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//Uses Menu Fragment
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private String activeUserId;

    FirebaseAuth mAuth;

    ImageView btn_profile;
    ImageView btn_pbabysiting;
    ImageView btn_pcleaning;
    ImageView btn_pelectrician;
    ImageView btn_plawncare;

    ImageView btn_cleaning;
    ImageView btn_locksmith;
    ImageView btn_lawncare;
    ImageView btn_babysiting;
    ImageView btn_dogwalking;
    ImageView btn_carpenter;
    ImageView btn_electrician;
    ImageView btn_plumber;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mAuth= FirebaseAuth.getInstance();
        activeUserId= mAuth.getCurrentUser().getUid();

        btn_profile=root.findViewById(R.id.profile_button);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("activeUserId",activeUserId);
                navController.navigate(R.id.navigation_profile, args);
            }


        });

        btn_pbabysiting=root.findViewById(R.id.babysitting);
        btn_pbabysiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","babysitting");
                navController.navigate(R.id.navigation_babysiting_service, args);
            }


        });

        btn_babysiting=root.findViewById(R.id.babysitting2);
        btn_babysiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","babysitting");
                navController.navigate(R.id.navigation_babysiting_service, args);
            }


        });

        btn_carpenter=root.findViewById(R.id.carpenter);
        btn_carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","carpenter");
                navController.navigate(R.id.navigation_carpenter_service, args);
            }
        });

        btn_pcleaning=root.findViewById(R.id.cleaning);
        btn_pcleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","cleaning");
                navController.navigate(R.id.navigation_cleaning_service, args);
            }
        });

        btn_cleaning=root.findViewById(R.id.cleaning2);
        btn_cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","cleaning");
                navController.navigate(R.id.navigation_cleaning_service, args);
            }
        });

        btn_pelectrician=root.findViewById(R.id.electrician);
        btn_pelectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","electrician");
                navController.navigate(R.id.navigation_electrician_service, args);
            }
        });

        btn_electrician=root.findViewById(R.id.electrician2);
        btn_electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","electrician");
                navController.navigate(R.id.navigation_electrician_service, args);
            }
        });

        btn_plawncare=root.findViewById(R.id.lawncare2);
        btn_plawncare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","lawncare");
                navController.navigate(R.id.navigation_lawncare_service, args);
            }
        });

        btn_lawncare=root.findViewById(R.id.lawncare);
        btn_lawncare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","lawncare");
                navController.navigate(R.id.navigation_lawncare_service, args);
            }
        });

        btn_locksmith=root.findViewById(R.id.locksmith);
        btn_locksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","locksmith");
                navController.navigate(R.id.navigation_locksmith_service, args);
            }
        });

        btn_plumber=root.findViewById(R.id.plumber);
        btn_plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","plumber");
                navController.navigate(R.id.navigation_plumber_service, args);
            }
        });

        btn_dogwalking=root.findViewById(R.id.dogwalking2);
        btn_dogwalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
                Bundle args = new Bundle();
                args.putString("service","dogwalking");
                navController.navigate(R.id.navigation_dogwalking_service, args);
            }
        });


//        View bServices = root.findViewById(R.id.imageButtonServices);
//        bServices.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_services, args);
//        });
//        View bMarketplace = root.findViewById(R.id.imageButtonMarketplace);
//        bMarketplace.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_marketplace, args);
//        });
//        View bProfile = root.findViewById(R.id.imageButtonProfile);
//        bProfile.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_profile, args);
//        });
//        View bSettings = root.findViewById(R.id.imageButtonSettings);
//        bSettings.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_settings, args);
//        });
//        View bHelp = root.findViewById(R.id.imageButtonHelp);
//        bHelp.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_help, args);
//        });
//        View bLogout = root.findViewById(R.id.imageButtonLogout);
//        bLogout.setOnClickListener(view -> {
//            startActivity(new Intent(((MainActivityBot)getActivity()), LogInActivity.class));
//        });

        /*
        ImageButton b1 = (ImageButton) v.findViewById(R.id.imageButtonServices);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ServicesFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b2 = (ImageButton) v.findViewById(R.id.imageButtonMarketplace);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MarketplaceFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b3 = (ImageButton) v.findViewById(R.id.imageButtonProfile);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ProfileFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b4 = (ImageButton) v.findViewById(R.id.imageButtonSettings);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SettingsFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                //FragmentManager fm = ((MainActivity)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b5 = (ImageButton) v.findViewById(R.id.imageButtonHelp);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HelpFragment();
                FragmentManager fm = ((MainActivityBot)getActivity()).fragmentManager;
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main_bot,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ImageButton b6 = (ImageButton) v.findViewById(R.id.imageButtonLogout);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(((MainActivityBot)getActivity()), LogInActivity.class));
            }
        });
         */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}