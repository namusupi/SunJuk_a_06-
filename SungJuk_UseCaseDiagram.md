```mermaid
flowchart LR
    %% 액터 정의
    P(["👤 교수"])

    %% 시스템 경계
    subgraph 성적관리시스템 ["성적 관리 시스템 (SungJuk_B01)"]
        direction TB
        
        %% 유스케이스 정의
        성적입력(("성적입력"))
        학점조회(("학점조회"))
        교수체크(("교수체크"))
    end

    %% 액터와 유스케이스 간의 관계
    P --- 성적입력
    P --- 학점조회

    %% 포함 관계 (<<include>>) - 성적입력/학점조회 시 반드시 교수체크 수행
    성적입력 -. "<< include >>" .-> 교수체크
    학점조회 -. "<< include >>" .-> 교수체크

    %% 스타일링
    classDef actor fill:#f9f9f9,stroke:#333,stroke-width:2px;
    classDef usecase fill:#e1f5fe,stroke:#01579b,stroke-width:2px;
    class P actor;
    class 성적입력,학점조회,교수체크 usecase;