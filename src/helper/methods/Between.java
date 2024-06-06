package helper.methods;

public class Between {
    private static StringBuilder originalInput;
    public static int start;
    public static int end;
    private static StringBuilder originalModule;
    public static int startModule;
    public static int endModule;
    public static boolean flag;
    public static void between (StringBuilder original, int one, int two){
        originalInput = original;
        start = one;
        end = two;
    }

    public static void betweenModule (StringBuilder original, int one, int two){
        originalModule = original;
        startModule = one;
        endModule = two;
    }
    public static void getFlag ( boolean b){
        flag = b;
    }


    public static StringBuilder originalInput(){
        return originalInput;
    }
    public static int start(){
        return start;
    }
    public static int end(){
        return end;
    }
    public static boolean flag(){
        return flag;
    }

    public static StringBuilder betweenModule(){
        return originalModule;
    }
    public static int getStartModule(){
        return startModule;
    }
    public static int getEndModule(){
        return endModule;
    }

    /*public static Between func(){
        return new Between(func().between(), func().start(), func().end());
    }*/
}
