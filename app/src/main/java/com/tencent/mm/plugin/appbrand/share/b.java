package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.b.b.f;
import com.tencent.mm.sdk.platformtools.c;
import junit.framework.Assert;

public final class b
  implements b.f
{
  private int mHeight;
  private int mWidth;
  
  public b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      bool1 = true;
      Assert.assertFalse(bool1);
      if (paramInt2 != 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertFalse(bool1);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final String Ke()
  {
    return String.format("Transformation_w%s_h%s", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
  }
  
  public final Bitmap o(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = this.mHeight / this.mWidth;
    Bitmap localBitmap = c.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect1 = new Rect();
    localRect1.left = 0;
    localRect1.top = 0;
    if (f <= j / i) {
      localRect1.right = i;
    }
    for (localRect1.bottom = ((int)(i * f));; localRect1.bottom = j)
    {
      Rect localRect2 = new Rect();
      localRect2.left = 0;
      localRect2.top = 0;
      localRect2.right = this.mWidth;
      localRect2.bottom = this.mHeight;
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, null);
      return localBitmap;
      localRect1.right = ((int)(j / f));
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/plugin/appbrand/share/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */