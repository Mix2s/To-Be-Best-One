package com.hui.springbootjpa.repository;

import com.hui.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostory extends JpaRepository<User,Integer> {
}
