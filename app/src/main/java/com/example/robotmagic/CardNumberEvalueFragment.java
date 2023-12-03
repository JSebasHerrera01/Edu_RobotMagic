package com.example.robotmagic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CardNumberEvalueFragment extends Fragment {
    private Button backButton, finish_Colors;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers_evalue_cards, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView titleTextView = view.findViewById(R.id.questionTextView);
        RadioButton answer1TextView = view.findViewById(R.id.answer1RadioButton);
        RadioButton answer2TextView = view.findViewById(R.id.answer2RadioButton);
        RadioButton answer3TextView = view.findViewById(R.id.answer3RadioButton);

        backButton = view.findViewById(R.id.back_numbers_evalue);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        finish_Colors = view.findViewById(R.id.finish_button_numbers_evalue);
        finish_Colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                onBackPressed();
            }

        });


        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title", "");
            String answer1 = bundle.getString("answer1", "");
            String answer2 = bundle.getString("answer2", "");
            String answer3 = bundle.getString("answer3", "");
            String imageName = bundle.getString("imageName", "");
            boolean isLastPage = bundle.getBoolean("isLastPage", false);

            titleTextView.setText(title);
            answer1TextView.setText(answer1);
            answer2TextView.setText(answer2);
            answer3TextView.setText(answer3);

            if (!TextUtils.isEmpty(imageName)) {
                // Cargar la imagen solo si el nombre de la imagen no está vacío
                int imageResourceId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());
                imageView.setImageResource(imageResourceId);
            }

            if (isLastPage) {
                finish_Colors.setVisibility(View.VISIBLE);
            } else {
                finish_Colors.setVisibility(View.GONE);
            }
        }


        return view;
    }

    private void onBackPressed() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {

            fragmentManager.popBackStack();
        } else {
            requireActivity().onBackPressed();
        }
    }

}
