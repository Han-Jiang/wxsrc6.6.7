package com.tencent.mm.plugin.product.c;

import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bk.a
{
  public int bWA;
  public String gmb;
  public g lRQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.fT(1, this.bWA);
      if (this.lRQ != null)
      {
        paramVarArgs.fV(2, this.lRQ.boi());
        this.lRQ.a(paramVarArgs);
      }
      if (this.gmb != null) {
        paramVarArgs.g(3, this.gmb);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = f.a.a.a.fQ(1, this.bWA) + 0;
      paramInt = i;
      if (this.lRQ != null) {
        paramInt = i + f.a.a.a.fS(2, this.lRQ.boi());
      }
      i = paramInt;
    } while (this.gmb == null);
    return paramInt + f.a.a.b.b.a.h(3, this.gmb);
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localj.bWA = ((f.a.a.a.a)localObject1).vHC.rY();
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, com.tencent.mm.bk.a.a((f.a.a.a.a)localObject2))) {}
          localj.lRQ = ((g)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localj.gmb = ((f.a.a.a.a)localObject1).vHC.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes2-dex2jar.jar!/com/tencent/mm/plugin/product/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */