package ga.inho.inho.client.ui.water;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ga.inho.inho.client.R;

public class WaterFragment extends Fragment {

    private WaterViewModel waterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        waterViewModel =
                ViewModelProviders.of(this).get(WaterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_water, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        waterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
