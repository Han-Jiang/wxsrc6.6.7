package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

public final class bi
{
  private static final TimeZone GMT;
  public static final long[] eyq = { 300L, 200L, 300L, 200L };
  private static final char[] gBx = { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
  private static final String[] gBy = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  private static final long[] sJE = { 300L, 50L, 300L, 50L };
  private static final BigInteger sJF;
  
  static
  {
    GMT = TimeZone.getTimeZone("GMT");
    sJF = BigInteger.ONE.shiftLeft(64);
  }
  
  public static String A(double paramDouble)
  {
    return String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
  }
  
  public static List<ResolveInfo> B(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return null;
    }
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
  }
  
  public static Intent C(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 0);
    if ((paramContext == null) || (paramContext.size() != 1)) {
      return null;
    }
    Object localObject = (ResolveInfo)paramContext.get(0);
    paramContext = ((ResolveInfo)localObject).serviceInfo.packageName;
    localObject = ((ResolveInfo)localObject).serviceInfo.name;
    x.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", new Object[] { paramContext, localObject });
    paramContext = new ComponentName(paramContext, (String)localObject);
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(paramContext);
    return paramIntent;
  }
  
  public static String Dc(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(localRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static ArrayList<String> F(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static String Fx(String paramString)
  {
    return paramString.replaceAll("[\\.\\-]", "").trim();
  }
  
  public static boolean G(String... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (oW(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean K(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean K(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() <= 0);
  }
  
  public static CharSequence L(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if ((c >= '0') && (c <= '9')) {
        localStringBuffer.append(c);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean L(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!k(paramContext, localIntent))
    {
      x.e("MicroMsg.Util", "jump to url failed, " + paramString);
      return false;
    }
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static String T(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return "(null)";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = paramArrayOfByte.length;
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp25_23 = arrayOfChar1;
    tmp25_23[0] = 48;
    char[] tmp31_25 = tmp25_23;
    tmp31_25[1] = 49;
    char[] tmp37_31 = tmp31_25;
    tmp37_31[2] = 50;
    char[] tmp43_37 = tmp37_31;
    tmp43_37[3] = 51;
    char[] tmp49_43 = tmp43_37;
    tmp49_43[4] = 52;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[5] = 53;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[6] = 54;
    char[] tmp68_61 = tmp61_55;
    tmp68_61[7] = 55;
    char[] tmp75_68 = tmp68_61;
    tmp75_68[8] = 56;
    char[] tmp82_75 = tmp75_68;
    tmp82_75[9] = 57;
    char[] tmp89_82 = tmp82_75;
    tmp89_82[10] = 97;
    char[] tmp96_89 = tmp89_82;
    tmp96_89[11] = 98;
    char[] tmp103_96 = tmp96_89;
    tmp103_96[12] = 99;
    char[] tmp110_103 = tmp103_96;
    tmp110_103[13] = 100;
    char[] tmp117_110 = tmp110_103;
    tmp117_110[14] = 101;
    char[] tmp124_117 = tmp117_110;
    tmp124_117[15] = 102;
    tmp124_117;
    char[] arrayOfChar2 = new char[i * 3 + i / 16];
    int j = 0;
    paramInt = 0;
    if (j < i + 0)
    {
      int k = paramArrayOfByte[j];
      int m = paramInt + 1;
      arrayOfChar2[paramInt] = ' ';
      int n = m + 1;
      arrayOfChar2[m] = arrayOfChar1[(k >>> 4 & 0xF)];
      paramInt = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(k & 0xF)];
      if ((j % 16 != 0) || (j <= 0)) {
        break label252;
      }
      k = paramInt + 1;
      arrayOfChar2[paramInt] = '\n';
      paramInt = k;
    }
    label252:
    for (;;)
    {
      j += 1;
      break;
      return new String(arrayOfChar2);
    }
  }
  
  public static byte[] U(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    x.i("MicroMsg.Util", "recycle bitmap:%s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      x.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public static long VE()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long VF()
  {
    return System.currentTimeMillis();
  }
  
  public static long VG()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static String WB(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("../", "");
    }
    return str;
  }
  
  public static boolean WC(String paramString)
  {
    if (oW(paramString)) {
      return false;
    }
    return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(paramString).find();
  }
  
  public static boolean WD(String paramString)
  {
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean WE(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return false;
      paramString = paramString.trim();
      try
      {
        long l = Long.valueOf(paramString).longValue();
        if ((l > 0L) && (l <= 4294967295L)) {
          return true;
        }
      }
      catch (NumberFormatException paramString)
      {
        x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return false;
  }
  
  public static boolean WF(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
  }
  
  public static boolean WG(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.trim();
    } while ((paramString.length() < 6) || (paramString.length() > 20) || (!o(paramString.charAt(0))));
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label89;
      }
      char c = paramString.charAt(i);
      if ((!o(c)) && (!p(c)) && (c != '-') && (c != '_')) {
        break;
      }
      i += 1;
    }
    label89:
    return true;
  }
  
  public static boolean WH(String paramString)
  {
    if (paramString == null) {}
    while (paramString.length() < 8) {
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      return false;
    }
    catch (NumberFormatException paramString) {}
    return true;
  }
  
  public static Intent WI(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      return localIntent;
    }
  }
  
  public static int WJ(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return paramString.length();
  }
  
  public static int WK(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return paramString.getBytes(Charset.forName("UTF-8")).length;
  }
  
  public static int WL(String paramString)
  {
    if (oW(paramString)) {
      return 0;
    }
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      return (int)l;
    }
    catch (Exception paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return 0;
  }
  
  public static int WM(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      long l = Long.decode(paramString).longValue();
      return (int)(l & 0xFFFFFFFF);
    }
    catch (NumberFormatException paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return 0;
  }
  
  public static String WN(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16) {
      return g.u(str.getBytes());
    }
    return g.u(str.substring(0, 16).getBytes());
  }
  
  public static String WO(String paramString)
  {
    return g.u(paramString.getBytes());
  }
  
  public static byte[] WP(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() <= 0)) {
      localObject = new byte[0];
    }
    for (;;)
    {
      return (byte[])localObject;
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfByte;
          if (i >= arrayOfByte.length) {
            break;
          }
          arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16) & 0xFF));
          i += 1;
        }
        return new byte[0];
      }
      catch (NumberFormatException paramString)
      {
        x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
  }
  
  public static int[] WQ(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.split(":");
    paramString = new ArrayList();
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = localObject[i];
        if ((str != null) && (str.length() > 0)) {}
        try
        {
          paramString.add(Integer.valueOf(Integer.valueOf(str).intValue()));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            x.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            x.e("MicroMsg.Util", "invalid port num, ignore");
          }
        }
      }
    }
    localObject = new int[paramString.size()];
    i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramString.get(i)).intValue();
      i += 1;
    }
    return (int[])localObject;
  }
  
  public static final String WR(String paramString)
  {
    if (oW(paramString)) {
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      x.printErrStackTrace("MicroMsg.Util", localMalformedURLException, "", new Object[0]);
      x.w("MicroMsg.Util", "get host error");
    }
    return paramString;
  }
  
  public static String WS(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = gBx.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (gBx[j] == c)
          {
            localStringBuffer.append(gBy[j]);
            k = 0;
          }
        }
        else
        {
          if (k != 0) {
            localStringBuffer.append(c);
          }
          i += 1;
          break;
        }
        j -= 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String WT(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (Build.VERSION.SDK_INT >= 8) {
      return paramString;
    }
    int n = paramString.length();
    char[] arrayOfChar = new char[n];
    int k = 0;
    int m = 0;
    int j = -1;
    char c;
    int i;
    if (k < n)
    {
      c = paramString.charAt(k);
      i = m + 1;
      arrayOfChar[m] = c;
      if ((c == '&') && (j == -1))
      {
        m = i;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = i;
      break;
      if ((j != -1) && (!Character.isLetter(c)) && (!Character.isDigit(c)) && (c != '#'))
      {
        if (c == ';')
        {
          m = a(arrayOfChar, j, i - j - 1);
          if (m > 65535)
          {
            i = m - 65536;
            arrayOfChar[(j - 1)] = ((char)((i >> 10) + 55296));
            arrayOfChar[j] = ((char)((i & 0x3FF) + 56320));
            j += 1;
          }
        }
        for (;;)
        {
          i = j;
          j = -1;
          break;
          if (m != 0)
          {
            arrayOfChar[(j - 1)] = ((char)m);
            continue;
            j = -1;
            break;
            return new String(arrayOfChar, 0, m);
          }
          j = i;
        }
      }
    }
  }
  
  public static int WU(String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
    }
    catch (Exception localException)
    {
      while (paramString == null) {}
      x.e("MicroMsg.Util", "parserInt error " + paramString);
    }
    return i;
    return 0;
  }
  
  public static long WV(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      while (paramString == null) {}
      x.e("MicroMsg.Util", "parseLong error " + paramString);
    }
    return l1;
    return 0L;
  }
  
  public static double WW(String paramString)
  {
    double d1 = 0.0D;
    try
    {
      double d2 = Double.parseDouble(paramString);
      d1 = d2;
    }
    catch (Exception localException)
    {
      while (paramString == null) {}
      x.e("MicroMsg.Util", "parseDouble error " + paramString);
    }
    return d1;
    return 0.0D;
  }
  
  public static float WX(String paramString)
  {
    float f1 = 0.0F;
    try
    {
      float f2 = Float.parseFloat(paramString);
      f1 = f2;
    }
    catch (Exception localException)
    {
      while (paramString == null) {}
      x.e("MicroMsg.Util", "parseFloat error " + paramString);
    }
    return f1;
    return 0.0F;
  }
  
  public static byte[] WY(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      x.e("MicroMsg.Util", "httpGet, url is null");
      return null;
    }
    if (URLUtil.isDataUrl(paramString)) {
      return Xb(paramString);
    }
    if (URLUtil.isHttpsUrl(paramString)) {
      return Xa(paramString);
    }
    return WZ(paramString);
  }
  
  private static byte[] WZ(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestMethod("GET");
      int i = paramString.getResponseCode();
      if (i != 200)
      {
        x.e("MicroMsg.Util", "http get response code = %d", new Object[] { Integer.valueOf(i) });
        return null;
      }
      paramString = new BufferedInputStream(paramString.getInputStream());
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (i = paramString.read(arrayOfByte); i > 0; i = paramString.read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      paramString.close();
      localByteArrayOutputStream.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      x.e("MicroMsg.Util", "http download failed : %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  private static byte[] Xa(String paramString)
  {
    try
    {
      paramString = (HttpsURLConnection)new URL(paramString).openConnection();
      paramString.setRequestMethod("GET");
      int i = paramString.getResponseCode();
      if (i != 200)
      {
        x.e("MicroMsg.Util", "https get response code = %d", new Object[] { Integer.valueOf(i) });
        return null;
      }
      paramString = new BufferedInputStream(paramString.getInputStream());
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (i = paramString.read(arrayOfByte); i > 0; i = paramString.read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      paramString.close();
      localByteArrayOutputStream.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      x.e("MicroMsg.Util", "getHttpsData failed : %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  private static byte[] Xb(String paramString)
  {
    try
    {
      int i = paramString.indexOf("base64");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 7);
      }
      paramString = Base64.decode(str, 0);
      return paramString;
    }
    catch (Exception paramString)
    {
      x.e("MicroMsg.Util", "decode base64 url failed : %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  public static String Xc(String paramString)
  {
    int i = 0;
    if ((oW(paramString)) || (paramString.startsWith("+"))) {
      localObject = "";
    }
    do
    {
      return (String)localObject;
      localObject = paramString;
    } while (paramString.length() <= 5);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(paramString.subSequence(0, 3));
    if (i < paramString.length() - 5)
    {
      char c = paramString.charAt(i + 3);
      if ((c >= '0') && (c <= '9')) {
        ((StringBuffer)localObject).append('*');
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuffer)localObject).append(c);
      }
    }
    ((StringBuffer)localObject).append(paramString.charAt(paramString.length() - 2));
    ((StringBuffer)localObject).append(paramString.charAt(paramString.length() - 1));
    return ((StringBuffer)localObject).toString();
  }
  
  public static Boolean Xd(String paramString)
  {
    Matcher localMatcher = Pattern.compile("^[+][0-9]{10,13}$").matcher(paramString);
    paramString = Pattern.compile("^1[0-9]{10}$").matcher(paramString);
    if ((localMatcher.matches()) || (paramString.matches())) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String Xe(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf("@");
        str = paramString;
        if (i != -1) {
          str = paramString.substring(0, i);
        }
      }
    }
    return str;
  }
  
  public static String Xf(String paramString)
  {
    if (oW(paramString)) {
      return "";
    }
    int i = paramString.length();
    if (i < 4) {
      return "*~" + i;
    }
    if (i < 8) {
      return paramString.substring(0, 1) + "*" + paramString.substring(i - 2, i - 1) + "~" + i;
    }
    return paramString.substring(0, 2) + "*" + paramString.substring(i - 3, i - 1) + "~" + i;
  }
  
  public static boolean Xg(String paramString)
  {
    if (oW(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString).getCanonicalPath();
        if (paramString.contains("/com.tencent.mm/cache/")) {
          return true;
        }
        if (!paramString.contains("/com.tencent.mm/")) {
          return true;
        }
      }
      catch (IOException paramString) {}
    }
    return false;
  }
  
  public static boolean Xh(String paramString)
  {
    if (oW(paramString)) {}
    int i;
    do
    {
      return false;
      i = paramString.lastIndexOf(".");
    } while (i == -1);
    return Xi(paramString.substring(i + 1));
  }
  
  public static boolean Xi(String paramString)
  {
    if (oW(paramString)) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if ((paramString.equals("webp")) && (Build.VERSION.SDK_INT >= 14)) {
        return true;
      }
    } while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("jpeg")) && (!paramString.equals("png")));
    return true;
  }
  
  public static String Xj(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    int i = paramString.length();
    for (;;)
    {
      str = paramString;
      if (i <= 0) {
        break;
      }
      if ((paramString.charAt(i - 1) != '\n') && (paramString.charAt(i - 1) != '\r')) {
        return paramString.substring(0, i);
      }
      i -= 1;
    }
  }
  
  public static String Xk(String paramString)
  {
    if (oW(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("‮", "");
  }
  
  public static final String Xl(String paramString)
  {
    if (oW(paramString)) {
      return null;
    }
    return Uri.parse(paramString).getHost();
  }
  
  public static int a(Integer paramInteger, int paramInt)
  {
    if (paramInteger == null) {
      return paramInt;
    }
    return paramInteger.intValue();
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return 0;
    }
    if ((paramArrayOfChar[paramInt1] != '#') || ((paramInt2 > 1) && ((paramArrayOfChar[(paramInt1 + 1)] == 'x') || (paramArrayOfChar[(paramInt1 + 1)] == 'X')))) {}
    for (;;)
    {
      try
      {
        paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
        return paramInt1;
      }
      catch (NumberFormatException paramArrayOfChar) {}
      try
      {
        paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
        return paramInt1;
      }
      catch (NumberFormatException paramArrayOfChar)
      {
        return 0;
      }
    }
    new String(paramArrayOfChar, paramInt1, paramInt2);
    return 0;
    return 0;
  }
  
  public static long a(Long paramLong, long paramLong1)
  {
    if (paramLong == null) {
      return paramLong1;
    }
    return paramLong.longValue();
  }
  
  public static String a(long paramLong, double paramDouble)
  {
    paramDouble = Math.round(paramLong * paramDouble / 1048576.0D) / paramDouble;
    return paramDouble + " MB";
  }
  
  /* Error */
  private static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 774	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 67	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 776
    //   17: aastore
    //   18: aload_2
    //   19: aload_3
    //   20: aconst_null
    //   21: invokevirtual 782	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +80 -> 106
    //   29: aload_2
    //   30: invokeinterface 787 1 0
    //   35: ifeq +71 -> 106
    //   38: aload_2
    //   39: ldc_w 776
    //   42: invokeinterface 790 2 0
    //   47: istore 4
    //   49: iload 4
    //   51: iconst_m1
    //   52: if_icmpne +31 -> 83
    //   55: ldc -105
    //   57: ldc_w 792
    //   60: invokestatic 271	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_2
    //   64: invokeinterface 793 1 0
    //   69: aload_2
    //   70: ifnull +9 -> 79
    //   73: aload_2
    //   74: invokeinterface 793 1 0
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: areturn
    //   83: aload_2
    //   84: iload 4
    //   86: invokeinterface 796 2 0
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: ifnull -14 -> 81
    //   98: aload_2
    //   99: invokeinterface 793 1 0
    //   104: aload_1
    //   105: areturn
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 793 1 0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aload 5
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +9 -> 132
    //   126: aload_1
    //   127: invokeinterface 793 1 0
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: aload_2
    //   136: astore_1
    //   137: goto -15 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   0	140	1	paramUri	Uri
    //   0	140	2	paramString	String
    //   0	140	3	paramArrayOfString	String[]
    //   47	38	4	i	int
    //   1	119	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	118	finally
    //   29	49	134	finally
    //   55	69	134	finally
    //   83	92	134	finally
  }
  
  public static String a(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<key>");
    Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramLinkedHashMap = (Map.Entry)localIterator.next();
      Object localObject1 = paramLinkedHashMap.getKey();
      Object localObject2 = paramLinkedHashMap.getValue();
      paramLinkedHashMap = (LinkedHashMap<String, String>)localObject1;
      if (localObject1 == null) {
        paramLinkedHashMap = "unknow";
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknow";
      }
      localStringBuilder.append("<" + paramLinkedHashMap + ">");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("</" + paramLinkedHashMap + ">");
    }
    localStringBuilder.append("</key>");
    return localStringBuilder.toString();
  }
  
  public static boolean a(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return paramBoolean1;
    }
    return paramBoolean.booleanValue();
  }
  
  public static String aG(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static int aH(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    return paramArrayOfByte.getInt();
  }
  
  public static String aj(float paramFloat)
  {
    if (paramFloat < 1024.0F) {
      return String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
    }
    if (paramFloat < 1048576.0F) {
      return String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
    }
    if (paramFloat < 1.07374182E9F) {
      return String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
    }
    return String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
  }
  
  public static ActivityManager.RunningTaskInfo am(Context paramContext, int paramInt)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1000).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
      if (localRunningTaskInfo.id == paramInt) {
        return localRunningTaskInfo;
      }
    }
    return null;
  }
  
  /* Error */
  public static String an(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: iload_1
    //   5: ifgt +6 -> 11
    //   8: ldc -39
    //   10: areturn
    //   11: aload_0
    //   12: ldc_w 887
    //   15: invokevirtual 891	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 893	android/app/ActivityManager
    //   21: invokevirtual 909	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   24: invokeinterface 898 1 0
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface 816 1 0
    //   36: ifeq +65 -> 101
    //   39: aload_0
    //   40: invokeinterface 820 1 0
    //   45: checkcast 911	android/app/ActivityManager$RunningAppProcessInfo
    //   48: astore 4
    //   50: aload 4
    //   52: getfield 914	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   55: iload_1
    //   56: if_icmpne -26 -> 30
    //   59: aload 4
    //   61: getfield 917	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   64: ifnull -34 -> 30
    //   67: aload 4
    //   69: getfield 917	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   72: ldc -39
    //   74: invokevirtual 420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne -47 -> 30
    //   80: aload 4
    //   82: getfield 917	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: ldc -105
    //   91: aload_0
    //   92: ldc -39
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: sipush 128
    //   104: newarray <illegal type>
    //   106: astore 5
    //   108: new 919	java/io/FileInputStream
    //   111: dup
    //   112: new 259	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 921
    //   119: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: iload_1
    //   123: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 923
    //   129: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 924	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   138: astore 4
    //   140: aload 4
    //   142: astore_0
    //   143: aload 4
    //   145: aload 5
    //   147: invokevirtual 925	java/io/FileInputStream:read	([B)I
    //   150: istore_3
    //   151: iload_3
    //   152: ifle +43 -> 195
    //   155: iconst_0
    //   156: istore_1
    //   157: goto +117 -> 274
    //   160: aload 4
    //   162: astore_0
    //   163: new 67	java/lang/String
    //   166: dup
    //   167: aload 5
    //   169: iconst_0
    //   170: iload_2
    //   171: invokespecial 927	java/lang/String:<init>	([BII)V
    //   174: astore 5
    //   176: aload 4
    //   178: invokevirtual 928	java/io/FileInputStream:close	()V
    //   181: aload 5
    //   183: areturn
    //   184: astore_0
    //   185: aload 5
    //   187: areturn
    //   188: iload_1
    //   189: iconst_1
    //   190: iadd
    //   191: istore_1
    //   192: goto +82 -> 274
    //   195: aload 4
    //   197: invokevirtual 928	java/io/FileInputStream:close	()V
    //   200: ldc -39
    //   202: areturn
    //   203: astore 5
    //   205: aconst_null
    //   206: astore 4
    //   208: aload 4
    //   210: astore_0
    //   211: ldc -105
    //   213: aload 5
    //   215: ldc -39
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload 4
    //   226: ifnull -26 -> 200
    //   229: aload 4
    //   231: invokevirtual 928	java/io/FileInputStream:close	()V
    //   234: goto -34 -> 200
    //   237: astore_0
    //   238: goto -38 -> 200
    //   241: astore 4
    //   243: aconst_null
    //   244: astore_0
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 928	java/io/FileInputStream:close	()V
    //   253: aload 4
    //   255: athrow
    //   256: astore_0
    //   257: goto -57 -> 200
    //   260: astore_0
    //   261: goto -8 -> 253
    //   264: astore 4
    //   266: goto -21 -> 245
    //   269: astore 5
    //   271: goto -63 -> 208
    //   274: iload_3
    //   275: istore_2
    //   276: iload_1
    //   277: iload_3
    //   278: if_icmpge -118 -> 160
    //   281: aload 5
    //   283: iload_1
    //   284: baload
    //   285: sipush 128
    //   288: if_icmpgt +10 -> 298
    //   291: aload 5
    //   293: iload_1
    //   294: baload
    //   295: ifgt -107 -> 188
    //   298: iload_1
    //   299: istore_2
    //   300: goto -140 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	Context
    //   0	303	1	paramInt	int
    //   170	130	2	i	int
    //   150	129	3	j	int
    //   48	182	4	localObject1	Object
    //   241	13	4	localObject2	Object
    //   264	1	4	localObject3	Object
    //   106	80	5	localObject4	Object
    //   203	11	5	localException1	Exception
    //   269	23	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	30	88	java/lang/Exception
    //   30	86	88	java/lang/Exception
    //   176	181	184	java/lang/Exception
    //   108	140	203	java/lang/Exception
    //   229	234	237	java/lang/Exception
    //   108	140	241	finally
    //   195	200	256	java/lang/Exception
    //   249	253	260	java/lang/Exception
    //   143	151	264	finally
    //   163	176	264	finally
    //   211	224	264	finally
    //   143	151	269	java/lang/Exception
    //   163	176	269	java/lang/Exception
  }
  
  public static String b(long paramLong, double paramDouble)
  {
    paramDouble = Math.round(paramLong * paramDouble / 1.073741824E9D) / paramDouble;
    return paramDouble + " GB";
  }
  
  public static String bA(byte[] paramArrayOfByte)
  {
    return T(paramArrayOfByte, 0);
  }
  
  public static String bB(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "(null)";
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp16_14 = arrayOfChar1;
    tmp16_14[0] = 48;
    char[] tmp22_16 = tmp16_14;
    tmp22_16[1] = 49;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[2] = 50;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[3] = 51;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[4] = 52;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[5] = 53;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[6] = 54;
    char[] tmp59_52 = tmp52_46;
    tmp59_52[7] = 55;
    char[] tmp66_59 = tmp59_52;
    tmp66_59[8] = 56;
    char[] tmp73_66 = tmp66_59;
    tmp73_66[9] = 57;
    char[] tmp80_73 = tmp73_66;
    tmp80_73[10] = 97;
    char[] tmp87_80 = tmp80_73;
    tmp87_80[11] = 98;
    char[] tmp94_87 = tmp87_80;
    tmp94_87[12] = 99;
    char[] tmp101_94 = tmp94_87;
    tmp101_94[13] = 100;
    char[] tmp108_101 = tmp101_94;
    tmp108_101[14] = 101;
    char[] tmp115_108 = tmp108_101;
    tmp115_108[15] = 102;
    tmp115_108;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k * 3];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = ' ';
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m >>> 4 & 0xF)];
      arrayOfChar2[j] = arrayOfChar1[(m & 0xF)];
      i += 1;
      j += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static boolean bC(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static int bD(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte.length;
  }
  
  public static String bE(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String bF(long paramLong)
  {
    if (paramLong >> 30 > 0L) {
      return b(paramLong, 10.0D);
    }
    if (paramLong >> 20 > 0L) {
      return a(paramLong, 10.0D);
    }
    if (paramLong >> 9 > 0L)
    {
      double d = Math.round(paramLong * 10.0D / 1024.0D) / 10.0D;
      return d + " KB";
    }
    return paramLong + " B";
  }
  
  public static long bG(long paramLong)
  {
    return System.currentTimeMillis() / 1000L - paramLong;
  }
  
  public static long bH(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static long bI(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  public static String bQ(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      x.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
    }
    return "(null)";
  }
  
  public static int bc(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception localException)
    {
      x.printErrStackTrace("MicroMsg.Util", localException, "colorString:%s", new Object[] { paramString });
    }
    return paramInt;
  }
  
  public static boolean br(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getClassName().toString().equals(paramString)))
      {
        x.w("MicroMsg.Util", "service " + paramString + " is running");
        return true;
      }
    }
    x.w("MicroMsg.Util", "service " + paramString + " is not running");
    return false;
  }
  
  public static boolean bs(Context paramContext, String paramString)
  {
    do
    {
      try
      {
        if ((paramString.equals("com.tencent.mm")) || (paramString.startsWith("com.tencent.mm:")) || (Build.VERSION.SDK_INT < 21))
        {
          x.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", new Object[] { paramString });
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
          if (paramContext == null) {
            return false;
          }
          paramContext = paramContext.iterator();
          do
          {
            if (!paramContext.hasNext()) {
              break;
            }
            localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          } while ((localObject == null) || (((ActivityManager.RunningAppProcessInfo)localObject).processName == null) || (!((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(paramString)));
          x.w("MicroMsg.Util", "process " + paramString + " is running");
          return true;
        }
        x.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", new Object[] { paramString });
        paramContext = cjf().iterator();
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
          localObject = (String)paramContext.next();
          x.d("MicroMsg.Util", "isProcessRunning, process command line = %s", new Object[] { localObject });
        } while ((localObject == null) || (!((String)localObject).contains(paramString)));
        localObject = ((String)localObject).split("\\s+");
        i = 0;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Object localObject;
          int i;
          x.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
          continue;
          i += 1;
        }
      }
    } while (i >= localObject.length);
    if (paramString.equals(localObject[i]))
    {
      x.i("MicroMsg.Util", "process %s is running", new Object[] { paramString });
      return true;
      x.w("MicroMsg.Util", "process " + paramString + " is not running");
      return false;
    }
  }
  
  public static long c(Long paramLong)
  {
    if (paramLong == null) {
      return 0L;
    }
    return paramLong.longValue();
  }
  
  public static String c(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (i == paramList.size() - 1) {
        localStringBuilder.append(((String)paramList.get(i)).trim());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(((String)paramList.get(i)).trim() + paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean c(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return true;
    }
    return paramBoolean.booleanValue();
  }
  
  public static String[] cW(List<String> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  public static boolean cX(List paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static String cg(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.toString();
    }
    return "null";
  }
  
  public static long ch(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof Long)) {
      return 0L;
    }
    return ((Long)paramObject).longValue();
  }
  
  public static boolean ci(Context paramContext)
  {
    String str = paramContext.getClass().getName();
    paramContext = bQ(paramContext);
    x.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    return paramContext.equalsIgnoreCase(str);
  }
  
  public static byte[] ciV()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/dev/urandom");
      byte[] arrayOfByte = new byte[16];
      int i = localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      if (i == 16) {
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      x.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      UUID localUUID = UUID.randomUUID();
      return g.v((localUUID.toString() + System.currentTimeMillis()).getBytes());
    }
  }
  
  public static boolean ciW()
  {
    int i = new GregorianCalendar().get(11);
    return (i >= 6L) && (i < 18L);
  }
  
  public static String ciX()
  {
    TimeZone localTimeZone = TimeZone.getDefault();
    int j = localTimeZone.getRawOffset() / 1000;
    if ((localTimeZone.useDaylightTime()) && (localTimeZone.inDaylightTime(new java.sql.Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0) {
      return String.format("%.2f", new Object[] { Double.valueOf(j / 3600.0D + i) });
    }
  }
  
  public static long ciY()
  {
    return System.currentTimeMillis() / 86400000L * 86400000L;
  }
  
  public static long ciZ()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static long cja()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        l1 = localStatFs.getBlockSize();
        return localStatFs.getAvailableBlocks() * l1;
      }
      long l1 = localStatFs.getBlockSizeLong();
      long l2 = localStatFs.getAvailableBlocksLong();
      return l2 * l1;
    }
    catch (Exception localException)
    {
      x.e("MicroMsg.Util", "getDataAvailableSize exception:%s", new Object[] { localException.getMessage() });
    }
    return 0L;
  }
  
  public static View.OnTouchListener cjb()
  {
    new View.OnTouchListener()
    {
      public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          return false;
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              paramAnonymousView.setPressed(false);
            }
          });
          continue;
          paramAnonymousView.setPressed(true);
        }
      }
    };
  }
  
  public static int cjc()
  {
    return new Random().nextInt();
  }
  
  public static aj cjd()
  {
    return new aj();
  }
  
  public static boolean cje()
  {
    String str = System.getProperty("java.vm.version");
    return (!oW(str)) && (str.startsWith("2"));
  }
  
  /* Error */
  private static List<String> cjf()
  {
    // Byte code:
    //   0: new 205	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 206	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: invokestatic 1172	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: ldc_w 1174
    //   14: invokevirtual 1178	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   17: astore_2
    //   18: new 1180	java/io/LineNumberReader
    //   21: dup
    //   22: new 1182	java/io/InputStreamReader
    //   25: dup
    //   26: aload_2
    //   27: invokevirtual 1185	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   30: invokespecial 1186	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 1189	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 1192	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +83 -> 130
    //   50: aload_1
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 386	java/lang/String:length	()I
    //   57: ifle -20 -> 37
    //   60: aload_1
    //   61: astore_0
    //   62: aload_3
    //   63: aload 4
    //   65: invokeinterface 518 2 0
    //   70: pop
    //   71: goto -34 -> 37
    //   74: astore_2
    //   75: aload_1
    //   76: astore_0
    //   77: ldc -105
    //   79: ldc_w 1194
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_2
    //   89: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 624	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 1195	java/io/LineNumberReader:close	()V
    //   104: ldc -105
    //   106: ldc_w 1197
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_3
    //   116: invokeinterface 130 1 0
    //   121: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 321	com/tencent/mm/sdk/platformtools/x:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: areturn
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: invokevirtual 1200	java/lang/Process:waitFor	()I
    //   136: pop
    //   137: aload_1
    //   138: astore_0
    //   139: aload_2
    //   140: invokevirtual 1203	java/lang/Process:destroy	()V
    //   143: aload_1
    //   144: invokevirtual 1195	java/io/LineNumberReader:close	()V
    //   147: goto -43 -> 104
    //   150: astore_0
    //   151: ldc -105
    //   153: ldc_w 1205
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_0
    //   163: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 624	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: goto -66 -> 104
    //   173: astore_0
    //   174: ldc -105
    //   176: ldc_w 1205
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 624	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -89 -> 104
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 1195	java/io/LineNumberReader:close	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_0
    //   210: ldc -105
    //   212: ldc_w 1205
    //   215: iconst_1
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_0
    //   222: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 624	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -22 -> 207
    //   232: astore_1
    //   233: goto -34 -> 199
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -164 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	101	0	localLineNumberReader1	java.io.LineNumberReader
    //   150	13	0	localException1	Exception
    //   173	13	0	localException2	Exception
    //   198	6	0	localObject1	Object
    //   209	13	0	localException3	Exception
    //   36	108	1	localLineNumberReader2	java.io.LineNumberReader
    //   196	12	1	localObject2	Object
    //   232	1	1	localObject3	Object
    //   238	1	1	localObject4	Object
    //   17	10	2	localProcess	Process
    //   74	66	2	localException4	Exception
    //   236	1	2	localException5	Exception
    //   7	122	3	localArrayList	ArrayList
    //   43	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   39	45	74	java/lang/Exception
    //   52	60	74	java/lang/Exception
    //   62	71	74	java/lang/Exception
    //   132	137	74	java/lang/Exception
    //   139	143	74	java/lang/Exception
    //   143	147	150	java/lang/Exception
    //   100	104	173	java/lang/Exception
    //   8	37	196	finally
    //   203	207	209	java/lang/Exception
    //   39	45	232	finally
    //   52	60	232	finally
    //   62	71	232	finally
    //   77	96	232	finally
    //   132	137	232	finally
    //   139	143	232	finally
    //   8	37	236	java/lang/Exception
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      x.printErrStackTrace("MicroMsg.Util", localIOException, "", new Object[0]);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static void d(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      x.printErrStackTrace("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
    }
  }
  
  public static boolean d(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (oW(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return true;
      }
    } while (paramString.isDirectory());
    return paramString.delete();
  }
  
  public static int eF(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      return new Random(System.currentTimeMillis()).nextInt(paramInt1 - paramInt2 + 1) + paramInt2;
    }
  }
  
  public static boolean eG(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static int f(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  public static void fO(Context paramContext)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null) {
      return;
    }
    paramContext.vibrate(sJE, -1);
  }
  
  public static String fP(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.trim();
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      x.e("MicroMsg.Util", "summerdeviceid getDeviceId failed, security exception[%s]", new Object[] { paramContext });
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        x.printErrStackTrace("MicroMsg.Util", paramContext, "summerdeviceid", new Object[0]);
      }
    }
  }
  
  public static long fQ(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return 0L;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L / 1024L;
  }
  
  public static List<String> fQ(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return Collections.EMPTY_LIST;
    }
    paramString1 = paramString1.split(paramString2);
    if (paramString1 == null) {
      return Collections.EMPTY_LIST;
    }
    return Arrays.asList(paramString1);
  }
  
  /* Error */
  public static int fR(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 1304	java/util/zip/ZipInputStream
    //   3: dup
    //   4: new 919	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 924	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 1305	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_0
    //   18: aload_3
    //   19: invokevirtual 1309	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +283 -> 309
    //   29: aload_3
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 1312	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   36: astore 5
    //   38: aload_3
    //   39: astore_0
    //   40: aload 5
    //   42: ldc_w 354
    //   45: invokevirtual 724	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   48: ifne -32 -> 16
    //   51: aload_3
    //   52: astore_0
    //   53: aload 5
    //   55: ldc_w 1314
    //   58: invokevirtual 724	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifne -45 -> 16
    //   64: aload_3
    //   65: astore_0
    //   66: aload 4
    //   68: invokevirtual 1315	java/util/zip/ZipEntry:isDirectory	()Z
    //   71: ifeq +86 -> 157
    //   74: aload_3
    //   75: astore_0
    //   76: aload 5
    //   78: iconst_0
    //   79: aload 5
    //   81: invokevirtual 386	java/lang/String:length	()I
    //   84: iconst_1
    //   85: isub
    //   86: invokevirtual 491	java/lang/String:substring	(II)Ljava/lang/String;
    //   89: astore 4
    //   91: aload_3
    //   92: astore_0
    //   93: new 434	java/io/File
    //   96: dup
    //   97: new 259	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 709	java/lang/StringBuilder:<init>	()V
    //   104: aload_1
    //   105: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 1318	java/io/File:separator	Ljava/lang/String;
    //   111: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 4
    //   116: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokespecial 435	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: invokevirtual 1321	java/io/File:mkdirs	()Z
    //   128: pop
    //   129: goto -113 -> 16
    //   132: astore_1
    //   133: aload_3
    //   134: astore_0
    //   135: ldc -105
    //   137: aload_1
    //   138: ldc -39
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 1322	java/util/zip/ZipInputStream:close	()V
    //   155: iconst_m1
    //   156: ireturn
    //   157: aload_3
    //   158: astore_0
    //   159: new 434	java/io/File
    //   162: dup
    //   163: new 259	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 709	java/lang/StringBuilder:<init>	()V
    //   170: aload_1
    //   171: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: getstatic 1318	java/io/File:separator	Ljava/lang/String;
    //   177: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokespecial 435	java/io/File:<init>	(Ljava/lang/String;)V
    //   191: astore 4
    //   193: aload_3
    //   194: astore_0
    //   195: aload 4
    //   197: invokevirtual 1325	java/io/File:createNewFile	()Z
    //   200: pop
    //   201: aload_3
    //   202: astore_0
    //   203: new 1327	java/io/FileOutputStream
    //   206: dup
    //   207: aload 4
    //   209: invokespecial 1330	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   212: astore 4
    //   214: aload_3
    //   215: astore_0
    //   216: sipush 1024
    //   219: newarray <illegal type>
    //   221: astore 5
    //   223: aload_3
    //   224: astore_0
    //   225: aload_3
    //   226: aload 5
    //   228: invokevirtual 1331	java/util/zip/ZipInputStream:read	([B)I
    //   231: istore_2
    //   232: iload_2
    //   233: iconst_m1
    //   234: if_icmpeq +50 -> 284
    //   237: aload_3
    //   238: astore_0
    //   239: aload 4
    //   241: aload 5
    //   243: iconst_0
    //   244: iload_2
    //   245: invokevirtual 1332	java/io/FileOutputStream:write	([BII)V
    //   248: aload_3
    //   249: astore_0
    //   250: aload 4
    //   252: invokevirtual 1335	java/io/FileOutputStream:flush	()V
    //   255: goto -32 -> 223
    //   258: astore_1
    //   259: aload_3
    //   260: astore_0
    //   261: ldc -105
    //   263: aload_1
    //   264: ldc -39
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_3
    //   274: ifnull +7 -> 281
    //   277: aload_3
    //   278: invokevirtual 1322	java/util/zip/ZipInputStream:close	()V
    //   281: bipush -2
    //   283: ireturn
    //   284: aload_3
    //   285: astore_0
    //   286: aload 4
    //   288: invokevirtual 1336	java/io/FileOutputStream:close	()V
    //   291: goto -275 -> 16
    //   294: astore_3
    //   295: aload_0
    //   296: astore_1
    //   297: aload_3
    //   298: astore_0
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 1322	java/util/zip/ZipInputStream:close	()V
    //   307: aload_0
    //   308: athrow
    //   309: aload_3
    //   310: invokevirtual 1322	java/util/zip/ZipInputStream:close	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_0
    //   316: ldc -105
    //   318: ldc_w 1338
    //   321: invokestatic 271	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: iconst_0
    //   325: ireturn
    //   326: astore_0
    //   327: ldc -105
    //   329: ldc_w 1338
    //   332: invokestatic 271	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -180 -> 155
    //   338: astore_0
    //   339: ldc -105
    //   341: ldc_w 1338
    //   344: invokestatic 271	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: goto -66 -> 281
    //   350: astore_1
    //   351: ldc -105
    //   353: ldc_w 1338
    //   356: invokestatic 271	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: goto -52 -> 307
    //   362: astore_0
    //   363: aconst_null
    //   364: astore_1
    //   365: goto -66 -> 299
    //   368: astore_1
    //   369: aconst_null
    //   370: astore_3
    //   371: goto -112 -> 259
    //   374: astore_1
    //   375: aconst_null
    //   376: astore_3
    //   377: goto -244 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString1	String
    //   0	380	1	paramString2	String
    //   231	14	2	i	int
    //   15	270	3	localZipInputStream	java.util.zip.ZipInputStream
    //   294	16	3	localObject1	Object
    //   370	7	3	localObject2	Object
    //   22	265	4	localObject3	Object
    //   36	206	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	132	java/io/FileNotFoundException
    //   31	38	132	java/io/FileNotFoundException
    //   40	51	132	java/io/FileNotFoundException
    //   53	64	132	java/io/FileNotFoundException
    //   66	74	132	java/io/FileNotFoundException
    //   76	91	132	java/io/FileNotFoundException
    //   93	129	132	java/io/FileNotFoundException
    //   159	193	132	java/io/FileNotFoundException
    //   195	201	132	java/io/FileNotFoundException
    //   203	214	132	java/io/FileNotFoundException
    //   216	223	132	java/io/FileNotFoundException
    //   225	232	132	java/io/FileNotFoundException
    //   239	248	132	java/io/FileNotFoundException
    //   250	255	132	java/io/FileNotFoundException
    //   286	291	132	java/io/FileNotFoundException
    //   18	24	258	java/io/IOException
    //   31	38	258	java/io/IOException
    //   40	51	258	java/io/IOException
    //   53	64	258	java/io/IOException
    //   66	74	258	java/io/IOException
    //   76	91	258	java/io/IOException
    //   93	129	258	java/io/IOException
    //   159	193	258	java/io/IOException
    //   195	201	258	java/io/IOException
    //   203	214	258	java/io/IOException
    //   216	223	258	java/io/IOException
    //   225	232	258	java/io/IOException
    //   239	248	258	java/io/IOException
    //   250	255	258	java/io/IOException
    //   286	291	258	java/io/IOException
    //   18	24	294	finally
    //   31	38	294	finally
    //   40	51	294	finally
    //   53	64	294	finally
    //   66	74	294	finally
    //   76	91	294	finally
    //   93	129	294	finally
    //   135	147	294	finally
    //   159	193	294	finally
    //   195	201	294	finally
    //   203	214	294	finally
    //   216	223	294	finally
    //   225	232	294	finally
    //   239	248	294	finally
    //   250	255	294	finally
    //   261	273	294	finally
    //   286	291	294	finally
    //   309	313	315	java/io/IOException
    //   151	155	326	java/io/IOException
    //   277	281	338	java/io/IOException
    //   303	307	350	java/io/IOException
    //   0	16	362	finally
    //   0	16	368	java/io/IOException
    //   0	16	374	java/io/FileNotFoundException
  }
  
  public static String fR(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        x.e("MicroMsg.Util", "getLine1Number failed, null tm");
        return null;
      }
      paramContext = paramContext.getLine1Number();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      x.e("MicroMsg.Util", "getLine1Number failed:%s ", new Object[] { aj.i(paramContext) });
    }
    return null;
  }
  
  public static String fS(Context paramContext)
  {
    if (paramContext == null)
    {
      x.w("MicroMsg.Util", "getSimCountryCode context is null.");
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getSimCountryIso();
      if (oW(paramContext)) {
        return "";
      }
      return paramContext.toUpperCase().trim();
    }
    return "";
  }
  
  public static boolean fS(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((oW(paramString1)) && (oW(paramString2))) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (!oW(paramString1)) {
          break;
        }
        bool1 = bool2;
      } while (!oW(paramString2));
      if (oW(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (oW(paramString2));
    return paramString1.equals(paramString2);
  }
  
  public static String fT(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return k(paramContext.getPackageName(), paramContext);
  }
  
  public static boolean fU(Context paramContext)
  {
    if (!Locale.getDefault().getCountry().equalsIgnoreCase("CN")) {
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset()) {
      return true;
    }
    if (paramContext == null)
    {
      x.w("MicroMsg.Util", "isOverseasUser context is null");
      return false;
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkCountryIso();
      if ((!oW(paramContext)) && (!paramContext.contains("cn")) && (!paramContext.contains("CN"))) {
        return true;
      }
    }
    return false;
  }
  
  public static a fV(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public static ComponentName fW(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      x.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
    }
    return null;
  }
  
  public static String fX(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label188;
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null) {
            return null;
          }
          str = paramContext.getClassName();
          paramContext = str;
          if (!str.contains(".")) {
            return paramContext;
          }
          return str.substring(str.lastIndexOf(".") + 1);
        }
      }
      else
      {
        str = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        paramContext = str;
        if (!str.contains(".")) {
          return paramContext;
        }
        paramContext = str.substring(str.lastIndexOf(".") + 1);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      x.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), aj.i(paramContext) });
    }
    return "";
    label188:
    paramContext = "";
    return paramContext;
  }
  
  public static int fY(Context paramContext)
  {
    if (paramContext == null)
    {
      x.i("MicroMsg.Util", "getSelfMemInMB context is null.");
      return -1;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext != null) && (paramContext.length > 0)) {
      return paramContext[0].getTotalPss() / 1024;
    }
    return 0;
  }
  
  public static void g(String paramString1, String paramString2, long paramLong)
  {
    if (oW(paramString1)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      if ((paramString1.exists()) && (paramString1.isDirectory()))
      {
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length != 0))
        {
          int j = paramString1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString1[i];
            if ((((File)localObject).isFile()) && (((File)localObject).getName().startsWith(paramString2)) && (System.currentTimeMillis() - ((File)localObject).lastModified() - paramLong >= 0L)) {
              ((File)localObject).delete();
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static String ga(long paramLong)
  {
    return new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(paramLong));
  }
  
  public static String gb(long paramLong)
  {
    return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000L * paramLong));
  }
  
  public static String gc(long paramLong)
  {
    return a(paramLong, 10.0D);
  }
  
  public static String gd(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(sJF);
    }
    return localBigInteger1.toString();
  }
  
  public static int ge(long paramLong)
  {
    return Math.round((float)paramLong / 1000.0F);
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (NumberFormatException paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return paramBoolean;
  }
  
  public static double getDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return paramDouble;
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    if (paramString == null) {
      return paramFloat;
    }
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return paramFloat;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramLong;
        }
        long l = Long.decode(paramString).longValue();
        return l;
      }
      catch (NumberFormatException paramString)
      {
        x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return paramLong;
  }
  
  @TargetApi(19)
  public static String h(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if ((paramContext == null) || (paramUri == null)) {
      x.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
    }
    String[] arrayOfString;
    do
    {
      return null;
      String str1 = paramUri.getScheme();
      if (oW(str1))
      {
        x.e("MicroMsg.Util", "input uri error. %s", new Object[] { paramUri });
        return null;
      }
      if (str1.equalsIgnoreCase("file"))
      {
        x.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
        return paramUri.getPath();
      }
      if (!str1.equalsIgnoreCase("content")) {
        break label404;
      }
      x.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
      if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {
        return paramUri.getLastPathSegment();
      }
      try
      {
        paramContext.grantUriPermission(paramUri.getAuthority(), paramUri, 1);
        str1 = a(paramContext, paramUri, null, null);
        if (!oW(str1)) {
          return str1;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          x.e("MicroMsg.Util", "getFilePath : exception = " + localSecurityException);
          arrayOfString = null;
        }
        if (Build.VERSION.SDK_INT < 19) {
          break label404;
        }
      }
      if (!DocumentsContract.isDocumentUri(paramContext, paramUri)) {
        break label404;
      }
      if (!"com.android.externalstorage.documents".equals(paramUri.getAuthority())) {
        break;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
    } while (!"primary".equalsIgnoreCase(paramContext[0]));
    return Environment.getExternalStorageDirectory() + "/" + paramContext[1];
    if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
    {
      paramUri = DocumentsContract.getDocumentId(paramUri);
      return a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
    }
    if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
    {
      arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
      String str2 = arrayOfString[0];
      if ("image".equals(str2)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return a(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
        if ("video".equals(str2))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = (Uri)localObject;
          if ("audio".equals(str2)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
    }
    label404:
    x.e("MicroMsg.Util", "unknown scheme");
    return null;
  }
  
  public static boolean hideVKB(View paramView)
  {
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager == null) {
        return false;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        x.printErrStackTrace("MicroMsg.Util", paramView, "", new Object[0]);
        x.e("MicroMsg.Util", "hide VKB exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
    x.v("MicroMsg.Util", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static String i(Throwable paramThrowable)
  {
    return aj.i(paramThrowable);
  }
  
  public static byte[] i(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    return paramArrayOfByte1;
  }
  
  public static String iR(int paramInt)
  {
    return String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
  }
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new Rect();
    paramView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= paramInt2;
    ((Rect)localObject).bottom += paramInt4;
    ((Rect)localObject).left -= paramInt1;
    ((Rect)localObject).right += paramInt3;
    localObject = new TouchDelegate((Rect)localObject, paramView);
    if (View.class.isInstance(paramView.getParent())) {
      ((View)paramView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
  
  public static void j(String paramString, Context paramContext)
  {
    paramContext.startActivity(WI(paramString));
  }
  
  public static String k(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (oW(paramString))) {
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 64).signatures[0].toByteArray();
      return g.u(paramString);
    }
    catch (Exception paramString)
    {
      x.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean k(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  public static boolean n(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean n(Uri paramUri)
  {
    if (paramUri == null) {
      return false;
    }
    if (!"file".equalsIgnoreCase(paramUri.getScheme())) {
      return true;
    }
    return Xg(paramUri.getPath());
  }
  
  public static boolean o(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  public static String oU(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    return str;
  }
  
  public static String oV(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean oW(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int p(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    do
    {
      return paramInt;
      if ((paramObject instanceof Integer)) {
        return ((Integer)paramObject).intValue();
      }
    } while (!(paramObject instanceof Long));
    return ((Long)paramObject).intValue();
  }
  
  public static boolean p(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static String q(String paramString, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = String.format(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      x.i("MicroMsg.Util", "error safeFormatString %s", new Object[] { paramVarArgs.getMessage() });
    }
    return paramString;
  }
  
  /* Error */
  public static boolean r(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 230	com/tencent/mm/sdk/platformtools/bi:oW	(Ljava/lang/String;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 1722	com/tencent/mm/sdk/platformtools/bi:bC	([B)Z
    //   11: ifeq +13 -> 24
    //   14: ldc -105
    //   16: ldc_w 1724
    //   19: invokestatic 534	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: new 1327	java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 1725	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: astore_0
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 1728	java/io/FileOutputStream:write	([B)V
    //   40: aload_2
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 1335	java/io/FileOutputStream:flush	()V
    //   46: aload_2
    //   47: invokevirtual 1336	java/io/FileOutputStream:close	()V
    //   50: ldc -105
    //   52: ldc_w 1730
    //   55: invokestatic 1054	com/tencent/mm/sdk/platformtools/x:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_0
    //   61: ldc -105
    //   63: aload_0
    //   64: ldc -39
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: goto -23 -> 50
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: ldc -105
    //   83: aload_3
    //   84: ldc -39
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: astore_0
    //   95: ldc -105
    //   97: ldc_w 1732
    //   100: invokestatic 534	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: ifnull -82 -> 22
    //   107: aload_1
    //   108: invokevirtual 1336	java/io/FileOutputStream:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: ldc -105
    //   116: aload_0
    //   117: ldc -39
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 1336	java/io/FileOutputStream:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_0
    //   142: ldc -105
    //   144: aload_0
    //   145: ldc -39
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: goto -15 -> 139
    //   157: astore_1
    //   158: goto -27 -> 131
    //   161: astore_3
    //   162: aload_2
    //   163: astore_1
    //   164: goto -85 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString	String
    //   0	167	1	paramArrayOfByte	byte[]
    //   32	131	2	localFileOutputStream	java.io.FileOutputStream
    //   76	8	3	localException1	Exception
    //   161	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   46	50	60	java/io/IOException
    //   24	33	76	java/lang/Exception
    //   107	111	113	java/io/IOException
    //   24	33	128	finally
    //   135	139	141	java/io/IOException
    //   35	40	157	finally
    //   42	46	157	finally
    //   81	93	157	finally
    //   95	103	157	finally
    //   35	40	161	java/lang/Exception
    //   42	46	161	java/lang/Exception
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 230	com/tencent/mm/sdk/platformtools/bi:oW	(Ljava/lang/String;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc -105
    //   9: ldc_w 1735
    //   12: invokestatic 534	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 434	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 435	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 1227	java/io/File:exists	()Z
    //   30: ifne +21 -> 51
    //   33: ldc -105
    //   35: ldc_w 1737
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: invokestatic 1739	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_3
    //   52: invokevirtual 1741	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: new 919	java/io/FileInputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 1742	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_3
    //   70: iload_1
    //   71: newarray <illegal type>
    //   73: astore 5
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 925	java/io/FileInputStream:read	([B)I
    //   85: istore_2
    //   86: iload_2
    //   87: iload_1
    //   88: if_icmpeq +58 -> 146
    //   91: aload 4
    //   93: astore_3
    //   94: ldc -105
    //   96: ldc_w 1744
    //   99: iconst_3
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iload_1
    //   110: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: iload_2
    //   117: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: invokestatic 1739	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 4
    //   126: invokevirtual 928	java/io/FileInputStream:close	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: ldc -105
    //   134: aload_0
    //   135: ldc -39
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aconst_null
    //   145: areturn
    //   146: aload 4
    //   148: astore_3
    //   149: ldc -105
    //   151: ldc_w 1746
    //   154: invokestatic 1054	com/tencent/mm/sdk/platformtools/x:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: invokevirtual 928	java/io/FileInputStream:close	()V
    //   162: aload 5
    //   164: areturn
    //   165: astore_0
    //   166: ldc -105
    //   168: aload_0
    //   169: ldc -39
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -16 -> 162
    //   181: astore 5
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_0
    //   186: astore_3
    //   187: ldc -105
    //   189: aload 5
    //   191: ldc -39
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_0
    //   201: ifnull -186 -> 15
    //   204: aload_0
    //   205: invokevirtual 928	java/io/FileInputStream:close	()V
    //   208: aconst_null
    //   209: areturn
    //   210: astore_0
    //   211: ldc -105
    //   213: aload_0
    //   214: ldc -39
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 928	java/io/FileInputStream:close	()V
    //   236: aload_0
    //   237: athrow
    //   238: astore_3
    //   239: ldc -105
    //   241: aload_3
    //   242: ldc -39
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 335	com/tencent/mm/sdk/platformtools/x:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: goto -15 -> 236
    //   254: astore_0
    //   255: goto -27 -> 228
    //   258: astore 5
    //   260: aload 4
    //   262: astore_0
    //   263: goto -78 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramString	String
    //   56	54	1	i	int
    //   85	32	2	j	int
    //   25	208	3	localObject	Object
    //   238	4	3	localIOException	IOException
    //   65	196	4	localFileInputStream	FileInputStream
    //   73	90	5	arrayOfByte	byte[]
    //   181	9	5	localException1	Exception
    //   258	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   124	129	131	java/io/IOException
    //   157	162	165	java/io/IOException
    //   51	67	181	java/lang/Exception
    //   204	208	210	java/io/IOException
    //   51	67	225	finally
    //   232	236	238	java/io/IOException
    //   70	75	254	finally
    //   78	86	254	finally
    //   94	124	254	finally
    //   149	157	254	finally
    //   187	200	254	finally
    //   70	75	258	java/lang/Exception
    //   78	86	258	java/lang/Exception
    //   94	124	258	java/lang/Exception
    //   149	157	258	java/lang/Exception
  }
  
  public static void t(Context paramContext, boolean paramBoolean)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      x.w("MicroMsg.Util", "shake:vibrator is null!");
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(eyq, -1);
      return;
    }
    paramContext.cancel();
  }
  
  public static boolean t(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    while ((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public static boolean u(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(5) == localCalendar2.get(5)) && (localCalendar1.get(2) == localCalendar2.get(2));
  }
  
  public static String x(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuffer.append(new String(arrayOfByte, 0, i));
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuffer.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          x.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static final class a
  {
    private Context context;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public final String toString()
    {
      Object localObject1 = this.context;
      if (localObject1 == null) {
        return null;
      }
      Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
      localObject1 = ((Context)localObject1).getPackageName();
      if ((localObject2 == null) || (bi.oW((String)localObject1))) {
        return null;
      }
      Object localObject3 = ((ActivityManager)localObject2).getRunningTasks(100);
      localObject2 = new StringBuffer();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject3).next();
        if ((localRunningTaskInfo.baseActivity.getClassName().startsWith((String)localObject1)) || (localRunningTaskInfo.topActivity.getClassName().startsWith((String)localObject1))) {
          ((StringBuffer)localObject2).append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[] { Integer.valueOf(localRunningTaskInfo.id), Integer.valueOf(localRunningTaskInfo.numRunning), Integer.valueOf(localRunningTaskInfo.numActivities), localRunningTaskInfo.topActivity.getShortClassName(), localRunningTaskInfo.baseActivity.getShortClassName() }));
        }
      }
      return ((StringBuffer)localObject2).toString();
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes-dex2jar.jar!/com/tencent/mm/sdk/platformtools/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */