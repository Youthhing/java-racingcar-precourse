package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행


        Game game = new Game();
        game.getNameList(); // 자동차 이름 입력받음
        game.getCarList();

        try {
            game.getGameNum();// Game시도할 횟수 입력받음.
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] : 시도 횟수는 숫자여야 한다.");
            game.getGameNum();
        }


        game.MoveNTimes();
        game.printWinner();

    }




}
