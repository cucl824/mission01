package com.back;

import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 0;

        WiseSaying[] wiseSayings = new WiseSaying[100];
        int wiseSayingsLastIndex = -1;

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                System.out.print("작가: ");
                String author = sc.nextLine().trim();

                System.out.print("명언: ");
                String content = sc.nextLine().trim();

                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = id;
                wiseSaying.author = author;
                wiseSaying.content = content;

                wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            }else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayingsLastIndex; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayings[i];

                    if (wiseSaying == null) {
                        continue;
                    }

                    System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
                }
            }
        }
        sc.close();
    }
}
