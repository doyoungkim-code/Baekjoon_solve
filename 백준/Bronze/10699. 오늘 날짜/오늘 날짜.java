import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
       Date now = new Date();
       
       //System.out.println(now);
       
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       
       String formatnow = format.format(now);
       
       System.out.println(formatnow);
    }
}