package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class r
{
  private static String a = null;
  private static String b = "GA";
  private static String c = "GE";
  private static String d = "9422";
  private static String e = "0";
  private static String f = "";
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  private static String a()
  {
    return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    paramContext = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", b, c, d, e, f, g);
    a = paramContext;
    return paramContext;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    String str2 = "";
    StringBuilder localStringBuilder = new StringBuilder();
    String str3 = b(paramContext) + "*" + c(paramContext);
    for (String str1 = str2;; str1 = str2)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
        str1 = str2;
        localPackageInfo = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
        str1 = str2;
        str2 = localApplicationInfo.packageName;
        str1 = str2;
        boolean bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          break label383;
        }
        str1 = str2;
      }
      catch (PackageManager.NameNotFoundException paramString7)
      {
        for (;;)
        {
          PackageInfo localPackageInfo;
          label383:
          paramString7 = "";
          continue;
          if (d(paramContext)) {
            paramContext = "PAD";
          } else {
            paramContext = "PHONE";
          }
        }
      }
      str2 = a(str1);
      if (!"QB".equals(str2)) {
        break;
      }
      if (!paramBoolean) {
        break label431;
      }
      paramContext = "PAD";
      localStringBuilder.append("QV=3");
      a(localStringBuilder, "PL", "ADR");
      a(localStringBuilder, "PR", str2);
      a(localStringBuilder, "PP", str1);
      a(localStringBuilder, "PPVN", paramString7);
      if (!TextUtils.isEmpty(paramString1)) {
        a(localStringBuilder, "TBSVC", paramString1);
      }
      a(localStringBuilder, "CO", "SYS");
      if (!TextUtils.isEmpty(paramString2)) {
        a(localStringBuilder, "COVC", paramString2);
      }
      a(localStringBuilder, "PB", paramString4);
      a(localStringBuilder, "VE", paramString3);
      a(localStringBuilder, "DE", paramContext);
      paramContext = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramContext = "0";
      }
      a(localStringBuilder, "CHID", paramContext);
      a(localStringBuilder, "LCID", paramString5);
      paramContext = a();
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "MO", paramContext);
      }
      a(localStringBuilder, "RL", str3);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "OS", paramContext);
      }
      a(localStringBuilder, "API", Build.VERSION.SDK_INT);
      return localStringBuilder.toString();
      str1 = str2;
      paramString7 = localPackageInfo.versionName;
    }
  }
  
  private static String a(String paramString)
  {
    if (paramString.equals("com.tencent.mm")) {
      return "WX";
    }
    if (paramString.equals("com.tencent.mobileqq")) {
      return "QQ";
    }
    if (paramString.equals("com.qzone")) {
      return "QZ";
    }
    if (paramString.equals("com.tencent.mtt")) {
      return "QB";
    }
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static int b(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getWidth();
    }
    return -1;
  }
  
  private static int c(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return -1;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool = true;
    if (h) {
      return i;
    }
    try
    {
      if (Math.min(b(paramContext), c(paramContext)) * 160 / e(paramContext) >= 700) {}
      for (;;)
      {
        i = bool;
        h = true;
        return i;
        bool = false;
      }
      return false;
    }
    catch (Throwable paramContext) {}
  }
  
  private static int e(Context paramContext)
  {
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      return paramContext.densityDpi;
    }
    return 160;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes6-dex2jar.jar!/com/tencent/smtt/utils/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */