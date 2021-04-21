package com.coffe.web.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // 글 갯수 카운터
    long count();

    // 1번 페이지 클릭 시 & 첫 로딩 시 SQL
    @Query(value = "SELECT p.* FROM Posts p ORDER BY p.id DESC LIMIT 10"
            , nativeQuery = true)
    List<Posts> firstPageSelector();

    //그외 페이지 클릭 시 SQL
    @Query(value = "SELECT p.* FROM POSTS p WHERE ID BETWEEN :af AND :be ORDER BY p.id DESC"
            , nativeQuery = true)
    List<Posts> pageSelector(@Param("be") long be, @Param("af") long af);
}
