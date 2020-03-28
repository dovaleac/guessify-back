package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.LangRecord;

public interface LangDao {

  LangRecord getLangByAbbrev(String abbrev);

}
