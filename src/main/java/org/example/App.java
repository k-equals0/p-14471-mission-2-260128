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
            } else if (cmd.equals("삭제?id=1")) {
                actionDelete();
            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        write(content, author);
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
        Quote[] foundedQuotes = findList();

        for (Quote quote : foundedQuotes) {
            System.out.printf("%d / %s / %s\n", quote.id, quote.author, quote.content);
        }
    }

    private Quote[] findList() {
        Quote[] foundedQuotes = new Quote[lastQuoteIndex + 1];
        int foundedQuoteIndex = -1;

        for (int i = lastQuoteIndex; i >= 0; i--) {
            Quote foundedQuote = quotes[i];
            foundedQuotes[++foundedQuoteIndex] = foundedQuote;
        }
        return foundedQuotes;
    }

    private void actionDelete() {
        delete();
        System.out.println("1번 명언이 삭제되었습니다.");
    }

    private void delete() {
        int deleteTarget = 0;   //1번 명언은 객체배열[0]에 들어있음

        for (int i = deleteTarget; i < lastQuoteIndex; i++) {
            quotes[i] = quotes[i + 1];    //타깃~마지막으로 입력된 명언까지 1칸씩 당기기
        }
        lastQuoteIndex--;               //다음 등록을 위해
    }
}
