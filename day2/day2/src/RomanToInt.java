import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args){
        System.out.println(convertToInt("LVIII"));
        String names = "LVIII";
        System.out.println(convertToString(58));
    }

    public static int convertToInt (String romanNumeral){
        Map<Character, Integer> lookupMap = new HashMap<>();
        lookupMap.put('I', 1);
        lookupMap.put('V', 5);
        lookupMap.put('X', 10);
        lookupMap.put('L',50);
        lookupMap.put('C', 100);
        lookupMap.put('D', 500);
        lookupMap.put('M',1000);

        int total = 0;
        for(int i= 0; i < romanNumeral.length(); i++){
            if(total > 0 && lookupMap.get(romanNumeral.charAt(i)) > lookupMap.get(romanNumeral.charAt(i-1))){
//                total -= lookupMap.get(romanNumeral.charAt(i-1));
                total+= lookupMap.get(romanNumeral.charAt(i)) - 2 * (lookupMap.get(romanNumeral.charAt(i-1)));
//                total -= lookupMap.get(romanNumeral.charAt(i-1));
            }else {
                total += lookupMap.get(romanNumeral.charAt(i));
            }

        }


        return total ;
    }

    public static String convertToString(int num){
        String [] thousands = new String[]{"", "M", "MM", "MMM"};
        String [] hundreds = new String[]{"", "C","CC", "CCC", "CD", "D","DC", "DCC", "DCCC", "CM"};
        String [] tens = new String[]{"", "X","XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] units = new String[]{"", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[((num%1000)%100)/10] + units[(((num % 1000)%100)%10)];
    }
}
