package LastExam;

import java.util.Random;

// 모의 담금질 알고리즘
public class Main2 {
    public static void main(String[] args) {
        double[] x = {1.0, 2.0, 3.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 12.0, 13.0, 14.0, 15.0, 16.0, 18.0, 19.0, 21.0, 22.0}; // 입력 변수 X
        double[] y = {62.0, 45.0, 50.0, 60.0, 50.0, 55.0, 60.0, 65.0, 70.0, 75.0, 80.0, 76.0, 68.0, 79.0, 70.0, 89.0, 79.0, 82.0}; // 목표 변수 Y

        double a = 0.0; // 선형 회귀 모델의 기울기 a
        double b = 0.0; // 선형 회귀 모델의 y절편 b

        double T = 1000.0; // 초기 온도
        double coolingRate = 0.999f; // 냉각율 (double 형을 float형으로 형변환 시켜 메모리 낭비를 줄임)
        int iterations = 10000; // 반복 횟수 (반복 횟수를 늘릴 수록 더욱 정확한 값이 나옴)

        Random random = new Random();   // 0 ~ 1미만의 랜덤 함수 생성

        double currentCost = cost(x, y, a, b);         // cost값 을 구하여 현재 cost값에 넣어줌
        double bestCost = currentCost;                    // 현재 cost값이 최적의 값이라고 가정

        double bestA = a;       // 현재의 a값을 최적의 a값이라고 가정
        double bestB = b;       // 현재의 b값을 최적의 b값이라고 가정

        long startTime = System.currentTimeMillis(); // 시작 시간 기록

        for (int i = 0; i < iterations; i++) {
            double newA = a + random.nextDouble() - 0.5; // -0.5 ~ 0.5까지 이웃한 a값 초기화
            double newB = b + random.nextDouble() - 0.5; // -0.5 ~ 0.5까지 이웃한 b값 초기화

            double newCost = cost(x, y, newA, newB);       // 새로운 모델(a, b)의 cost값을 구함

            double acceptanceProbability = acceptanceProbability(currentCost, newCost, T); // 수용 확률 계산

            // 새로운 값(new~)을 현재 값(current~)에 업데이트 하는 과정
            // random은 0이상 1미만의 수
            // 만약 acceptanceProbabilty 메서드에서 1값을 반환 받을 경우 조건에 해당하지 않으므로 업데이트를 하지 않음
            if (acceptanceProbability > random.nextDouble()) { // 새로운 모델을 수용할지 결정
                a = newA;               // a값 업데이트
                b = newB;               // b값 업데이트
                currentCost = newCost;    // 오차 업데이트
            }

            // 현재 값(current)을 최적의 값(best)에 업데이트 하는 과정
            // 현재 모델이 최적의 모델인지 확인
            if (currentCost < bestCost) {
                bestA = a; // 최적의 가중치 업데이트
                bestB = b; // 최적의 절편 업데이트
                bestCost = currentCost; // 최적의 오차 업데이트
            }

            // 온도 점차 감소 (냉각률 0.1)
            T *= coolingRate;

            // 제대로 되고 있는지 디버깅을 위해 100번마다 bestE값 출력
            if ((i + 1) % 100 == 0) {
                System.out.println((i + 1) + " 번째 값의 최적의 Cost : " + bestCost);
            }
        }

        long endTime = System.currentTimeMillis(); // 종료 시간 기록
        long takeTime = endTime - startTime; // 실행 시간 계산

        System.out.println("최적의 a값 : " + bestA);
        System.out.println("최적의 b값 : " + bestB);
        System.out.println("최적의 cost값 : " + bestCost);
        System.out.println("걸린 시간 : " + takeTime + " ms");
    }

    // cost값 구하는 메서드
    public static double cost(double[] x, double[] y, double w, double b) {
        double squaredError = 0.0;
        // 정답 모델의 개수
        int m = x.length;

        // 보고서 식의 시그마 i=1 부터 m까지
        for (int i = 0; i < m; i++) {
            double predicted = w * x[i] + b; // 모델의 예측값 계산  a * x + b
            double error = predicted - y[i]; // 예측 오차 계산    (a * x + b ) - y
            squaredError += error * error; // 제곱 오차 누적      ((a * x + b ) - y)^2
        }

        return squaredError / m;           // 평균 제곱 오차 반환 == cost(a,b)
    }

    // 새로운 모델(a, b)을 수용할 확률 계산
    public static double acceptanceProbability(double currentCost, double newCost, double T) {
        if (newCost < currentCost) {
            return 1.0; // 새로운 cost값이 현재 cost값보다 작으면 더 나은 상황이라고 판단하여 1값을 반환
        }

        // 아닐 경우 수용 확률을 정하여 반환 (처음에는 더 큰 오차를 허용하면서 지역해에 국한하지 않고 전역해에 도달하도록 함
        // T 값이 점점 내려가면서 더 작은 오차를 요구하게 되면서 전역해에 도달)
        return Math.exp((currentCost - newCost) / T);
    }
}
