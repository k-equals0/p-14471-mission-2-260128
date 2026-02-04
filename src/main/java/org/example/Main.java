package org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        int lastId = 0;             //id와 별개
        Quote quote = new Quote();  //객체 생성

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료"))
                break;

            if(cmd.equals("등록")){
                System.out.print("명언 : ");      //키보드로 받기
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                quote.id = ++lastId;        //전위 연산, 객체에 저장
                quote.content = content;
                quote.author = author;

                System.out.println(lastId + "번 명언이 등록되었습니다.");
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n--------------------------");
                for(int i=lastId; i>0; i--){    //아직 구현 안됨
                    System.out.println(quote.id + " / " + quote.author + " / " + quote.content);
                }
            }
        }
    }
}
