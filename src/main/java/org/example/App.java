package org.example;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);    //인스턴수 변수로 꺼내기 -> 함수들이 공동으로 사용
    int lastId = 0;

    Quote[] quotes = new Quote[10];
    int lastQuoteIndex = -1;

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료"))
                break;

            if(cmd.equals("등록")){       //등록 기능 분리
                actionWrite();            //command + 함수명 누르면 해당 함수로 이동
            }
            else if(cmd.equals("목록")){  //목록 기능 분리
                actionList();
            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        Quote quote = new Quote();

        quote.id = ++lastId;
        quote.content = content;
        quote.author = author;

        quotes[++lastQuoteIndex] = quote;
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언\n--------------------------");
        for (int i = lastQuoteIndex; i >= 0; i--) {
            Quote foundedQuote = quotes[i];
            System.out.println(foundedQuote.id + " / " + foundedQuote.author + " / " + foundedQuote.content);
        }
    }
}
