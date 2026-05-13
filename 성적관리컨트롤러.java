package sungjuck;
public class 성적관리컨트롤러 {

    // 성적 입력 처리
    public void 성적입력(String 교수아이디,
                      String 학생아이디,
                      int 자바,
                      int 데이터베이스,
                      int 보안) {

        교수 교수객체 = new 교수(교수아이디);

        // 교수 인증
        if (교수객체.교수체크()) {

            성적 성적객체 =
                    new 성적(학생아이디, 자바, 데이터베이스, 보안);

            System.out.println("성적 입력 완료");
            System.out.println("----------------");
            성적객체.출력();

        } else {

            System.out.println("ID가 일치하지 않습니다.");
        }
    }
}
