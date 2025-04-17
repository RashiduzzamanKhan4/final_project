package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UIHelper {
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
