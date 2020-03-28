package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.LangRecord;
import com.dovaleac.guessing.game.model.dto.GameId;
import com.dovaleac.guessing.game.model.dto.Player;
import com.dovaleac.guessing.game.model.dto.RoomId;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

public interface LangService {
  LangRecord getLangByAbbrev(String abbrev);
}
