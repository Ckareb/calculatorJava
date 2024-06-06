package helper.methods;

import mathematical.operation.NumberModule;

import java.util.regex.Pattern;

import static helper.methods.Between.*;


public class Parenthesis {
    public static StringBuilder parenthesis(StringBuilder input, StringBuilder  inputUser){

        if (!input.toString().equals(" ")){

            inputUser.replace(Between.start(), Between.end(), input.toString());

        }

        int start = 0, end = 0, count = 0, cnt = 0, modules = 0;
        StringBuilder inp;
        while (!Pattern.matches("-?\\d+(\\.\\d+)?", inputUser.toString())){;
            for (int i = 0; i < inputUser.length(); ++i) {

                if (inputUser.charAt(i) == '(' || inputUser.charAt(i) == ')') count++;

                if (inputUser.charAt(i) == ')' && cnt == 0) {
                    end = i;
                    ++cnt;
                }
            }

            for (int i = 0; i < inputUser.length(); ++i) {
                if (inputUser.charAt(i) == '('  && i < end) start = i;
                if (inputUser.charAt(i) == '|') ++modules;
            }

            if (count == 0) {
                between(inputUser, 0, inputUser.length());
                NumberModule.numberModule(new StringBuilder(" "),inputUser);
            }else if (count % 2 == 0 && modules % 2 == 0){
                inp = new StringBuilder(inputUser.substring(start+1, end));
                between(inputUser, start, end+1);
                inputUser.delete(start,start);
                inputUser.delete(end,end);
                NumberModule.numberModule(new StringBuilder(" "),inp);
            } else {
                inputUser =  new StringBuilder("Ошибка в формуле");
                break;
            }
        } return inputUser;
    }
}
//((2+2)*(2+2))