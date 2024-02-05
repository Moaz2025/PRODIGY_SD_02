package com.example.prodigy_sd_02;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Objects;

public class HelloController {
    Generator generator;

    @FXML
    private Text attempts;

    @FXML
    private Text generated;

    @FXML
    private TextField guessInput;

    @FXML
    private Text output;

    @FXML
    private TextField rangeInput;

    @FXML
    void checkInput(MouseEvent event) {
        if (Objects.isNull(generator))
            output.setText("No number generated");
        else {
            String input = guessInput.getText();
            NumericCheck numericCheck = new NumericCheck();
            if (numericCheck.isNumeric(input)) {
                String check = generator.checkValue(Integer.parseInt(guessInput.getText()));
                output.setText("Status: " + check);
                attempts.setText("Number of attempts: " + generator.getAttempts());
            }
            else output.setText("Enter a valid number");
        }
    }

    @FXML
    void generate(MouseEvent event) {
        String input = rangeInput.getText();
        NumericCheck numericCheck = new NumericCheck();
        if (numericCheck.isNumeric(input)) {
            this.generator = new Generator();
            generator.start(Integer.parseInt(rangeInput.getText()));
            generated.setText("Number generated successfully");
        }
        else generated.setText("Enter a valid number");
    }
}
