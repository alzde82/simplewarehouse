package Utility;

public class Validation {
    public String validNameForSelectQuery(String name){
        String newName="%"+ name +"%";
        return newName;
    }
}
