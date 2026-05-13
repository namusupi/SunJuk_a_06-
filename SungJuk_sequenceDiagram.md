```mermaid
sequenceDiagram
    autonumber
    participant JSP as 성적입력.jsp
    participant C as 성적관리컨트롤러
    participant P as 교수
    participant S as 성적

    Note over JSP: 사용자 요청 발생
    JSP->>C: 성적입력("inha", "20250001", 95, 88, 90)
    activate C

    C->>P: new 교수("inha")
    activate P
    P-->>C: 교수 인스턴스
    deactivate P

    C->>P: 교수체크()
    activate P
    P-->>C: true (인증 성공)
    deactivate P

    opt 인증 성공 시 (true)
        C->>S: new 성적("20250001", 95, 88, 90)
        activate S
        
        Note over S: 내부 로직 실행
        S->>S: 총점계산()
        S->>S: 평균계산()
        S->>S: 학점부여()
        
        S-->>C: 성적 인스턴스
        deactivate S

        C->>S: 출력()
        activate S
        Note right of S: 콘솔에 성적 결과 출력
        S-->>C: 
        deactivate S
    end

    C-->>JSP: 처리 완료
    deactivate C