package SungJuk;

import java.util.HashMap;
import java.util.Map;

public class 성적처리모델 {
    // 메모리 내에 학생 ID별로 데이터를 저장 (DB 역할)
    private Map<String, int[]> 점수지도 = new HashMap<>();
    private Map<String, Double> 평균지도 = new HashMap<>();

    public void 성적저장(String 학생아이디, int 자바, int 디비, int 보안, double 평균) {
        점수지도.put(학생아이디, new int[]{자바, 디비, 보안});
        평균지도.put(학생아이디, 평균);
        System.out.println("[데이터베이스] " + 학생아이디 + " 학생의 성적 정보가 저장되었습니다.");
    }

    public Double 평균가져오기(String 학생아이디) {
        return 평균지도.get(학생아이디);
    }
}