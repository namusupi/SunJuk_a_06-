package SungJuk;

public class GradeController {
    private GradeModel model = new GradeModel();
    private final String ADMIN_ID = "inha";

    // [시나리오 1] 성적 입력 및 처리
    public String processInputGrade(String profId, String studentId, int java, int db, int security) {
        // 1. 교수ID 체크
        if (!profId.equals(ADMIN_ID)) {
            return "ID 인증 실패: ID가 일치하지 않습니다.";
        }

        // 2. 총점 및 평균 계산
        int total = java + db + security;
        double avg = total / 3.0;

        // 3. 모델(DB)에 저장
        model.saveScore(studentId, java, db, security, avg);

        return "성적 입력 성공 (평균: " + String.format("%.2f", avg) + ")";
    }

    // [시나리오 2] 학점 조회 및 부여
    public String processGetGrade(String profId, String studentId) {
        // 1. 교수ID 체크
        if (!profId.equals(ADMIN_ID)) {
            return "ID 인증 실패: ID가 일치하지 않습니다.";
        }

        // 2. 모델에서 데이터 요청
        Double avg = model.getAverage(studentId);
        if (avg == null) return "해당 학생의 정보가 없습니다.";

        // 3. 학점 부여 로직 (A/B/C 판별)
        String grade;
        if (avg >= 90) grade = "A";
        else if (avg >= 80) grade = "B";
        else grade = "C";

        return studentId + " 학생의 학점 결과: " + grade;
    }
}