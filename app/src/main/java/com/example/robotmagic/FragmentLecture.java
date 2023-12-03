package com.example.robotmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentLecture extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lecture, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardLectureItem> cardLectureItems = getCardItems();
        CardLectureAdapter CardLectureAdapter = new CardLectureAdapter(getChildFragmentManager(), getLifecycle(), cardLectureItems);
        viewPager.setAdapter(CardLectureAdapter);
        return view;
    }


    private List<CardLectureItem> getCardItems() {
        List<CardLectureItem> CardLectureItem = new ArrayList<>();
        CardLectureItem.add(new CardLectureItem("video_lecture"));
        return CardLectureItem;
    }
}
