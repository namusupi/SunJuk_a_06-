package SungJuk;

public class 성적관리컨트롤러 {
    private 성적처리모델 모델 = new 성적처리모델();
    private final String 관리자아이디 = "inha";

    // [시나리오 1] 성적 입력 및 처리
    public String 성적입력처리(String 교수아이디, String 학생아이디, int 자바, int 디비, int 보안) {
        // 1. 교수아이디 체크
        if (!교수아이디.equals(관리자아이디)) {
            return "ID 인증 실패: 아이디가 일치하지 않습니다.";
        }

        // 2. 총점 및 평균 계산
        int 총점 = 자바 + 디비 + 보안;
        double 평균 = 총점 / 3.0;

        // 3. 모델(DB)에 저장
        모델.성적저장(학생아이디, 자바, 디비, 보안, 평균);

        return "성적 입력 성공 (평균: " + String.format("%.2f", 평균) + ")";
    }

    // [시나리오 2] 학점 조회 및 부여
    public String 학점조회처리(String 교수아이디, String 학생아이디) {
        // 1. 교수아이디 체크
        if (!교수아이디.equals(관리자아이디)) {
            return "ID 인증 실패: 아이디가 일치하지 않습니다.";
        }

        // 2. 모델에서 데이터 요청
        Double 평균 = 모델.평균가져오기(학생아이디);
        if (평균 == null) return "해당 학생의 정보가 없습니다.";

        // 3. 학점 부여 로직 (A/B/C 판별)
        String 학점;
        if (평균 >= 90) 학점 = "A";
        else if (평균 >= 80) 학점 = "B";
        else 학점 = "C";

        return 학생아이디 + " 학생의 학점 결과: " + 학점;
    }
}