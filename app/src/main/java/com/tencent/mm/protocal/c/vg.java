package com.tencent.mm.protocal.c;

import f.a.a.b;
import java.util.LinkedList;

public final class vg
  extends bhp
{
  public int hUm;
  public String hUn;
  public String ixy;
  public String kLZ;
  public String kNq;
  public String kNr;
  public int ryC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.six == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.six != null)
      {
        paramVarArgs.fV(1, this.six.boi());
        this.six.a(paramVarArgs);
      }
      paramVarArgs.fT(2, this.hUm);
      if (this.hUn != null) {
        paramVarArgs.g(3, this.hUn);
      }
      if (this.kLZ != null) {
        paramVarArgs.g(4, this.kLZ);
      }
      if (this.ixy != null) {
        paramVarArgs.g(5, this.ixy);
      }
      paramVarArgs.fT(6, this.ryC);
      if (this.kNr != null) {
        paramVarArgs.g(7, this.kNr);
      }
      if (this.kNq != null) {
        paramVarArgs.g(8, this.kNq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.six == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.fS(1, this.six.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.fQ(2, this.hUm);
      paramInt = i;
      if (this.hUn != null) {
        paramInt = i + f.a.a.b.b.a.h(3, this.hUn);
      }
      i = paramInt;
      if (this.kLZ != null) {
        i = paramInt + f.a.a.b.b.a.h(4, this.kLZ);
      }
      paramInt = i;
      if (this.ixy != null) {
        paramInt = i + f.a.a.b.b.a.h(5, this.ixy);
      }
      i = paramInt + f.a.a.a.fQ(6, this.ryC);
      paramInt = i;
      if (this.kNr != null) {
        paramInt = i + f.a.a.b.b.a.h(7, this.kNr);
      }
      i = paramInt;
      if (this.kNq != null) {
        i = paramInt + f.a.a.b.b.a.h(8, this.kNq);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bhp.a(paramVarArgs); paramInt > 0; paramInt = bhp.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        if (this.six != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vg localvg = (vg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fl)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhp.a((f.a.a.a.a)localObject2))) {}
            localvg.six = ((fl)localObject1);
            paramInt += 1;
          }
        case 2: 
          localvg.hUm = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        case 3: 
          localvg.hUn = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 4: 
          localvg.kLZ = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 5: 
          localvg.ixy = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 6: 
          localvg.ryC = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        case 7: 
          localvg.kNr = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        }
        localvg.kNq = ((f.a.a.a.a)localObject1).vHC.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/protocal/c/vg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */