package com.example.robotmagic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import com.example.robotmagic.ProfileFragment;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ModulesFragment extends Fragment  {

    public interface ProgressListener {
        void onProgressUpdated(int progress);
    }
    private ProgressListener progressListener;
     int progress = 0;
    ProgressBar progressBar_colors, progressBar_numbers, progressBar_colors_evalue, progressBar_numbers_evalue, progressBar_lecture, progressBar_lecture_evalue;
     int completedActivities_colors = 0, completedActivities_colors_evalue = 0, totalActivities = 1, completedActivities_numbers_evalue = 0, completedActivities_lecture_evalue = 0, completedActivities_numbers = 0, completedActivities_lecture = 0;
    // Suponiendo que tienes un total de 6 barras de progreso
    int totalProgressBars = 6; int completedProgressBars = 0;
    float progressStatus_colors, progressStatus_colors_evalue, progressStatus_numbers, progressStatus_numbers_evalue, progressStatus_lecture, progressStatus_lecture_evalue;
     Handler handler = new Handler();
    TextView txtper_color, txtper_color_evalue, txtper_numbers, txtper_numbers_evalue, txtper_lecture, txtper_lecture_evalue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modules, container, false);
        // Inicializa los fragmentos
        progressBar_colors = view.findViewById(R.id.prog_colors);
        txtper_color = view.findViewById(R.id.txt_percent_color);
        progressBar_colors_evalue = view.findViewById(R.id.prog_colors_evalue);
        txtper_color_evalue = view.findViewById(R.id.txt_percent_color_evalue);
        progressBar_numbers = view.findViewById(R.id.prog_number);
        txtper_numbers = view.findViewById(R.id.txt_percent_number);
        progressBar_numbers_evalue = view.findViewById(R.id.prog_number_evalue);
        txtper_numbers_evalue = view.findViewById(R.id.txt_percent_number_evalue);
        progressBar_lecture = view.findViewById(R.id.prog_lecture);
        txtper_lecture = view.findViewById(R.id.txt_percent_lecture);
        progressBar_lecture_evalue = view.findViewById(R.id.prog_lecture_evalue);
        txtper_lecture_evalue = view.findViewById(R.id.txt_percent_lecture_evalue);

        CardView cardViewColor = view.findViewById(R.id.CardViewColors);
        CardView cardViewColorEvalue = view.findViewById(R.id.CardViewColors_evalue);
        CardView cardViewNumber = view.findViewById(R.id.cardViewNumber);
        CardView cardViewNumberEvalue = view.findViewById(R.id.cardViewNumberEvalue);
        CardView cardViewLecture = view.findViewById(R.id.cardViewLecture);
        CardView cardViewLectureEvalue = view.findViewById(R.id.cardViewLectureEvalue);


        // En tu método onCreateView o en otro lugar apropiado
        progressListener = (ProgressListener) requireActivity();

        cardViewColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_colors < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_colors++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_colors = ((float) completedActivities_colors / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 16; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentColor fragmentColor = new FragmentColor();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, fragmentColor);
                    transaction.addToBackStack(null);
                    transaction.commit();


                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_colors.setProgress((int) progressStatus_colors);
                txtper_color.setText(String.format("%.0f%%", progressStatus_colors));

            }

        });


        cardViewColorEvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_colors_evalue < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_colors_evalue++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_colors_evalue = ((float) completedActivities_colors_evalue / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 16; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentColor_Evalue fragmentColorEvalue = new FragmentColor_Evalue();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, fragmentColorEvalue);
                    transaction.addToBackStack(null);
                    transaction.commit();

                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }


            }

        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_colors_evalue.setProgress((int) progressStatus_colors_evalue);
                txtper_color_evalue.setText(String.format("%.0f%%", progressStatus_colors_evalue));
            }
        });


        cardViewNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_numbers < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_numbers++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_numbers = ((float) completedActivities_numbers / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 16; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentNumber fragmentNumber = new FragmentNumber();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, fragmentNumber);
                    transaction.addToBackStack(null);
                    transaction.commit();

                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }


            }

        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_numbers.setProgress((int) progressStatus_numbers);
                txtper_numbers.setText(String.format("%.0f%%", progressStatus_numbers));
            }
        });

        cardViewNumberEvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_numbers_evalue < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_numbers_evalue++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_numbers_evalue = ((float) completedActivities_numbers_evalue / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 16; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentNumber_Evalue fragmentNumberEvalue = new FragmentNumber_Evalue();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, fragmentNumberEvalue);
                    transaction.addToBackStack(null);
                    transaction.commit();

                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }


            }

        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_numbers_evalue.setProgress((int) progressStatus_numbers_evalue);
                txtper_numbers_evalue.setText(String.format("%.0f%%", progressStatus_numbers_evalue));
            }
        });

        cardViewLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_lecture < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_lecture++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_lecture = ((float) completedActivities_lecture / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 16; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentLecture FragmentLecture = new FragmentLecture();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, FragmentLecture);
                    transaction.addToBackStack(null);
                    transaction.commit();

                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }


            }

        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_lecture.setProgress((int) progressStatus_lecture);
                txtper_lecture.setText(String.format("%.0f%%", progressStatus_lecture));
            }
        });
        cardViewLectureEvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si aún hay actividades por completar
                if (completedActivities_lecture_evalue < totalActivities) {
                    // Incrementa el número de actividades completadas
                    completedActivities_lecture_evalue++;
                    completedProgressBars++;
                    // Calcula el nuevo progreso
                    progressStatus_lecture_evalue = ((float) completedActivities_lecture_evalue / totalActivities) * 100;
                    // Notifica el progreso actualizado a la actividad y suma al progreso acumulado
                    progress += 20; // Suma 20 al progreso acumulado
                    progressListener.onProgressUpdated(progress);
                    // Si el progreso es menor a 100, realiza la acción
                    FragmentLecture_Evalue FragmentLecture_Evalue = new FragmentLecture_Evalue();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, FragmentLecture_Evalue);
                    transaction.addToBackStack(null);
                    transaction.commit();

                } else {

                    // Todas las actividades han sido completadas, puedes mostrar un mensaje o realizar otra acción.
                    Toast.makeText(requireContext(), "Ya completaste el modulo.", Toast.LENGTH_SHORT).show();
                }


            }

        });
        handler.post(new Runnable() {
            @SuppressLint("DefaultLocale")
            public void run() {
                progressBar_lecture_evalue.setProgress((int) progressStatus_lecture_evalue);
                txtper_lecture_evalue.setText(String.format("%.0f%%", progressStatus_lecture_evalue));
            }
        });

        if (completedProgressBars == 3) {
            // Define el texto que deseas mostrar en el Toast
            String message = "¡Felicitaciones! Has completado la mitad del curso";
// Crea un SpannableString para personalizar el estilo del texto
            SpannableString spannableString = new SpannableString(message);
// Define un objeto TextAppearanceSpan para cambiar el tamaño y estilo del texto
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.BOLD, 40, null, null);
// Aplica el estilo de texto personalizado al SpannableString
            spannableString.setSpan(textAppearanceSpan, 0, message.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
// Crea una vista personalizada para el Toast
            View toastView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_toast, null);
            TextView textView = toastView.findViewById(R.id.custom_toast_text);
            textView.setText(spannableString);
// Crea y muestra el Toast personalizado
            Toast toast = new Toast(requireContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0); // Centra el Toast
            toast.setView(toastView);
            toast.show();

        }

        if (completedProgressBars == totalProgressBars) {

            String message = "¡Felicitaciones! Completaste todo el curso";
// Crea un SpannableString para personalizar el estilo del texto
            SpannableString spannableString = new SpannableString(message);
// Define un objeto TextAppearanceSpan para cambiar el tamaño y estilo del texto
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.BOLD, 45, null, null);
// Aplica el estilo de texto personalizado al SpannableString
            spannableString.setSpan(textAppearanceSpan, 0, message.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
// Crea una vista personalizada para el Toast
            View toastView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_toast, null);
            TextView textView = toastView.findViewById(R.id.custom_toast_text);
            textView.setText(spannableString);
// Crea y muestra el Toast personalizado
            Toast toast = new Toast(requireContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0); // Centra el Toast
            toast.setView(toastView);
            toast.show();

        }

        return view;
    }




}