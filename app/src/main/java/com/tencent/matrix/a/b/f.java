package com.tencent.matrix.a.b;

import android.os.Environment;
import com.tencent.matrix.c.c.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.matrix.c.c
{
  private final int boZ;
  private final int bpa;
  final Map<String, d> bqg = new HashMap();
  final Map<String, c> bqh = new HashMap();
  final int bqi;
  final a bqj;
  final Runnable bqk;
  final e bql;
  
  public f(c.a parama, com.tencent.matrix.a.a.a parama1, a parama2)
  {
    super(parama);
    this.bqi = parama1.boY;
    this.bpa = parama1.bpa;
    this.boZ = parama1.boZ;
    this.bqj = parama2;
    this.bqk = new Runnable()
    {
      public final void run()
      {
        Iterator localIterator = f.this.bqh.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((f.c)((Map.Entry)localIterator.next()).getValue()).tp();
        }
        f.this.tn();
      }
    };
    if (parama1.el(2))
    {
      this.bql = new e();
      return;
    }
    this.bql = null;
  }
  
  private static JSONObject a(c paramc, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wakeLockTag", paramc.tag);
      localJSONObject.put("subTag", "wakeLock");
      localJSONObject.put("timeFrame", paramLong);
      localJSONObject.put("acquireCnt", paramc.bqq);
      localJSONObject.put("acquireCntWhenScreenOff", paramc.bqr);
      localJSONObject.put("statisticalHoldTime", paramc.bqp);
      localJSONObject.put("stackHistory", paramc.bqs);
      return localJSONObject;
    }
    catch (JSONException paramc)
    {
      com.tencent.matrix.d.b.e("Matrix.WakeLockDetector", "json content error: %s", new Object[] { paramc });
    }
    return localJSONObject;
  }
  
  private void to()
  {
    Iterator localIterator = this.bqh.entrySet().iterator();
    long l1 = System.currentTimeMillis();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (c)((Map.Entry)localObject1).getValue();
      long l2 = l1 - ((c)localObject1).bqo;
      int i = (int)(l2 / 3600000L) + 1;
      int j = ((c)localObject1).bqq / i;
      int k = ((c)localObject1).bqr / i;
      long l3 = ((c)localObject1).bqp / i;
      if ((j >= this.boZ) || (k > this.boZ / 2))
      {
        localObject2 = String.format("%s:%d", new Object[] { str, Integer.valueOf(2) });
        if (!cb((String)localObject2)) {
          break label241;
        }
        com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", new Object[] { localObject2 });
      }
      for (;;)
      {
        if (l3 < this.bpa) {
          break label283;
        }
        str = String.format("%s:%d", new Object[] { str, Integer.valueOf(3) });
        if (!cb(str)) {
          break label285;
        }
        com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", new Object[] { str });
        break;
        label241:
        com.tencent.matrix.c.b localb = new com.tencent.matrix.c.b(2);
        localb.aAL = ((String)localObject2);
        localb.brm = a((c)localObject1, l2);
        c(localb);
        ca((String)localObject2);
      }
      label283:
      continue;
      label285:
      Object localObject2 = new com.tencent.matrix.c.b(3);
      ((com.tencent.matrix.c.b)localObject2).aAL = str;
      ((com.tencent.matrix.c.b)localObject2).brm = a((c)localObject1, l2);
      c((com.tencent.matrix.c.b)localObject2);
      ca(str);
    }
  }
  
  final void tn()
  {
    Iterator localIterator = this.bqg.entrySet().iterator();
    long l = System.currentTimeMillis();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        d locald = (d)((Map.Entry)localIterator.next()).getValue();
        if (l - locald.bqw < this.bqi) {
          continue;
        }
        String str = String.format("%s:%d", new Object[] { locald.tag, Integer.valueOf(1) });
        if (cb(str))
        {
          com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockOnceHoldTime issue already published: %s", new Object[] { str });
          continue;
        }
        com.tencent.matrix.c.b localb = new com.tencent.matrix.c.b(1);
        localb.aAL = str;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("subTag", "wakeLock");
          localJSONObject.put("wakeLockTag", locald.tag);
          localJSONObject.put("flags", locald.flags);
          localJSONObject.put("holdTime", l - locald.bqw);
          localJSONObject.put("stackHistory", locald.bqs);
          localb.brm = localJSONObject;
          c(localb);
          ca(str);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            com.tencent.matrix.d.b.e("Matrix.WakeLockDetector", "json content error: %s", new Object[] { localJSONException });
          }
        }
      }
    }
    to();
  }
  
  public static abstract interface a
  {
    public abstract void b(Runnable paramRunnable, long paramLong);
    
    public abstract boolean isScreenOn();
  }
  
  private static final class b
  {
    final Vector<String> bqn = new Vector();
    
    final void bY(String paramString)
    {
      this.bqn.add(paramString);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.bqn.size())
      {
        localStringBuilder.append((String)this.bqn.get(i)).append("\t\t");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  private static final class c
  {
    final long bqo;
    long bqp;
    int bqq;
    int bqr;
    f.b bqs;
    final Map<String, Boolean> bqt;
    long bqu;
    final String tag;
    
    c(String paramString)
    {
      this.tag = paramString;
      this.bqp = 0L;
      this.bqq = 0;
      this.bqr = 0;
      this.bqu = -1L;
      this.bqs = new f.b();
      this.bqo = System.currentTimeMillis();
      this.bqt = new HashMap();
    }
    
    final void tp()
    {
      if (this.bqu < 0L) {
        return;
      }
      long l = System.currentTimeMillis();
      this.bqp += l - this.bqu;
      this.bqu = l;
    }
  }
  
  private static final class d
  {
    f.b bqs;
    final String bqv;
    final long bqw;
    final int flags;
    final String tag;
    
    d(String paramString1, String paramString2, int paramInt, long paramLong)
    {
      this.bqv = paramString1;
      this.tag = paramString2;
      this.flags = paramInt;
      this.bqw = paramLong;
      this.bqs = new f.b();
    }
  }
  
  private static final class e
  {
    private final String bps;
    int bqx;
    final StringBuilder bqy;
    
    e()
    {
      String str = com.tencent.matrix.d.c.h("yyyy-MM-dd", System.currentTimeMillis());
      this.bps = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), str });
      this.bqy = new StringBuilder();
      com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "WakeLockInfoRecorder path:%s", new Object[] { this.bps });
    }
    
    /* Error */
    final void tq()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 81	com/tencent/matrix/a/b/f$e:bqx	I
      //   4: bipush 10
      //   6: if_icmplt +85 -> 91
      //   9: aconst_null
      //   10: astore 4
      //   12: aconst_null
      //   13: astore_2
      //   14: aconst_null
      //   15: astore_3
      //   16: aload_2
      //   17: astore_1
      //   18: new 41	java/io/File
      //   21: dup
      //   22: aload_0
      //   23: getfield 58	com/tencent/matrix/a/b/f$e:bps	Ljava/lang/String;
      //   26: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
      //   29: astore 5
      //   31: aload_2
      //   32: astore_1
      //   33: aload 5
      //   35: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
      //   38: invokevirtual 91	java/io/File:mkdirs	()Z
      //   41: ifne +51 -> 92
      //   44: aload_2
      //   45: astore_1
      //   46: aload 5
      //   48: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
      //   51: invokevirtual 94	java/io/File:exists	()Z
      //   54: ifne +38 -> 92
      //   57: aload_2
      //   58: astore_1
      //   59: ldc 65
      //   61: ldc 96
      //   63: iconst_0
      //   64: anewarray 4	java/lang/Object
      //   67: invokestatic 98	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   70: aload_0
      //   71: iconst_0
      //   72: putfield 81	com/tencent/matrix/a/b/f$e:bqx	I
      //   75: aload_0
      //   76: getfield 63	com/tencent/matrix/a/b/f$e:bqy	Ljava/lang/StringBuilder;
      //   79: iconst_0
      //   80: aload_0
      //   81: getfield 63	com/tencent/matrix/a/b/f$e:bqy	Ljava/lang/StringBuilder;
      //   84: invokevirtual 102	java/lang/StringBuilder:length	()I
      //   87: invokevirtual 106	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   90: pop
      //   91: return
      //   92: aload_2
      //   93: astore_1
      //   94: new 108	java/io/BufferedWriter
      //   97: dup
      //   98: new 110	java/io/OutputStreamWriter
      //   101: dup
      //   102: new 112	java/io/FileOutputStream
      //   105: dup
      //   106: aload 5
      //   108: iconst_1
      //   109: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   112: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   115: invokespecial 121	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   118: astore_2
      //   119: aload_0
      //   120: getfield 63	com/tencent/matrix/a/b/f$e:bqy	Ljava/lang/StringBuilder;
      //   123: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: astore_1
      //   127: aload_2
      //   128: aload_1
      //   129: iconst_0
      //   130: aload_1
      //   131: invokevirtual 125	java/lang/String:length	()I
      //   134: invokevirtual 129	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
      //   137: aload_2
      //   138: invokevirtual 132	java/io/BufferedWriter:flush	()V
      //   141: aload_2
      //   142: invokevirtual 135	java/io/BufferedWriter:close	()V
      //   145: goto -75 -> 70
      //   148: astore_1
      //   149: goto -79 -> 70
      //   152: astore_1
      //   153: aload_3
      //   154: astore_2
      //   155: aload_1
      //   156: astore_3
      //   157: aload_2
      //   158: astore_1
      //   159: ldc 65
      //   161: ldc -119
      //   163: iconst_1
      //   164: anewarray 4	java/lang/Object
      //   167: dup
      //   168: iconst_0
      //   169: aload_3
      //   170: invokevirtual 140	java/io/FileNotFoundException:getLocalizedMessage	()Ljava/lang/String;
      //   173: aastore
      //   174: invokestatic 143	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: aload_2
      //   178: ifnull -108 -> 70
      //   181: aload_2
      //   182: invokevirtual 135	java/io/BufferedWriter:close	()V
      //   185: goto -115 -> 70
      //   188: astore_1
      //   189: goto -119 -> 70
      //   192: astore_3
      //   193: aload 4
      //   195: astore_2
      //   196: aload_2
      //   197: astore_1
      //   198: ldc 65
      //   200: ldc -119
      //   202: iconst_1
      //   203: anewarray 4	java/lang/Object
      //   206: dup
      //   207: iconst_0
      //   208: aload_3
      //   209: invokevirtual 144	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
      //   212: aastore
      //   213: invokestatic 143	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   216: aload_2
      //   217: ifnull -147 -> 70
      //   220: aload_2
      //   221: invokevirtual 135	java/io/BufferedWriter:close	()V
      //   224: goto -154 -> 70
      //   227: astore_1
      //   228: goto -158 -> 70
      //   231: astore_3
      //   232: aload_1
      //   233: astore_2
      //   234: aload_3
      //   235: astore_1
      //   236: aload_2
      //   237: ifnull +7 -> 244
      //   240: aload_2
      //   241: invokevirtual 135	java/io/BufferedWriter:close	()V
      //   244: aload_1
      //   245: athrow
      //   246: astore_2
      //   247: goto -3 -> 244
      //   250: astore_1
      //   251: goto -15 -> 236
      //   254: astore_3
      //   255: goto -59 -> 196
      //   258: astore_3
      //   259: goto -102 -> 157
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	e
      //   17	114	1	localObject1	Object
      //   148	1	1	localIOException1	java.io.IOException
      //   152	4	1	localFileNotFoundException1	java.io.FileNotFoundException
      //   158	1	1	localObject2	Object
      //   188	1	1	localIOException2	java.io.IOException
      //   197	1	1	localObject3	Object
      //   227	6	1	localIOException3	java.io.IOException
      //   235	10	1	localObject4	Object
      //   250	1	1	localObject5	Object
      //   13	228	2	localObject6	Object
      //   246	1	2	localIOException4	java.io.IOException
      //   15	155	3	localObject7	Object
      //   192	17	3	localIOException5	java.io.IOException
      //   231	4	3	localObject8	Object
      //   254	1	3	localIOException6	java.io.IOException
      //   258	1	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   10	184	4	localObject9	Object
      //   29	78	5	localFile	File
      // Exception table:
      //   from	to	target	type
      //   141	145	148	java/io/IOException
      //   18	31	152	java/io/FileNotFoundException
      //   33	44	152	java/io/FileNotFoundException
      //   46	57	152	java/io/FileNotFoundException
      //   59	70	152	java/io/FileNotFoundException
      //   94	119	152	java/io/FileNotFoundException
      //   181	185	188	java/io/IOException
      //   18	31	192	java/io/IOException
      //   33	44	192	java/io/IOException
      //   46	57	192	java/io/IOException
      //   59	70	192	java/io/IOException
      //   94	119	192	java/io/IOException
      //   220	224	227	java/io/IOException
      //   18	31	231	finally
      //   33	44	231	finally
      //   46	57	231	finally
      //   59	70	231	finally
      //   94	119	231	finally
      //   159	177	231	finally
      //   198	216	231	finally
      //   240	244	246	java/io/IOException
      //   119	141	250	finally
      //   119	141	254	java/io/IOException
      //   119	141	258	java/io/FileNotFoundException
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes-dex2jar.jar!/com/tencent/matrix/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */