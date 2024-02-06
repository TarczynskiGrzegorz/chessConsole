package pl.tg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (!scanner.hasNext("quit")){
            String text = scanner.nextLine();
            System.out.println(typeOfMovement(text));
        }


    }

    private static String typeOfMovement(String str){
        String figuresName ="[KQRBP]";
        String columnsName ="[a-h]";
        String rowsName = "[1-8]";


        Map<String,String> typeMoves = new HashMap<>();
        typeMoves.put("movePawn" , columnsName+rowsName);
        typeMoves.put("moveFigure",figuresName+columnsName+rowsName);
        typeMoves.put("moveFigureAmbiguous",figuresName+"[a-h|1-8]"+columnsName+rowsName);
        typeMoves.put("capture",figuresName+":"+columnsName+rowsName);
        typeMoves.put("captureAmbigyous", figuresName+"[a-h|1-8]:"+columnsName+rowsName);
        typeMoves.put("capturePassing",columnsName+":"+columnsName+rowsName);
        typeMoves.put("promotion",columnsName+rowsName+figuresName);
        typeMoves.put("castlingKingside","O-O");
        typeMoves.put("castlingQueenside","O-O-O");

        for(Map.Entry<String,String> entry: typeMoves.entrySet()){
            Pattern pattern = Pattern.compile(entry.getValue());
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches()){
                return entry.getKey();
            }
        }
        return "default";

    }

}
