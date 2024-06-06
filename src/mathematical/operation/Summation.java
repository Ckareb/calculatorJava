package mathematical.operation;

import java.util.regex.Pattern;

public class Summation {
    public static void summation(StringBuilder input){
        //StringBuilder input = new Division().division();

        double result;
        int start, end, count = 0;
        for (int i = 0; i < input.length(); ++i){
            if(input.charAt(0) == '+' || input.charAt(input.length()-1) == '+') {
                System.out.println("Ошибка в формуле");
                break;}
            else if (input.charAt(i) == '+'){
                start = i - 1;
                end = i + 1;

                while (Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(start))) && start > 0) start -= 1;

                if (start > 0 && Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(start - 1)))) start += 1;

                if (input.charAt(end) == '-' && !Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(end-1)))) end += 1;

                while (end < input.length() && Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(end)))) end += 1;

                result = Double.parseDouble(input.substring(start, i)) + Double.parseDouble(input.substring(i+1, end));

                input.replace(start, end, Double.toString(result));
                i=0;
            }
        }
        Subtraction.subtraction(input);
    }
}
