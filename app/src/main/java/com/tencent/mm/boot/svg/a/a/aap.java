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

public final class aap
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-14046139);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(96.0F, 0.0F);
      localPath.lineTo(96.0F, 96.0F);
      localPath.lineTo(0.0F, 96.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 4);
      localCanvas.drawPath(localPath, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 51, 4);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(48.7577F, 15.974849F);
      ((Path)localObject2).lineTo(27.774939F, 3.7349038F);
      ((Path)localObject2).cubicTo(27.466654F, 3.5550714F, 26.53348F, 3.554993F, 26.225061F, 3.7349038F);
      ((Path)localObject2).lineTo(5.2423F, 15.974849F);
      ((Path)localObject2).lineTo(27.0F, 28.536663F);
      ((Path)localObject2).lineTo(48.7577F, 15.974849F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.4F, 19.183588F);
      ((Path)localObject2).lineTo(28.8F, 31.654354F);
      ((Path)localObject2).lineTo(28.8F, 56.89739F);
      ((Path)localObject2).lineTo(49.59719F, 44.765697F);
      ((Path)localObject2).cubicTo(49.920998F, 44.57681F, 50.4F, 43.743988F, 50.4F, 43.37328F);
      ((Path)localObject2).lineTo(50.4F, 19.183588F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.6F, 19.183588F);
      ((Path)localObject2).lineTo(3.6F, 43.37328F);
      ((Path)localObject2).cubicTo(3.6F, 43.73662F, 4.0836716F, 44.579533F, 4.402809F, 44.765697F);
      ((Path)localObject2).lineTo(25.2F, 56.89739F);
      ((Path)localObject2).lineTo(25.2F, 31.654354F);
      ((Path)localObject2).lineTo(3.6F, 19.183588F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.411127F, 0.62529963F);
      ((Path)localObject2).cubicTo(25.840921F, -0.20874764F, 28.160156F, -0.20811874F, 29.588873F, 0.62529963F);
      ((Path)localObject2).lineTo(51.411125F, 13.354947F);
      ((Path)localObject2).cubicTo(52.840923F, 14.188994F, 54.0F, 16.21864F, 54.0F, 17.856966F);
      ((Path)localObject2).lineTo(54.0F, 43.37328F);
      ((Path)localObject2).cubicTo(54.0F, 45.02563F, 52.839844F, 47.04188F, 51.411125F, 47.8753F);
      ((Path)localObject2).lineTo(29.588873F, 60.604946F);
      ((Path)localObject2).cubicTo(28.159079F, 61.438995F, 25.839844F, 61.438366F, 24.411127F, 60.604946F);
      ((Path)localObject2).lineTo(2.5888736F, 47.8753F);
      ((Path)localObject2).cubicTo(1.1590781F, 47.041252F, 0.0F, 45.01161F, 0.0F, 43.37328F);
      ((Path)localObject2).lineTo(0.0F, 17.856966F);
      ((Path)localObject2).cubicTo(0.0F, 16.204617F, 1.1601562F, 14.188366F, 2.5888736F, 13.354947F);
      ((Path)localObject2).lineTo(24.411127F, 0.62529963F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes2-dex2jar.jar!/com/tencent/mm/boot/svg/a/a/aap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */