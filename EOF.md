# EOF(End Of File)

> EOF란 End Of File의 줄임말로, 더 이상 읽을 수 있는 데이터가 없음을 의미한다.

## 1. Java EOF(End Of File) 처리하기

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

## 2. Python EOF 처리하기

Python의 경우 EOF를 try-catch구문으로 해결할 수 있다.

### 1) try ~ catch

```python
while True:
    try:
        a = input()

    except EOFError:
        break
```