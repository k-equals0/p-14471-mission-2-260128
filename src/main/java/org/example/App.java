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
        int deleteTarget = 1;   //삭제하려는 명언의 id
        int foundIndex = -1;    //삭제하려는 명언의 배열에서의 위치(인덱스)

        for (int i = 0; i <= lastQuoteIndex; i++) { //객체배열 돌면서 타겟 위치 찾음
            Quote foundedQuote = quotes[i];

            if (deleteTarget == foundedQuote.id)    //타겟의 id와 일치하는 명언객체 찾으면
                foundIndex = i;
        }

        if (foundIndex == -1)   //삭제할 명언 찾지 못한 경우(유효 인덱스X) 종료
            return;

        for (int i = foundIndex; i < lastQuoteIndex; i++) {
            quotes[i] = quotes[i + 1];
        }
        lastQuoteIndex--;
    }
}
