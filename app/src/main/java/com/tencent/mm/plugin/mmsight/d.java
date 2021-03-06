package com.tencent.mm.plugin.mmsight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d
{
  private static float ldU = 0.01F;
  private static boolean ldV = false;
  private static int ldW = 0;
  private static int ldX = 0;
  private static ConcurrentHashMap<String, Long> ldY = new ConcurrentHashMap();
  
  public static String Hn(String paramString)
  {
    paramString = new File(String.format("%s/%s.mp4", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
    if (paramString.exists()) {
      paramString.delete();
    }
    return paramString.getAbsolutePath();
  }
  
  public static String Ho(String paramString)
  {
    try
    {
      paramString = com.tencent.mm.plugin.sight.base.d.Ho(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      x.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  public static void Hp(String paramString)
  {
    x.i("MicroMsg.MMSightUtil", "setTime key %s %s", new Object[] { paramString, bi.cjd().toString() });
    ldY.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static long Hq(String paramString)
  {
    if (ldY.containsKey(paramString))
    {
      long l = ((Long)ldY.get(paramString)).longValue();
      return System.currentTimeMillis() - l;
    }
    return 0L;
  }
  
  private static int a(String paramString, FileInputStream paramFileInputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        int n;
        return 0;
      }
      catch (IOException paramString)
      {
        continue;
      }
      int k = i;
      if (j < m)
      {
        n = j - i;
        k = i;
        if (arrayOfByte[j] == paramString.charAt(n))
        {
          if (n == paramString.length() - 1)
          {
            if ((j < 1024) && (arrayOfByte[j] != 10))
            {
              if (Character.isDigit(arrayOfByte[j]))
              {
                i = j + 1;
                if ((i < 1024) && (Character.isDigit(arrayOfByte[i])))
                {
                  i += 1;
                  continue;
                }
                i = bi.WU(new String(arrayOfByte, 0, j, i - j));
                return i;
              }
              j += 1;
              continue;
            }
            return 0;
          }
          j += 1;
          continue;
        }
      }
      int j = k + 1;
      if (j < m) {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
        }
      }
    }
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    return a(paramPoint1, paramPoint2, paramBoolean, false);
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int n = paramPoint2.x;
    int i1 = paramPoint2.y;
    int j;
    int k;
    label32:
    int i;
    if (paramBoolean1)
    {
      j = paramPoint1.y;
      if (!paramBoolean1) {
        break label194;
      }
      k = paramPoint1.x;
      int m = (int)(n * (k / j));
      i = m;
      if (m % 2 != 0) {
        i = m - 1;
      }
      float f = i1;
      j = (int)(j / k * f);
      if (!paramBoolean2) {
        break label212;
      }
      i = cP(i, paramPoint2.y);
    }
    label194:
    label212:
    for (;;)
    {
      x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(n), Integer.valueOf(i), Boolean.valueOf(paramBoolean2), Integer.valueOf(j), Boolean.valueOf(paramBoolean1) });
      if ((i <= paramPoint2.y) && (n <= paramPoint2.x))
      {
        return new Point(n, i);
        j = paramPoint1.x;
        break;
        k = paramPoint1.y;
        break label32;
      }
      x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
      return null;
    }
  }
  
  public static ArrayList<Camera.Size> a(Camera.Parameters paramParameters)
  {
    paramParameters = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort(paramParameters, new a((byte)0));
    return paramParameters;
  }
  
  public static void a(com.tencent.mm.plugin.mmsight.model.a.d paramd, SightParams paramSightParams)
  {
    Object localObject1 = paramSightParams.lep;
    Object localObject2 = paramSightParams.len;
    paramSightParams = paramSightParams.leo;
    if ((!bi.oW((String)localObject1)) && (!bi.oW((String)localObject2)) && (!bi.oW(paramSightParams)))
    {
      x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", new Object[] { localObject1, localObject2, paramSightParams });
      paramd.setFilePath((String)localObject2);
      paramd.Hr(paramSightParams);
    }
    for (;;)
    {
      paramSightParams = CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis());
      x.i("MicroMsg.MMSightUtil", "captureImagePath %s", new Object[] { paramSightParams });
      paramd.Hs(paramSightParams);
      return;
      paramSightParams = CaptureMMProxy.getInstance().getAccVideoPath();
      int i = ldW;
      ldW = i + 1;
      localObject1 = new File(String.format("%s/tempvideo%s.mp4", new Object[] { paramSightParams, Integer.valueOf(i) }));
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      localObject2 = new File(((File)localObject1).getAbsolutePath() + ".remux");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new File(((File)localObject1).getAbsoluteFile() + ".thumb");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new File(((File)localObject1).getAbsoluteFile() + ".soundmp4");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      i.C(new d.1(ldW - 3, paramSightParams));
      paramSightParams = ((File)localObject1).getAbsolutePath();
      localObject1 = bi.aG(paramSightParams, "") + ".thumb";
      x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", new Object[] { paramSightParams, localObject1 });
      paramd.setFilePath(paramSightParams);
      paramd.Hr((String)localObject1);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2)
  {
    float f;
    int i;
    int j;
    if ((paramInt3 > 0) && (Math.min(paramInt1, paramInt2) > paramInt3)) {
      if (paramInt1 < paramInt2)
      {
        f = paramInt1 * 1.0F / paramInt3;
        i = (int)(paramInt2 / f);
        j = paramInt3;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramPInt1.value = j;
      paramPInt2.value = i;
      x.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
      return bool;
      f = paramInt2 * 1.0F / paramInt3;
      j = (int)(paramInt1 / f);
      i = paramInt3;
      break;
      i = paramInt2;
      j = paramInt1;
    }
  }
  
  public static boolean a(Context paramContext, Point paramPoint, boolean paramBoolean)
  {
    paramContext = dO(paramContext);
    float f2 = paramContext.y / paramContext.x;
    if (paramBoolean) {}
    for (float f1 = paramPoint.x / paramPoint.y;; f1 = paramPoint.y / paramPoint.x)
    {
      float f3 = Math.abs(f2 - f1);
      x.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", new Object[] { paramPoint, paramContext, Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3) });
      if (f3 <= ldU) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    return b(paramPoint1, paramPoint2, paramBoolean, false);
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = paramPoint2.x;
    int m = paramPoint2.y;
    int i;
    if (paramBoolean1)
    {
      i = paramPoint1.y;
      if (!paramBoolean1) {
        break label167;
      }
    }
    label167:
    for (int j = paramPoint1.x;; j = paramPoint1.y)
    {
      float f = m;
      j = (int)(i / j * f);
      i = j;
      if (j % 2 != 0) {
        i = j + 1;
      }
      j = i;
      if (paramBoolean2) {
        j = cP(i, paramPoint2.y);
      }
      x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      if (j > paramPoint2.x) {
        break label176;
      }
      return new Point(j, m);
      i = paramPoint1.x;
      break;
    }
    label176:
    x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
    return null;
  }
  
  public static String bA(List<Camera.Size> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + " " + localSize.height * 1.0D / localSize.width + "||");
    }
    return localStringBuffer.toString();
  }
  
  public static Point bdF()
  {
    return ak.gu(ad.getContext());
  }
  
  public static String bz(List<Camera.Size> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + ";");
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = j.lin.i(Integer.valueOf(paramArrayOfByte.length));
    int i5 = paramInt1 * paramInt2;
    int m;
    int n;
    label46:
    int i1;
    if (paramInt3 % 180 != 0)
    {
      m = 1;
      if (paramInt3 % 270 == 0) {
        break label246;
      }
      n = 1;
      if (paramInt3 < 180) {
        break label252;
      }
      i1 = 1;
      label56:
      paramInt3 = 0;
    }
    for (;;)
    {
      if (paramInt3 >= paramInt2) {
        break label290;
      }
      int i = 0;
      label66:
      if (i < paramInt1)
      {
        int i6 = (paramInt3 >> 1) * paramInt1 + i5 + (i & 0xFFFFFFFE);
        int i2;
        label96:
        int i3;
        label104:
        int j;
        if (m != 0)
        {
          i2 = paramInt2;
          if (m == 0) {
            break label264;
          }
          i3 = paramInt1;
          if (m == 0) {
            break label270;
          }
          j = paramInt3;
          label112:
          if (m == 0) {
            break label277;
          }
        }
        label246:
        label252:
        label264:
        label270:
        label277:
        for (int k = i;; k = paramInt3)
        {
          int i4 = j;
          if (n != 0) {
            i4 = i2 - j - 1;
          }
          j = k;
          if (i1 != 0) {
            j = i3 - k - 1;
          }
          k = (j >> 1) * i2 + i5 + (i4 & 0xFFFFFFFE);
          arrayOfByte[(j * i2 + i4)] = ((byte)(paramArrayOfByte[(paramInt3 * paramInt1 + i)] & 0xFF));
          arrayOfByte[k] = ((byte)(paramArrayOfByte[i6] & 0xFF));
          arrayOfByte[(k + 1)] = ((byte)(paramArrayOfByte[(i6 + 1)] & 0xFF));
          i += 1;
          break label66;
          m = 0;
          break;
          n = 0;
          break label46;
          i1 = 0;
          break label56;
          i2 = paramInt1;
          break label96;
          i3 = paramInt2;
          break label104;
          j = i;
          break label112;
        }
      }
      paramInt3 += 1;
    }
    label290:
    j.lin.F(paramArrayOfByte);
    return arrayOfByte;
  }
  
  public static int cP(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % 16;
    if (i == 0) {
      return paramInt1;
    }
    int j = 16 - i + paramInt1;
    if (j < paramInt2) {
      return j;
    }
    return paramInt1 - i;
  }
  
  public static Point dO(Context paramContext)
  {
    Point localPoint = ak.gu(paramContext);
    if ((!ldV) && (ak.gt(paramContext))) {
      localPoint.y -= ak.gs(paramContext);
    }
    return localPoint;
  }
  
  /* Error */
  public static int dP(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 442	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +39 -> 44
    //   8: new 444	android/app/ActivityManager$MemoryInfo
    //   11: dup
    //   12: invokespecial 445	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: ldc_w 447
    //   21: invokevirtual 453	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 455	android/app/ActivityManager
    //   27: aload 6
    //   29: invokevirtual 459	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   32: aload 6
    //   34: getfield 463	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   37: l2d
    //   38: ldc2_w 464
    //   41: ddiv
    //   42: d2i
    //   43: ireturn
    //   44: new 135	java/io/FileInputStream
    //   47: dup
    //   48: ldc_w 467
    //   51: invokespecial 468	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_0
    //   55: ldc_w 470
    //   58: aload_0
    //   59: invokestatic 472	com/tencent/mm/plugin/mmsight/d:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: dstore_3
    //   68: dload_3
    //   69: dstore_1
    //   70: dload_3
    //   71: dconst_0
    //   72: dcmpl
    //   73: ifle +9 -> 82
    //   76: dload_3
    //   77: ldc2_w 464
    //   80: ddiv
    //   81: dstore_1
    //   82: aload_0
    //   83: invokevirtual 475	java/io/FileInputStream:close	()V
    //   86: dload_1
    //   87: d2i
    //   88: ireturn
    //   89: astore 6
    //   91: aload_0
    //   92: invokevirtual 475	java/io/FileInputStream:close	()V
    //   95: aload 6
    //   97: athrow
    //   98: astore_0
    //   99: dconst_0
    //   100: dstore_1
    //   101: goto -15 -> 86
    //   104: astore_0
    //   105: goto -19 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramContext	Context
    //   69	32	1	d1	double
    //   67	10	3	d2	double
    //   62	3	5	i	int
    //   15	18	6	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   89	7	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	89	finally
    //   44	55	98	java/io/IOException
    //   91	98	98	java/io/IOException
    //   82	86	104	java/io/IOException
  }
  
  public static void gs(boolean paramBoolean)
  {
    ldV = paramBoolean;
  }
  
  public static Bitmap mZ(String paramString)
  {
    Object localObject;
    if ((bi.oW(paramString)) || (!FileOp.cn(paramString)))
    {
      x.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", new Object[] { paramString });
      localObject = null;
      return (Bitmap)localObject;
    }
    x.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        int j = bi.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), -1);
        int i = bi.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), -1);
        int k = SightVideoJNI.getMp4Rotate(paramString);
        x.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
        Bitmap localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(0L, 2);
        ((MediaMetadataRetriever)localObject).release();
        localObject = localBitmap;
        if (localBitmap != null) {
          break;
        }
        x.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
        if ((j <= 0) || (i <= 0))
        {
          localObject = SightVideoJNI.getSimpleMp4Info(paramString);
          x.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          j = ((JSONObject)localObject).getInt("videoWidth");
          i = ((JSONObject)localObject).getInt("videoHeight");
          paramString = MP4MuxerJNI.getVideoThumb(paramString, j, i);
          if (paramString == null)
          {
            x.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
            return null;
          }
          localObject = ByteBuffer.wrap(paramString);
          paramString = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
          paramString.copyPixelsFromBuffer((Buffer)localObject);
          localObject = paramString;
          if (k <= 0) {
            break;
          }
          paramString = c.b(paramString, k);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        x.printErrStackTrace("MicroMsg.MMSightUtil", paramString, "get video thumb error! %s", new Object[] { paramString.getMessage() });
        return null;
      }
    }
  }
  
  public static String oN(String paramString)
  {
    return e.dgl + String.format("%s%d.%s", new Object[] { "wx_camera_", Long.valueOf(System.currentTimeMillis()), paramString });
  }
  
  public static boolean sL(int paramInt)
  {
    return paramInt % 16 == 0;
  }
  
  public static int sM(int paramInt)
  {
    return cP(paramInt, Integer.MAX_VALUE);
  }
  
  public static int sN(int paramInt)
  {
    int i = paramInt % 32;
    if (i == 0) {
      return paramInt;
    }
    int j = paramInt - (32 - i);
    if (j < Integer.MAX_VALUE) {
      return j;
    }
    return paramInt - i;
  }
  
  private static final class a
    implements Comparator<Camera.Size>
  {}
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes2-dex2jar.jar!/com/tencent/mm/plugin/mmsight/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */