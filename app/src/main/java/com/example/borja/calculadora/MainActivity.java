package com.example.borja.calculadora;


import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button button0, button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonMulti,buttonDiv,buttonSum,buttonRes,buttonIgual;

    private int i = 0 , a = 0;
    private boolean operacion = false;
    private int iOperacion = 0;
    private char z;
    private TextView resultado, operando1, operando2,id1;


    @Override
    public void onClick(View v) {
        String cadena = null;

          if (button0.getId() == v.getId()) { //se mira la id de el boton  segun la id de la vista.

            if (operacion) { a = ( a * 10 );} else {i=(i * 10);}

          }  else if (button1.getId() == v.getId()) {

            if (operacion) {a =  (a * 10) + 1;  } else {i = (i * 10) + 1; }

          } else if (button2.getId() == v.getId()) {

            if (operacion) {a =(a * 10) + 2;  } else {i = (i * 10) + 2;}

          } else if (button3.getId() == v.getId()) {

            if (operacion) { a=(a * 10) + 3; } else {i = (i * 10) + 3;}

          } else if (button4.getId() == v.getId()) {

            if (operacion) { a=(a * 10) + 4; } else {i = (i * 10) + 4;}

          } else if (button5.getId() == v.getId()) {

            if (operacion) {a = (a * 10) + 5;  } else {i = (i * 10) + 5;}

          } else if (button6.getId() == v.getId()) {

            if (operacion) { a =  (a * 10) + 6; } else {i = (i * 10) + 6;}

          } else if (button7.getId() == v.getId()){

            if (operacion) {a =  (a * 10) + 7;  } else { i = (i * 10) + 7 ;}

           } else if (button8.getId() == v.getId()){

            if (operacion) { a =  (a * 10) + 8; } else { i =  (i * 10) + 8 ;}


           } else if (button9.getId() == v.getId()){

            if (operacion) { a =  (a * 10) + 9; } else { i =  (i * 10) + 9 ;}

             //division 1, multiplicacion 2, suma 3,  resta 4
           } else if (buttonDiv.getId() == v.getId()){
                operacion = true;
                iOperacion = 1;
           } else if (buttonMulti.getId() == v.getId()) {
                operacion = true;
                iOperacion = 2;
           }else if (buttonRes.getId() == v.getId())  {
                operacion = true;
                iOperacion = 4;
           } else if (buttonSum.getId() == v.getId()){
                operacion = true;
                iOperacion = 3;
           } else if (buttonIgual.getId() == v.getId()){
                switch (iOperacion) {
                    case 1:
                        cadena = String.valueOf(div());
                        this.resultado.setText(cadena);
                        Toast.makeText(this,"el resultado es " + cadena,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        cadena = String.valueOf(mul());
                        this.resultado.setText(cadena);
                        Toast.makeText(this,"el resultado es " + cadena,Toast.LENGTH_LONG).show();
                        this.resultado.setText(cadena);

                        break;
                    case 3:
                        cadena = String.valueOf(suma());
                        this.resultado.setText(cadena);
                        Toast.makeText(this,"el resultado es " + cadena,Toast.LENGTH_LONG).show();
                        this.resultado.setText(cadena);

                        break;
                    case 4:
                        cadena = String.valueOf(resta());
                        this.resultado.setText(cadena);
                        Toast.makeText(this,"el resultado es " + cadena,Toast.LENGTH_LONG).show();
                        this.resultado.setText(cadena); ;
                        break;
                }

                i = 0 ;
                a = 0 ;
                iOperacion = 0;
                operacion = false;
              this.operando1.setText("");
              this.operando2.setText("");
              this.id1.setText("");

          } else {
                Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show();
            }
        if( i > 0 ){ cadena = String.valueOf(i);
            this.operando1.setText(cadena); }

        switch (iOperacion) {
            case 1:

                this.id1.setText("/");

                break;
            case 2:

                this.id1.setText("*");



                break;
            case 3:

                this.id1.setText("+");


                break;
            case 4:

                this.id1.setText("-");

                break;

        }
        if (a > 0) {
            cadena = String.valueOf(a);
            this.operando2.setText(cadena); ;
        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonMulti = (Button) findViewById(R.id.button13);
        buttonDiv = (Button) findViewById(R.id.button12);
        buttonSum = (Button) findViewById(R.id.button11);
        buttonRes = (Button) findViewById(R.id.button10);
        buttonIgual = (Button) findViewById(R.id.button14);

        this.resultado = (TextView) findViewById(R.id.resul);
        this.operando1 = (TextView) findViewById(R.id.operando1);
        this.operando2 = (TextView) findViewById(R.id.operando2);
        this.id1 = (TextView) findViewById(R.id.id1);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonSum.setOnClickListener(this);
        buttonRes.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);

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

    private int suma(){

        return i + a;
    }
    private int mul(){

        return i * a;
    }

    private int resta(){

        return i - a ;
    }

    private int div(){

        return  i / a;
    }


    private int resultado(){

        return i;
    }


}
