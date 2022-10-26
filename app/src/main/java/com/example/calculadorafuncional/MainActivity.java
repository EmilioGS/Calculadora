package com.example.calculadorafuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1;
    double resultado = 0, num1, num2, ans;
    Boolean num1Bool = false, num2Bool = false;
    String auxCadena1 = "0", auxCadena2 = "0", operador = "", ansCadena = "1";
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,
            btnMult, btnMinus, btnSum, btnEquals, btnPoint,
            btnMinusOne, btnSquared, btnSquaredRoot, btnDiv, btnMasMenos, btnC, btnCE, btnANS, btnPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            txt1 = (TextView) findViewById(R.id.textView);
            btnZero = (Button) findViewById(R.id.zero);
            btnOne = (Button) findViewById(R.id.one);
            btnTwo = (Button) findViewById(R.id.two);
            btnThree = (Button) findViewById(R.id.three);
            btnFour = (Button) findViewById(R.id.four);
            btnFive = (Button) findViewById(R.id.five);
            btnSix = (Button) findViewById(R.id.six);
            btnSeven = (Button) findViewById(R.id.seven);
            btnEight = (Button) findViewById(R.id.eight);
            btnNine = (Button) findViewById(R.id.nine);
            btnMult = (Button) findViewById(R.id.mult);
            btnMinus = (Button) findViewById(R.id.minus);
            btnSum = (Button) findViewById(R.id.sum);
            btnEquals = (Button) findViewById(R.id.equals);
            btnPoint = (Button) findViewById(R.id.point);
            btnMinusOne = (Button) findViewById(R.id.minusOne);
            btnSquared = (Button) findViewById(R.id.squared);
            btnSquaredRoot = (Button) findViewById(R.id.squaredRoot);
            btnDiv = (Button) findViewById(R.id.div);
            btnMasMenos = (Button) findViewById(R.id.MasMenos);
            btnC = (Button) findViewById(R.id.C);
            btnCE = (Button) findViewById(R.id.CE);
            btnANS = (Button) findViewById(R.id.ANS);
            btnPercent = (Button) findViewById(R.id.Percent);

            btnZero.setOnClickListener(this);
            btnOne.setOnClickListener(this);
            btnTwo.setOnClickListener(this);
            btnThree.setOnClickListener(this);
            btnFour.setOnClickListener(this);
            btnFive.setOnClickListener(this);
            btnSix.setOnClickListener(this);
            btnSeven.setOnClickListener(this);
            btnEight.setOnClickListener(this);
            btnNine.setOnClickListener(this);
            btnMult.setOnClickListener(this);
            btnMinus.setOnClickListener(this);
            btnSum.setOnClickListener(this);
            btnEquals.setOnClickListener(this);
            btnPoint.setOnClickListener(this);
            btnMinusOne.setOnClickListener(this);
            btnSquared.setOnClickListener(this);
            btnSquaredRoot.setOnClickListener(this);
            btnDiv.setOnClickListener(this);
            btnMasMenos.setOnClickListener(this);
            btnC.setOnClickListener(this);
            btnCE.setOnClickListener(this);
            btnANS.setOnClickListener(this);
            btnPercent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String x = ((TextView) view).getText().toString();
        Log.d("x", x);
        Log.d("op", operador);

        // CLEAR and CLEAR ERROR
        if(x.equals(btnC.getText())){
            reinicio();
            txt1.setText("0");
        }else if(x.equals(btnCE.getText())){

            if(operador.isEmpty()){
                auxCadena1 = "0"; //txt1.setText("Caso 1");
            }else if( operador != "" && auxCadena2 == ""){
                operador = ""; //txt1.setText("Caso 2");
            }else if(operador != "" && auxCadena2 != ""){
                auxCadena2 = "0"; //txt1.setText("Caso 3");
            }
        }

        // +/- Bool
        if(x.equals("+/-")) {
            if (operador.equals("") || operador.equals("C") || operador.equals("CE")) {
                num1Bool = true; txt1.setText("num1Bool=true");
            } else {
                num2Bool = true; txt1.setText("num2Bool=true");
            }
        }

        //ANS
        if(x.equals("ANS")){
            ansCadena = String.valueOf(ans);
            auxCadena1 = ansCadena;
            txt1.setText("ANS");
        }

        //identificador de numeros
        if(Character.isDigit(x.charAt(0)) || x.equals(btnPoint.getText()) ){

            if(operador.isEmpty() && (auxCadena1 != ansCadena)){
                auxCadena1 = auxCadena1 + x;
                txt1.setText(String.valueOf(auxCadena1));
            }else{
                auxCadena2 = auxCadena2 + x;
                txt1.setText(String.valueOf(auxCadena2));
            }

        }else if(x.equals("=")){
                Log.d("op", operador);
                Log.d("cadena1", auxCadena1);
                Log.d("cadena2", auxCadena2);
                idOperacion();
                txt1.setText(String.valueOf(resultado));
                ans = resultado;
                reinicio();
        }else if( !(x.equals("C") || x.equals("CE") || x.equals("+/-")) ){
            operador = x;
        }
    }

    public void idOperacion(){

        num1 = Double.valueOf(auxCadena1);
        num2 = Double.valueOf(auxCadena2);

        // +/- operation
        if(num1Bool)
            num1 = -1*num1;
        if(num2Bool)
            num2 = -1*num2;

        switch (operador){
            case"+":
                resultado = num1 + num2;
                break;
            case"-":
                resultado = num1 - num2;
                break;
            case"*":
                resultado = num1 * num2;
                break;
            case"/":
                resultado = num1/num2;
                break;
            case"^-1":
                resultado = Math.pow(num1, -1);
                break;
            case"X^2":
                resultado = Math.pow(num1, 2);
                break;
            case"sqrt(X)":
                resultado = Math.sqrt(num1);
                break;
            case"%":
                resultado = num1*(num2/100);
                break;
        }
    }

    public void reinicio(){
        auxCadena1 = "0";
        auxCadena2 = "0";
        num1 = 0;
        num2 = 0;
        operador = "";
        resultado = 0;
        num1Bool = false;
        num2Bool = false;
    }
}