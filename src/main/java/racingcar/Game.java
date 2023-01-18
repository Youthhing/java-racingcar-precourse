package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {

    private int gameNum;
    private String nameList;

    private ArrayList<Car> carList = new ArrayList<Car>();

    public Game() {
        this.nameList = new String();
        this.carList = new ArrayList<Car>();
        this.gameNum=0;

    }


    public void getNameList(){
        System.out.print("경주할 자동차 이름을 입력하세요. ");
        this.nameList = Console.readLine();
    }

    public void getGameNum(){
        System.out.print("시도할 횟수를 선정하시오 : ");
        String tmp = Console.readLine();
        this.gameNum = Integer.parseInt(tmp);
    }

    public void getCarList(){//Game에 참여할 Carlist를 생성하기.
        //NullPointerException 에러 발생
        try{
            String [] arr = nameList.split(",");
            for(int i=0;i<arr.length;i++){
                if(arr[i].length()>5){
                    throw new IllegalArgumentException();
                }
                Car temp = new Car(arr[i]);
                carList.add(temp);
            }
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] : 사용자의 이름은 5글자 이하여야한다.");
            getNameList();
            getCarList();
        }
    }

    public void MoveOneTime(){

        try{
            int NumOfCar = carList.size();

            for(int i=0;i<NumOfCar;i++){
                System.out.print(carList.get(i).getName()+" : ");
                carList.get(i).canImove();
                System.out.println("");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }


    }

    public void MoveNTimes(){
        try{
            for(int i=0;i<this.gameNum;i++){
                MoveOneTime();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    public ArrayList<String> getWinner(){
        try{
            int mx = 0;
            for(int i=0;i<carList.size();i++){
                if(mx<carList.get(i).point())mx=carList.get(i).point();
            }
            ArrayList<String> winner = new ArrayList<String>();
            for(int i=0;i<carList.size();i++){
                if(mx==carList.get(i).point())winner.add(carList.get(i).getName());
            }
            return winner;
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }

    }

    public void printWinner(){
        try{
            ArrayList<String> winner = new ArrayList<String>();
            winner = getWinner();
            System.out.print("최종우승자 : ");
            for(int i=0;i<winner.size();i++){
                System.out.print(winner.get(i)+" ");
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }


}
