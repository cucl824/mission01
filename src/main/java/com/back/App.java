package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    public void run() {
        Scanner sc = AppContext.getScanner();

        WiseSayingController wiseSayingController =
                AppContext.getWiseSayingController();

        SystemController systemController =
                AppContext.getSystemController();

        try {
            System.out.println("== 명언 앱 ==");

            while (true) {
                System.out.print("명령) ");

                if (!sc.hasNextLine()) {
                    return;
                }

                Rq rq = new Rq(sc.nextLine().trim());

                switch (rq.getActionName()) {
                    case "종료" -> {
                        systemController.exit();
                        return;
                    }
                    case "등록" -> wiseSayingController.write();
                    case "목록" -> wiseSayingController.list();
                    case "삭제" -> wiseSayingController.delete(rq);
                    case "수정" -> wiseSayingController.modify(rq);
                    default -> {
                    }
                }
            }
        } finally {
            sc.close();
        }
    }
}