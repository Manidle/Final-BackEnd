package com.example.planergram.travelContents.service;

import com.example.planergram.travelContents.DTO.RentCarDTO;
import com.example.planergram.travelContents.model.RentCar;
import com.example.planergram.travelContents.repository.RentCarRepository;
import com.example.planergram.userLike.model.RentCarLike;
import com.example.planergram.userLike.repository.RentCarLikeRepository;
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
        for (RentCar rentCar : rentCarList) {
            rentCarDTOList.add(makeRentCarDTO(rentCar));
        }
        return rentCarDTOList;
    }

    public List<RentCarDTO> findTop5ByOrderByLikeCountDesc() {
        List<RentCar> rentCarList = rentCarRepository.findTop5ByOrderByLikeCountDesc();
        List<RentCarDTO> rentCarDTOList = new ArrayList<>();
        for (RentCar rentCar : rentCarList) {
            rentCarDTOList.add(makeRentCarDTO(rentCar));
        }
        return rentCarDTOList;
    }

    public List<RentCarDTO> findByNameLikeOrAddressLikeOrCompanyName(String search) {
        List<RentCar> rentCarList = rentCarRepository.findByNameLikeOrAddressLikeOrCompanyName(search);
        List<RentCarDTO> rentCarDTOList = new ArrayList<>();
        for (RentCar rentCar : rentCarList) {
            rentCarDTOList.add(makeRentCarDTO(rentCar));
        }
        return rentCarDTOList;
    }


    public RentCarDTO findById(Long id) {
        RentCar rentCar = rentCarRepository.getById(id);
        return makeRentCarDTO(rentCar);
    }

    public RentCarDTO update(Long id, RentCarDTO rentCarDTO) {
        RentCar rentCar = rentCarRepository.getById(id);
        rentCar.setAddress(rentCarDTO.getAddress());
        rentCar.setCompanyName(rentCarDTO.getCompanyName());
        rentCar.setCarSort(rentCarDTO.getCarSort());
        rentCar.setCarName(rentCarDTO.getCarName());
        rentCar.setLikeCount(rentCarDTO.getLikeCount());
        rentCar = rentCarRepository.save(rentCar);
        return makeRentCarDTO(rentCar);
    }

    public List<RentCarDTO> delete(Long id) {
        RentCar rentCar = rentCarRepository.getById(id);
        rentCarRepository.delete(rentCar);
        return findAll();
    }

    private RentCar makeRentCar(RentCarDTO rentCarDTO) {
        List<RentCarLike> rentCarLikeList = new ArrayList<>();
        if (rentCarDTO.getRentCarLikeIdList() != null) {
            for (Long rentCarLikeId : rentCarDTO.getRentCarLikeIdList()) {
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
                .rentCarLikeList(rentCarLikeList)
                .build();
    }

    private RentCarDTO makeRentCarDTO(RentCar rentCar) {
        List<Long> rentCarLikeIdList = new ArrayList<>();
        if (rentCar.getRentCarLikeList() != null) {
            for (RentCarLike rentCarLike : rentCar.getRentCarLikeList()) {
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