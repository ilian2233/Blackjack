package org.example;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import org.example.Models.Card;
import org.example.Models.Impl.Dealer;

import java.io.IOException;

public class GameRoundController {

    @FXML
    private Button standButton;
    @FXML
    private Button hitButton;
    @FXML
    private ListView<Card> playerCards;
    @FXML
    private Label playerCardsValue;
    @FXML
    private ListView<Card> dealerCards;
    @FXML
    private Label dealerCardsValue;
    @FXML
    private Label betAmount;
    @FXML
    private AnchorPane anchorPane;

    private void updateHandValues() {
        playerCards.getItems().clear();
        Main.game.getPlayersHand().forEach(i -> playerCards.getItems().add(i));
        playerCardsValue.setText("Hand value: " + Main.game.getPlayerHandValue());

        dealerCards.getItems().clear();
        Main.game.getDealersHand().forEach(i -> dealerCards.getItems().add(i));
        dealerCardsValue.setText("Hand value: " + Main.game.getDealerHandValue());
    }

    public void initialize() {
        updateHandValues();
        betAmount.setText("Bet: " + (int) Main.game.getBetAmount());
        if(Main.game.getPlayerHandValue()==21||Main.game.getDealerHandValue()==21){
            endGameForPlayer();
        }
    }

    @FXML
    private void stand() {
        endGameForPlayer();
    }

    @FXML
    private void hit() {
        Main.game.hitPlayer();
        updateHandValues();
        if (Main.game.getPlayerHandValue() >= 21) {
            endGameForPlayer();
        }
    }

    private void endGameForPlayer() {
        hitButton.setDisable(true);
        standButton.setDisable(true);

        Main.game.dealerPlay();
        updateHandValues();

        if (Main.game.getWinner().isEmpty()) {
            setPlayerAndDealerColor(Color.GREEN, Color.GREEN);
        } else if (Main.game.getWinner().get().getClass() == Dealer.class) {
            setPlayerAndDealerColor(Color.RED, Color.GREEN);
        } else {
            setPlayerAndDealerColor(Color.GREEN, Color.RED);
        }

        anchorPane.setOnMouseClicked(mouseEvent -> {
            Main.game.addWinningsOrLosesToPlayer();
            try {
                Main.toMainPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setPlayerAndDealerColor(Color playerColor, Color dealerColor) {
        playerCards.setBackground(new Background(new BackgroundFill(playerColor, CornerRadii.EMPTY, Insets.EMPTY)));
        playerCardsValue.setBackground(new Background(new BackgroundFill(playerColor, CornerRadii.EMPTY, Insets.EMPTY)));

        dealerCards.setBackground(new Background(new BackgroundFill(dealerColor, CornerRadii.EMPTY, Insets.EMPTY)));
        dealerCardsValue.setBackground(new Background(new BackgroundFill(dealerColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
