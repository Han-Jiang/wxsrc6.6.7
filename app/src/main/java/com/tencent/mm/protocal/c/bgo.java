package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bgo
  extends bhd
{
  public com.tencent.mm.bk.b shy;
  public int shz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.shy == null) {
        throw new f.a.a.b("Not all required fields were included: clientCheckData");
      }
      if (this.shX != null)
      {
        paramVarArgs.fV(1, this.shX.boi());
        this.shX.a(paramVarArgs);
      }
      if (this.shy != null) {
        paramVarArgs.b(2, this.shy);
      }
      paramVarArgs.fT(3, this.shz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.shX == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = f.a.a.a.fS(1, this.shX.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.shy != null) {
        i = paramInt + f.a.a.a.a(2, this.shy);
      }
      return i + f.a.a.a.fQ(3, this.shz);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bhd.a(paramVarArgs); paramInt > 0; paramInt = bhd.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        if (this.shy != null) {
          break;
        }
        throw new f.a.a.b("Not all required fields were included: clientCheckData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgo localbgo = (bgo)paramVarArgs[1];
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
            localObject1 = new fk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fk)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhd.a((f.a.a.a.a)localObject2))) {}
            localbgo.shX = ((fk)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbgo.shy = ((f.a.a.a.a)localObject1).cJR();
          return 0;
        }
        localbgo.shz = ((f.a.a.a.a)localObject1).vHC.rY();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/protocal/c/bgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */