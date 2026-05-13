classDiagram
    %% Boundary 클래스 (요구사항에 명시된 클래스명 사용)
    class Add_Sungjuk_UI {
        <<Boundary>>
    }

    class Search_Sungjuk_UI {
        <<Boundary>>
    }

    %% 교수 엔티티 클래스
    class 교수 {
        - 교수id : String
        + 교수체크(입력교수id: String) boolean
    }

    %% 성적 엔티티 클래스
    class 성적 {
        - 학생id : String
        - 자바 : int
        - DB : int
        - 보안 : int
        - 총점 : int
        - 평균 : double
        - 학점 : String
        
        %% 외부(UI)에서 호출 가능한 Public 행위
        + 성적입력(학생id: String, 자바: int, DB: int, 보안: int) void
        + 학점조회(학생id: String) String
        
        %% 순차도(Sequence Diagram)의 내부 호출을 반영한 Private 행위
        - 총점계산() void
        - 평균계산() void
        - 학점부여() void
        - 출력() void
    }

    %% 관계 설정 (Relationships)
    
    %% UI 경계 클래스가 성적 클래스의 행위를 호출
    Add_Sungjuk_UI ..> 성적 : 성적입력 호출
    Search_Sungjuk_UI ..> 성적 : 학점조회 호출
    
    %% 성적 클래스가 작업 수행 전 교수 클래스를 호출하여 검증
    성적 ..> 교수 : 교수체크 호출