package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;

public final class o
{
  private static final Uri aOJ;
  private static final Uri aOK;
  
  static
  {
    Uri localUri = Uri.parse("http://plus.google.com/");
    aOJ = localUri;
    aOK = localUri.buildUpon().appendPath("circles").appendPath("find").build();
  }
  
  public static Intent be(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
  
  public static Intent bf(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString).build());
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
  
  public static Intent pp()
  {
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    return localIntent;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/google/android/gms/common/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */