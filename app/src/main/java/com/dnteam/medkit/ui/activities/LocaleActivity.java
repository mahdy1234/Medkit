package com.dnteam.medkit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import com.dnteam.medkit.R;
import com.dnteam.medkit.adapters.CountryAdapter;
import com.dnteam.medkit.util.SharedPreferencesUtil;


public class LocaleActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale);
        recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(CountryAdapter.getInstance(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        done = findViewById(R.id.done);
        done.setOnClickListener((cl) -> {
            RadioGroup group = findViewById(R.id.language_radio_group);
            int radioButtonId = group.getCheckedRadioButtonId();
            CountryAdapter adapter = (CountryAdapter) recyclerView.getAdapter();

            String langKey = (radioButtonId == R.id.arabic) ? "ar" : "en";
            assert adapter != null;
            String countryKey = adapter.getDataList().get(adapter.getLastPosition()).getKey();
            SharedPreferencesUtil.setCountry(LocaleActivity.this, countryKey);
            SharedPreferencesUtil.setLang(LocaleActivity.this, langKey);

            Intent i = new Intent(LocaleActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        });
    }
}