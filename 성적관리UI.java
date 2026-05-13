package SungJuk;

public class 성적관리화면 {
    public static void main(String[] args) {
        성적관리컨트롤러 컨트롤러 = new 성적관리컨트롤러();

        System.out.println("--- [성적 입력 시나리오] ---");
        // 성공 케이스
        String 결과1 = 컨트롤러.성적입력처리("inha", "s202401", 95, 88, 92);
        System.out.println("화면 출력: " + 결과1);

        // 아이디 불일치 케이스
        String 결과2 = 컨트롤러.성적입력처리("wrong_id", "s202402", 70, 70, 70);
        System.out.println("화면 출력: " + 결과2);

        System.out.println("\n--- [학점 조회 시나리오] ---");
        // 학점 판별 조회
        String 결과3 = 컨트롤러.학점조회처리("inha", "s202401");
        System.out.println("화면 출력: " + 결과3);
    }
}