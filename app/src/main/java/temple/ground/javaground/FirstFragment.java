package temple.ground.javaground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import temple.ground.javaground.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Toast button
        binding.toastButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getContext(), R.string.toast_text, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );
        // Count button
        binding.countButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        increaseNumber();
                    }
                }
        );
        // Random button
        binding.randomButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navigateToSecondScreen();
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void increaseNumber() {
        String text = binding.textviewFirst.getText().toString();
        int number = Integer.parseInt(text);
        number++;
        binding.textviewFirst.setText(String.valueOf(number));
    }

    private void navigateToSecondScreen() {
        String text = binding.textviewFirst.getText().toString();
        int number = Integer.parseInt(text);
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(number);
        NavHostFragment
                .findNavController(FirstFragment.this)
                .navigate(action);
    }
}