package com.example.demo.shelter.controller;

import com.example.demo.shelter.cache.ShelterRedisTemplateService;
import com.example.demo.shelter.dto.ShelterDto;
import com.example.demo.shelter.entity.Shelter;
import com.example.demo.shelter.service.ShelterRepositoryService;
import com.example.demo.util.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterRepositoryService shelterRepositoryService;
    private final ShelterRedisTemplateService shelterRedisTemplateService;

    // 데이터 초기 셋팅을 위한 임시 메소드
    @GetMapping("/csv/save")
    public String saveCsv() {
        saveCsvToDatabase();
        saveCsvToRedis();

        return "success save";
    }

    public void saveCsvToDatabase() {

        List<Shelter> shelterList = loadShelterList();
        shelterRepositoryService.saveAll(shelterList);

    }

    public void saveCsvToRedis() {

        List<ShelterDto> shelterDtoList = shelterRepositoryService.findAll()
                .stream().map(shelter -> ShelterDto.builder()
                        .id(shelter.getId())
                        .shelterName(shelter.getShelterName())
                        .shelterAddress(shelter.getShelterAddress())
                        .latitude(shelter.getLatitude())
                        .longitude(shelter.getLongitude())
                        .build())
                .collect(Collectors.toList());

        shelterDtoList.forEach(shelterRedisTemplateService::save);

    }

    private List<Shelter> loadShelterList() {
        return CsvUtils.convertToShelterDtoList()
                .stream().map(shelterDto ->
                        Shelter.builder()
                                .id(shelterDto.getId())
                                .shelterName(shelterDto.getShelterName())
                                .shelterAddress(shelterDto.getShelterAddress())
                                .latitude(shelterDto.getLatitude())
                                .longitude(shelterDto.getLongitude())
                                .build())
                .collect(Collectors.toList());
    }
}