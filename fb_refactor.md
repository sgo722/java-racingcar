# 피드백 이후 수정
1. 패키지 구조 변경
2. InputView 추가
3. Cars 일급 컬렉션 생성
4. Result 인터페이스 생성
5. RandomNumberGenerator 객체 생성
6. OutputView로 출력 기능 분리


# 생각하며 피드백 수정
1. 패키지 설계
    1. 도메인 기반으로 패키지 구조 설계
        - 패키지 구조를 도메인 기반 / 기능 기반으로 설계할 수 있습니다.
          도메인은 기능보다 변경될 가능성이 작습니다. 그래서 도메인 기반으로 하여 패키지 구조를 설계하였습니다.
          기존 작성된 코드에서 domain 하위에 car 와 game이라는 패키지를 구성하였습니다.

2. 객체 이름 변경
    1. InputMessage -> InputView /  OutputMessage -> OutputView
        - 두 객체 모두 화면에 종속된 객체들이기 떄문에 View라는 단어가 더 납득이 될 것 같아 수정했습니다.

3. 일급컬렉션
    1. Cars라는 일급 컬렉션을 생성해서 상태와 행위를 한번에 관리한다.
        1. CarGameManager에만 지나친 책임을 분산시킬 수 있었다.
            - 자동차 생성 기능
            - 자동차 게임 결과 출력 기능
        2. CarGameService 객체를 삭제하였다.
            - 게임 운영과 게임 실행의 명확한 분리가 안됐고, 게임을 실행한다는 새로운 객체보다 일급컬렉션으로 상태와 행위를 관리하는 객체로 해결하는게 더 낫다고 생각했습니다.

4. 클린코드
    1. 메소드 접근자에 따른 위치 분리
        - 가독성 향상을 위해 public 상단 / private 하단에 위치시켰습니다.
    2. if-else 지양하라.
        - 출력문 if-else문 제거 -> if문으로 대체
    3. 매직넘버 제거
        - 랜덤숫자 중 의미있는 숫자는 상수로 치환

5. 인터페이스 적용(OCP / DI)
    1. Result 인터페이스 생성
        - 결과 출력에 대한 요구사항 변경이 일어나도 대응할 수 있습니다.
        - 요구사항에 맞춰 Result의 구현체를 만들면 되기 때문에 확장성을 확보했다고 생각합니다.
        - 결과 객체를 의존성 주입을 받아 OCP를 확보했다고 생각합니다.

6. 객체지향
    1. 단일책임원칙
        2. RandomNumberGenerator 생성
            - Car 객체가 랜덤숫자 생성, 판단까지 담당하고 있었기에 랜덤 숫자를 생성하는 객체르 만들어 분리했습니다.

7. 불변객체
    1. MoveCount를 불변객체로 만들려는 시도 중 MoveCount 객체를 반환하면 Car가 불변을 유지하지 못하는데 어떡해야하나..