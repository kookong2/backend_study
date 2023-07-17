package week14;

public class Main {
    public static void main(String[] args) {
        double[] x = {1.0, 2.0, 3.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 12.0, 13.0, 14.0, 15.0, 16.0, 18.0, 19.0, 21.0, 22.0}; // 입력 변수 X
        double[] y = {62.0, 45.0, 50.0, 60.0, 50.0, 55.0, 60.0, 65.0, 70.0, 75.0, 80.0, 76.0, 68.0, 79.0, 70.0, 89.0, 79.0, 82.0}; // 목표 변수 Y

        double learningRate = 0.001; // 학습률
        int iterations = 10000; // 반복 횟수 (반복 횟수를 늘릭 수록 더욱 정확한 값이 나옴)

        double a = 0.0; // 선형 회귀 모델의 a 초기화
        double b = 0.0; // 선형 회귀 모델의 b 초기화

        // 시작 시간 기록
        long startTime = System.currentTimeMillis();

        // 경사 하강법 시작
        for (int i = 0; i < iterations; i++) {
            double gradientA = 0.0;             // a에 대해 미분한 값 초기화
            double gradientB = 0.0;             // b에 대해 미분한 값 초기화
            int m = x.length;                   // 정답 모델의 개수

            // a와 b에 대해 미분한 값 구하기 시작
            for (int j = 0; j < m; j++) {
                double predicted = a * x[j] + b; // 모델의 예측값 계산
                double error = predicted - y[j]; // 예측 오차 계산

                // 기울기 계산
                gradientA += (2.0 / m) * x[j] * error;
                gradientB += (2.0 / m) * error;
            }

            // 기울기가 0이 되는 지점까지 a와 b값을 변경해주는 식
            // 학습률이 너무 높은 경우 발산할 위험이 있으므로 조절해줘야 한다.
            a -= learningRate * gradientA;
            b -= learningRate * gradientB;

            // 제대로 되고 있는지 디버깅을 위해 100번마다 bestE값 출력
            if ((i + 1) % 100 == 0) {
                double currentCost = cost(x, y, a, b);
                System.out.println((i + 1) + " 번째 값의 최적의 Cost : " + currentCost);
            }

        }

        double bestCost = cost(x, y, a, b);     // 최적의 cost값 업데이트

        long endTime = System.currentTimeMillis();  // 종료 시간 기록
        long takeTime = endTime - startTime;        // 실행 시간 계산

        System.out.println("최적의 a값 : " + a);
        System.out.println("최적의 b값 : " + b);
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
}
