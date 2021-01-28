# 일반적인 LIS/LCS 문제   
## 제한 사항이 10000 이하이면 반복문 두번이면 가능
> 문제 | 가장 긴 증가하는 부분 수열: https://www.acmicpc.net/problem/11053   
   
```c++
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    vector<int> d(n);
    for (int i=0; i<n; i++) {
        d[i] = 1;
        for (int j=0; j<i; j++) {
            if (a[j] < a[i] && d[j]+1 > d[i]) {
                d[i] = d[j]+1;
            }
        }
    }
    
    cout << *max_element(d.begin(),d.end()) << '\n';
    return 0;
}
```
* 10 50 30 40 60 이라 가정
  * i == 1 -> 1 -> 10
  * i == 2 -> 2 -> 10 50
  * i == 3 -> 2 -> 처음부터 다시 돌아서 10 30이 가장 긴 것을 암
  * i == 1 -> 1 -> 처음부터 다시 돌아서 10 30 40 60 이 가장 긴 것을 암
    
## 제한 사항이 10000 초과이면 반복문 한번으로 처리하던가 `(n+a)` 으로 처리해야함 
> 문제 | 꼬인 전깃줄 : https://www.acmicpc.net/problem/1365      
> 시간 | 20분   


```c++
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<int> a;
    for (int i=0; i<n; i++) {
        int num;
        cin >> num; // 하나씩 입력 받음
        auto it = lower_bound(a.begin(), a.end(), num); // a안에 num에 대해 크거나 같은 값이 있냐, 이분탐색   
        if (it == a.end()) { // 아에 없으면
            a.push_back(num); // a 뒤에 넣는다.
        } else {
            // it는 a의 어떤 부분을 가리키는데
            // num과 같거나 큰 값에 들어있다.
            // 그렇기에 num을 넣는것은 최소값으로 갱신하는 것이다.
            *it = num; // 해당 위치에 num 넣는다.
        }
    }
    cout << a.size() << '\n'; // 단 해당 코드는 길이만 구할 수 있다.
    return 0;
}

/* INPUT
 
 8
 1 6 2 5 7 3 5 6
 
 * PROCESS
 
 배열 a의 변화를 보여줍니다.  
 1
 1 6
 1 2
 1 2 5
 1 2 5 7
 1 2 3 7
 1 2 3 5
 1 2 3 5 6 
 
 * OUTPUT
 
 5
 
 */
 
```

# 주의점      
## 배열에 저장된 값은 올바른 형태가 아니다!!      
위 예제는 운이 좋겠도 배열안에 요소가 올바르게 들어가지만,         
다른 테스트케이스를 이용하면 그렇게 나오지 않는다.     
  
즉, **갯수**만 따질 때는 위 같은 방법을 사용하고,        
갯수가 아닌 배열의 저장된 요소들을 하나씩 출력할 때는 코드를 조금 수정해야한다.    
  
