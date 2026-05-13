```mermaid
classDiagram
    class 성적처리모델 {
        -점수지도: Map~String, int[]~
        -평균지도: Map~String, Double~
        +성적저장(학생아이디: String, 자바: int, 디비: int, 보안: int, 평균: double)
        +평균가져오기(학생아이디: String) Double
    }

    class 성적관리컨트롤러 {
        -모델: 성적처리모델
        -관리자아이디: String
        +성적입력처리(교수아이디: String, 학생아이디: String, 자바: int, 디비: int, 보안: int) String
        +학점조회처리(교수아이디: String, 학생아이디: String) String
    }

    class 성적관리화면 {
        +main(args: String[])
    }

    %% 관계 설정
    성적관리컨트롤러 "1" --> "1" 성적처리모델 : 사용
    성적관리화면 ..> 성적관리컨트롤러 : 의존