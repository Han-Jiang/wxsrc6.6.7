package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class yh
  extends c
{
  private final int height = 93;
  private final int width = 93;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 93;
      return 93;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(5.2173915F, 0.0F);
      ((Path)localObject3).cubicTo(2.2700827F, 0.0F, -7.1054274E-15F, 2.4263568F, -7.1054274E-15F, 5.2173915F);
      ((Path)localObject3).lineTo(-7.1054274E-15F, 65.21739F);
      ((Path)localObject3).cubicTo(-7.1054274E-15F, 68.00842F, 2.2700827F, 70.434784F, 5.2173915F, 70.434784F);
      ((Path)localObject3).lineTo(86.08696F, 70.434784F);
      ((Path)localObject3).cubicTo(89.03313F, 70.434784F, 91.304344F, 68.00842F, 91.304344F, 65.21739F);
      ((Path)localObject3).lineTo(91.304344F, 5.2173915F);
      ((Path)localObject3).cubicTo(91.304344F, 2.4263568F, 89.03313F, 0.0F, 86.08696F, 0.0F);
      ((Path)localObject3).lineTo(5.2173915F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(67.82609F, 6.521739F);
      ((Path)localObject3).lineTo(80.933716F, 6.521739F);
      ((Path)localObject3).cubicTo(82.835846F, 6.521739F, 84.78261F, 8.498771F, 84.78261F, 11.73913F);
      ((Path)localObject3).lineTo(84.78261F, 24.782608F);
      ((Path)localObject3).lineTo(91.304344F, 24.782608F);
      ((Path)localObject3).lineTo(91.304344F, 44.347828F);
      ((Path)localObject3).lineTo(84.78261F, 44.347828F);
      ((Path)localObject3).lineTo(84.78261F, 58.695652F);
      ((Path)localObject3).cubicTo(84.78261F, 61.936012F, 82.835846F, 63.913044F, 80.933716F, 63.913044F);
      ((Path)localObject3).lineTo(67.82609F, 63.913044F);
      ((Path)localObject3).lineTo(67.82609F, 70.434784F);
      ((Path)localObject3).lineTo(24.782608F, 70.434784F);
      ((Path)localObject3).lineTo(24.782608F, 63.913044F);
      ((Path)localObject3).lineTo(10.370634F, 63.913044F);
      ((Path)localObject3).cubicTo(8.467525F, 63.913044F, 6.521739F, 61.936012F, 6.521739F, 58.695652F);
      ((Path)localObject3).lineTo(6.521739F, 44.347828F);
      ((Path)localObject3).lineTo(7.1054274E-15F, 44.347828F);
      ((Path)localObject3).lineTo(8.303451E-15F, 24.782608F);
      ((Path)localObject3).lineTo(6.521739F, 24.782608F);
      ((Path)localObject3).lineTo(6.521739F, 11.73913F);
      ((Path)localObject3).cubicTo(6.521739F, 8.498771F, 8.467525F, 6.521739F, 10.370634F, 6.521739F);
      ((Path)localObject3).lineTo(24.782608F, 6.521739F);
      ((Path)localObject3).lineTo(24.782608F, 0.0F);
      ((Path)localObject3).lineTo(67.82609F, 0.0F);
      ((Path)localObject3).lineTo(67.82609F, 6.521739F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(29.608696F, 34.347828F);
      ((Path)localObject2).lineTo(27.0F, 39.565216F);
      ((Path)localObject2).lineTo(38.739132F, 53.913044F);
      ((Path)localObject2).lineTo(64.82609F, 22.608696F);
      ((Path)localObject2).lineTo(62.217392F, 20.0F);
      ((Path)localObject2).lineTo(38.739132F, 42.173912F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/boot/svg/a/a/yh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */