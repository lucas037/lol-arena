package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import Entity.*;
import Controller.*;

public class Telas {
    private static Stage stage;
    private static final Image icon = new Image("/view/Imagens/Personagens/Viper.png");
    private Jogador jogadorA;
    private Jogador jogadorB;

    public Telas(Stage stage) {
        Telas.stage = stage;
        Telas.stage.setTitle("Arena");
        stage.setWidth(1366);
        stage.setHeight(728);
        stage.setMinWidth(1366);
        stage.setMinHeight(728);
        Telas.stage.getIcons().add(icon);
    }

    public static void switchScene(String fxml) {
        FXMLLoader loader = new FXMLLoader(Telas.class.getResource(fxml));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchTelaPartida(String fxml) {
        FXMLLoader loader = new FXMLLoader(Telas.class.getResource(fxml));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());



            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage newScene(String fxml) {
        FXMLLoader loader = new FXMLLoader(Telas.class.getResource(fxml));
        Parent root;
        Stage newStage = null;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
            newStage = new Stage();
            newStage.setTitle("Arena");
            newStage.setResizable(false);
            newStage.getIcons().add(icon);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newStage;
    }

}