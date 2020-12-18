package regularexpression;

public class REExample {
    public static void main(String[] args) {
        String s1 = "apple, apple and orange please";
        String s2 = s1.replaceAll("ple\\b", "ricot");
        String[] s3 = s1.split("\\b");
        for(String s : s3){
            if(s.matches("\\w+")){
                System.out.println(s);
            }
        }
    }
}
