import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;



public class Main {


    public static void main(String[] args) {

        List<String> AcceptedWords = new ArrayList<>();
        List<String> WrongLetters = new ArrayList<>();
        List<String> GoodLetters = new ArrayList<>();
        List<String> possibleAnswers = new ArrayList<>();
        System.out.println("Okay So Here Are Your Options");

        // Yellow Or Green Letters


        BufferedReader bufferedReader = null;
        String filename = "/Users/Admin/Documents/EverySingleWord.txt";
        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            while ((line = bufferedReader.readLine()) != null) {
                AcceptedWords.add(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Random RandomGenerator = new Random(AcceptedWords.size());


        Integer NewNum = (RandomGenerator.nextInt(AcceptedWords.size() - 10 + 23 - 13));
        System.out.println("We have " + AcceptedWords.size() + "" +
                " differnt words Computer Thinks you should try this "
                + "[" + (AcceptedWords.get(NewNum) + "]")
        );


        /* Everyone has an a*/

        /*    WrongLetters.add("a"); */
        /* GoodLetters.add("e"); */
        System.out.println(AcceptedWords.get(6));
        GoodLetters.add("l");
        System.out.println(Sorters.DoesHaveThis(AcceptedWords.get(6), GoodLetters));
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        JButton button1 = new JButton("Submit Yellow Letter");
        JButton button2 = new JButton("Submit Grey Letter");
        JButton button3 = new JButton("Submit Green Letter");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
        panel.setLayout(new GridLayout(3, 3));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        JPanel TextBoxPanel = new JPanel();
        TextBoxPanel.setBorder(BorderFactory.createEmptyBorder(500, 00, 00, 00));
        TextBoxPanel.setLayout(new GridLayout(3, 3));

        JTextField Letters = new JTextField(1);



        String WordleAnswers = null;
        if (AcceptedWords.size() > 20) {
            WordleAnswers = "Okay So We Have Too Many Options Right Now, Actually We Have " + AcceptedWords.size()
                    + " So Ill give you 10 to choose from, keep it mind this may not be the anwser ["
                    + AcceptedWords.get(NewNum - 1) + "] or ["
                    + AcceptedWords.get(NewNum - 2) + "] or ["
                    + AcceptedWords.get(NewNum - 3) + "] or ["
                    + AcceptedWords.get(NewNum - 4) + "] or ["
                    + AcceptedWords.get(NewNum - 5) + "] or ["
                    + AcceptedWords.get(NewNum + 1) + "] or ["
                    + AcceptedWords.get(NewNum + 2) + "] or ["
                    + AcceptedWords.get(NewNum + 3) + "] or ["
                    + AcceptedWords.get(NewNum + 4) + "] or ["
                    + AcceptedWords.get(NewNum + 5) + "]";
        }
        JFrame answers = new JFrame("Answers");
        JLabel label1 = new JLabel(WordleAnswers);

        answers.setSize(300, 300);
        answers.add(label1);
        answers.setVisible(true);

        TextBoxPanel.add(Letters);
        TextBoxPanel.setVisible(true);
        panel.add(Letters);
        panel.setVisible(true);
        frame.add(panel);
        frame.setVisible(true);
        frame.add(TextBoxPanel);
        frame.setVisible(true);
        int TheresAlreadyACut = 0;

        String finalWordleAnswers = WordleAnswers;
        button2.addActionListener(new ActionListener() {
            public static int TheresAlreadyACut = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String Letter = Letters.getText().toLowerCase();
                WrongLetters.add(Letter);
                System.out.println(AcceptedWords.size());
                System.out.println(AcceptedWords);
                System.out.println("Looks here Grey this [" + Letter + "] is not in the word at all");
                for(int x = 0; x < AcceptedWords.size();x++){
                    if(Sorters.DoesntHaveThis(AcceptedWords.get(x),WrongLetters)){

                        possibleAnswers.add(AcceptedWords.get(x));
                    }

                }
                AcceptedWords.clear();
                for(int i = 0; i < possibleAnswers.size();i++){
                    AcceptedWords.add(possibleAnswers.get(i));
                }
                possibleAnswers.clear();


                System.out.println(AcceptedWords.size());
                System.out.println(AcceptedWords);
                String WordleAnswers = null;
                if (AcceptedWords.size() > 20) {
                    WordleAnswers = "Okay So We Have Too Many Options Right Now, Actually We Have " + AcceptedWords.size()
                            + " So Ill give you 3 to choose from, keep it mind this may not be the anwser ";

                }
                answers.setVisible(false);

                JFrame Cut = new JFrame("Answers");
                JLabel label1 = new JLabel(WordleAnswers);
                Cut.add(label1);
                Cut.setVisible(3 == 3);
                TheresAlreadyACut++;
                System.out.println(TheresAlreadyACut);
              ;


            }
        });


    }
}

