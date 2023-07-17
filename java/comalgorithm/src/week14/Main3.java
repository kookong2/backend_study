package week14;

import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0}; // 입력 변수 X
        double[] y = {3.0, 5.0, 7.0, 9.0, 11.0}; // 목표 변수 Y

        double w = 0.0; // 선형 회귀 모델의 기울기
        double b = 0.0; // 선형 회귀 모델의 y절편

        double initialTemperature = 1000.0; // 초기 온도
        double coolingRate = 0.9f; // 냉각율
        int numIterations = 1000; // 반복 횟수

        Random random = new Random();   // 0 ~ 1미만의 랜덤 함수 생성

        double currentError = calculateError(x, y, w, b); // cost 구함
        double bestError = currentError;                    // 현재 cost값이 최적의 값이라고 초기화

        double bestW = w; // 최적의 기울기 초기화
        double bestB = b; // 최적의 y절편 초기화

        long startTime = System.currentTimeMillis(); // 시작 시간 기록

        for (int i = 0; i < numIterations; i++) {
            double newW = w + random.nextDouble() - 0.5; // -0.5 ~ 0.5까지 이웃한 기울기
            double newB = b + random.nextDouble() - 0.5; // -0.5 ~ 0.5까지 이웃한 y절편

            double newError = calculateError(x, y, newW, newB); // 새로운 모델의 오차 계산

            double acceptanceProbability = acceptanceProbability(currentError, newError, initialTemperature); // 수용 확률 계산

            if (acceptanceProbability > random.nextDouble()) { // 새로운 모델을 수용할지 결정
                w = newW; // 기울기 업데이트
                b = newB; // y절편 업데이트
                currentError = newError; // 오차 업데이트
            }

            if (currentError < bestError) { // 현재 모델이 최적의 모델인지 확인
                bestW = w; // 최적의 가중치 업데이트
                bestB = b; // 최적의 절편 업데이트
                bestError = currentError; // 최적의 오차 업데이트
            }

            initialTemperature *= coolingRate; // 온도 점차 감소

            if ((i + 1) % 100 == 0) { // 100번 반복마다 출력
                System.out.println("Best error after " + (i + 1) + " iterations: " + bestError);
            }
        }

        long endTime = System.currentTimeMillis(); // 종료 시간 기록
        long executionTime = endTime - startTime; // 실행 시간 계산

        System.out.println("Best w: " + bestW);
        System.out.println("Best b: " + bestB);
        System.out.println("Best error: " + bestError);
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    // cost 구하는 메서드
    public static double calculateError(double[] x, double[] y, double w, double b) {
        double cost = 0.0;
        int m = x.length;

        for (int i = 0; i < m; i++) {
            double predicted = w * x[i] + b; // 모델의 예측값 계산
            double error = predicted - y[i]; // 예측 오차 계산
            cost += error * error; // 제곱 오차 누적
        }

        return cost / m; // 평균 제곱 오차 반환
    }

    public static double acceptanceProbability(double currentError, double newError, double temperature) {
        if (newError < currentError) {
            return 1.0; // 새로운 오차가 현재 오차보다 작으면 항상 수용
        }
        return Math.exp((currentError - newError) / temperature); // 수용 확률 계산
    }
}
