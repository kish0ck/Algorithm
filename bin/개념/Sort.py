'''
 파이썬으로 정렬 알고리즘 구현하기
 http://ejklike.github.io/2017/03/04/sorting-algorithms-with-python.html
 
 순차탐색 O(n)
 이진탐색 O(logn) : 데이터가 순서에 맞게 정렬이 되어있어야함

 Name  Best    Worst     Stable  Memory
 버블    n      n^2        T       1
 선택    n^2    n^2        F       1
 삽입    n      n^2        T       1
 셀    nlogn   nlog^2n     F       1
 병합  nlogn   nlogn       T       n
 퀵    nlogn   nlogn~n^2   F    logn~n

'''

'''
 버블정렬(Bubble Sort)
 : 이웃한 두 값을 비교하여 정렬
   큰 값이 오른쪽으로 이동하는 과정이 반복되면서 비교했던 모든 값들의 최댓값이 맨 오른쪽으로 옮겨지게 된다.
'''

# def swap(x, i, j):
#     x[i], x[j] = x[j], x[i]

# def bubble_sort(x):
#     for size in reversed(range(len(x))):
#         for i in range(size):
#             if x[i] > x[i+1]:
#                 swap(x, i, i+1)

# x = [9,7,1,3,4,8,2,6,5]
# bubble_sort(x)
# print(x)

# print("len(x) : {0}".format(len(x)))
# len(x) : 9
# print("range(len(x)) : {0}".format(range(len(x))))
# range(len(x)) : range(0, 9)
# print("reversed(range(len(x))) : {0}".format(list(reversed(range(len(x))))))
# reversed(range(len(x))) : [8, 7, 6, 5, 4, 3, 2, 1, 0]

'''
선택정렬(Selection Sort)
: 주어진 배열에서 최댓값(최솟값)을 찾아 맨 오른쪽(왼쪽)값과 교체한다. 
  최댓값을 맨 오른쪽으로 보낸다는 점에서 버블정렬과 비슷하지만, 
  이웃한 두 값을 정렬하는 과정이 없기 때문에 대체로 버블정렬보다 빠르다. 
  최댓값을 찾아야 하므로 정렬 상태에 관계없이 언제나 O(n2)이다.
'''
# def swap(x, i, j):
#     x[i], x[j] = x[j], x[i]

# def selection_sort(x):
#     for size in reversed(range(len(x))):
#         max_i = 0
#         for i in range(1, 1+size):
#             if x[i] > x[max_i]:
#                 max_i = i
#         swap(x, max_i, size)

# x = [9,7,1,3,4,8,2,6,5]
# selection_sort(x)
# print(x)

'''
삽입정렬(Insertion Sort)
: 아직 정렬되지 않은 값을 이미 정렬된 배열 사이에 끼워 넣는 과정을 반복한다. 
  여전히 O(n2)이지만 평균적으로 삽입정렬이 선택정렬과 버블정렬에 비해 빠르다.
  버블정렬과 마찬가지로 데이터가 이미 정렬되어 있다면 O(n)이다. 
  그러나, 데이터가 역순으로 정렬된 상태라면 
  삽입을 위해 값을 하나씩 뒤로 밀어내는 과정을 아주 많이 반복해야 하므로 느리다
'''

# def insertion_sort(x):
#     for size in range(1, len(x)):
#         val = x[size]
#         i = size
#         while i > 0 and x[i-1] > val:
#             x[i] = x[i-1]
#             i -= 1
#         x[i] = val

# x = [9,7,1,3,4,8,2,6,5]
# insertion_sort(x)
# print(x)

'''
셀정렬(Shell Sort)
: 삽입 정렬이 거의 정렬된 배열에서 최적의 성능을 냄과 동시에 값 하나씩 위치를 결정하여 비효율적이라는 점에서 착안되었다. 
  셸 정렬은 주어진 간격만큼 듬성듬성 떨어진 서브배열을 만들어 삽입정렬을 수행한다. 
  간격이 3이라면 3개의 서브배열이 만들어진다. 
  모든 서브배열에 대해 삽입정렬을 마쳤다면, 간격을 (보통 절반으로) 줄여 반복한다. 
  간격이 1이 되면 거의 정렬이 된 상태이므로 빠르게 정렬할 수 있다.
  간격 정의에 따라 성능이 제각각이라 시간복잡도 분석이 쉽지 않다. 
  배열이 이미 정렬되어 있다면 O(nlogn)이고 최악의 경우 아래 구현처럼 간격을 절반씩 줄인다면 O(n2)이다.
  다른 간격 정의를 사용한다 하더라도 현재까지 알려진 바로는 O(nlog2n)이 최선이다.
'''
# def gap_insertion_sort(x, start, gap):
#     for target in range(start+gap, len(x), gap):
#         val = x[target]
#         i = target
#         while i > start:
#             if x[i-gap] > val:
#                 x[i] = x[i-gap]
#             else:
#                 break
#             i -= gap
#         x[i] = val

# def shell_sort(x):
#     gap = len(x) // 2
#     while gap > 0:
#         for start in range(gap):
#             gap_insertion_sort(x, start, gap)
#         gap = gap // 2


# x = [9,7,1,3,4,8,2,6,5]
# shell_sort(x)
# print(x)

'''
병합정렬(Merge Sort)
: 폰 노이만이 개발했으며, 두 부분으로 쪼개는 작업을 재귀적으로 반복한 뒤,
  쪼갠 순서의 반대로 작은 값부터 병합해나가는 분할 정복 알고리즘의 일종이다.
  두 부분으로 쪼개는 데 O(logn) (이진탐색 참고)이고, 데이터 병합이 O(n)이므로,
  정렬 상태와 무관하게 언제나 O(nlogn)이다. 
  데이터 크기만한 메모리가 더 필요한 게 단점이다.
'''
# def merge_sort(x):
#     if len(x) > 1:
#         mid = len(x)//2
#         lx, rx = x[:mid], x[mid:]
#         merge_sort(lx)
#         merge_sort(rx)

#         li, ri, i = 0, 0, 0
#         while li < len(lx) and ri < len(rx):
#             if lx[li] < rx[ri]:
#                 x[i] = lx[li]
#                 li += 1
#             else:
#                 x[i] = rx[ri]
#                 ri += 1
#             i += 1
#         x[i:] = lx[li:] if li != len(lx) else rx[ri:]

# x = [9,7,1,3,4,8,2,6,5]
# merge_sort(x)
# print(x)

'''
퀵 정렬(Quick Sort)
: 피벗(pivot, 기준값) 원소를 정하여 피벗보다 작은 값은 피벗 앞 쪽에, 피벗보다 큰 값은 피벗 뒤 쪽에 오도록 한다. 피벗 양 쪽 배열에 대해 같은 작업을 반복해나간다. 분할 정복 방법의 일종이며, 재귀 호출이 진행될 때마다 최소한 하나의 원소(피벗)는 최종적으로 위치가 정해진다. 병합정렬은 데이터를 쪼갠 뒤 합치는 과정에서 정렬하지만, 퀵정렬은 데이터를 쪼개면서 정렬한다.
  데이터를 절반씩 쪼갠다면 O(logn)이고 n개의 값을 피봇과 비교하므로 O(nlogn)이다. 피봇 선정 기준에 따라 쪼개는 위치가 한 쪽에 치우쳐 있을 수도 있다 (예: 데이터가 이미 정렬되어 있고, 맨 끝 원소를 피봇으로 선정하는 경우). 이 때는 쪼개는 비용이 O(n)이므로 퀵정렬의 시간복잡도가 O(n2)까지 증가한다. 재귀 호출을 위한 스택을 사용하므로 추가 메모리가 필요하다.
  퀵정렬은 병합정렬과 달리 데이터를 복제할 필요가 없는 in-place 알고리즘이다. 하지만, 퀵정렬의 파이썬 구현을 인터넷에 검색해보면 데이터를 복제하여 O(n)의 추가 메모리를 사용하는 방식으로 구현한 코드가 많다. 이렇게 구현하면 추가 메모리를 사용하긴 하지만 실행속도가 빨라지며 stable한 퀵정렬이 된다. stable의 의미를 모른다면 아래 나무위키 글을 참고하자.

  파이썬은 퀵정렬을 하지 않는다. 그 이유는 파이썬은 stable한 정렬을 하는데, 퀵정렬은 stable하지 않기 때문이다. 예를 들어 한글의 키값이 2, 숫자의 키값이 1이라 두면 1, ㄱ , ㄷ, ㄹ, 2를 퀵정렬해서 2, 1, ㄹ, ㄱ, ㄷ 같은 게 나올 수도 있다. O(n)의 추가 메모리를 이용하면 stable한 퀵정렬을 만들 수 있다.
'''
# def swap(x, i, j):
#     x[i], x[j] = x[j], x[i]

# def pivot_first(x, lmark, rmark):
#     pivot_val = x[lmark]
#     pivot_idx = lmark
#     while lmark <= rmark:
#         while lmark <= rmark and x[lmark] <= pivot_val:
#             lmark += 1
#         while lmark <= rmark and x[rmark] >= pivot_val:
#             rmark -= 1
#         if lmark <= rmark:
#             swap(x, lmark, rmark)
#             lmark += 1
#             rmark -= 1
#     swap(x, pivot_idx, rmark)
#     return rmark

# def quick_sort(x, pivotMethod=pivot_first):
#     def _qsort(x, first, last):
#         if first < last:
#             splitpoint = pivotMethod(x, first, last)
#             _qsort(x, first, splitpoint-1)
#             _qsort(x, splitpoint+1, last)
#     _qsort(x, 0, len(x)-1)


# x = [9,7,1,3,4,8,2,6,5]
# quick_sort(x)
# print(x)