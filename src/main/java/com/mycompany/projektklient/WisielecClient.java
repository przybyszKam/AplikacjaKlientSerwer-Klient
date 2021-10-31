package com.mycompany.projektklient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kamila Przybysz
 */
public class WisielecClient {
    BufferedReader in;
    PrintWriter out;
    JFrame frame = new JFrame("Wisielec");
    JTextField textField = new JTextField(40);
    JTextField textHaslo = new JTextField(40);
    JTextArea messageArea = new JTextArea(10,20);
    JTextArea wisielecArea = new JTextArea(10,20);
    JScrollPane scrollPane = new JScrollPane(messageArea);
    int verticalScrollBarMaximumValue;
   
    public WisielecClient(){
        textField.setEditable(false);
        textHaslo.setEditable(false);
        messageArea.setEditable(false);
        wisielecArea.setEditable(false);
        verticalScrollBarMaximumValue = scrollPane.getVerticalScrollBar().getMaximum();
        scrollPane.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent e) -> {
            if ((verticalScrollBarMaximumValue - e.getAdjustable().getMaximum()) == 0)
                return;
            e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            verticalScrollBarMaximumValue = scrollPane.getVerticalScrollBar().getMaximum();
        });
        
        frame.getContentPane().add(textHaslo, BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane, BorderLayout.LINE_START);
        frame.getContentPane().add(wisielecArea, BorderLayout.LINE_END);
        frame.getContentPane().add(textField, BorderLayout.PAGE_END);
        frame.pack();
        frame.setResizable(false);

        textField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println(textField.getText());
                textField.setText("");
            }
        });  
    }
    
    private String getServerAddress(){
        return JOptionPane.showInputDialog(
                frame, 
                "Enter IP Address of the Server:",
                "Welcome to the Wisielec",
                JOptionPane.QUESTION_MESSAGE);
    }
    
    private String getName(){
        return JOptionPane.showInputDialog(
                frame,
                "Choose a screen name:",
                "Screen name selection",
                JOptionPane.QUESTION_MESSAGE);
    }
    
    private String rysowanieWisielca(int szansa){
        StringBuilder wisielec = new StringBuilder();
        switch(szansa){
            case 0: 
                wisielec.append("\n\n\n\n\n\n\n\n");
            
                break;
            case 1:
                wisielec.append("\n\n\n\n\n\n\n")
                        .append("                    / ");
             
                break;
            case 2:
                wisielec.append("\n\n\n\n\n\n\n")
                        .append("                    / \\");
                break;    
            case 3:
                wisielec.append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 4:
                wisielec.append("                     |______ \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                
                break;  
            case 5:
                wisielec.append("                     |______ \n")
                        .append("                     |/ \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 6:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 7:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 8:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     |             | \n")
                        .append("                     |             | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 9:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     |            /| \n")
                        .append("                     |             | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 10:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     |            /|\\ \n")
                        .append("                     |             | \n")
                        .append("                     | \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 11:
                wisielec.append("                     |______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     |            /|\\ \n")
                        .append("                     |             | \n")
                        .append("                     |            /  \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
            case 12:
                wisielec.append("                      ______ \n")
                        .append("                     |/            | \n")
                        .append("                     |            O \n")
                        .append("                     |            /|\\ \n")
                        .append("                     |             | \n")
                        .append("                     |            / \\ \n")
                        .append("                     | \n")
                        .append("                    / \\");
                break;  
        }
        return wisielec.toString();
    }
    
    private void runn() throws IOException{
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        while(true){
            String line = in.readLine();
            if(line!=null){
                if(line.startsWith("name")){
                out.println(getName());
                }else if(line.equals("waiting for opponent")){
                    messageArea.append(line + "\n");
                }else if(line.equals("accepted")){
                    textField.setEditable(true);
                }else if(line.startsWith("moja tura")){
                    textField.setEditable(true);
                }else if(line.startsWith("czekaj")){
                    textField.setEditable(false);
                }else if(line.startsWith("message")){
                    messageArea.append(line.substring(8) + "\n");
                }else if(line.equals("opponent exit")){
                    messageArea.append(line + "\n");
                    textField.setEditable(false);
                }else if(line.startsWith("nowe haslo")){
                    textHaslo.setText(line.substring(11));
                }else if(line.startsWith("aktualizacja ukrytego hasla")){
                    textHaslo.setText(line.substring(28));
                }else if(line.startsWith("wisielec")){
                    wisielecArea.setText(rysowanieWisielca(Integer.valueOf(line.substring(9))));
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        WisielecClient client = new WisielecClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.runn();
    }
}