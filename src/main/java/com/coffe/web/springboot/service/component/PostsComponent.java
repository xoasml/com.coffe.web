package com.coffe.web.springboot.service.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostsComponent {
    public void getPostsPages(long cnt, List<Long> pages) {
        long page = cnt / 10;
        if (cnt % 10 != 0) {
            page++;
        }

        for (long i = 1; i <= page; i++) {
            pages.add(i);
        }
    }

    public void getBeAf(long pickPage, long cnt, Map<String, Long> beAf) {
        // 총 몇 페이지 인지 찾는다.
        long page = cnt / 10;
        if (cnt % 10 != 0) {
            page++;
        }
        // 페이지 당 10개씩 짤라서 리스트에 담는다.
        //page : 3 / cnt 22 --- 22 21 20 19 18 17 16 15 14 13 &&&& 12 11 10 9 8 7 6 5 4 3 &&&& 2 1
        Map<Long, List<Long>> pageIndex = new HashMap<>();

        for (long i = 1; i <= page; i++) {
            List<Long> index = new ArrayList<>();
            for (int x = 0; x < 10; x++) {
                index.add(cnt);
                cnt--;
                if (cnt == 0) { break; }
            }
            pageIndex.put(i, new ArrayList<>(index));
            index.clear();
        }
        beAf.put("be", pageIndex.get(pickPage).get(0));
        beAf.put("af", pageIndex.get(pickPage).get(pageIndex.get(pickPage).size()-1));
    }
}
