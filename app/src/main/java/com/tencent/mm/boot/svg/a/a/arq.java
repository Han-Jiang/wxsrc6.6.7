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

public final class arq
  extends c
{
  private final int height = 50;
  private final int width = 34;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 50;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3815995);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -945.0F, 0.0F, 1.0F, -405.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(948.125F, 426.5625F);
      ((Path)localObject2).lineTo(948.125F, 432.50198F);
      ((Path)localObject2).cubicTo(948.125F, 440.09482F, 954.28107F, 446.25F, 961.875F, 446.25F);
      ((Path)localObject2).cubicTo(969.46893F, 446.25F, 975.625F, 440.09482F, 975.625F, 432.50198F);
      ((Path)localObject2).lineTo(975.625F, 426.5625F);
      ((Path)localObject2).lineTo(977.99774F, 426.5625F);
      ((Path)localObject2).cubicTo(978.41595F, 426.5625F, 978.75F, 426.89874F, 978.75F, 427.31354F);
      ((Path)localObject2).lineTo(978.75F, 432.3685F);
      ((Path)localObject2).cubicTo(978.75F, 440.96136F, 972.1874F, 448.0379F, 963.75F, 448.9606F);
      ((Path)localObject2).lineTo(963.75F, 451.875F);
      ((Path)localObject2).lineTo(971.42896F, 451.875F);
      ((Path)localObject2).cubicTo(971.84674F, 451.875F, 972.1875F, 452.21368F, 972.1875F, 452.63147F);
      ((Path)localObject2).lineTo(972.1875F, 454.24353F);
      ((Path)localObject2).cubicTo(972.1875F, 454.66556F, 971.8479F, 455.0F, 971.42896F, 455.0F);
      ((Path)localObject2).lineTo(952.32104F, 455.0F);
      ((Path)localObject2).cubicTo(951.90326F, 455.0F, 951.5625F, 454.66132F, 951.5625F, 454.24353F);
      ((Path)localObject2).lineTo(951.5625F, 452.63147F);
      ((Path)localObject2).cubicTo(951.5625F, 452.20944F, 951.9021F, 451.875F, 952.32104F, 451.875F);
      ((Path)localObject2).lineTo(960.0F, 451.875F);
      ((Path)localObject2).lineTo(960.0F, 448.9606F);
      ((Path)localObject2).cubicTo(951.5626F, 448.0379F, 945.0F, 440.96136F, 945.0F, 432.3685F);
      ((Path)localObject2).lineTo(945.0F, 427.30655F);
      ((Path)localObject2).cubicTo(945.0F, 426.89603F, 945.3368F, 426.5625F, 945.75226F, 426.5625F);
      ((Path)localObject2).lineTo(948.125F, 426.5625F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(961.875F, 405.0F);
      ((Path)localObject2).cubicTo(967.05383F, 405.0F, 971.25F, 409.20065F, 971.25F, 414.38242F);
      ((Path)localObject2).lineTo(971.25F, 431.86758F);
      ((Path)localObject2).cubicTo(971.25F, 437.05624F, 967.0527F, 441.25F, 961.875F, 441.25F);
      ((Path)localObject2).cubicTo(956.69617F, 441.25F, 952.5F, 437.04935F, 952.5F, 431.86758F);
      ((Path)localObject2).lineTo(952.5F, 414.38242F);
      ((Path)localObject2).cubicTo(952.5F, 409.19376F, 956.6973F, 405.0F, 961.875F, 405.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes6-dex2jar.jar!/com/tencent/mm/boot/svg/a/a/arq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */