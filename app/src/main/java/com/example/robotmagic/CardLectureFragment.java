package com.example.robotmagic;


import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CardLectureFragment extends Fragment {
    private Button backButton, finish_Colors;
    final int delayInSeconds = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lecture_cards, container, false);

        VideoView videoView = view.findViewById(R.id.VideoView);




        backButton = view.findViewById(R.id.back_Lecture);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        finish_Colors = view.findViewById(R.id.finish_button_Lecture);
        finish_Colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                onBackPressed();
            }

        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            String videoName = bundle.getString("videoName");
            boolean isLastPage = bundle.getBoolean("isLastPage", false);

            if (!TextUtils.isEmpty(videoName)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int videoResourceID = getResources().getIdentifier(videoName, "raw", requireContext().getPackageName());
                        videoView.setVideoURI(Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + videoResourceID));
                        MediaController mediaController = new MediaController(requireContext());
                        videoView.setMediaController(mediaController);
                        mediaController.setAnchorView(videoView);
                        videoView.start();
                    }
                }, delayInSeconds * 1000); // Convierte los segundos a milisegundos
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
