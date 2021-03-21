package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Painel t = new Painel();
    }

    public static class Painel extends JFrame {
        JPanel panel = new JPanel();
        JLabel textosaida = new JLabel();
        JTextField textoEntrada = new JTextField("Enter text here",5);
        JButton botãoInput = new JButton("Enter");
        JLabel textoSaida1 = new JLabel();
        JLabel textoSaida2 = new JLabel();
        JLabel textoSaida3 = new JLabel();
        JLabel textoSaida4 = new JLabel();

        public Painel() {
            setTitle("Atividade TI-III");
            setVisible(true);
            setSize(600, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            panel.setLayout(null);
            textoEntrada.setDocument(new JTextFieldLimit(5));


            JLabel rotulo1,rotulo2,rotulo3,rotulo4, rotulo5, rotulo6;

            rotulo1 = new JLabel ("Insira uma palavra");
            rotulo2 = new JLabel ("String normal: ");
            rotulo3 = new JLabel ("String com separação dos caracteres: ");
            rotulo4 = new JLabel ("Convertendo char para ASII: ");
            rotulo5 = new JLabel ("Soma 10: ");
            rotulo6 = new JLabel ("Saida criptografada: ");

            //Get the width and height of the app window
            int largura = getContentPane().getSize().width;
            int altura = getContentPane().getSize().height;

            //Set position of the components
            rotulo1.setBounds(largura - 550, altura - 250, 110, 30);
            textoEntrada.setBounds(largura - 430, altura - 250, 250, 30);
            botãoInput.setBounds(largura - 150, altura - 250, 100, 30);
            rotulo2.setBounds(largura - 550, altura - 200, 110, 30);
            rotulo3.setBounds(largura - 550, altura - 170, 250, 30);
            rotulo4.setBounds(largura - 550, altura - 140, 200, 30);
            rotulo5.setBounds(largura - 550, altura - 110, 110, 30);
            rotulo6.setBounds(largura - 550, altura - 80, 200, 30);
            textosaida.setBounds(largura - 460, altura - 200, 110, 30);
            textoSaida1.setBounds(largura - 320, altura - 170, 110, 30);
            textoSaida2.setBounds(largura - 380, altura - 140, 200, 30);
            textoSaida3.setBounds(largura - 380, altura - 110, 200, 30);
            textoSaida4.setBounds(largura - 400, altura - 80, 300, 30);


            panel.add(rotulo1);
            panel.add(textoEntrada);
            panel.add(textoEntrada);
            panel.add(textosaida);
            panel.add(textoSaida2);
            panel.add(textoSaida3);
            panel.add(textoSaida4);



            textoEntrada.addActionListener(e -> {
                String input = textoEntrada.getText();
                textosaida.setText(input);

            });


            botãoInput.addActionListener(e -> {
                String input = textoEntrada.getText();
                textosaida.setText(input);

                String input1 = setSpaceinString(input);
                String input2 = ConvertToASCIIPlusWithoutSpace(input1);
                textoSaida1.setText(input1);
                textoSaida2.setText(ConvertToASCII(input1));
                textoSaida3.setText(ConvertToASCIIPlus(input1));
                long yourLong = Long.parseLong(input2);
                String str = String.valueOf(yourLong);
                textoSaida4.setText(asciiToString(str,yourLong));
            });

            //Separar a string



            panel.add(botãoInput);
            panel.add(textoSaida1);
            panel.add(rotulo2);
            panel.add(rotulo3);
            panel.add(rotulo4);
            panel.add(rotulo5);
            panel.add(rotulo6);
            add(panel);
            setResizable(false);
        }
    }

    public static String setSpaceinString(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > 0) {
                result.append(" ");
            }

            result.append(input.charAt(i));
        }
        return result.toString();
    }

    public static String ConvertToASCII (String input) {
        String str = input;  // or anything else

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
            sb.append((int)c);

        String teste = sb.toString();
        BigInteger mInt = new BigInteger(sb.toString());
        String intToString = mInt.toString();
        String returnString = intToString.replace("32", " ");


        return returnString;
    }

    public static String ConvertToASCIIPlus (String input) {
        String str1 = input;

        StringBuilder sb = new StringBuilder();
        for (char c : str1.toCharArray())
            sb.append((int)c + 10);

        String teste = sb.toString();
        BigInteger mInt = new BigInteger(sb.toString());
        String intToString = mInt.toString();
        String returnString = intToString.replace("42", " ");


        return returnString;
    }

    public static String ConvertToASCIIPlusWithoutSpace (String input) {
        String str1 = input;

        StringBuilder sb = new StringBuilder();
        for (char c : str1.toCharArray())
            sb.append((int)c + 10);

        String teste = sb.toString();
        BigInteger mInt = new BigInteger(sb.toString());
        String intToString = mInt.toString();
        String returnString = intToString.replace("42", "0");


        return returnString;
    }

    static String asciiToString(String str, long len)
    {
        int num = 0;
        String returnString = "";
        try {
            for (int i = 0; i < len; i++) {


                // Append the current digit
                num = num * 10 + (str.charAt(i) - '0');

                // If num is within the required range
                if (num >= 32 && num <= 400) {
                    char ch = (char) num;
                    // Convert num to char
                    //char ch = (char)num;
                    returnString = returnString.concat(String.valueOf(ch));
                    System.out.print(ch);
                    System.out.print(returnString);
                    // Reset num to 0
                    num = 0;
                }
            }
        }
        catch (Exception e) {
        System.out.println(e);
        }
        return returnString;
    }

    static class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }
        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;
            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
