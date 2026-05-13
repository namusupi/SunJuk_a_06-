classDiagram
    %% Boundary 클래스
    class Add_Sungjuk_UI {
        <<Boundary>>
    }

    class Search_Sungjuk_UI {
        <<Boundary>>
    }

    %% 교수 클래스
    class 교수 {
        - 교수id : String
        + 교수체크(교수id: String) boolean
    }

    %% 성적 클래스
    class 성적 {
        - 학생id : String
        - 자바 : int
        - DB : int
        - 보안 : int
        - 총점 : int
        - 평균 : double
        - 학점 : String
        + 성적입력(교수id: String, 학생id: String, 자바: int, DB: int, 보안: int) boolean
        + 학점조회(교수id: String, 학생id: String) String
    }

    %% 관계 설정 (Relationships)
    
    %% UI 클래스는 기능 수행을 위해 성적 클래스에 의존
    Add_Sungjuk_UI ..> 성적 : 입력 요청
    Search_Sungjuk_UI ..> 성적 : 조회 요청
    
    %% 성적 클래스는 성적입력 및 학점조회 시 교수 인증을 위해 교수 클래스에 의존
    성적 ..> 교수 : 교수체크 호출
