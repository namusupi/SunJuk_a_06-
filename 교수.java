package sungjuck;
public class 교수 {

    private String 교수아이디;

    public 교수(String 교수아이디) {
        this.교수아이디 = 교수아이디;
    }

    // 교수 ID 체크
    public boolean 교수체크() {

        if (교수아이디.equals("inha")) {
            return true;
        } else {
            return false;
        }
    }
}