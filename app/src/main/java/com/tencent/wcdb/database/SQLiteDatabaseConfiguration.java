package com.tencent.wcdb.database;

import java.util.ArrayList;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration
{
  public static final String MEMORY_DB_PATH = ":memory:";
  public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList();
  public boolean customWALHookEnabled;
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public Locale locale;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;
  public int synchronousMode;
  public String vfsName;
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    this.path = paramSQLiteDatabaseConfiguration.path;
    this.label = paramSQLiteDatabaseConfiguration.label;
    updateParametersFrom(paramSQLiteDatabaseConfiguration);
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("path must not be null.");
    }
    this.path = paramString;
    this.label = paramString;
    this.openFlags = paramInt;
    this.synchronousMode = 2;
    this.maxSqlCacheSize = 25;
    this.locale = Locale.getDefault();
    if ((paramInt & 0x100) != 0) {}
    for (paramString = "vfslog";; paramString = null)
    {
      this.vfsName = paramString;
      return;
    }
  }
  
  public final boolean isInMemoryDb()
  {
    return this.path.equalsIgnoreCase(":memory:");
  }
  
  public final void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("other must not be null.");
    }
    if (!this.path.equals(paramSQLiteDatabaseConfiguration.path)) {
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
    this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
    this.locale = paramSQLiteDatabaseConfiguration.locale;
    this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
    this.customWALHookEnabled = paramSQLiteDatabaseConfiguration.customWALHookEnabled;
    this.synchronousMode = paramSQLiteDatabaseConfiguration.synchronousMode;
    this.vfsName = paramSQLiteDatabaseConfiguration.vfsName;
    this.customFunctions.clear();
    this.customFunctions.addAll(paramSQLiteDatabaseConfiguration.customFunctions);
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes-dex2jar.jar!/com/tencent/wcdb/database/SQLiteDatabaseConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */