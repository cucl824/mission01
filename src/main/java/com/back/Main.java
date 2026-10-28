package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<WiseSaying> wiseSayings = new ArrayList<>();
    private static int lastId = 0;

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            Rq rq = new Rq(sc.nextLine().trim());

            switch (rq.getActionName()) {
                case "종료" -> {
                    sc.close();
                    return;
                }
                case "등록" -> writeList();
                case "목록" -> showList();
                case "삭제" -> deleteList(rq);
                case "수정" -> modifyList(rq);
                default -> {
                }
            }
        }
    }

    static void writeList() {
        System.out.print("작가: ");
        String author = sc.nextLine().trim();

        System.out.print("명언: ");
        String content = sc.nextLine().trim();

        int id = ++lastId;
        wiseSayings.add(new WiseSaying(id, content, author));

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    static void showList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n",
                    wiseSaying.getId(),
                    wiseSaying.getAuthor(),
                    wiseSaying.getContent());
        }
    }

    static WiseSaying findById(int id) {
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    static void deleteList(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        boolean deleted = wiseSayings.removeIf(
                wiseSaying -> wiseSaying.getId() == id
        );

        if (deleted) {
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }
    }

    static void modifyList(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        WiseSaying foundWiseSaying = findById(id);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n",
                foundWiseSaying.getContent());
        System.out.print("명언 : ");
        foundWiseSaying.setContent(sc.nextLine().trim());

        System.out.printf("작가(기존) : %s\n",
                foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        foundWiseSaying.setAuthor(sc.nextLine().trim());
    }
}