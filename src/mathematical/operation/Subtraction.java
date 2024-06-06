package mathematical.operation;

import helper.methods.Between;
import helper.methods.Parenthesis;

import java.util.regex.Pattern;

public class Subtraction {
    public static void subtraction(StringBuilder input){

        double result;
        int start, end;
        for (int i = 0; i < input.length(); ++i){

            if(input.charAt(input.length()-1) == '-') {
                System.out.println("Ошибка в формуле");
                break;}
            else if ( i != 0 && input.charAt(i) == '-' && Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(i-1)))){
                start = i - 1;
                end = i + 1;

                while (Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(start))) && start > 0) start -= 1;

                if (start > 0 && Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(start - 1)))) start += 1;

                if (input.charAt(end) == '-' && !Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(end-1)))) end += 1;

                while (end < input.length() && Pattern.matches("[0-9.0-9]" ,Character.toString(input.charAt(end)))) end += 1;

                result = Double.parseDouble(input.substring(start, i)) - Double.parseDouble(input.substring(i+1, end));

                input.replace(start, end, Double.toString(result));
            }
        }
        if (Between.flag()) {
            String inp = input.toString();
            double inputInt = Math.abs(Double.parseDouble(inp));
            NumberModule.numberModule(new StringBuilder(Double.toString(inputInt)), Between.betweenModule());
        } else {
            Parenthesis.parenthesis(input,Between.originalInput());
        }
    }
}
