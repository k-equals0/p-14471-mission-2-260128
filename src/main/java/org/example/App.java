package org.example;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);    //인스턴수 변수로 꺼내기 -> 함수들이 공동으로 사용
    int lastId = 0;

    Quote[] quotes = new Quote[10];
    int lastQuoteIndex = -1;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료"))
                break;

            if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
    }

    //App 내부에서만 동작하는 함수들이기 때문에 private으로 설정
    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        write(content, author);     //write 기능 분리
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    private void write(String content, String author) {
        Quote quote = new Quote();

        quote.id = ++lastId;
        quote.content = content;
        quote.author = author;

        quotes[++lastQuoteIndex] = quote;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언\n--------------------------");
        Quote[] foundedQuotes = findList(); //list 기능 분리, 최신순으로 정리된 명언 목록 받아옴

        for (Quote quote : foundedQuotes) {
            System.out.printf("%d / %s / %s\n", quote.id, quote.author, quote.content); //printf
        }
    }

    private Quote[] findList() {
        Quote[] foundedQuotes = new Quote[lastQuoteIndex + 1];
        int foundedQuoteIndex = -1;

        for (int i = lastQuoteIndex; i >= 0; i--) {
            Quote foundedQuote = quotes[i];                     //저장소에서 최신명언부터 꺼냄
            foundedQuotes[++foundedQuoteIndex] = foundedQuote;  //0번 인덱스부터 최신 명언 채움
        }
        return foundedQuotes;   //출력만 하면 되는 상태로 돌려줌
    }
}
