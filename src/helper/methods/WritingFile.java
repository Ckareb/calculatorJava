package helper.methods;

import java.io.*;
import java.util.regex.Pattern;

public class WritingFile {
    public static String writingFile(){
        File file = new File("src\\resources", "fileForWrite.txt");
        StringBuilder s = new StringBuilder(" ");
        String result = "";
        StringBuilder res = new StringBuilder();

        if (Input.input().equalsIgnoreCase("���������")){
            result = Input.input();
        } else if (Pattern.matches("^[a-zA-Z�-��-�]+$", Input.input())) result = "������� ������� �� �����";
        else result = Parenthesis.parenthesis(s, new StringBuilder(Input.input())).toString();


        if (!result.equalsIgnoreCase("������ � �������") && !result.equalsIgnoreCase("���������")
                && !result.equalsIgnoreCase("������� ������� �� �����")){
            try (FileWriter fw = new FileWriter(file, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(Input.input() + " = " + result);
                bw.newLine();
            } catch (IOException e) {
                System.out.println("�������� ������ �� ����� ������, ��������� ������.");
            }
            return result;
        } else if (result.equalsIgnoreCase("���������")) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    res.append(line);
                    res.append("\n");
                }
            } catch (IOException e) {
                System.out.println("�������� ������ �� ����� ������, ��������� ������.");
            }
            return res.toString();
        } else return result;
    }
}
