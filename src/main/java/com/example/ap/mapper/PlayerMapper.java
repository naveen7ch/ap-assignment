package com.example.ap.mapper;

import com.example.ap.dto.PlayerDto;
import com.example.ap.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends EntityMapper<PlayerDto, Player> {
    @Mapping(target = "sports", ignore = true)
    PlayerDto toDto(Player e);
}
