package com.tenpay.android.wechat;

public abstract interface ISecureEncrypt
{
  public abstract String desedeEncode(String paramString1, String paramString2);
  
  public abstract String desedeVerifyCode(String paramString1, String paramString2);
  
  public abstract String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract String encryptPasswdWithRSA2048(boolean paramBoolean, String paramString1, String paramString2);
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tenpay/android/wechat/ISecureEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */