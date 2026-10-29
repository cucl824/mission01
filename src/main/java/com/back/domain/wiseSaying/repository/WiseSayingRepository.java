package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(String content, String author) {
        WiseSaying wiseSaying =
                new WiseSaying(++lastId, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return new ArrayList<>(wiseSayings);
    }

    public WiseSaying findById(int id) {
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteById(int id) {
        return wiseSayings.removeIf(
                wiseSaying -> wiseSaying.getId() == id
        );
    }

    public boolean update(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return false;
        }

        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        return true;
    }
}