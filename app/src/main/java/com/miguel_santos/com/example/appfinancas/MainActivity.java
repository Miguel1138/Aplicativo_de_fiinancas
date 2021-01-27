package com.miguel_santos.com.example.appfinancas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.miguel_santos.com.example.appfinancas.model.Expense;
import com.xwray.groupie.GroupAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new GroupAdapter();
        adapter.setOnItemClickListener((item, view) -> {
            Toast.makeText(this, "Adicionar funcionalidade", Toast.LENGTH_SHORT).show();
        });

        RecyclerView recyclerExpenses = findViewById(R.id.recycler_expenses);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        recyclerExpenses.addItemDecoration(itemDecoration);
        recyclerExpenses.setAdapter(adapter);
        recyclerExpenses.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        mockItems(adapter);
        
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criar novo item na recyclerView.
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void mockItems(GroupAdapter adapter) {
        
        List<Expense> fakeItems = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Expense expense = new Expense("title"+i, "date"+i, R.color.black,"preço"+i);
            fakeItems.add(expense);
        }
        adapter.addAll(fakeItems);
        adapter.notifyDataSetChanged();
    }

}