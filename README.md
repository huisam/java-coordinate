# java-coordinate
좌표계산기 미션을 진행하기 위한 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 좌표 계산기

### 입력

- 좌표 입력
  - 좌표정보는 괄호(",")로 둘러쌓여 있으며 쉼표(,)로 x,y값을 구분한다.
    - 예시 : `(10,10)`
  - 좌표 값을 두개이상 입력한 경우 좌표값과 좌표값 사이는'-'문자로 구분한다.
    - 예시 : `(10,10)-(24,22)`
  - 입력 범위를 초과시 에러문구 출력 후 다시 입력받는다.

### 기능

- 좌표(Coordinate)
  - 좌표 정보는 (1,1) ~ (24,24) 까지만 허용한다.
  - 다른 좌표와의 거리를 구한다.
  - 다른 좌표와의 기울기를 구한다.
  
- 좌표들(Coordinates)
  - 중복되는 좌표가 없도록 설정한다.

- 직선(Line)
  - 직선인 경우는 두점 사이 거리를 계산한다.
  - 정상적인 좌표값을 입력한 경우, 해당좌표에 특수문자를 표시한다.
  
- 삼각형(Triangle)
  - 기울기를 이용해서 삼각형인지 판단한다.
  - 넓이를 구한다.

- 사각형(Rectangle)
  - 피타고라스 정리를 이용해서 직사각형인지 판단한다.
  - 넓이를 구한다.
  
- 팩토리(ShapeMaker)
  - 좌표 개수에 따라서 도형을 생성해 준다.

### 출력

- 좌표 출력
  - 모든 좌표를 나타낸다
  - 직선일 때 거리를 출력한다.
  - Figure일 때 넓이를 출력한다.