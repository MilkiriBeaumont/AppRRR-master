package com.example.apprrr;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class Principal1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal1);
        //Referenva al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tl = (TabLayout) findViewById(R.id.tablayaout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               //codificar cosas a ejecutar cuando le das tap deja de estar seleccionado




            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                //codificar cosas a ejecutar cuando le das tap a se vuelve a seleccionar
                int position = tab.getPosition();
                switch (position){
                    case 1:
                        //llamar al fracmento comunidad
                        Reutilizacion rt = new Reutilizacion();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,rt).commit();
                        break;
                    case 0:
                        //llamar al fracmento  reciclaje
                        Comunidad c = new Comunidad();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,c).commit();
                        break;


                }




            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                //codificar cosas a ejecutar cuando le das tap a se vuelve a seleccionar


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        /* incorporamos al menu lateral*/
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //Recupera la opcion del menu
                int id = item.getItemId();

                if(id==R.id.op9) {
                    Toast.makeText(getApplicationContext(), "vas al plastico", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Principal1.this, Plastico.class);
                    startActivity(intent);
                }
                else if(id==R.id.op10) {
                    Toast.makeText(getApplicationContext(), "vas al papel y carton", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Principal1.this, Papelycarton.class);
                    startActivity(intent);
                }
                else if(id==R.id.op11) {
                    Toast.makeText(getApplicationContext(), "vas al vidrio", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Principal1.this, Vidrio.class);
                    startActivity(intent);
                }
                else if(id==R.id.op12) {
                    Toast.makeText(getApplicationContext(), "vas a latas", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Principal1.this, Latas.class);
                    startActivity(intent);
                }
                else if(id==R.id.op13) {
                    Toast.makeText(getApplicationContext(), "vas a otros residuos", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Principal1.this, Otrosresiduos.class);
                    startActivity(intent);
                }
                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer

        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //incorporar el menu dentro de la activity
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.op2) {
            Toast.makeText(this, "vas a  la reutilizacion", Toast.LENGTH_SHORT).show();
            Reutilizacion rt = new Reutilizacion();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,rt).commit();
        }
        else if(id==R.id.op3) {
            Toast.makeText(this, "vas a la  comunidad", Toast.LENGTH_SHORT).show();
            Comunidad c = new Comunidad();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,c).commit();
        }
        else if(id==R.id.op4) {
            Toast.makeText(this, "vas  al plastico", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal1.this, Plastico.class);
            startActivity(intent);
        }
        else if(id==R.id.op5) {
            Toast.makeText(this, "vas al papel y carton", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal1.this, Papelycarton.class);
            startActivity(intent);
        }
        else if(id==R.id.op6) {
            Toast.makeText(this, "vas al vidrio", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal1.this, Vidrio.class);
            startActivity(intent);
        }
        else if(id==R.id.op7) {
            Toast.makeText(this, "vas a latas", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal1.this, Latas.class);
            startActivity(intent);
        }
        else if(id==R.id.op8) {
            Toast.makeText(this, "vas a otros residuos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal1.this, Otrosresiduos.class);
            startActivity(intent);
        }




        return super.onOptionsItemSelected(item);
    }
}


