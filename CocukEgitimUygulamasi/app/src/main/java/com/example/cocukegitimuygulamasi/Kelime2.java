package com.example.cocukegitimuygulamasi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Kelime2 extends Fragment {

    private Context context;
    private List<Kelime3> modelListLeft, modelListRight;
    private int widthButton, heightButton;
    private LinearLayout containerLeft, containerRight;
    private int x, y;
    private int silinenButonSayisi = 0;
    private static final int DURATION = 400;
    private static final int DURATION_KAYBOL = 300;
    private static final int DURATION_ADD_BUTTON = 700;
    private Button selectButtonLeft = null;
    private Button selectButtonRight = null;
    private boolean buttonClickEnable = true;


    private View.OnTouchListener touchlistener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            x = (int) event.getX();
            y = (int) event.getY();

            return false;
        }
    };

    private View.OnClickListener clicklistenerLeft = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!buttonClickEnable)
                return;

            if (selectButtonRight != null) {

                selectButtonLeft = (Button) v;
                buttonClickEnable = false;

                if (selectButtonLeft.getId() == selectButtonRight.getId()) {
                    revealEffectBlue();
                } else {
                    revealEffectRed();
                }

            } else {
                if (selectButtonLeft != null)
                    selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));

                selectButtonLeft = (Button) v;
                selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonSelect)));

            }

        }
    };


    private View.OnClickListener clicklistenerRight = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!buttonClickEnable)
                return;

            if (selectButtonLeft != null) {

                selectButtonRight = (Button) v;
                buttonClickEnable = false;

                if (selectButtonLeft.getId() == selectButtonRight.getId()) {
                    revealEffectBlue();
                } else {
                    revealEffectRed();
                }

            } else {
                if (selectButtonRight != null)
                    selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));

                selectButtonRight = (Button) v;
                selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonSelect)));

            }

        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_kelime2, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);


        modelListLeft = new ArrayList<>();
        modelListRight = new ArrayList<>();
        containerLeft = ((AppCompatActivity) context).findViewById(R.id.containerLeft);
        containerRight = ((AppCompatActivity) context).findViewById(R.id.containerRight);



        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthButton = (int) ((size.x) / (2 + .4));
        heightButton = (int) ((size.y) / (6 + 1.5));



        modelListLeft.add(new Kelime3("January", "Ocak", 0));
        modelListLeft.add(new Kelime3("February", "Şubat", 1));
        modelListLeft.add(new Kelime3("March", "Mart", 2));
        modelListLeft.add(new Kelime3("April", "Nisan", 3));
        modelListLeft.add(new Kelime3("May", "Mayıs", 4));
        modelListLeft.add(new Kelime3("June", "Haziran", 5));
        modelListLeft.add(new Kelime3("July", "Temmuz", 6));
        modelListLeft.add(new Kelime3("August", "Ağustos", 7));
        modelListLeft.add(new Kelime3("September", "Eylül", 8));
        modelListLeft.add(new Kelime3("October", "Ekim", 9));
        modelListLeft.add(new Kelime3("November", "Kasım", 10));
        modelListLeft.add(new Kelime3("December", "Aralık", 11));


        for (Kelime3 model : modelListLeft) {
            modelListRight.add(model);
        }



        Collections.shuffle(modelListLeft);
        Collections.shuffle(modelListRight);


        for (int i = 0; i < 7; i++) {

            Button button = new Button(context);
            button.setWidth(widthButton);
            button.setHeight(heightButton);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
            button.setAllCaps(false);
            button.setTextSize(heightButton / 9);
            button.setId(modelListLeft.get(0).getId());
            button.setText(modelListLeft.get(0).getKelime());
            button.setOnTouchListener(touchlistener);
            button.setOnClickListener(clicklistenerLeft);
            containerLeft.addView(button);
            modelListLeft.remove(0);
        }



        for (int i = 0; i < 7; i++) {

            Button button = new Button(context);
            button.setWidth(widthButton);
            button.setHeight(heightButton);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
            button.setAllCaps(false);
            button.setTextSize(heightButton / 9);
            button.setId(modelListRight.get(0).getId());
            button.setText(modelListRight.get(0).getAnlami());
            button.setOnTouchListener(touchlistener);
            button.setOnClickListener(clicklistenerRight);
            containerRight.addView(button);
            modelListRight.remove(0);
        }

        girisAnimasyonu();

    }

    private void girisAnimasyonu() {

        for (int i = 0; i < containerLeft.getChildCount(); i++) {
            Button button = (Button) containerLeft.getChildAt(5 - i);
            ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationX", -widthButton * 1.5f, 0);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(DURATION + i * 70);
            animator.start();
        }

        for (int i = 0; i < containerRight.getChildCount(); i++) {
            Button button = (Button) containerRight.getChildAt(5 - i);
            ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationX", widthButton * 1.5f, 0);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(DURATION + i * 70);
            animator.start();
        }
    }

    private void revealEffectRed() {

        int finalRadius = Math.max(widthButton, heightButton);

        Animator animRight =
                ViewAnimationUtils.createCircularReveal(selectButtonRight, x, y, 0, finalRadius);
        Animator animLeft =
                ViewAnimationUtils.createCircularReveal(selectButtonLeft, x, y, 0, finalRadius);

        selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonRed)));
        selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonRed)));

        animLeft.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));

                selectButtonLeft = null;
                selectButtonRight = null;

                buttonClickEnable = true;


            }
        });

        animLeft.setDuration(DURATION);
        animRight.setDuration(DURATION);
        animLeft.start();
        animRight.start();

    }

    private void revealEffectBlue() {

        int finalRadius = Math.max(widthButton, heightButton);

        Animator animRight =
                ViewAnimationUtils.createCircularReveal(selectButtonRight, x, y, 0, finalRadius);
        Animator animLeft =
                ViewAnimationUtils.createCircularReveal(selectButtonLeft, x, y, 0, finalRadius);

        selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonBlue)));
        selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonBlue)));

        animLeft.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                kaybol();

            }
        });

        animLeft.setDuration(DURATION);
        animRight.setDuration(DURATION);
        animLeft.start();
        animRight.start();
    }

    private void kaybol() {

        ObjectAnimator animatorLeft = ObjectAnimator.ofFloat(selectButtonLeft, "TranslationX", 0, -widthButton * 1.5f);
        ObjectAnimator animatorRight = ObjectAnimator.ofFloat(selectButtonRight, "TranslationX", 0, widthButton * 1.5f);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorLeft, animatorRight);
        set.setDuration(DURATION_KAYBOL);
        set.setInterpolator(new LinearInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                selectButtonLeft.setVisibility(View.GONE);
                selectButtonRight.setVisibility(View.GONE);
                selectButtonLeft = null;
                selectButtonRight = null;

                buttonClickEnable = true;

                silinenButonSayisi++;


                if (modelListLeft.size() == 0 && modelListRight.size() == 0) {

                    if (silinenButonSayisi == 12) {

                        Dialog dialog = new Dialog(context,R.style.CustomDialog);
                        LayoutInflater layoutInflater = LayoutInflater.from(context);
                        CardView view = (CardView) layoutInflater.inflate(R.layout.activity_kelime3, null);
                        dialog.setContentView(view);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    }

                } else {
                    addButton();
                }


            }
        });
        set.start();
    }

    private void addButton() {
        Button button = new Button(context);
        button.setWidth(widthButton);
        button.setHeight(heightButton);
        button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
        button.setAllCaps(false);
        button.setTextSize(heightButton / 9);
        button.setId(modelListLeft.get(0).getId());
        button.setText(modelListLeft.get(0).getKelime());
        button.setOnTouchListener(touchlistener);
        button.setOnClickListener(clicklistenerLeft);
        containerLeft.addView(button, 0);
        modelListLeft.remove(0);
        ObjectAnimator animatorLeft = ObjectAnimator.ofFloat(button, "TranslationX", -widthButton * 1.5f, 0);
        animatorLeft.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorLeft.setDuration(DURATION_ADD_BUTTON);
        animatorLeft.start();


        Button buttonR = new Button(context);
        buttonR.setWidth(widthButton);
        buttonR.setHeight(heightButton);
        buttonR.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonR.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
        buttonR.setAllCaps(false);
        buttonR.setTextSize(heightButton / 9);
        buttonR.setId(modelListRight.get(0).getId());
        buttonR.setText(modelListRight.get(0).getAnlami());
        buttonR.setOnTouchListener(touchlistener);
        buttonR.setOnClickListener(clicklistenerRight);
        containerRight.addView(buttonR, 0);
        modelListRight.remove(0);
        ObjectAnimator animatorRight = ObjectAnimator.ofFloat(buttonR, "TranslationX", widthButton * 1.5f, 0);
        animatorRight.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorRight.setDuration(DURATION_ADD_BUTTON);
        animatorRight.start();
    }



}

