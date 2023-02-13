import java.util.ArrayList;

import java.util.Random;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Scanner;




public class testMemorable{

    static ArrayList<String> quotes = new ArrayList<String>();

    static Scanner input = new Scanner(System.in);

   

    public static void readQuotes(){

        try {

            File file = new File("Quotes.txt");

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                quotes.add(line);

            }

            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

    public static void addQuotes(){

        try {

            FileWriter writer = new FileWriter("Quotes.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String str : quotes) {

                bufferedWriter.write(str);

                bufferedWriter.newLine();

            }

            bufferedWriter.close();

            System.out.println("Data written to file successfully!");

        } catch (IOException e) {

            System.out.println("An error occurred while writing data to the file: " + e.getMessage());

        }

    }

    public static void updateQuotes(){

        try {

            FileWriter writer = new FileWriter("Quotes.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String str : quotes) {

                bufferedWriter.write(str);




                bufferedWriter.newLine();

            }

            bufferedWriter.close();

            System.out.println("Data updated in file successfully!");

        } catch (IOException e) {

            System.out.println("An error occurred while updating data in the file: " + e.getMessage());

        }

    }

    public static void deleteQuotes(){

        try {

            FileWriter writer = new FileWriter("Quotes.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String str : quotes) {

                bufferedWriter.write(str);




                bufferedWriter.newLine();

            }

            bufferedWriter.close();

        } catch (IOException e) {

            System.out.println("An error occurred while updating data in the file: " + e.getMessage());

        }

    }




    public static String printQuotes(String quote){

        String strQuote = quote;

        String[] arrOfStr = strQuote.split("@", 4);

        int counter = Integer.parseInt(arrOfStr[3]);

        counter=counter + 1;

        int index = quotes.indexOf(quote);

        String count = Integer.toString(counter);

        quotes.set(index, arrOfStr[0]+"@"+arrOfStr[1]+"@"+arrOfStr[2]+"@"+count);

        updateQuotes();

        return("Counter("+ count+ "):" + arrOfStr[0]+"\n\t---"+arrOfStr[1]);

    }

    public static String getRandomQuote(){

        Random random = new Random();

        int index = random.nextInt(quotes.size());

        return quotes.get(index);

      }

   

    public static int extractDelay(String[] input) {

        int flag=0;

        int delayInt=0;

        for(int i=0; i<input.length; i++){

            if (input[i].startsWith("delay=")) {

                String delayString = input[i].substring("delay=".length());

                flag+=1;

                try {

                    delayInt = Integer.parseInt(delayString);

                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException("Cannot parse delay value", e);

                }

            }

        }

        if(flag ==0){

        throw new IllegalArgumentException("Input string must start with 'delay='");

        }

        return delayInt;




    }

    public static int extractMax(String[] max) {

        int flag=0;

        int maxInt=0;

        for(int i=0; i<max.length; i++){

            if (max[i].startsWith("max=")) {

                String maxString = max[i].substring("max=".length());

                flag+=1;

                try {

                    maxInt = Integer.parseInt(maxString);

                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException("Cannot parse max value", e);

                }

            }

        }

        if(flag ==0){

        throw new IllegalArgumentException("max string must start with 'max='");

        }

        return maxInt;




    }

    public static void refSearchQuote(String keyword){

        System.out.println("Search results for \"" + keyword + "\":");

        int flag=0;

        for(int n=0; n<quotes.size(); n++){

            String[] arrOfStr = quotes.get(n).split("@");




                if (arrOfStr[1].toLowerCase().contains(keyword.toLowerCase())) {

                    System.out.println("Reference:" + arrOfStr[1] + " Content:" + arrOfStr[0]);

                    flag+=1;

                }

            }

            if(flag==0){

                System.out.println("No Reference Found");

            }

        }

    public static void contSearchQuote(String keyword){

        System.out.println("Search results for \"" + keyword + "\":");

        int flag=0;

        for(int n=0; n<quotes.size(); n++){

        String[] arrOfStr = quotes.get(n).split("@");

          if (arrOfStr[0].toLowerCase().contains(keyword.toLowerCase())) {

            System.out.println(arrOfStr[0]+ " By: " + arrOfStr[1]);

            flag+=1;

          }

        }

        if(flag==0){

            System.out.println("No Content Found");

        }

    }

    public static void categSearchQuote(String keyword){

        System.out.println("Search results for Category: \"" + keyword + "\"");

        int flag=0;

        for(int n=0; n<quotes.size(); n++){

        String[] arrOfStr = quotes.get(n).split("@");

          if (arrOfStr[2].toLowerCase().contains(keyword.toLowerCase())) {

            System.out.println(arrOfStr[0]);

            flag+=1;

          }

        }

        if(flag==0){

            System.out.println("No Category Found");

        }

    }

    public static void showAllQuotes(){

        for (int i=0; i<quotes.size();i++) {

            String strQuote = quotes.get(i);

            String[] arrOfStr = strQuote.split("@", 4);

            int counter = Integer.parseInt(arrOfStr[3]);

            counter=counter + 1;

            int index = quotes.indexOf(strQuote);

            String count = Integer.toString(counter);

            quotes.set(index, arrOfStr[0]+"@"+arrOfStr[1]+"@"+arrOfStr[2]+"@"+count);

            updateQuotes();

            System.out.println(arrOfStr[0]+"\n\t---"+arrOfStr[1]);

        }

    }

    public static void main(String[] args) throws InterruptedException {

        readQuotes();

        if (args.length <= 0) {

            System.out.println("ERROR");

        }

        switch(args[0]){

            case "add":

                System.out.println("Enter your New Quotes(Quotes@Author@Category)");

                String writeQuotes = input.nextLine();

                quotes.add(writeQuotes);

                addQuotes();

                break;

            case "update":

                showAllQuotes();

                System.out.println("Enter the line number");

                int lineNumber = input.nextInt();

                input.nextLine();

                System.out.println("Enter your Updated Quotes(Quotes@Author@Category)");

                String newLineText = input.nextLine();

                // Update the specific line in the ArrayList

                quotes.set(lineNumber - 1, newLineText);

                // Write the updated data back to the file

                updateQuotes();

                break;

            case "delete":

                System.out.print("Enter the line number to delete: ");

                int lineNumber1 = input.nextInt();

                quotes.remove(lineNumber1 - 1);

                updateQuotes();

                break;

            case "random":

                String quote = getRandomQuote();

                String formatQuotes = printQuotes(quote);

                System.out.println(formatQuotes);

                break;

            case "all":

                showAllQuotes();

                break;

            case "search":

                if(args[1].equals("content")){

                    contSearchQuote(args[2]);

                }

                else if(args[1].equals("reference")){

                    refSearchQuote(args[2]);

                }

                else if(args[1].equals("category")){

                    categSearchQuote(args[2]);

                }

                else{

                    System.out.println("Search Command Invalid");

                }




                break;

            case "display":

                String[] input = {args[1], args[2]};

                int delay = extractDelay(input)*1000;//5

                String[] max = {args[1], args[2]};

                int maximum = extractMax(max);

                int count=0;

                while(count<maximum){

                        for(count=1; count<=maximum;count++){

                            String disquote = getRandomQuote();

                            String format1Quotes = printQuotes(disquote);

                            System.out.println("["+count+"/"+maximum+"]" + format1Quotes);

                            Thread.sleep(delay);

                        }

                    }

                    break;




            default:

                System.out.println("Invalid Command");

        }

 

    }

}