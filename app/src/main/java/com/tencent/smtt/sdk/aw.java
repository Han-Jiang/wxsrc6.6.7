package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class aw
  implements FileFilter
{
  aw(an paraman) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".jar");
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/smtt/sdk/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */