//package com.example.taskill.ui.notifications;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//
//import com.example.taskill.R;
//import com.example.taskill.databinding.FragmentHomeBinding;
//import com.example.taskill.databinding.FragmentNotificationsBinding;
//
////Uses Marketplace Fragment
//public class HomeFragment extends Fragment {
//
//    private NotificationsViewModel notificationsViewModel;
//    private FragmentHomeBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        notificationsViewModel =
//                new ViewModelProvider(this).get(NotificationsViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        /*final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });*/
//
//        ConstraintLayout cServicee1 = root.findViewById(R.id.constraintLayoutMarketPlace1);
//        cServicee1.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_hireServicee, args);
//        });
//
//        ConstraintLayout cServicee2 = root.findViewById(R.id.constraintLayoutMarketPlace2);
//        cServicee2.setOnClickListener(view -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
//            Bundle args = new Bundle();
//            navController.navigate(R.id.navigation_hireServicee, args);
//        });
//
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//}