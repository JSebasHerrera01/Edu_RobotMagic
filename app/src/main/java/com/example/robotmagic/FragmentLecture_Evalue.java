package com.example.robotmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentLecture_Evalue extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lecture_evalue, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardLectureEvalueItem> CardLectureEvalueItem = getCardItems();
        CardLectureEvalueAdapter CardLectureEvalueAdapter = new CardLectureEvalueAdapter(getChildFragmentManager(), getLifecycle(), CardLectureEvalueItem);
        viewPager.setAdapter(CardLectureEvalueAdapter);
        return view;
    }


    private List<CardLectureEvalueItem> getCardItems() {
        List<CardLectureEvalueItem> CardLectureEvalueItem = new ArrayList<>();
        CardLectureEvalueItem.add(new CardLectureEvalueItem("¿Por que Tito se quedaba despierto hasta tarde?", "Porque tenia malos habitos", "Porque queria ver la luna", "Porque dormia en el dia", "lecture_tito"));
        CardLectureEvalueItem.add(new CardLectureEvalueItem("Segun el cuento, ¿Cuales son las consecuencias de no dormir bien?", "Problemas de salud, poca energia", "Ningunas, no hay consecuencias", "Mejora la memoria y la toma de decisiones", "lecture_tito_dos"));
        return CardLectureEvalueItem;
    }
}
