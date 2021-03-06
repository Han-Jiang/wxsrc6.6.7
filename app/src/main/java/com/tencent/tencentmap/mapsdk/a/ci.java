package com.tencent.tencentmap.mapsdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ci
{
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected HashMap<String, Object> b = new HashMap();
  protected String c = "GBK";
  md d = new md();
  private HashMap<String, Object> e = new HashMap();
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
          throw new IllegalArgumentException("only byte[] is supported");
        }
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          paramObject = Array.get(paramObject, 0);
        }
        else
        {
          paramArrayList.add("Array");
          paramArrayList.add("?");
        }
      }
      else
      {
        if ((paramObject instanceof Array)) {
          throw new IllegalArgumentException("can not support Array, please use List");
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (((List)paramObject).size() > 0) {
            paramObject = ((List)paramObject).get(0);
          } else {
            paramArrayList.add("?");
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label223;
          }
          paramArrayList.add("java.util.Map");
          paramObject = (Map)paramObject;
          if (((Map)paramObject).size() <= 0) {
            break;
          }
          Object localObject = ((Map)paramObject).keySet().iterator().next();
          paramObject = ((Map)paramObject).get(localObject);
          paramArrayList.add(localObject.getClass().getName());
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    return;
    label223:
    paramArrayList.add(paramObject.getClass().getName());
  }
  
  private Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    if (this.b.containsKey(paramString)) {
      return this.b.get(paramString);
    }
    paramClassLoader = ag.a(paramString, paramBoolean, paramClassLoader);
    this.b.put(paramString, paramClassLoader);
    return paramClassLoader;
  }
  
  private void b(String paramString, Object paramObject)
  {
    this.e.put(paramString, paramObject);
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    String str = null;
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    if (this.e.containsKey(paramString)) {
      return (T)this.e.get(paramString);
    }
    Object localObject = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      str = (String)((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        paramClassLoader = b(str, paramBoolean, paramClassLoader);
        this.d.a((byte[])localObject);
        this.d.a(this.c);
        paramClassLoader = this.d.a(paramClassLoader, 0, true);
        b(paramString, paramClassLoader);
        return paramClassLoader;
      }
      catch (Exception paramString)
      {
        throw new bh(paramString);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new me();
    ((me)localObject).a(this.c);
    ((me)localObject).a(paramT, 0);
    localObject = mg.a(((me)localObject).a());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(ag.a(localArrayList), localObject);
    this.e.remove(paramString);
    this.a.put(paramString, localHashMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte);
    this.d.a(this.c);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.d.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    me localme = new me(0);
    localme.a(this.c);
    localme.a(this.a, 0);
    return mg.a(localme.a());
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes7-dex2jar.jar!/com/tencent/tencentmap/mapsdk/a/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */