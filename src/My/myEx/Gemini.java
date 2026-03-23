package My.myEx;

public class Gemini {
    public static void main(String[] args) {
        final String GEMINI_KEY = "AIzaSyB5npaLIKLr80yTONtPHC0Z5fRPt3lcxf4";

        if(!GEMINI_KEY.isEmpty()) {
            System.out.println("인증 완료");
        } else {
            System.out.println("키 등록해라");
        }
    } // end of main
} // end of class
