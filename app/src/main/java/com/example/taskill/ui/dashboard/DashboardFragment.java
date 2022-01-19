package com.example.taskill.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentDashboardBinding;

//Uses Services Fragment
public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View bCleaning = root.findViewById(R.id.imageButtonCleaning);
        bCleaning.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","cleaning");
            navController.navigate(R.id.navigation_cleaning_service, args);
        });

        View bLockSmith = root.findViewById(R.id.imageButtonLockSmith);
        bLockSmith.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","locksmith");
            navController.navigate(R.id.navigation_locksmith_service, args);
        });

        View bPlumber = root.findViewById(R.id.imageButtonPlumber);
        bPlumber.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","plumber");
            navController.navigate(R.id.navigation_plumber_service, args);
        });
        View bLawncare = root.findViewById(R.id.imageButtonLawncare);
        bLawncare.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","lawncare");
            navController.navigate(R.id.navigation_lawncare_service, args);
        });

        View bElectrician = root.findViewById(R.id.imageButtonElectrician);
        bElectrician.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","electrician");
            navController.navigate(R.id.navigation_electrician_service, args);
        });

        View bBabysitting = root.findViewById(R.id.imageButtonBabysitting);
        bBabysitting.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","babysitting");
            navController.navigate(R.id.navigation_babysiting_service, args);
        });

        View bDogWalking = root.findViewById(R.id.imageButtonDogWalking);
        bDogWalking.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","dogwalking");
            navController.navigate(R.id.navigation_dogwalking_service, args);
        });
        View bCarpenter = root.findViewById(R.id.imageButtonCarpenter);
        bCarpenter.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            args.putString("service","carpenter");
            navController.navigate(R.id.navigation_carpenter_service, args);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}