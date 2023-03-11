import java.util.HashMap;
import java.util.Map;

public class Main {
    //키패드 누르기
    public String solution(int[] numbers, String hand) {

        StringBuilder stringBuilder = new StringBuilder();
        String answer ="";
        int lefthand = 10; //*치환
        int righthand = 12; //#치환
        for(int i=0;i < numbers.length;i++) {
            if(numbers[i] ==1 || numbers[i] == 4 || numbers[i] == 7) { //왼손으로 쳐야함
                lefthand = numbers[i];
                stringBuilder.append("L");
            } else if (numbers[i] ==3 || numbers[i] ==6 || numbers[i] ==9) { //오른손으로 쳐야함
                righthand = numbers[i];
                stringBuilder.append("R");
            } else {
                int number = numbers[i] ==0 ?11:numbers[i]; //0일경우 11로 치환
                int leftdistance = Math.abs(number - lefthand)/3 + Math.abs(number - lefthand)%3; //왼쪽과 거리
                int rightdistance = Math.abs(number - righthand)/3 + Math.abs(number - righthand)%3; //오른쪽과 거리
                if(leftdistance > rightdistance) {
                    righthand = number;
                    stringBuilder.append("R");
                }else if (leftdistance < rightdistance) {
                    lefthand = number;
                    stringBuilder.append("L");
                }else{ //왼손과 오른손이 같으면 왼손잡이인지 오른손잡이인지 판단
                    if(hand.equals("left")) {
                        stringBuilder.append("L");
                        lefthand = number;
                    }else {
                        stringBuilder.append("R");
                        righthand = number;
                    }

                }

            }
        }
        answer = stringBuilder.toString();
        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] numbers = {1,2,3,5,8,2,1,4,5,9,5};
        String hand = "right";
        System.out.println(main.solution(numbers,hand));
    }
}