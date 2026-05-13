```mermaid
sequenceDiagram
    autonumber
    actor P as 교수
    participant UI as 성적입력UI
    participant C as 성적관리 컨트롤러
    participant M as 성적 DB (모델)

    Note over P, UI: 시스템 접속 및 서비스 선택

    alt 성적 입력 시나리오
        P->>UI: 성적 입력 요청 (ID, 학생ID, 과목별 점수)
        UI->>C: 입력 데이터 전달
        activate C
        
        Note over C: [체크] 교수ID == 'inha'?
        
        alt ID 인증 성공
            C->>C: 총점 및 평균 계산
            C->>M: 성적 정보 저장
            activate M
            M-->>C: 저장 완료
            deactivate M
            C-->>UI: 입력 완료 메시지
        else ID 인증 실패
            C-->>UI: "ID가 일치하지 않습니다"
        end
        deactivate C
        UI-->>P: 결과 화면 출력

    else 학점 조회 시나리오
        P->>UI: 학점 조회 요청 (ID, 학생ID)
        UI->>C: 조회 데이터 전달
        activate C
        
        Note over C: [체크] 교수ID == 'inha'?
        
        alt ID 인증 성공
            C->>M: 학생 성적 데이터 요청
            activate M
            M-->>C: 성적 데이터 반환 (평균 점수 등)
            deactivate M
            
            Note over C: 학점 부여 로직 (A/B/C 판별)
            C-->>UI: 계산된 학점 결과 전달
        else ID 인증 실패
            C-->>UI: "ID가 일치하지 않습니다"
        end
        deactivate C
        UI-->>P: 학점 정보 표시
    end