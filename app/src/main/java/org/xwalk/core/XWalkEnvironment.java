package org.xwalk.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.tencent.xweb.util.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class XWalkEnvironment
{
  private static final String APK_DIR = "apk";
  public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
  public static final int LOCAL_TEST_VERSION = 999;
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  public static final String[] MANDATORY_RESOURCES = { "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js" };
  private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
  private static final String OPTIMIZED_DEX_DIR = "dex";
  private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
  private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
  public static final int SDK_VERSION = 21;
  private static final int SPECIAL_TEST_USER_ID = 10001;
  private static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
  private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
  private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
  private static final String TAG = "XWalkLib";
  public static String UPDATEINFOTAG = "xwalk_update_info";
  public static final String XWALK_CORE_APK_NAME = "base.apk";
  private static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
  private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
  private static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
  private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
  private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
  private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
  private static final String XWALK_CORE_ZIP_NAME = "base.zip";
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  private static final String ZIP_DIR = "zip";
  private static Context sApplicationContext;
  private static String sApplicationName;
  private static int sAvailableVersion;
  static boolean sBHasInitedSafePsProvider;
  private static String sDeviceAbi;
  private static Boolean sIsDownloadMode = Boolean.valueOf(true);
  private static Boolean sIsDownloadModeUpdate = Boolean.valueOf(true);
  private static Boolean sIsXWalkVerify;
  static int sNDeviceRd;
  static int sPid;
  private static String sRuntimeAbi;
  static Method sSafePSProvider;
  static String sStrCurentProcessName;
  static String sStrDeviceId;
  private static String sStrTempUpdateConfigUrl;
  private static String sStrVersionDetail;
  private static String sXWalkApkUrl;
  private static String sXWalkDownConfigUrl;
  static int s_grayValue;
  
  static
  {
    sAvailableVersion = -1;
    sBHasInitedSafePsProvider = false;
    sPid = android.os.Process.myPid();
    s_grayValue = 0;
    sNDeviceRd = 0;
    sStrDeviceId = null;
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    Log.i("XWalkUpdater", paramString);
    String str1 = new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    String str2 = sPid + ":" + str1 + " : " + paramString;
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    str1 = localSharedPreferences.getString("log", "");
    paramString = str1;
    if (str1.length() > 5000) {
      paramString = str1.substring(4000);
    }
    paramString = str2 + "\n" + paramString;
    localSharedPreferences.edit().putString("log", paramString).apply();
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    addXWalkInitializeLog(paramString1 + ": " + paramString2);
  }
  
  public static boolean checkApiVersionAllFileExist(int paramInt)
  {
    return (checkApiVersionExtractResourceExist(paramInt)) && (checkApiVersionBaseApkExist(paramInt));
  }
  
  /* Error */
  public static boolean checkApiVersionAvailable(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: invokestatic 253	org/xwalk/core/XWalkEnvironment:getExtractedCoreDir	(I)Ljava/lang/String;
    //   4: astore_2
    //   5: iload_0
    //   6: invokestatic 256	org/xwalk/core/XWalkEnvironment:getClassDexFilePath	(I)Ljava/lang/String;
    //   9: astore_3
    //   10: new 258	java/io/File
    //   13: dup
    //   14: aload_3
    //   15: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 262	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 264	dalvik/system/DexClassLoader
    //   29: dup
    //   30: aload_3
    //   31: iload_0
    //   32: invokestatic 267	org/xwalk/core/XWalkEnvironment:getOptimizedDexDir	(I)Ljava/lang/String;
    //   35: aload_2
    //   36: invokestatic 273	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokespecial 276	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc_w 278
    //   47: invokevirtual 282	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore 4
    //   52: ldc -51
    //   54: astore_2
    //   55: new 284	org/xwalk/core/ReflectField
    //   58: dup
    //   59: aload 4
    //   61: ldc_w 286
    //   64: invokespecial 289	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   67: invokevirtual 293	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   70: checkcast 138	java/lang/String
    //   73: astore_3
    //   74: aload_3
    //   75: astore_2
    //   76: new 284	org/xwalk/core/ReflectField
    //   79: dup
    //   80: aload 4
    //   82: ldc_w 295
    //   85: invokespecial 289	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   88: invokevirtual 293	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   91: checkcast 297	java/lang/Integer
    //   94: invokevirtual 300	java/lang/Integer:intValue	()I
    //   97: istore_0
    //   98: new 284	org/xwalk/core/ReflectField
    //   101: dup
    //   102: aload 4
    //   104: ldc_w 302
    //   107: invokespecial 289	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   110: invokevirtual 293	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   113: checkcast 297	java/lang/Integer
    //   116: invokevirtual 300	java/lang/Integer:intValue	()I
    //   119: istore_1
    //   120: ldc 49
    //   122: new 181	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 304
    //   129: invokespecial 305	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_2
    //   133: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 307
    //   139: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_0
    //   143: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: ldc_w 309
    //   149: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload_1
    //   153: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 312	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: iconst_1
    //   163: ireturn
    //   164: astore_2
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_2
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_3
    //   171: goto -95 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramInt	int
    //   119	34	1	i	int
    //   4	129	2	localObject	Object
    //   164	1	2	localException1	Exception
    //   167	1	2	localException2	Exception
    //   9	66	3	str	String
    //   170	1	3	localRuntimeException	RuntimeException
    //   50	53	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   43	52	164	java/lang/Exception
    //   55	74	164	java/lang/Exception
    //   76	162	164	java/lang/Exception
    //   0	24	167	java/lang/Exception
    //   26	43	167	java/lang/Exception
    //   55	74	170	java/lang/RuntimeException
  }
  
  public static boolean checkApiVersionBaseApkExist(int paramInt)
  {
    return new File(getDownloadApkPath(paramInt)).exists();
  }
  
  private static boolean checkApiVersionExtractResourceExist(int paramInt)
  {
    String[] arrayOfString = MANDATORY_RESOURCES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!str.equals("xweb_fullscreen_video.js"))
      {
        File localFile = new File(getExtractedCoreDir(paramInt) + str);
        if (!localFile.exists())
        {
          Log.i("XWalkLib", "XWalkEnvironment checkApiVersionExtractResourceExist not exist Version:" + paramInt + ", resource name:" + str + ", Path:" + localFile.getAbsolutePath());
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  public static void clearAllVersion(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null)) {}
    do
    {
      return;
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    } while (paramContext == null);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((((File)localObject).getName().startsWith("app_xwalk_")) && (((File)localObject).isDirectory())) {
        a.adE(((File)localObject).getAbsolutePath());
      }
      i += 1;
    }
    setAvailableVersion(-1, "");
  }
  
  public static boolean delApiVersion(int paramInt)
  {
    return a.adE(getVesionDir(paramInt));
  }
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  private static String getApplicationMetaData(String paramString)
  {
    try
    {
      paramString = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(paramString).toString();
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;) {}
    }
  }
  
  public static String getApplicationName()
  {
    if (sApplicationName == null) {}
    try
    {
      PackageManager localPackageManager = sApplicationContext.getPackageManager();
      sApplicationName = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(sApplicationContext.getPackageName(), 0));
      if ((sApplicationName == null) || (sApplicationName.isEmpty()) || (sApplicationName.matches("[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*"))) {
        sApplicationName = "this application";
      }
      Log.d("XWalkLib", "Crosswalk application name: " + sApplicationName);
      return sApplicationName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public static int getAvailableVersion()
  {
    return sAvailableVersion;
  }
  
  public static String getAvailableVersionDetail()
  {
    return sStrVersionDetail;
  }
  
  public static String getClassDexFilePath(int paramInt)
  {
    return getExtractedCoreDir(paramInt) + File.separator + "classes.dex";
  }
  
  public static String getDeviceAbi()
  {
    if (sDeviceAbi == null) {}
    try
    {
      sDeviceAbi = Build.SUPPORTED_ABIS[0].toLowerCase();
      Log.d("XWalkLib", "Device ABI: " + sDeviceAbi);
      return sDeviceAbi;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      try
      {
        InputStreamReader localInputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        sDeviceAbi = localBufferedReader.readLine().toLowerCase();
        localBufferedReader.close();
        localInputStreamReader.close();
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Can not detect device's ABI");
      }
    }
  }
  
  public static String getDeviceId()
  {
    if (sStrDeviceId == null) {}
    for (;;)
    {
      try
      {
        localTelephonyManager = (TelephonyManager)getApplicationContext().getSystemService("phone");
        if (localTelephonyManager != null) {
          continue;
        }
        sStrDeviceId = "";
      }
      catch (Exception localException)
      {
        TelephonyManager localTelephonyManager;
        sStrDeviceId = "";
        Log.e("XWalkEnvironment", "getDeviceId failed " + localException.getMessage());
        continue;
      }
      return sStrDeviceId;
      sStrDeviceId = localTelephonyManager.getDeviceId();
    }
  }
  
  public static int getDeviceRd()
  {
    if (sNDeviceRd <= 0)
    {
      int i = getSharedPreferences().getInt("sNDeviceRd", -1);
      sNDeviceRd = i;
      if (i <= 0)
      {
        sNDeviceRd = new Random().nextInt(10000000) + 1;
        getSharedPreferences().edit().putInt("sNDeviceRd", sNDeviceRd).apply();
      }
    }
    return sNDeviceRd % 10000 + 1;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "base.apk";
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "patch.zip";
  }
  
  public static String getDownloadZipDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "zip";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "base.zip";
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    return getExtractedCoreFile(paramInt, "filelist.config");
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString;
  }
  
  public static int getGrayValue()
  {
    if (s_grayValue != 0) {
      return s_grayValue;
    }
    try
    {
      int i = getSharedPreferences().getInt("TEST_GRAY_VALUE", -1);
      s_grayValue = i;
      if (i <= 0) {
        s_grayValue = getSharedPreferences().getInt("GRAY_VALUE", -1);
      }
      if (s_grayValue <= 0) {
        s_grayValue = getDeviceRd();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkEnvironment", "match gray rate exception: " + localException.getMessage());
      }
    }
    return s_grayValue;
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "dex";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getPatchConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "patch.config");
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString;
  }
  
  public static String getPatchZipTempDecompressPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getProcessName()
  {
    if (sStrCurentProcessName != null) {
      return sStrCurentProcessName;
    }
    Object localObject = getApplicationContext();
    int i = android.os.Process.myPid();
    if (localObject == null) {
      return null;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i) {
            sStrCurentProcessName = localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    return sStrCurentProcessName;
  }
  
  public static SharedPreferences getProcessSafePreferences(String paramString, int paramInt)
  {
    
    if (sSafePSProvider == null) {
      return sApplicationContext.getSharedPreferences(paramString, paramInt);
    }
    try
    {
      localObject = sSafePSProvider.invoke(null, new Object[] { sApplicationContext, paramString, Integer.valueOf(paramInt) });
      if ((localObject != null) && ((localObject instanceof SharedPreferences))) {
        break label71;
      }
      sSafePSProvider = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label71:
        sSafePSProvider = null;
      }
    }
    return sApplicationContext.getSharedPreferences(paramString, paramInt);
    localObject = (SharedPreferences)localObject;
    return (SharedPreferences)localObject;
  }
  
  public static String getRuntimeAbi()
  {
    int j = 0;
    String str;
    int i;
    if (sRuntimeAbi == null)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label233;
        }
        throw new NoSuchFieldError();
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        str = System.getProperty("os.arch").toLowerCase();
        switch (str.hashCode())
        {
        }
      }
      i = -1;
      switch (i)
      {
      default: 
        label146:
        throw new RuntimeException("Unexpected os.arch: " + str);
        label233:
        str = Build.CPU_ABI.toLowerCase();
        switch (str.hashCode())
        {
        }
        break;
      }
    }
    for (;;)
    {
      throw new RuntimeException("Unexpected CPU_ABI: " + str);
      if (str.equals("armeabi"))
      {
        i = 0;
        break label762;
        if (str.equals("armeabi-v7a"))
        {
          i = 1;
          break label762;
          if (str.equals("arm64-v8a"))
          {
            i = 2;
            break label762;
            if (str.equals("x86"))
            {
              i = 3;
              break label762;
              if (str.equals("x86_64"))
              {
                i = 4;
                break label762;
                sRuntimeAbi = "armeabi-v7a";
                label402:
                if (sRuntimeAbi.equals("armeabi-v7a")) {
                  if (!isIaDevice()) {}
                }
                for (sRuntimeAbi = "x86";; sRuntimeAbi = "x86_64") {
                  do
                  {
                    Log.d("XWalkLib", "Runtime ABI: " + sRuntimeAbi);
                    return sRuntimeAbi;
                    sRuntimeAbi = "arm64-v8a";
                    break label402;
                    sRuntimeAbi = "x86";
                    break label402;
                    sRuntimeAbi = "x86_64";
                    break label402;
                    if (!str.equals("x86")) {
                      break;
                    }
                    i = j;
                    break label146;
                    if (!str.equals("i686")) {
                      break;
                    }
                    i = 1;
                    break label146;
                    if (!str.equals("i386")) {
                      break;
                    }
                    i = 2;
                    break label146;
                    if (!str.equals("ia32")) {
                      break;
                    }
                    i = 3;
                    break label146;
                    if (!str.equals("x64")) {
                      break;
                    }
                    i = 4;
                    break label146;
                    if (!str.equals("x86_64")) {
                      break;
                    }
                    i = 5;
                    break label146;
                    if (!str.equals("armv7l")) {
                      break;
                    }
                    i = 6;
                    break label146;
                    if (!str.equals("armeabi")) {
                      break;
                    }
                    i = 7;
                    break label146;
                    if (!str.equals("armeabi-v7a")) {
                      break;
                    }
                    i = 8;
                    break label146;
                    if (!str.equals("aarch64")) {
                      break;
                    }
                    i = 9;
                    break label146;
                    if (!str.equals("armv8")) {
                      break;
                    }
                    i = 10;
                    break label146;
                    if (!str.equals("arm64")) {
                      break;
                    }
                    i = 11;
                    break label146;
                    sRuntimeAbi = "x86";
                    break label402;
                    if (is64bitDevice())
                    {
                      sRuntimeAbi = "x86_64";
                      break label402;
                    }
                    sRuntimeAbi = "x86";
                    break label402;
                    sRuntimeAbi = "armeabi-v7a";
                    break label402;
                    if (is64bitDevice())
                    {
                      sRuntimeAbi = "arm64-v8a";
                      break label402;
                    }
                    sRuntimeAbi = "armeabi-v7a";
                    break label402;
                  } while ((!sRuntimeAbi.equals("arm64-v8a")) || (!isIaDevice()));
                }
              }
            }
          }
        }
      }
      i = -1;
      label762:
      switch (i)
      {
      }
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return sApplicationContext.getSharedPreferences("libxwalkcore", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForLog()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("UPDATELOG", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    return getProcessSafePreferences("UPDATEINFOTAG", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    return sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
  }
  
  public static String getTempUpdateConfigUrl()
  {
    try
    {
      String str = sStrTempUpdateConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getTestDownLoadUrl(Context paramContext)
  {
    return paramContext.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
  }
  
  public static String getUpdateConfigDir()
  {
    return sApplicationContext.getDir("xwalkconfig", 0).getAbsolutePath();
  }
  
  public static String getVesionDir(int paramInt)
  {
    String str = sApplicationContext.getDir("xwalk_" + paramInt, 0).getAbsolutePath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getXWalkInitializeLog()
  {
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("log", "");
  }
  
  public static String getXWalkUpdateConfigUrl()
  {
    String str;
    if (sXWalkDownConfigUrl == null)
    {
      str = getTestDownLoadUrl(getApplicationContext());
      sXWalkDownConfigUrl = str;
      if ((str == null) || (sXWalkDownConfigUrl.trim().isEmpty())) {
        break label59;
      }
      addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
    }
    for (;;)
    {
      return sXWalkDownConfigUrl;
      label59:
      str = getTempUpdateConfigUrl();
      sXWalkDownConfigUrl = str;
      if ((str != null) && (!sXWalkDownConfigUrl.trim().isEmpty())) {
        addXWalkInitializeLog("use temp config url : " + sXWalkDownConfigUrl);
      } else {
        sXWalkDownConfigUrl = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
      }
    }
  }
  
  public static boolean hasAvailableVersion()
  {
    return 49 <= getAvailableVersion();
  }
  
  public static void init(Context paramContext)
  {
    sApplicationContext = paramContext.getApplicationContext();
    if (sAvailableVersion == -1)
    {
      sAvailableVersion = getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
      sStrVersionDetail = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
      if (sAvailableVersion != -1) {
        getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sAvailableVersion)).commit();
      }
    }
  }
  
  static void initSafePsProvider()
  {
    if (sBHasInitedSafePsProvider) {
      return;
    }
    sBHasInitedSafePsProvider = true;
  }
  
  public static boolean is64bitApp()
  {
    String str = getRuntimeAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean is64bitDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean isDownloadMode()
  {
    return sIsDownloadMode.booleanValue();
  }
  
  public static boolean isDownloadModeUpdate()
  {
    return sIsDownloadModeUpdate.booleanValue();
  }
  
  public static boolean isIaDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("x86")) || (str.equals("x86_64"));
  }
  
  public static boolean setAvailableVersion(int paramInt, String paramString)
  {
    Log.i("XWalkLib", "setAvailableVersion:" + paramInt);
    SharedPreferences.Editor localEditor = getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt("availableVersion", paramInt);
    localEditor.putString("versionDetail", paramString);
    boolean bool = localEditor.commit();
    addXWalkInitializeLog("XWalkLib", "set xwalk version to " + paramInt + " suc = " + bool);
    return bool;
  }
  
  public static void setGrayValueByUserId(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      long l = paramInt;
      Object localObject = "xweb_gray_value" + (0xFFFFFFFF & l);
      try
      {
        localObject = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
        if ((localObject != null) && (localObject.length > 3))
        {
          paramInt = localObject[3];
          int i = localObject[2];
          int j = localObject[1];
          paramInt = (localObject[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
          if (paramInt != 0) {
            s_grayValue = paramInt % 10000 + 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s_grayValue = 0;
        }
      }
    }
    getSharedPreferences().edit().putInt("GRAY_VALUE", s_grayValue).commit();
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    getSharedPreferences().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
  }
  
  public static void setTempUpdateConfigUrl(String paramString)
  {
    try
    {
      sStrTempUpdateConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setTestDownLoadUrl(Context paramContext, String paramString)
  {
    sXWalkDownConfigUrl = null;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
      getXWalkUpdateConfigUrl();
      return;
    }
    paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
    getXWalkUpdateConfigUrl();
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes2-dex2jar.jar!/org/xwalk/core/XWalkEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */