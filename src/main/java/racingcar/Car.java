package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    // random 숫자가 4이상이면 move한다 --> randomnum 출력
    public void canImove(){
        int rannum = Randoms.pickNumberInRange(0,9);
        if(rannum>=4) {
            forward();
        }
        PrintCurPosition();
    }

    public void forward(){ // 전진하는 경우 위치 ++;
        this.position++;
    }

    public void PrintCurPosition(){// 현 위치 만큼 -를 출력해주자.
        for(int i=0;i<this.position;i++){
            System.out.print('-');
        }
    }



    public int point(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }




}
