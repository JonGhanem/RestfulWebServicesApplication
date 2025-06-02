package com.ghanem.RestfulWebServicesApplication.socialmedia.repo;

import com.ghanem.RestfulWebServicesApplication.socialmedia.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
