package com.example.planergram.service;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.model.RentCar;
import com.example.planergram.repository.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentCarService {

    @Autowired
    private RentCarRepository rentCarRepository;

    public RentCar save(RentCarDTO rentCarDTO) throws Exception {
        RentCar rentCar = makeRentCar(rentCarDTO);
        return rentCarRepository.save(rentCar);
    }

    public List<RentCar> findAll() {
        return rentCarRepository.findAll();
    }

    public RentCar update(int id, RentCarDTO rentCarDTO) throws Exception {
        RentCar findRentCar = rentCarRepository.findById(id).orElseThrow(Exception::new);
        findRentCar.setAddress(rentCarDTO.getAddress());
        findRentCar.setCompanyName(rentCarDTO.getCompanyName());
        findRentCar.setCarSort(rentCarDTO.getCarSort());
        findRentCar.setCarName(rentCarDTO.getCarName());
        return rentCarRepository.save(findRentCar);
    }

    public List<RentCar> remove(int id) {
        final Optional<RentCar> foundRentCar = rentCarRepository.findById(id);
        foundRentCar.ifPresent(rentCar -> {
            rentCarRepository.delete(rentCar);
        });
        return rentCarRepository.findAll();
    }

    //회원삭제
    public RentCar delete(int id) throws Exception {
        final RentCar rentCar = rentCarRepository.findById(id).orElseThrow(Exception::new);
        rentCarRepository.delete(rentCar);
        return rentCar;
    }

    //make
    public RentCarDTO makeRentCarDTO(RentCar rentCar) {
        return RentCarDTO
                .builder()
                .rentCarId(rentCar.getRentCarId())
                .address(rentCar.getAddress())
                .companyName(rentCar.getCompanyName())
                .carSort(rentCar.getCarSort())
                .carName(rentCar.getCarName())
                .build();
    }

    public RentCar makeRentCar(RentCarDTO rentCarDTO) {
        return RentCar
                .builder()
                .rentCarId(rentCarDTO.getRentCarId())
                .address(rentCarDTO.getAddress())
                .companyName(rentCarDTO.getCompanyName())
                .carSort(rentCarDTO.getCarSort())
                .carName(rentCarDTO.getCarName())
                .build();
    }
}
