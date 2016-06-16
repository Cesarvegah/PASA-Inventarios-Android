package pasa.inventarios.com.pasa_inventarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_Division extends AppCompatActivity {

    // uicontrols
    Spinner spn_Division;
    //class members
    String arr_Division[] = { "", "Pública", "Privada", "Gobierno"};
    ArrayAdapter<String> adap_Division;
    // local members
    String str_Division;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        spn_Division = (Spinner) findViewById(R.id.spn_Division);
        // Initialize and set Adapter
        adap_Division = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arr_Division);
        adap_Division.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_Division.setAdapter(adap_Division);
        // Business Type Item Selected Listener
        spn_Division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                // On selecting a spinner item
                str_Division = adapter.getItemAtPosition(position).toString();
                if(position == 0){
                    // Showing selected spinner item
                    Toast.makeText(getApplicationContext(),
                            "Selecciona una opción: " + str_Division, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "División: " + str_Division, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Activity_Division.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
