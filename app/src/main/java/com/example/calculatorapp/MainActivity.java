package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button bt0 , bt1 ,bt2 , bt3 , bt4 , bt5 , bt6 , bt7 ,
        bt8 , bt9 , btcancel , btdivide , btmultiply , btminus , btplus , btequal , btdecimal;//reference to buttons
EditText etResult;//reference to edit text
String first_number ="";//to store left operand of equation//
    // taken in string as we need to check value of first number whether it is empty or not
    // because i will set operator type only after first number has some value
    //with string we can easily check
    //and if i used double for it then i have to split the digits
    //so depends upon own style of coding
    //equation is possible only if first number has some value//no chances of error as only numeric values are present in app
    //we can choose double type also//in calculation parse double is used to make it double again
String second_number ="";//to store right operand of equation
Double final_result =0.0;//to store final result/output
String operator ="";//to store operator type
String equation ="";//to store whole equation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //memory to buttons and edittext
        etResult =(EditText)findViewById(R.id.enteredResult);

        bt0 =(Button)findViewById(R.id.bt0);
        bt1 =(Button)findViewById(R.id.bt1);
        bt2 =(Button)findViewById(R.id.bt2);
        bt3 =(Button)findViewById(R.id.bt3);
        bt4 =(Button)findViewById(R.id.bt4);
        bt5 =(Button)findViewById(R.id.bt5);
        bt6 =(Button)findViewById(R.id.bt6);
        bt7 =(Button)findViewById(R.id.bt7);
        bt8 =(Button)findViewById(R.id.bt8);
        bt9 =(Button)findViewById(R.id.bt9);
        btcancel =(Button)findViewById(R.id.btcancel);
        btdivide =(Button)findViewById(R.id.btdivide);
        btmultiply =(Button)findViewById(R.id.btmultiply);
        btminus =(Button)findViewById(R.id.btminus);
        btplus =(Button)findViewById(R.id.btplus);
        btequal =(Button)findViewById(R.id.btequal);
        btdecimal =(Button)findViewById(R.id.btdecimal);
    }
    public  void findOutput(View view){//this function is called when any button is clicked based on button ID
        if(view.getId() == R.id.bt0){
            setValues("0");
        }
        else if(view.getId() == R.id.bt1){
            setValues("1");
        }
        else if(view.getId() == R.id.bt2){
            setValues("2");
        }
        else if(view.getId() == R.id.bt3){
            setValues("3");
        }
        else if(view.getId() == R.id.bt4){
            setValues("4");
        }
        else if(view.getId() == R.id.bt5){
            setValues("5");
        }
        else if(view.getId() == R.id.bt6){
            setValues("6");
        }
        else if(view.getId() == R.id.bt7){
            setValues("7");
        }
        else if(view.getId() == R.id.bt8){
            setValues("8");
        }
        else if(view.getId() == R.id.bt9){
            setValues("9");
        }
        else if(view.getId() == R.id.btcancel){
            reset1();
        }
        else if(view.getId() == R.id.btdivide){
              setOperator("/");
        }
        else if(view.getId() == R.id.btmultiply){
            setOperator("*");
        }
        else if(view.getId() == R.id.btminus){
            setOperator("-");
        }
        else if(view.getId() == R.id.btplus){
            setOperator("+");
        }
        else if(view.getId() == R.id.btequal){
            calculate();
        }
        else if(view.getId() == R.id.btdecimal){
            if(!first_number.equals("")){
                setValues(".");
            }
        }
    }
    public void setValues(String btvalue){// set values in first number , second and equation . also set equation in edittext
        if(first_number.equals("")){
            first_number+=btvalue;//to append other digits in first number with it
            equation  = first_number+operator+second_number;//to make partial equation dpending upon value of first number to show in edit text
            etResult.setText(equation);//to set this equation on edit text
        }
        else{
            if(operator.equals("")){//condition to check if operator value is null then append new digit into first number
                first_number+=btvalue;// to append
            }
            else {
                second_number+=btvalue;// to append in second number if operator value is not null
            }
            equation  = first_number+operator+second_number;// to make equation depending upon changes in first number or second number
            etResult.setText(equation);//set it again on edit text
        }

    }
    public void setOperator(String operatorType){//this function set operator type ,
        // equation based on operator and set equation  in edit text
        if(!first_number.equals("")){
            operator=operatorType;//if first number is not null then set operator  type value otherwise not
            equation  = first_number+operator+second_number;//to make quation again depending on operator type value
            etResult.setText(equation);//set on edit text
        }
        else{
        }
    }
    public void calculate(){
        //this function will calculate final result depending upon operator choosed
        //then set final equation in edit text

        if(!first_number.equals("") && !second_number.equals("") && !operator.equals("")){//calculate only if first number ,
            // second number and operator has values
            if(operator.equals("/")){
                final_result = Double.parseDouble(first_number) / Double.parseDouble(second_number);//first covert in double form
            }
            else if(operator.equals("*")){
                final_result = Double.parseDouble(first_number) * Double.parseDouble(second_number);
            }
            else  if(operator.equals("-")){
                final_result = Double.parseDouble(first_number) - Double.parseDouble(second_number);
            }
            else if(operator.equals("+")){
                final_result = Double.parseDouble(first_number) + Double.parseDouble(second_number);
            }
            etResult.setText(Math.round(final_result)+"");
            reset2();
        }
    }
    public void reset1(){//initialize first number , second number , final result,operator , equation values to empty
        //also edit text is cleared
        //as per instructions in mid term assignment->The app only needs to handle one equation at a time
        // (expect the user to press clear after each equation)
        first_number="";
        second_number="";
        operator="";
        equation="";
        etResult.setText("");
        final_result=0.0;
    }
    public void reset2(){//initialize first number , second number , final result,operator , equation values to empty
        //this function is same as rest1 except it does not clear edit text
        first_number=Math.round(final_result)+"";
        second_number="";
        operator="";
        equation="";
        final_result=0.0;
    }
}
