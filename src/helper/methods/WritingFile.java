package helper.methods;

import java.io.*;
import java.util.regex.Pattern;

public class WritingFile {
    public static String writingFile(){
        File file = new File("src\\resources", "fileForWrite.txt");
        StringBuilder s = new StringBuilder(" ");
        String result = "";
        StringBuilder res = new StringBuilder();

        if (Input.input().equalsIgnoreCase("чтовфайле")){
            result = Input.input();
        } else if (Pattern.matches("^[a-zA-Zа-яА-Я]+$", Input.input())) result = "Формула введена не верно";
        else result = Parenthesis.parenthesis(s, new StringBuilder(Input.input())).toString();


        if (!result.equalsIgnoreCase("Ошибка в формуле") && !result.equalsIgnoreCase("чтовфайле")
                && !result.equalsIgnoreCase("Формула введена не верно")){
            try (FileWriter fw = new FileWriter(file, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(Input.input() + " = " + result);
                bw.newLine();
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }
            return result;
        } else if (result.equalsIgnoreCase("чтовфайле")) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    res.append(line);
                    res.append("\n");
                }
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }
            return res.toString();
        } else return result;
    }
}
