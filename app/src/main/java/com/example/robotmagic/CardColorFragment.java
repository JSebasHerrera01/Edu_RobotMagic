package com.example.robotmagic;

// CardColorFragment.java

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class CardColorFragment extends Fragment {


    private Button backButton, finish_Colors;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors_cards, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        backButton = view.findViewById(R.id.back_Colors);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        finish_Colors = view.findViewById(R.id.finish_button_Color);
        finish_Colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                onBackPressed();
            }

        });


        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title", "");
            String description = bundle.getString("description", "");
            String imageName = bundle.getString("imageName", "");
            boolean isLastPage = bundle.getBoolean("isLastPage", false);

            titleTextView.setText(title);
            descriptionTextView.setText(description);

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

