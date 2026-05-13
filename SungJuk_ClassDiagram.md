```mermaid
classDiagram
    class 성적입력_jsp {
    }

    class 성적관리컨트롤러 {
        +성적입력(교수아이디: String, 학생아이디: String, 자바: int, 데이터베이스: int, 보안: int)
    }

    class 교수 {
        -교수아이디: String
        +교수(교수아이디: String)
        +교수체크() boolean
    }

    class 성적 {
        -학생아이디: String
        -자바: int
        -데이터베이스: int
        -보안: int
        -총점: int
        -평균: double
        -학점: String
        +성적(학생아이디: String, 자바: int, 데이터베이스: int, 보안: int)
        +총점계산()
        +평균계산()
        +학점부여()
        +출력()
    }

    %% 관계 설정
    성적입력_jsp ..> 성적관리컨트롤러 : 호출
    성적관리컨트롤러 ..> 교수 : 생성 및 활용
    성적관리컨트롤러 ..> 성적 : 생성 및 활용