package com.tencent.mm.protocal.c;

import f.a.a.b;
import java.util.LinkedList;

public final class bgb
  extends bhd
{
  public int hcC;
  public int shg;
  public byp shh;
  public int shi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.shh == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      if (this.shX != null)
      {
        paramVarArgs.fV(1, this.shX.boi());
        this.shX.a(paramVarArgs);
      }
      paramVarArgs.fT(2, this.hcC);
      paramVarArgs.fT(3, this.shg);
      if (this.shh != null)
      {
        paramVarArgs.fV(4, this.shh.boi());
        this.shh.a(paramVarArgs);
      }
      paramVarArgs.fT(5, this.shi);
      return 0;
    }
    if (paramInt == 1) {
      if (this.shX == null) {
        break label567;
      }
    }
    label567:
    for (paramInt = f.a.a.a.fS(1, this.shX.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.fQ(2, this.hcC) + f.a.a.a.fQ(3, this.shg);
      paramInt = i;
      if (this.shh != null) {
        paramInt = i + f.a.a.a.fS(4, this.shh.boi());
      }
      return paramInt + f.a.a.a.fQ(5, this.shi);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bhd.a(paramVarArgs); paramInt > 0; paramInt = bhd.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        if (this.shh != null) {
          break;
        }
        throw new b("Not all required fields were included: PieceData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgb localbgb = (bgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fk)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhd.a((f.a.a.a.a)localObject2))) {}
            localbgb.shX = ((fk)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbgb.hcC = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        case 3: 
          localbgb.shg = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byp)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhd.a((f.a.a.a.a)localObject2))) {}
            localbgb.shh = ((byp)localObject1);
            paramInt += 1;
          }
        }
        localbgb.shi = ((f.a.a.a.a)localObject1).vHC.rY();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/protocal/c/bgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */