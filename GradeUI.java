package SungJuk;

public class GradeUI {
    public static void main(String[] args) {
        GradeController controller = new GradeController();

        System.out.println("--- [성적 입력 시나리오] ---");
        // 성공 케이스
        String res1 = controller.processInputGrade("inha", "s202401", 95, 88, 92);
        System.out.println("UI 출력: " + res1);

        // ID 불일치 케이스
        String res2 = controller.processInputGrade("wrong_id", "s202402", 70, 70, 70);
        System.out.println("UI 출력: " + res2);

        System.out.println("\n--- [학점 조회 시나리오] ---");
        // 학점 판별 (A학점)
        String res3 = controller.processGetGrade("inha", "s202401");
        System.out.println("UI 출력: " + res3);
    }
}