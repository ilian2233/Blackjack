package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.io.IOException;

public class MainPageController {

    @FXML
    public Button submit;
    @FXML
    private Label bankAmount;
    @FXML
    private Slider betAmountSlider;
    @FXML
    private Label betAmountLabel;

    public void initialize() {
        betAmountSlider.setMin(1);
        betAmountSlider.setMax(Main.getPlayerBankAmount());
        bankAmount.setText(/*"Amount in bank: " + */String.valueOf(Main.getPlayerBankAmount()));
        calculateBet();
    }

    public void startRound() throws IOException {
        Main.startRound((int) betAmountSlider.getValue());
    }

    public void calculateBet() {
        betAmountLabel.setText(String.valueOf((int) (betAmountSlider.getValue())));
    }
}
