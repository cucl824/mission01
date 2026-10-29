package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class App {

    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            WiseSayingRepository repository = new WiseSayingRepository();
            WiseSayingService service = new WiseSayingService(repository);

            WiseSayingController wiseSayingController =
                    new WiseSayingController(sc, service);

            SystemController systemController = new SystemController();

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
        }
    }
}