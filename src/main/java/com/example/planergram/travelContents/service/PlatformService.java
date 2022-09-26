package com.example.planergram.travelContents.service;

import com.example.planergram.travelContents.DTO.PlatformDTO;
import com.example.planergram.travelContents.model.Platform;
import com.example.planergram.travelContents.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformService {

    @Autowired
    PlatformRepository platformRepository;

    public List<PlatformDTO> findAll() {
        List<Platform> platformList = platformRepository.findAll();
        List<PlatformDTO> platformDTOList = new ArrayList<>();
        for (Platform platform : platformList) {
            platformDTOList.add(makePlatformDTO(platform));
        }
        return platformDTOList;
    }

    private PlatformDTO makePlatformDTO(Platform platform) {
        return PlatformDTO.builder()
                .platformId(platform.getPlatformId())
                .cityCode(platform.getCityCode())
                .cityName(platform.getCityName())
                .nodeId(platform.getNodeId())
                .nodeName(platform.getNodeName())
                .build();
    }
}