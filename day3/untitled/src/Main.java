public class Main {
    public static void main(String[] args){
        System.out.println(pal("racecar"));
    }

    public static boolean pal(String string){
        int i =0;
        int j = string.length()-1;
        while(i< j){
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
