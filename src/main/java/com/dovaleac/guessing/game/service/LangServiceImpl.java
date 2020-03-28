package com.dovaleac.guessing.game.service;

import com.dovaleac.guessing.game.dao.LangDao;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.LangRecord;

import javax.inject.Singleton;

@Singleton
public class LangServiceImpl implements LangService {

  private final LangDao langDao;

  public LangServiceImpl(LangDao langDao) {
    this.langDao = langDao;
  }

  @Override
  public LangRecord getLangByAbbrev(String abbrev) {
    return langDao.getLangByAbbrev(abbrev);
  }
}
