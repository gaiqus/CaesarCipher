package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {


    public static String encrypt(String message) {
        StringBuilder stringBuilder = new StringBuilder(message);
        int distance = 3;

        for (int i = 0; i < stringBuilder.length(); i++) {
            int c = (int) stringBuilder.charAt(i);
            if (c + distance > 122) {
                c = 31 + (distance - (122 - c));
            } else {
                c += distance;
            }
            stringBuilder.setCharAt(i, (char)c);

        }
        return stringBuilder.toString();
    }

    public static String decrypt(String message) {
        StringBuilder stringBuilder = new StringBuilder(message);
        int distance = 3;

        for (int i = 0; i < stringBuilder.length(); i++) {
            int c = (int) stringBuilder.charAt(i);
            if (c - distance < 32) {
                c = 123 - (distance - (c - 32));
            } else {
                c -= distance;
            }
            stringBuilder.setCharAt(i, (char)c);

        }
        return stringBuilder.toString();
    }

    public Button encodeButton;
    public Button decodeButton;
    public Button resetButton;
    public Button exitButton;
    public TextArea inputFromUser;
    public TextArea resultText;

    public void encodeButtonClick(){
        String message = inputFromUser.getText();
        String encrypted = Controller.encrypt(message);
        resultText.setText(encrypted);
    }
    public void decodeButtonClick(){
        String message = inputFromUser.getText();
        String encrypted = Controller.decrypt(message);
        resultText.setText(encrypted);
    }
    public void resetButtonClick(){
        inputFromUser.setText("");
        resultText.setText("");
    }
    public void exitButtonClick(){
        System.exit(0);
    }
}
