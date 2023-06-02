package com.example.ap.mapper;

import com.example.ap.dto.PlayerDto;
import com.example.ap.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { SportsMapper.class })
public interface PlayerMapper extends EntityMapper<PlayerDto, Player> {
}
