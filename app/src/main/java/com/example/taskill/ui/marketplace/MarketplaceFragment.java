package com.example.taskill.ui.marketplace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskill.R;
import com.example.taskill.databinding.FragmentHomeBinding;
import com.example.taskill.databinding.FragmentMarketplaceBinding;

//Uses Marketplace Fragment
public class MarketplaceFragment extends Fragment {

    private MarketplaceViewModel marketplaceViewModel;
    private FragmentMarketplaceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        marketplaceViewModel =
                new ViewModelProvider(this).get(MarketplaceViewModel.class);

        binding = FragmentMarketplaceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

       Button readmore = root.findViewById(R.id.button_marketplace);
       readmore.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main_bot);
               Bundle args = new Bundle();
               navController.navigate(R.id.marketplaceItemFragment, args);
           }
       });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}