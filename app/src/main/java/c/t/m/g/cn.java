package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class cn
  implements Observer
{
  protected static String a = "";
  protected static String b = "";
  protected static String c = "";
  private static final HashMap<String, String> e = new HashMap();
  private static cn f = null;
  volatile ConcurrentHashMap<String, List<d>> d = null;
  private HashMap<Class<?>, Object> g = new HashMap();
  private volatile ConcurrentHashMap<String, String> h = null;
  private volatile boolean i = false;
  
  private cn()
  {
    this.g.put(String.class, "");
    this.g.put(Integer.class, Integer.valueOf(Integer.MIN_VALUE));
    this.g.put(Float.class, Float.valueOf(Float.MIN_VALUE));
    this.g.put(Double.class, Double.valueOf(Double.MIN_VALUE));
    this.g.put(Long.class, Long.valueOf(Long.MIN_VALUE));
    this.g.put(Boolean.class, Boolean.FALSE);
    c();
  }
  
  /* Error */
  public static cn a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	c/t/m/g/cn:f	Lc/t/m/g/cn;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	c/t/m/g/cn
    //   15: dup
    //   16: invokespecial 105	c/t/m/g/cn:<init>	()V
    //   19: putstatic 43	c/t/m/g/cn:f	Lc/t/m/g/cn;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 43	c/t/m/g/cn:f	Lc/t/m/g/cn;
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	5	0	localcn	cn
    //   34	5	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   35	38	34	finally
    //   3	12	40	finally
    //   25	29	40	finally
    //   38	40	40	finally
  }
  
  private final Object a(String paramString, Class<?> paramClass)
  {
    if (!this.i) {
      c();
    }
    if (!this.g.containsKey(paramClass)) {
      throw new IllegalStateException("The property \"" + paramString + "\" don't support class type \"" + paramClass.toString() + "\"");
    }
    Object localObject2 = (String)this.h.get(paramString);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = (String)e.get(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    try
    {
      localObject1 = b((String)localObject2, paramClass);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramString = b((String)e.get(paramString), paramClass);
        return paramString;
      }
      catch (Throwable paramString) {}
    }
    return this.g.get(paramClass);
  }
  
  protected static void a(String paramString)
  {
    b = paramString;
  }
  
  protected static void a(String paramString1, String paramString2)
  {
    a = paramString1;
    c = paramString2;
    b("app_version", paramString2);
  }
  
  protected static void a(HashMap<String, String> paramHashMap)
  {
    b("cc_version", "-1");
    b("cc_req_interval", "10800000");
    b("last_pull_time", "0");
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      b(str, (String)paramHashMap.get(str));
    }
  }
  
  private static Object b(String paramString, Class<?> paramClass)
  {
    Object localObject;
    if (paramClass == Integer.class) {
      localObject = Integer.valueOf(Integer.parseInt(paramString));
    }
    do
    {
      return localObject;
      if (paramClass == Long.class) {
        return Long.valueOf(Long.parseLong(paramString));
      }
      if (paramClass == Boolean.class) {
        return Boolean.valueOf(Boolean.parseBoolean(paramString));
      }
      if (paramClass == Float.class) {
        return Float.valueOf(Float.parseFloat(paramString));
      }
      localObject = paramString;
    } while (paramClass != Double.class);
    return Double.valueOf(Double.parseDouble(paramString));
  }
  
  private static void b(String paramString1, String paramString2)
  {
    e.put(paramString1, paramString2);
  }
  
  private void c()
  {
    try
    {
      SharedPreferences localSharedPreferences = co.a().b();
      if (localSharedPreferences != null)
      {
        String str = localSharedPreferences.getString("app_version", "");
        if ((c.length() > 0) && (!c.equals(str)))
        {
          cj.a("CC_Set", "clear sp > pre:" + str + ",now:" + c);
          localSharedPreferences.edit().clear().apply();
          localSharedPreferences.edit().putString("app_version", c).apply();
        }
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      cj.a("CC_Set", localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void f(String paramString)
  {
    if (e.get(paramString) == null) {}
    SharedPreferences localSharedPreferences;
    ConcurrentHashMap localConcurrentHashMap;
    for (;;)
    {
      return;
      try
      {
        localSharedPreferences = co.a().b();
        if (localSharedPreferences != null)
        {
          localConcurrentHashMap = this.h;
          if (!e.containsKey(paramString)) {
            throw new NullPointerException("Not exists property name \"" + paramString + "\"");
          }
        }
      }
      catch (Throwable paramString)
      {
        cj.b("CC_Set", paramString.toString());
        return;
      }
    }
    localConcurrentHashMap.put(paramString, localSharedPreferences.getString(paramString, (String)e.get(paramString)));
  }
  
  public final int b(String paramString)
  {
    return ((Integer)a(paramString, Integer.class)).intValue();
  }
  
  protected final void b()
  {
    if (co.a().b() == null)
    {
      cj.a("CC_Set", "---> read xml: failed,not init finish!");
      return;
    }
    Iterator localIterator = e.keySet().iterator();
    while (localIterator.hasNext()) {
      f((String)localIterator.next());
    }
    this.i = true;
    cj.a("CC_Set", "---> read xml:" + this.h.toString());
  }
  
  public final long c(String paramString)
  {
    return ((Long)a(paramString, Long.class)).longValue();
  }
  
  public final boolean d(String paramString)
  {
    return ((Boolean)a(paramString, Boolean.class)).booleanValue();
  }
  
  public final String e(String paramString)
  {
    return (String)a(paramString, String.class);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null)
    {
      paramObservable = null;
      if ((paramObservable != null) && (paramObservable.length() != 0)) {
        break label26;
      }
    }
    for (;;)
    {
      return;
      paramObservable = (String)paramObject;
      break;
      label26:
      paramObject = "update [" + paramObservable + "] : " + (String)this.h.get(paramObservable) + " --> ";
      f(paramObservable);
      cj.a("CC_Set", (String)paramObject + (String)this.h.get(paramObservable));
      paramObservable = (List)this.d.get(paramObservable);
      if ((paramObservable != null) && (!paramObservable.isEmpty()))
      {
        paramObservable = paramObservable.iterator();
        while (paramObservable.hasNext()) {
          paramObservable.next();
        }
      }
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes3-dex2jar.jar!/c/t/m/g/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */