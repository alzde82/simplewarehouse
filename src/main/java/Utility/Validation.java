package Utility;

public class Validation {
    public String validNameForSelectQuery(String name){
        String newName="%"+ name +"%";
        return newName;
    }
    public int negativeNumber(int number){
        return number * (-1);
    }
}
