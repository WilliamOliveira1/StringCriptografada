package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Tutorial t = new Tutorial();
    }

    public static class Tutorial extends JFrame {
        JPanel panel = new JPanel();
        JLabel textosaida = new JLabel();
        JTextField textoEntrada = new JTextField(30);
        JButton botãoInput = new JButton("Enter");
        JLabel textoSaida1 = new JLabel();
        JLabel textoSaida2 = new JLabel();

        public Tutorial() {
            setTitle("Atividade TI-III - Agenda 05");
            setVisible(true);
            setSize(600, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            panel.setLayout(null);


            JLabel rotulo1,rotulo2,rotulo3,rotulo4, rotulo5, rotulo6;

            rotulo1 = new JLabel ("Insira uma palavra");
            rotulo2 = new JLabel ("String normal: ");
            rotulo3 = new JLabel ("String com separação dos caracteres: ");
            rotulo4 = new JLabel ("Convertendo char para ASII: ");
            rotulo5 = new JLabel ("Soma 10: ");
            rotulo6 = new JLabel ("Saida criptografada: ");

            int largura = getContentPane().getSize().width;
            int altura = getContentPane().getSize().height;

            rotulo1.setBounds(largura - 100, 10, 110, 30);
            textoEntrada.setBounds(largura - 100, 50, 110, 30);
            panel.add(rotulo1);
            panel.add(textoEntrada);
            panel.add(textoEntrada);
            panel.add(textosaida);
            panel.add(textoSaida2);

            textoEntrada.addActionListener(e -> {
                String input = textoEntrada.getText();
                textosaida.setText(input);
                textoSaida1.setText(input);
                textoSaida2.setText(input);
            });


            botãoInput.addActionListener(e -> {
                String input = textoEntrada.getText();
                textosaida.setText(input);
                textoSaida1.setText(input);
                textoSaida2.setText(input);
            });

            panel.add(botãoInput);
            panel.add(textoSaida1);
            panel.add(rotulo2);
            panel.add(rotulo3);
            panel.add(rotulo4);
            panel.add(rotulo5);
            panel.add(rotulo6);
            add(panel);
            //getContentPane().add(BorderLayout.SOUTH, panel);
            setResizable(false);
        }
    }
}
