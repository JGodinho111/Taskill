package com.example.taskill.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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


        View bBabysitting = root.findViewById(R.id.imageButton);
        bBabysitting.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_babysiting_service, args);
        });

        View bCleaning = root.findViewById(R.id.imageButton2);
        bCleaning.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_babysiting_service, args);
        });

        View bRepairs = root.findViewById(R.id.imageButton3);
        bRepairs.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_babysiting_service, args);
        });
        View bShopping = root.findViewById(R.id.imageButton4);
        bShopping.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
            Bundle args = new Bundle();
            navController.navigate(R.id.navigation_babysiting_service, args);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}