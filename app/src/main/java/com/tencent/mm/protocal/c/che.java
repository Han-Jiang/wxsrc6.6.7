package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class che
  extends com.tencent.mm.bk.a
{
  public LinkedList<bsd> rgX = new LinkedList();
  public int sBi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.rgX);
      paramVarArgs.fT(2, this.sBi);
      return 0;
    }
    if (paramInt == 1) {
      return f.a.a.a.c(1, 8, this.rgX) + 0 + f.a.a.a.fQ(2, this.sBi);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rgX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bk.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bk.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cJS();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      che localche = (che)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsd)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, com.tencent.mm.bk.a.a((f.a.a.a.a)localObject2))) {}
          localche.rgX.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localche.sBi = ((f.a.a.a.a)localObject1).vHC.rY();
      return 0;
    }
    return -1;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes2-dex2jar.jar!/com/tencent/mm/protocal/c/che.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */