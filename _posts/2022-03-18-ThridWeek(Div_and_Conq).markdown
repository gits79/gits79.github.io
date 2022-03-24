# 분할 정복 알고리즘

**분할 정복**이란? \
\
주어진 문제의 입력에 대하여 동일한 알고리즘을 적용하여 해를 계산하며, 이들의 해를 취합하여 원래 문제의 해를 얻는다.   


## 분할 정복 알고리즘의 분류

- 합병정렬
- 퀵 정렬
- 선택 문제
- 최근접 점의 쌍 찾기   

    
1. 합병정렬 \
![imgae](http://dudri63.github.io/image/algo5-1.png)

알고리즘
```
MergeSort(A,p,q)
입력: A[p]~A[q]
출력: 정렬된 A[p]~A[q]
if(p < q>){
    k = [(p+q)/2]
    MergeSort(A,p,k)
    MergeSort(A,k+1,q)
    A[p]~A[q]와 A[k+1]~A[q]를 합병한다
}
```

합병정렬의 시간 복잡도 **O(nlog n)**   


2. 퀵 정렬 \
![imgae](https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort-concepts.png)

알고리즘
```
QuickSort(A,left,right)
입력: 배열 A[left]~A[right]
출력: 정렬된 배열 A[left]~A[right]
if(left < right){
    피봇을 A[left]~A[right]중에서 선택하고 피봇을 A[left]와 자리를 바꾼 후 피봇과 배열의 각 원소를 비교하여 작은 숫자들은 A[left]~A[p-1]로 옮기고 피봇보다 큰 숫자들은 A[p+1]~A[right]로 옮기며 피못은 A[p]에 놓는다
    QuickSort(A,left,p-1)
    QuickSOrt(A,p+1,right)
}
```

퀵 정렬의 시간 복잡도:  **O(nlog_2 n)** 

3. 선택문제\
![imgae](http://dudri63.github.io/image/algo7-1.png)

알고리즘
```
Selection(A,left,right,k)
입력: A[left]~A[right]와 k
출력: A[left]~A[right]에서 k번째 작은 원소
피봇을 A[left]~A[right]에서 랜덤하게 선택하고, 피봇과 A[left]의 자리를 바꾼 후 피봇과 배열의 각 원소를 비교하여 피봇보다 작은 숫자는 A[left]~A[p-1]로 옮기고 피봇보다 큰 숫자는 A[p+1]~A[right]로 옮기며 피못은 A[p]에 놓는다
S = (p-1)-left+1
if(k<= S) Selection(A,left,p-1,k)
eles if(k=S+1) return A[p]
eles Selection(A,p+1 right,k-S-1)
```

선택 문제의 시간 복잡도: **O(n)**   

4. 최근접 점의 쌍 찾기\
![imgae](https://t1.daumcdn.net/cfile/tistory/999DA7435ABF302109)

알고리즘
```
입력: x-좌표의 오름차순으로 정렬된 배열 S에는 i개의 점이 주어진다
출력: S에 있는 점들 중 최근접 점의 쌍의 거리
if(i<=3) return
정렬된 S를 같은 크기의 SL과 SR로 분할한다
CpL = ClosetPair(SL)
CpR = ClosetPair(SR)
d = min{dist(CpL),dist(CpR)}
return (CpL,CpC,CpR 중에서 거리가 가장 짧은 쌍)
```

최근접 점의 쌍 찾기 시간 복잡도: **O(nlog^2 n)**