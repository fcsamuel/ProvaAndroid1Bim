package com.example.felipe.felipecarvalho;

import android.content.Intent;
import android.media.tv.TvView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.felipe.felipecarvalho.model.Atendimento;
import com.example.felipe.felipecarvalho.model.Empresa;

public class SecondActivity extends AppCompatActivity {

    private ListView lvEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvEmpresa = findViewById(R.id.lvEmpresa);

        final ArrayAdapter<Empresa> adapterEmpresa = new ArrayAdapter<>(SecondActivity.this,
                R.layout.item_pessoa, Empresa.list);
        lvEmpresa.setAdapter(adapterEmpresa);

        lvEmpresa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Empresa empresaSel = adapterEmpresa.getItem(position);
                Intent output = new Intent();
                output.putExtra("EMPRESA_SEL", empresaSel);
                setResult(RESULT_OK, output);
                finish();
            }
        });

    }


}
