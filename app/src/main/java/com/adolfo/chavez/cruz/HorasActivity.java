package com.adolfo.chavez.cruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HorasActivity extends AppCompatActivity {

    private EditText editTextHoras;
    private EditText editTextSegundos;
    private Button buttonConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);
        editTextHoras = findViewById( R.id.editTextNumberHoras);
        editTextSegundos= findViewById( R.id.editTextNumberSegundos);
        editTextSegundos.setEnabled( false );
        buttonConvertir = findViewById(R.id.buttonConvertir );
        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaOperacion( );
            }
        });
    }
    private void realizaOperacion()
    {
        int total = 0;
        if( editTextHoras.getText().toString() != null )
        {
            if( isEntero( editTextHoras.getText().toString() ) )
            {
                total = getEntero( editTextHoras.getText().toString() ) * 3600 ;
            }
        }
        editTextSegundos.setText( String.valueOf(total) ,TextView.BufferType.SPANNABLE );
        editTextSegundos.setEnabled( false );
    }

    private int getEntero(String entero)
    {
        try
        {
            return Integer.parseInt( entero );
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isEntero(String entero)
    {
        try
        {
            if( entero == null || entero.length() == 0)
            {
                return false;
            }
            Integer.parseInt( entero );
            return true;
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
