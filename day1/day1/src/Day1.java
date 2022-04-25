import java.util.Stack;

public class Day1 {

    public static void main(String[] args){

    }

    public static String removeDuplicates (String word){
        char[] stack = new char[word.length()];
        int counter = 0;

        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(counter > 0 && stack[i-1]== currentChar){
                counter--;
            }else{
                stack[i] = currentChar;
                counter++;
            }
        }
        return new String(stack, 0, counter);
    }

    public static String removeDuplicates2(String word){
        Stack<Character> words = new Stack<Character>();
        char [] string = new char[word.length()];
        int counter = 0;
        for(int i = 0; i < word.length(); i++){
            if(words.empty()){
               words.push(word.charAt(i));
            }else if(!words.empty() && words.peek() == word.charAt(i)){
                words.pop();

            }else{
                words.push(word.charAt(i));
            }
        }
        int i = 0;
        while(!words.empty()){
            string[i++] = words.pop();
        }
        return new String(string);
    }
}
