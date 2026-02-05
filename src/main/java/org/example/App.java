package org.example;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
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
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
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

    private void actionDelete(String cmd) {
        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        boolean rst = delete(id);

        if(!rst){
            System.out.println("d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    private boolean delete(int deleteTarget) {
        int foundIndex = -1;

        for (int i = 0; i <= lastQuoteIndex; i++) {
            Quote foundedQuote = quotes[i];

            if (deleteTarget == foundedQuote.id)
                foundIndex = i;
        }

        if (foundIndex == -1)
            return false;

        for (int i = foundIndex; i < lastQuoteIndex; i++) {
            quotes[i] = quotes[i + 1];
        }
        lastQuoteIndex--;
        return true;
    }
}
