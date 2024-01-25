/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import view.Menu;
import model.TextModel;
/**
 *
 * @author HELLO
 */
public class TextController extends Menu<String> {
    static String[] mchon = new String[] {"Normalize Text", "Exit"};
    private TextModel model = new TextModel();
    public TextController() {
        super("NORMALIZE TEXT PROGRAM", mchon);
    }
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
            {
                try {
                    model.readTextFromFile();
                } catch (ParseException ex) {
                    System.out.println("Cannot read file");
                }
            }
                break;

            default:
                System.exit(0);
        }
    }
    
}
