package com.ghanem.RestfulWebServicesApplication.socialmedia.repo;

import com.ghanem.RestfulWebServicesApplication.socialmedia.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
