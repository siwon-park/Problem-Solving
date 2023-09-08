## [플2] K번째 수 (7469번)

https://www.acmicpc.net/problem/7469

### 문제 유형

자료 구조, 정렬, 세그먼트 트리, 이분 탐색, 머지 소트 트리, 퍼시스턴트 세그먼트 트리

<br>

### 어려웠던 점 / 문제의 핵심

머지 소트 트리란 자료 구조를 사용하여 문제를 풀 수도 있지만, 퍼시스턴트 세그먼트 트리를 사용하여 2차원의 평면 상에서 세그먼트 트리를 구성하여 풀 수도 있다.

퍼시스턴트 세그먼트 트리를 연습하기 위해 이 방법으로 풀었다.

다음과 같이 2차원의 평면상의 좌표에 대해서 구간 `[i, j]`의 `k`번째 수를 찾는 것이다.

|                 arr = [1, 5, 2, 6, 3, 7, 4]                  |                        Q(2, 6, 2) = 3                        |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/6dfd403a-1828-4fb5-8a67-0398f48512ce) | ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/b37fce42-0c56-4389-917f-abcf2345ef0a) |

`K`번째 수를 찾기 위해서는 결국 `arr[i]`가 몇 번째 수인지 알아야 한다.

arr[i]는 최소 -10억 ~ 최대 10억이기 때문에 반드시 `좌표 압축`을 통해  arr[i]가 몇 번째 숫자인지 압축하는 것이 필요하다. 이를 위해 arr[i]를 복사한 배열을 만들고 정렬하여 좌표 압축을 실시한다.

그 후 퍼시스턴트 세그먼트 트리(PST)를 구축한다.

PST는 `누적 합`의 개념도 있기 때문에 구간 `[i, j]`의 값을 구하기 위해선 `[0, j]`에서 `[0, i - 1]`를 빼주면 된다.

PST의 `root[i]`에서 `i`를 `x좌표`라고 생각하면 된다.

그러면 PST의 의미는 `0 ~ x좌표`까지의 구간의 최댓값 이하로 존재하는 점의 개수이다.

즉, 예를 들어 PST를 업데이트 한다고 할 때 다음과 같다. (일부만 예시로 표현함)

|                           root[0]                            |                      root[0] → root[1]                       |                      root[1] → root[2]                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/37bf9d16-1410-4f9f-af35-97265c247b9c) | ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/e7fd1e69-186b-421a-934c-165fc463d8d5) | ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/f525a452-22a7-44d3-b90d-748707537f19) |

|                      root[2] → root[3]                       |                      root[3] → root[4]                       |                      root[4] → root[5]                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/2b7eecdd-a6a8-4611-b4e2-5d1d1ac9dc60) | ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/a20d4d4e-5c8a-4170-abc6-c840612a3b34) | ![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/7f3466be-3c54-4f1a-b1b5-b3a8726d1a38) |

이후, 이러한 PST에서 K번째 수를 찾는 방법은 세그먼트 트리 상에서 K번째 수를 찾는 과정과 같다.

`root[i + 1].left.cnt - root[i].left.cnt` 차이를 왼쪽의 점의 개수(`diff`)라고 할 때, 왼쪽 점의 수가 `k`이상일 경우에는 왼쪽에서 탐색하고, `k`가 왼쪽 점의 개수보다 크면 오른쪽으로 탐색하고, `k - 왼쪽의 개수`를 해준다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도    | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ------------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |               |            |           |           |                    |
| Java   | 94340 KB | 832 ms        | O(2N + NlogN) | O(NlogN)   | 60분      | 1         | :white_check_mark: |
| Kotlin |          |               |               |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```
