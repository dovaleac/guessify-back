package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.LangRecord;

public interface LangService {
  LangRecord getLangByAbbrev(String abbrev);
}
