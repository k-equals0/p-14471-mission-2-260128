package org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        int lastId = 0;                 //객체 id

        Quote[] quotes = new Quote[10]; //객체 저장할 배열 생성
        int lastQuoteIndex = -1;        //객체배열 인덱스

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료"))
                break;

            if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                Quote quote = new Quote();          //등록 시 객체 생성

                quote.id = ++lastId;
                quote.content = content;
                quote.author = author;

                quotes[++lastQuoteIndex] = quote;   //객체배열에 객체 저장
                System.out.println(lastId + "번 명언이 등록되었습니다.");
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n--------------------------");
                for(int i=lastQuoteIndex; i>=0; i--){
                    Quote foundedQuote = quotes[i];     //현재 처리중인 명언임을 드러내기 위함
                    System.out.println(foundedQuote.id + " / " + foundedQuote.author + " / " + foundedQuote.content);
                }
            }
        }
    }
}
