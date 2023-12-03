package com.example.robotmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentNumber extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardNumberItem> cardNumberItems = getCardItems();
        CardNumberAdapter cardnumberAdapter = new CardNumberAdapter(getChildFragmentManager(), getLifecycle(), cardNumberItems);
        viewPager.setAdapter(cardnumberAdapter);
        return view;
    }


    private List<CardNumberItem> getCardItems() {
        List<CardNumberItem> cardNumberItems = new ArrayList<>();
        cardNumberItems.add(new CardNumberItem("Uno / One", "¡El número 1! Es el número más pequeñito y el inicio de todos los números. ¡Como el primer paso que das al caminar! 🚶‍♂️", "uno_numero"));
        cardNumberItems.add(new CardNumberItem("Dos / Two", "¡El número 2! Son como dos amiguitos juntos. ¡Pueden ser tus dos ojitos o tus dos orejitas! 👀👂", "dos_numero"));
        cardNumberItems.add(new CardNumberItem("Tres / Three", "¡El número 3! ¡Es un número mágico! Hay tres cerditos, tres ositos, ¡y hasta tres deseos mágicos! 🐷🐻✨", "tres_numero"));
        cardNumberItems.add(new CardNumberItem("Cuatro / Four", "¡El número 4! ¡Cuatro patitas como los gatitos! También hay cuatro estaciones en el año, ¡como el verano y el invierno! 🐾☀️❄️", "cuatro_numero"));
        cardNumberItems.add(new CardNumberItem("Cinco / Five", "¡El número 5! ¿Sabías que tenemos cinco deditos en cada mano? ¡Es perfecto para contar! 1, 2, 3, 4, 5. 🖐️👍", "cinco_numero"));
        cardNumberItems.add(new CardNumberItem("Seis / Six", "¡El número 6! ¡Es el doble de 3! Puedes imaginarlo como tres amigos más tres amigos. ¡Una fiesta de seis! 🎉🎈", "seis_numero"));
        cardNumberItems.add(new CardNumberItem("Siete / Seven", "¡El número 7! ¡Es un número mágico también! Hay siete días en una semana y siete colores en el arcoíris. 🌈📅", "siete_numero"));
        cardNumberItems.add(new CardNumberItem("Ocho / Eight", "¡El número 8! ¡Es como un infinito que se puso de lado! Hay ocho planetas en nuestro sistema solar. 🪐🚀", "ocho_numero"));
        cardNumberItems.add(new CardNumberItem("Nueve / Nine", "¡El número 9! ¿Has visto un gato con nueve vidas? Es un número muy especial. ¡Nueve abrazos para ti! 🐱❤️", "nueve_numero"));
        cardNumberItems.add(new CardNumberItem("Diez / Ten", "¡El número 10! ¡Es el final de la cuenta hasta diez! Diez dedos, diez juguetes, ¡diez razones para sonreír! 🤗🎉", "diez_numero"));
        return cardNumberItems;
    }
}
