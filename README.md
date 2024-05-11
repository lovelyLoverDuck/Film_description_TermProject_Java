# TermProject_Java

### Description of the movie selection presented by each genre

- 목차
  1. 프로그램 전체 구성
  2. 간략한 구성 설명
  3. 상세 설명
  4. 인터페이스 설명

---

---

### 1. 프로그램 전체 구성


- src
  - buttonListener
    - PosterButtonListener
    * GenreButtonListener
  - project
    - MovieManager

- MovieData
  - action
  - comedy
  - crime
  - hero

---

---

### 2. 간략한 구성 설명

버튼 리스너를 “buttonListener” package를 구성하여 모아 구별함.<br>
각 영화 포스터와 영화 정보를 MovieData 폴더에 구성함.<br>
project 패키지에 MovieManager은 메인이 되는 파일이며 아래와 같은 메소드가 존재함.

```Java
JButton createButton(String text, Color background, Color foreground)
ImageIcon imageSetSize(ImageIcon icon, int i, int j)
void updateMoviePosters(String genre)
Movie[] getMoviesByGenre(String genre)
```

---

---

### 3. 상세 설명

- #### MovieManager()

제목, 크기 및 레이아웃과 함께 주요 프레임을 초기화합니다.<br>
genrePanel은 장르 버튼을 위한 패널이며 movieDescription 텍스트 영역 및 영화 포스터를 표시하는 posterPanel을 생성합니다.<br>
Action, Comedy, Crime, Hero, Exit과 같은 장르 버튼과 종료 버튼을 만들고 해당하는 색상을 설정합니다.<br>
GenreButtonListener를 사용하여 기본 영화 포스터 버튼을 초기화하며 장르 버튼 및 ExitButtonListener를 사용하여 종료 버튼에 대한 작업 리스너를 설정합니다.

- #### createButton Method

영화 장르를 버튼으로 설정하고 버튼의 색상을 한번에 지정하기 위해 사용됩니다.<br>
지정된 텍스트, 배경 색상, 글꼴, 글꼴의 색을 사용자 정의된 JButton을 생성하고 반환합니다.

- #### imageSetSize

처음 시작화면의 “영화 장르별 설명”사진의 크기 조정하기 위해 사용됩니다.<br>
Image.SCALE_SMOOTH를 사용하여 ImageIcon의 크기를 지정된 너비 및 높이로 조절합니다.

- #### updateMoviePosters Method

해당 장르에 속하는 영화 배열을 통하여 포스터를 표시하는 posterPanel을 초기화합니다.<br>
각 영화에 대해서 포스터를 버튼 형태로 만들어 패널에 추가합니다.<br>
각 포스터 버튼에는 클릭 시 영화 설명을 표시하는 PosterButtonListener가 추가됩니다.

- #### getMoviesByGenre Method

입력된 장르에 따라 폴더 경로를 설정합니다.<br>
각 장르에 해당하는 폴더에서 1부터 6까지의 텍스트 파일과 이미지 파일을 가지고 옵니다.<br>
각 영화는 Movie 클래스의 리스트에 추가합니다. <br> 최종적으로 영화 리스트를 배열로 변환하여 반환합니다.

---

---

### 4. 인터페이스 설명

1. 초기화면에 타이틀 사진이 나타납니다.
2. 해당 사진을 클릭하면 상세 이용 설명이 아래에 나타납니다.
3. 버튼으로 구성되어 있는 영화 장르 중 원하는 장르를 선택하여 클릭합니다.
4. 장르를 선택하면 6가지의 영화가 나타납니다.
5. 6가지 영화 중 설명을 보고 싶은 영화를 선택하여 클릭합니다.
6. 해당 영화의 설명이 아래에 나타납니다.
7. 다른 장르의 영화 설명을 보고 싶다면 다른 장르 버튼을 선택하여 클릭합니다.
8. 더 이상 보고 싶은 영화가 없다면 종료버튼을 클릭하여 프로그램을 종료합니다.
