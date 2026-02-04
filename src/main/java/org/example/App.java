package org.example;

import java.util.Scanner;

public class App {
    public void run(){

        Scanner sc = new Scanner(System.in);
        int lastId = 0;

        Quote[] quotes = new Quote[10];
        int lastQuoteIndex = -1;

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

                Quote quote = new Quote();

                quote.id = ++lastId;
                quote.content = content;
                quote.author = author;

                quotes[++lastQuoteIndex] = quote;
                System.out.println(lastId + "번 명언이 등록되었습니다.");
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n--------------------------");
                for(int i=lastQuoteIndex; i>=0; i--){
                    Quote foundedQuote = quotes[i];
                            System.out.println(foundedQuote.id + " / " + foundedQuote.author + " / " + foundedQuote.content);
                }
            }
        }
    }
}
