/**
 * @author yoad.
 *  extend for Arithmetic progression/Geometric series calculator with context menu shows all the series.
 */
package com.example.targilsdarot;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class calc extends AppCompatActivity implements View.OnCreateContextMenuListener,AdapterView.OnItemClickListener
{
    TextView tx;
    ListView list;
    int i,pos;
    double x1, d2, a, n = 2;
    boolean kind;
    String sa,sx,sd;
    String[] sidra = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Intent gi = getIntent();
        tx = (TextView) findViewById(R.id.tx);
        list = (ListView) findViewById(R.id.list);
        list.setChoiceMode(list.CHOICE_MODE_SINGLE);
        ArrayAdapter<String>adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,sidra);
        list.setAdapter(adp);
        list.setOnItemClickListener(this);
        list.setOnCreateContextMenuListener(this);
        x1 = gi.getDoubleExtra("a", 1);
        kind = gi.getBooleanExtra("k", false);
        d2 = gi.getDoubleExtra("b", 1);
        sx=String.valueOf(x1);
        sd=String.valueOf(d2);
         sidra[0]=sx;
        tx.setText(sx);
        if (kind) {
            for ( i = 1; i < 20; i++) {
                a = x1 + (d2 * (n - 1));
                sa=String.valueOf(a);
                sidra[i] = sa;
                n++;
            }

        }
        else{

            for ( i = 1; i < 20; i++){
                a=x1*Math.pow(d2,(n-1));
                sa=String.valueOf(a);
                 sidra[i]=sa;
                n++;
            }

        }
    }
    /**
     * getting back to first activity.
     * <p>
     * @param view view.
     */
    public void backfirst(View view) {
        finish();
    }
    /**
     * creating context menu
     * <p>
     * @param menu the context menu.
     * @param v the view.
     * @param menuInfo info.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("this a place");
        menu.add("sum");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    /**
     * reacting to users choose int the menu.
     * <p>
     * @param item the row that got chosen.
     * @return boolean whether the method was operating.
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();
        switch (st) {
            case ("this a place") :
                tx.setText(sidra[pos]);
                break;

           case ("sum"):
                if (kind) {
                    tx.setText("");
                }
                else {
                    tx.setText("");
                }
            }
            return super.onContextItemSelected(item);
        }
        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
            pos = position;
        }
    }
