/*
Written by Emmanuel Uzodike
Date: November 28, 2021

Simple Calculator

This program is a simple calculator. It takes two inputs from the user and performs simple operations on them. (add, subtract
division or multiplication). The program also clears the calculator when the user clicks on the clear button

 */


package com.example.calculatorfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application implements EventHandler<ActionEvent> {
    //Button objects. +,-,/,*,= and clear
    Button plusButton = new Button("+");Button minusButton = new Button("-");
    Button divideButton = new Button("/");Button multButton = new Button("*");Button ClearButton = new Button("CLEAR");
    TextField Number1 = new TextField();
    TextField Number2 = new TextField();
    Label resultLabel = new Label();
    MyEvaluateExpression evaluateExpression = new MyEvaluateExpression(); //this object does the calculations

    @Override
    public void start(Stage stage) throws IOException {
        //create gridpane and add buttons to it
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5 ));
        gridPane.setVgap(5.5);
        gridPane.setHgap(5.5);
        gridPane.setMinSize(400,200);

        gridPane.add(Number1, 1 ,0);
        gridPane.add(Number2, 1,1);

        gridPane.add(new Label("Number 1"), 0,0); //first operand label
        //gridPane.add(new TextField(), 1,0);
        gridPane.add(new Label("Number 2"), 0,1 );//second operant label
        //gridPane.add(new TextField(),1,1);
        gridPane.add(new Label("Result: "), 0, 2); //result label
       // Label resultLabel = new Label();
        gridPane.add(resultLabel, 1, 2);

//add buttons to pane
       gridPane.add(minusButton, 3, 2);
        gridPane.add(plusButton, 3, 3);gridPane.add(divideButton, 3, 0);gridPane.add(ClearButton, 0, 3);
        gridPane.add(multButton, 3,1 );

        //action event call
        plusButton.setOnAction(this);
        minusButton.setOnAction(this);divideButton.setOnAction(this);multButton.setOnAction(this);
        ClearButton.setOnAction(this);


        Scene scene = new Scene(gridPane);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    //Event handler(button press)
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource(); //cast event to a button
        String buttonText = button.getText(); //get text of the button
        double result = 0;
        try{

        switch (buttonText){
            case "CLEAR":
                setClearButton(); //clear calculator
                break;
            default:
                //calculate and return and store in result text field
                resultLabel.setText(evaluateExpression.evaluateExpression(Number1.getText(), Number2.getText(), buttonText));

        }


    }catch (Exception e){
            resultLabel.setText("ERROR"); //display if an error occurs
        }
    }
//clear button
    public void setClearButton(){
        Number1.setText(" "); //clear number1 text field
        Number2.setText(" "); //clear number2 text field
        resultLabel.setText(" "); //clear result text field

    }
}