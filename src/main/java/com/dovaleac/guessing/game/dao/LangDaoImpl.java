package com.dovaleac.guessing.game.dao;

import com.dovaleac.guessing.game.jooq.generated.independent.tables.Lang;
import com.dovaleac.guessing.game.jooq.generated.independent.tables.records.LangRecord;
import com.dovaleac.guessing.game.utils.jooq.DslContextSupplier;

import javax.inject.Singleton;

@Singleton
public class LangDaoImpl implements LangDao {

  public static final Lang LANG = Lang.LANG;
  private final DslContextSupplier dslContextSupplier;

  public LangDaoImpl(DslContextSupplier dslContextSupplier) {
    this.dslContextSupplier = dslContextSupplier;
  }

  @Override
  public LangRecord getLangByAbbrev(String abbrev) {
    return dslContextSupplier.executeFunction(
        dslContext -> dslContext.selectFrom(LANG).where(LANG.ABBREV.eq(abbrev)).fetchOne());
  }
}
