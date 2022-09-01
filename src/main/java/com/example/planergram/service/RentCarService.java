package com.example.planergram.service;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.model.RentCar;
import com.example.planergram.model.RentCarLike;
import com.example.planergram.repository.RentCarLikeRepository;
import com.example.planergram.repository.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentCarService {

    @Autowired
    private RentCarRepository rentCarRepository;

    @Autowired
    private RentCarLikeRepository rentCarLikeRepository;

    public RentCarDTO signUp(RentCarDTO rentCarDTO) {
        RentCar rentCar = makeRentCar(rentCarDTO);
        rentCar = rentCarRepository.save(rentCar);
        return makeRentCarDTO(rentCar);
    }

    public List<RentCarDTO> findAll() {
        List<RentCar> rentCarList = rentCarRepository.findAll();
        List<RentCarDTO> rentCarDTOList = new ArrayList<>();
        for (RentCar rentCar: rentCarList) {
            rentCarDTOList.add(makeRentCarDTO(rentCar));
        }
        return rentCarDTOList;
    }

    public RentCarDTO findById(Long id) {
        RentCar rentCar = rentCarRepository.getById(id);
        return makeRentCarDTO(rentCar);
    }

    public RentCarDTO update(Long id, RentCarDTO rentCarDTO) {
        RentCar rentCar  = rentCarRepository.getById(id);
        rentCar.setAddress(rentCarDTO.getAddress());
        rentCar.setCompanyName(rentCarDTO.getCompanyName());
        rentCar.setCarSort(rentCarDTO.getCarSort());
        rentCar.setCarName(rentCarDTO.getCarName());
        rentCar.setLikeCount(rentCarDTO.getLikeCount());
        rentCar = rentCarRepository.save(rentCar);
        return makeRentCarDTO(rentCar);
    }

    public void delete(Long id) {
        RentCar rentCar = rentCarRepository.getById(id);
        rentCarRepository.delete(rentCar);
    }




    private RentCar makeRentCar(RentCarDTO rentCarDTO){
        List<RentCarLike> rentCarLikeList = new ArrayList<>();
        if (rentCarDTO.getRentCarLikeIdList() != null){
            for (Long rentCarLikeId: rentCarDTO.getRentCarLikeIdList()) {
                rentCarLikeList.add(rentCarLikeRepository.getById(rentCarLikeId));
            }
        }
        return RentCar.builder()
                .rentCarId(rentCarDTO.getRentCarId())
                .address(rentCarDTO.getAddress())
                .companyName(rentCarDTO.getCompanyName())
                .carSort(rentCarDTO.getCarSort())
                .carName(rentCarDTO.getCarName())
                .likeCount(rentCarDTO.getLikeCount())
                .rentcarLikeList(rentCarLikeList)
                .build();
    }

    private RentCarDTO makeRentCarDTO(RentCar rentCar){
        List<Long> rentCarLikeIdList = new ArrayList<>();
        if (rentCar.getRentcarLikeList() != null){
            for (RentCarLike rentCarLike: rentCar.getRentcarLikeList()) {
                rentCarLikeIdList.add(rentCarLike.getRentCarLikeId());
            }
        }

        return RentCarDTO.builder()
                .rentCarId(rentCar.getRentCarId())
                .address(rentCar.getAddress())
                .companyName(rentCar.getCompanyName())
                .carSort(rentCar.getCarSort())
                .carName(rentCar.getCarName())
                .likeCount(rentCar.getLikeCount())
                .rentCarLikeIdList(rentCarLikeIdList)
                .build();
    }
}