package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {

    private static final Scanner sc = new Scanner(System.in);

    private static final WiseSayingRepository wiseSayingRepository =
            new WiseSayingRepository();

    private static final WiseSayingService wiseSayingService =
            new WiseSayingService(wiseSayingRepository);

    private static final WiseSayingController wiseSayingController =
            new WiseSayingController(sc, wiseSayingService);

    private static final SystemController systemController =
            new SystemController();

    public static Scanner getScanner() {
        return sc;
    }

    public static WiseSayingRepository getWiseSayingRepository() {
        return wiseSayingRepository;
    }

    public static WiseSayingService getWiseSayingService() {
        return wiseSayingService;
    }

    public static WiseSayingController getWiseSayingController() {
        return wiseSayingController;
    }

    public static SystemController getSystemController() {
        return systemController;
    }
}