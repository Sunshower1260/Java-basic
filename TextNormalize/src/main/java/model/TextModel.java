/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.logging.Logger;

/**
 *
 * @author HELLO
 */
public class TextModel {
    private String input = "";
    private String output="";
    
    public TextModel() {}
    
    public TextModel(String input, String output) {
        this.input = input;
        this.output = output;
    }
    
    public void addText(String text) {
        output = output + text;
    }
    
    public String getOutput() {
        return this.output;
    }
    
    public void readTextFromFile() throws ParseException {
        String path = "text.txt";
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                input = line;
                addText(normallizeText(input));
                line = bufferedReader.readLine();
            }
        } catch (IOException i) {
            System.out.println("File not found");
        } finally {
            try {
                System.out.println(getOutput());
                bufferedReader.close();
                writeFile(getOutput());
            } catch (IOException ex) {
                Logger.getLogger("Cannot close file");
            }
        }
    }
    
    public String normallizeText(String input) {
        input = input.replaceAll("\\s", " ").toLowerCase();
        String[] array = input.split(" ");
        array[0] = array[0].substring(0,1).toUpperCase() + array[0].substring(1);
        for (int i=0; i<array.length-2; i++) {
            if (array[i].contains(".")) {
                array[i] = formatText(array[i]);
            }
        }
        String temp= "";
        for (String string: array) {
            temp += " " + string;
        }
        if (!array[array.length-1].endsWith(".")) {
            temp += ".";
        }
        temp += "\n";
        return temp;
    }
    
    public static String formatText(String text) {
        String[] tokens = text.split("\\.");
        
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            
            if (i > 0) {
                formattedText.append(". ");
            }
            
            formattedText.append(Character.toUpperCase(token.charAt(0)))
                        .append(token.substring(1));
        }
        
        return formattedText.toString();
    }
    
    public void writeFile(String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write(text + "\n");
            bufferedWriter.close();
        } 
        catch (IOException i) {
            System.out.println("Write to file failed");
        }
    }
}
