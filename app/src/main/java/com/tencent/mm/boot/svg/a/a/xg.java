package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class xg
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 25, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(44.999012F, 71.646385F);
      ((Path)localObject).lineTo(18.06173F, 87.246506F);
      ((Path)localObject).cubicTo(16.15247F, 88.35221F, 15.124873F, 87.53144F, 15.765567F, 85.41645F);
      ((Path)localObject).lineTo(24.811031F, 55.55646F);
      ((Path)localObject).lineTo(1.0043138F, 34.66419F);
      ((Path)localObject).cubicTo(-0.6587564F, 33.204716F, -0.20764746F, 32.021576F, 1.9966353F, 32.021576F);
      ((Path)localObject).lineTo(31.459358F, 32.021576F);
      ((Path)localObject).lineTo(43.445843F, 3.5297964F);
      ((Path)localObject).cubicTo(44.303635F, 1.4908304F, 45.69375F, 1.4893055F, 46.552185F, 3.5297964F);
      ((Path)localObject).lineTo(58.538666F, 32.021576F);
      ((Path)localObject).lineTo(88.00139F, 32.021576F);
      ((Path)localObject).cubicTo(90.2125F, 32.021576F, 90.65668F, 33.204803F, 88.99371F, 34.66419F);
      ((Path)localObject).lineTo(65.187F, 55.55646F);
      ((Path)localObject).lineTo(74.23246F, 85.41645F);
      ((Path)localObject).cubicTo(74.87358F, 87.53287F, 73.84428F, 88.35146F, 71.936295F, 87.246506F);
      ((Path)localObject).lineTo(44.999012F, 71.646385F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/boot/svg/a/a/xg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */