package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class t
  extends cz
{
  static final String[] fgs;
  static final c.a fgt;
  
  static
  {
    int i = 0;
    fgs = new String[] { "key", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).sKy = new Field[4];
    ((c.a)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "key";
    ((c.a)localObject1).sKA.put("key", "TEXT");
    ((StringBuilder)localObject2).append(" key TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).sKA.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "scene";
    ((c.a)localObject1).sKA.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "updateTime";
    ((c.a)localObject1).sKA.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((c.a)localObject1).columns[4] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fgt = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = fgs;
    int j = localObject2.length;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localObject1 = (String)localObject1 + ", " + (String)localObject3;
      i += 1;
    }
    localObject1 = ((String)localObject1).replaceFirst(",", "");
    localObject1 = (String)localObject1 + " )";
    localObject2 = new StringBuilder();
    Object localObject3 = fgt;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  protected final c.a AX()
  {
    return fgt;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/plugin/appbrand/appcache/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */