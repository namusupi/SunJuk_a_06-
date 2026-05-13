package sungjuck;
public class 성적 {

    private String 학생아이디;
    private int 자바;
    private int 데이터베이스;
    private int 보안;
    private int 총점;
    private double 평균;
    private String 학점;

    // 생성자
    public 성적(String 학생아이디, int 자바, int 데이터베이스, int 보안) {
        this.학생아이디 = 학생아이디;
        this.자바 = 자바;
        this.데이터베이스 = 데이터베이스;
        this.보안 = 보안;

        총점계산();
        평균계산();
        학점부여();
    }

    // 총점 계산
    public void 총점계산() {
        총점 = 자바 + 데이터베이스 + 보안;
    }

    // 평균 계산
    public void 평균계산() {
        평균 = 총점 / 3.0;
    }

    // 학점 부여
    public void 학점부여() {

        if (평균 >= 90) {
            학점 = "A";
        } else if (평균 >= 80) {
            학점 = "B";
        } else {
            학점 = "C";
        }
    }

    // 결과 출력용 메소드
    public void 출력() {

        System.out.println("학생 ID : " + 학생아이디);
        System.out.println("자바 점수 : " + 자바);
        System.out.println("DB 점수 : " + 데이터베이스);
        System.out.println("보안 점수 : " + 보안);
        System.out.println("총점 : " + 총점);
        System.out.println("평균 : " + 평균);
        System.out.println("학점 : " + 학점);
    }
}