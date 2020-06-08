package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.Models.Game;
import org.example.Models.Impl.TableImpl;
import org.example.Models.Table;

import java.io.IOException;

public class Main extends Application {

    private static Scene scene;

    private static final Table table = new TableImpl(1000);

    public static Game game;

    public static int getPlayerBankAmount(){
        return table.getPlayerBankAmount();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void setScene(String name) throws IOException {
        scene.setRoot(loadFXML(name));
        scene.getWindow().sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void startRound(double betAmount) throws IOException {
        game = table.startRound(betAmount);
        setScene("gameRound");
    }

    public static void toMainPage() throws IOException {

        setScene("mainPage");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("mainPage"));

        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
