package com.example.ap.mapper;

import com.example.ap.dto.SportsDto;
import com.example.ap.entity.Sports;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PlayerMapper.class})
public interface SportsMapper extends EntityMapper<SportsDto, Sports> {
}
