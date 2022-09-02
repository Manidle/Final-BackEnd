package com.example.planergram.repository;

import com.example.planergram.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRentCarRepository extends JpaRepository<PostRentCar,Long> {
    PostRentCar findByPostAndRentCar(Post post, RentCar rentCar);

    List<PostRentCar> findByPost(Post post);
    List<PostRentCar> findByRentCar(RentCar rentCar);
}
