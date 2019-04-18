package com.example.felipe.felipecarvalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.felipe.felipecarvalho.model.Tipo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etAssunto, etContato, etTelefone, etEmail;
    private Spinner spTipo;
    private TextView tvEmpresa;
    private ImageButton ibEmpresa;
    private Button btSalvar, btCancelar;
    private Atendimento atendimento = new Atendimento();
    private Tipo tipo;
    private Empresa empresa = new Empresa();
    private ListView lvAtendimento;
    private List<Atendimento> atendimentoList = new ArrayList<>();



    private final int LOV_EMPRESA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadComponents();
        loadEvents();
        populaLista();

        final ArrayAdapter<Atendimento> adapterAtendimento = new ArrayAdapter<>(MainActivity.this,
                R.layout.item_pessoa, atendimentoList);
        lvAtendimento.setAdapter(adapterAtendimento);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == LOV_EMPRESA) {
            empresa = (Empresa) data.getExtras().get("EMPRESA_SEL");
            tvEmpresa.setText(empresa.getDescricao());
        }
    }

    private void loadComponents() {
        etAssunto = findViewById(R.id.etAssunto);
        etContato = findViewById(R.id.etContato);
        etTelefone = findViewById(R.id.etTelefone);
        etEmail = findViewById(R.id.etEmail);
        btSalvar = findViewById(R.id.btSalvar);
        ibEmpresa = findViewById(R.id.ibEmpresa);
        tvEmpresa = findViewById(R.id.tvEmpresa);
        lvAtendimento = findViewById(R.id.lvAtendimento);
    }

    private void loadEvents() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atendimento.setAssunto(etAssunto.getText().toString());
                atendimento.setContato(etContato.getText().toString());
                atendimento.setTelefone(etTelefone.getText().toString());
                atendimento.setEmail(etEmail.getText().toString());
                atendimento.setData(new Date());
                atendimento.setEmpresa(empresa);
                atendimentoList.add(atendimento);
            }
        });

        ibEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, LOV_EMPRESA);
            }
        });
    }

    private void populaLista() {
        Empresa.list.add(new Empresa(1, "Empresa 1"));
        Empresa.list.add(new Empresa(1, "Empresa 2"));
        Empresa.list.add(new Empresa(1, "Empresa 3"));
        Empresa.list.add(new Empresa(1, "Empresa 4"));
        Empresa.list.add(new Empresa(1, "Empresa 5"));
        Empresa.list.add(new Empresa(1, "Empresa 6"));
        Empresa.list.add(new Empresa(1, "Empresa 7"));
        Empresa.list.add(new Empresa(1, "Empresa 8"));
    }

}
