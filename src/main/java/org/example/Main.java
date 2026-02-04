package org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        int id = 1;

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료"))
                break;

            if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String quote = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                System.out.println(id + "번 명언이 등록되었습니다.");
                id++;
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n--------------------------");
                for(int i=id-1; i>0; i--){
                    System.out.println(id + " / " + author + " / " + quote);    //명언, 작가 저장 필요
                }
            }
        }
    }
}
