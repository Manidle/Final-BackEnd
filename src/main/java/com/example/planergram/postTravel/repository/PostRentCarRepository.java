package com.example.planergram.postTravel.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostRentCar;
import com.example.planergram.travelContents.model.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRentCarRepository extends JpaRepository<PostRentCar, Long> {
    PostRentCar findByPostAndRentCar(Post post, RentCar rentCar);

    List<PostRentCar> findByPost(Post post);

    List<PostRentCar> findByRentCar(RentCar rentCar);
}
