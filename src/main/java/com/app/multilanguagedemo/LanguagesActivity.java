package com.app.multilanguagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.LanguageDataAdapter;
import model.LanguageModel;
import utils.LocaleHelper;
import utils.MyPreference;

public class LanguagesActivity extends AppCompatActivity {


    public int lastCategoryItemSelected = 0;
    GridLayoutManager lLayout_category;
    RecyclerView category_list;
    RecyclerView.Adapter adapterFilter;
    MyPreference myPreference;
    LanguageModel languageModel;
    private ArrayList<LanguageModel> languageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        myPreference = new MyPreference(this);

        lastCategoryItemSelected = myPreference.getSelectedLanmguagePosition();
        initViews();
        loadLocale();


    }

    //Initiate all views
    private void initViews() {

        category_list = findViewById(R.id.card_recycler_category_list);


        lLayout_category = new GridLayoutManager(LanguagesActivity.this, 1);
        category_list.setLayoutManager(lLayout_category);

        languageModel = new LanguageModel("en", "English");
        languageList.add(languageModel);

        languageModel = new LanguageModel("hi", "हिन्दी /Hindi");
        languageList.add(languageModel);

        languageModel = new LanguageModel("ben", "বাংলা / Bangla");
        languageList.add(languageModel);

        languageModel = new LanguageModel("mar", "मराठी/Marathi");
        languageList.add(languageModel);

        languageModel = new LanguageModel("te", "తెలుగు /Telugu");
        languageList.add(languageModel);

        languageModel = new LanguageModel("ta", "தமிழ் / Tamil");
        languageList.add(languageModel);

        languageModel = new LanguageModel("guj", "ગુજરાતી /Gujarati");
        languageList.add(languageModel);

        languageModel = new LanguageModel("ur", "Urdu/اردو");
        languageList.add(languageModel);

        languageModel = new LanguageModel("kn", "ಕನ್ನಡ /Kannada");
        languageList.add(languageModel);

        languageModel = new LanguageModel("or", "ଓଡିଆ/Odia or Oriya");
        languageList.add(languageModel);

        languageModel = new LanguageModel("ml", "മലയാളം /Malayalam");
        languageList.add(languageModel);

        adapterFilter = new LanguageDataAdapter(lastCategoryItemSelected, LanguagesActivity.this, languageList);

        category_list.setAdapter(adapterFilter);

    }

    public void fiterCategoryItemClick(int selectedPosition, String lang) {

        Log.d("tag", "menu list last selected item selectedPosition---" + selectedPosition);
        lastCategoryItemSelected = selectedPosition;

        myPreference.setSelectedLanmguagePosition(lastCategoryItemSelected);
//        Log.d("tag","menu list last selected item activity---"+ ((MainActivity) getActivity()).lastCategoryItemSelected);

        LocaleHelper.setLocale(LanguagesActivity.this, lang);
        restartApp();


    }

    public void restartApp() {
        finish();
        Intent i = new Intent(LanguagesActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }

    //Change Locale
    public void changeLocale(String lang) {

        LocaleHelper.setLocale(LanguagesActivity.this, lang);


    }

    //Get locale method in preferences
    public void loadLocale() {

        changeLocale(LocaleHelper.getLanguage(this));


    }


}
