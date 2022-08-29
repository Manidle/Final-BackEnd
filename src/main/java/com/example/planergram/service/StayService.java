package com.example.planergram.service;

import com.example.planergram.DTO.StayDTO;
import com.example.planergram.model.Stay;
import com.example.planergram.model.StayLike;
import com.example.planergram.repository.StayLikeRepository;
import com.example.planergram.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StayService {

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private StayLikeRepository stayLikeRepository;

    public StayDTO signUp(StayDTO stayDTO) {
        Stay stay = makeStay(stayDTO);
        stay = stayRepository.save(stay);
        return makeStayDTO(stay);
    }

    public List<StayDTO> findAll() {
        List<Stay> stayList = stayRepository.findAll();
        List<StayDTO> stayDTOList = new ArrayList<>();
        for (Stay stay: stayList) {
            stayDTOList.add(makeStayDTO(stay));
        }
        return stayDTOList;
    }

    public StayDTO findById(Long id) {
        Stay stay = stayRepository.getById(id);
        return makeStayDTO(stay);
    }


    public void delete(Long id) {
        Stay stay = stayRepository.getById(id);
        stayRepository.delete(stay);
    }

    public StayDTO update(Long id, StayDTO stayDTO) {
        Stay stay = stayRepository.getById(id);
        stay.setAddress(stayDTO.getAddress());
        stay.setCheckIn(stayDTO.getCheckIn());
        stay.setCheckOut(stayDTO.getCheckOut());
        stay.setPrice(stayDTO.getPrice());
        stay.setName(stayDTO.getName());
        stay = stayRepository.save(stay);
        return makeStayDTO(stay);
    }

    private Stay makeStay(StayDTO stayDTO){
        List<StayLike> stayLikeList = new ArrayList<>();
        if (stayDTO.getStayLikeIdList() != null){
            for (Long stayLikeId: stayDTO.getStayLikeIdList()) {
                stayLikeList.add(stayLikeRepository.getById(stayLikeId));
            }
        }
        return Stay.builder()
                .id(stayDTO.getId())
                .address(stayDTO.getAddress())
                .checkIn(stayDTO.getCheckIn())
                .checkOut(stayDTO.getCheckOut())
                .name(stayDTO.getName())
                .price(stayDTO.getPrice())
                .likeCount(stayDTO.getLikeCount())
                .stayLikeList(stayLikeList)
                .build();
    }

    private StayDTO makeStayDTO(Stay stay){
        List<Long> stayLikeIdList = new ArrayList<>();
        if (stay.getStayLikeList() != null){
            for (StayLike stayLike: stay.getStayLikeList()) {
                stayLikeIdList.add(stayLike.getId());
            }
        }

        return StayDTO.builder()
                .id(stay.getId())
                .address(stay.getAddress())
                .checkIn(stay.getCheckIn())
                .checkOut(stay.getCheckOut())
                .likeCount(stay.getLikeCount())
                .stayLikeIdList(stayLikeIdList)
                .name(stay.getName())
                .price(stay.getPrice())
                .build();
    }
}
