package SungJuk;

import java.util.HashMap;
import java.util.Map;

public class GradeModel {
    // 메모리 내에 학생 ID별로 데이터를 저장 (DB 역할)
    private Map<String, int[]> scoreMap = new HashMap<>();
    private Map<String, Double> averageMap = new HashMap<>();

    public void saveScore(String studentId, int java, int db, int security, double avg) {
        scoreMap.put(studentId, new int[]{java, db, security});
        averageMap.put(studentId, avg);
        System.out.println("[DB] " + studentId + " 학생의 성적 정보가 저장되었습니다.");
    }

    public Double getAverage(String studentId) {
        return averageMap.get(studentId);
    }
}