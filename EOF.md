# EOF(End Of File)

> EOF란 End Of File의 줄임말로, 더 이상 읽을 수 있는 데이터가 없음을 의미한다.

PS를 하다보면 테스트 케이스 개수에 대한 입력을 별도로 받지 않는 경우가 있는데, 이 때 EOF 처리를 별도로 해줘야만 한다.

각 언어별로 EOF를 처리하는 방법에 차이가 있기 때문에 숙지하는 것이 필요하다.

참고로 코딩 테스트에서는 쓸 일이 없다.

EOF 처리의 핵심은 Null에 대한 처리이다.

## 1. Java

Java는 Scanner와 BufferedReader를 활용해서 EOF를 처리할 수 있다.

### 1) Scanner

```java
Scanner sc = new Scanner(System.in);

while (sc.hasNextLine()) {
    sc.nextLine();
}

while (sc.hasNext()) {
    sc.next();
}

while (sc.hasNextInt()) {
    sc.nextInt();
}
```

<br>

### 2) BufferedReader

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String S = "";

// 1. 입력이 파일로 들어온다면 EOF를 정상 처리 가능, 하지만 IDEA에서는 무한 루프를 돌음
while ((S = br.readLine()) != null) {
    ...
}

// 2. 입력의 끝에 Enter를 입력하면 EOF를 정상적으로 처리 가능
while ((S = br.readLine()) != null && !S.isEmpty()) {
    ...
}

// 3. IDE에서는 Enter입력 시 EOF를 정상 처리 가능하지만, 파일이 입력이라면 RuntimeError를 반환함
while (!(S = br.readLine()).equals("")) {
    ...
}
```

<br>

## 2. Python

Python의 경우 EOF를 try-catch구문으로 해결할 수 있다.

### 1) try ~ catch

```python
while True:
    try:
        a = input()

    except EOFError:
        break
```

※ `input = sys.stdin.readline`이 있다면 해당 라인을 제거하고 제출해볼 것.

- 이유는 sys.stdin.readline는 개행(`\n`)을 빈 줄 혹은 빈 문자열로 인식하지 않고 처리하기 때문.  sys.stdin.readline을 사용했을 때, input().rstrip()으로 rstrip()을 통해 개행을 처리해주는 것과 같은 원리.

<br>

## 3. Kotlin

Kotlin의 경우 대부분의 문법이 java와 비슷하지만, EOF 처리에는 차이가 있다.

우선 java에서와 같이 while 문의 조건부 안에 변수에 값을 대입하는 문법을 허용하지 않는다.

### 1) ?:

> 엘비스(elvis) 연산자; 연산자 앞의 값이 null이면 연산자 뒤의 값(구문)을 반환한다.

엘비스(elvis) 연산자로 EOF를 처리할 수 있다.

```kotlin
    while (true) {
        val line: String = br.readLine() ?: break
        val st: StringTokenizer = StringTokenizer(line)
        
    }
```

코틀린에서는 기본적으로 null check를 하지 않는다. 타입 바로 뒤에 `?`를 붙여서 null이 들어올 수 있는 값이라고 명시하지 않는 이상 null이 기본적으로 불가능하다고 보기 때문이다. (단, 이는 null이 아님을 단언하는 것이 아님)

※ 참고로 `val st: StringTokenizer = StringTokenizer(br.readLine()) ?: break`와 같은 구문은 EOF 처리를 정상적으로 할 수 없다. 왜냐하면 br.readLine()이 null인 것이지 st가 null인 것이 아니기 때문이다. 이대로 사용하면 NullPointerException이 발생한다.