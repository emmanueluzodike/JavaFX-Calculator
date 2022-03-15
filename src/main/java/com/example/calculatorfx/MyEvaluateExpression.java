package com.example.calculatorfx;

import javafx.scene.control.Button;

public class MyEvaluateExpression {
    String expression;
    double result = 0;
    //calculates expression based on buttonText
    public String evaluateExpression(String Number1, String Number2, String buttonText){
        if (buttonText == "+") {
            double num1 = Double.parseDouble(Number1); //casts string to double value
            double num2 = Double.parseDouble(Number2); //casts string to double value
            result = num1 + num2;
            String stringValue = String.valueOf(result); //casts double to string
            return stringValue; //returns result/string
        }

       else if (buttonText == "-") {
            double num1 = Double.parseDouble(Number1);
            double num2 = Double.parseDouble(Number2);
             result = num1 - num2;
             String stringValue = String.valueOf(result);
             return stringValue;

        }

        else if (buttonText == "/") {
            double num1 = Double.parseDouble(Number1);
            double num2 = Double.parseDouble(Number2);
            if(num2 == 0){
                return "ERROR";
            }
            result = num1 / num2;
            String stringValue = String.valueOf(result);
            return stringValue;

        }

        else if (buttonText == "*") {
            double num1 = Double.parseDouble(Number1);
            double num2 = Double.parseDouble(Number2);
            result = num1 * num2;
            String stringValue = String.valueOf(result);
            return stringValue;

        }
return "ERROR";
    }
}
