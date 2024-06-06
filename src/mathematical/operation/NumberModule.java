package mathematical.operation;

import helper.methods.Between;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static helper.methods.Between.*;
import static helper.methods.Between.getEndModule;

public class NumberModule {
    public static void numberModule(StringBuilder input, StringBuilder  inputUser){

        if (!input.toString().equals(" ")){
            inputUser.replace(getStartModule(), getEndModule(), input.toString());

        }
        String regex = "\\|([-+*/^:%]?[0-9]+(\\.[0-9]+)?([-+*/^:%][0-9]+(\\.[0-9]+)?)*)\\|";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputUser);

        if (matcher.find()){
            betweenModule(inputUser, matcher.start(), matcher.end());
            Between.getFlag(true);
            Degree.degree(new StringBuilder(matcher.group(1)));
        }else if (!matcher.find()) {
            betweenModule(inputUser, 0, input.length());
            Between.getFlag(false);
            Degree.degree(inputUser);
        }
    }
}
//|2+2|
//||2+2|+2|
//(|2+2|*|2+2|)
//(|2+2|)