package com.tencent.mm.protocal.c;

import f.a.a.b;
import java.util.LinkedList;

public final class bfu
  extends bhd
{
  public int hcE;
  public int jRa;
  public String rxQ;
  public bxg sgW;
  public btp sgX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sgW == null) {
        throw new b("Not all required fields were included: UserPosition");
      }
      if (this.shX != null)
      {
        paramVarArgs.fV(1, this.shX.boi());
        this.shX.a(paramVarArgs);
      }
      if (this.rxQ != null) {
        paramVarArgs.g(2, this.rxQ);
      }
      paramVarArgs.fT(3, this.hcE);
      if (this.sgW != null)
      {
        paramVarArgs.fV(4, this.sgW.boi());
        this.sgW.a(paramVarArgs);
      }
      paramVarArgs.fT(5, this.jRa);
      if (this.sgX != null)
      {
        paramVarArgs.fV(6, this.sgX.boi());
        this.sgX.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.shX == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = f.a.a.a.fS(1, this.shX.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rxQ != null) {
        i = paramInt + f.a.a.b.b.a.h(2, this.rxQ);
      }
      i += f.a.a.a.fQ(3, this.hcE);
      paramInt = i;
      if (this.sgW != null) {
        paramInt = i + f.a.a.a.fS(4, this.sgW.boi());
      }
      i = paramInt + f.a.a.a.fQ(5, this.jRa);
      paramInt = i;
      if (this.sgX != null) {
        paramInt = i + f.a.a.a.fS(6, this.sgX.boi());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bhd.a(paramVarArgs); paramInt > 0; paramInt = bhd.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        if (this.sgW != null) {
          break;
        }
        throw new b("Not all required fields were included: UserPosition");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfu localbfu = (bfu)paramVarArgs[1];
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
            localbfu.shX = ((fk)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfu.rxQ = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 3: 
          localbfu.hcE = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxg)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhd.a((f.a.a.a.a)localObject2))) {}
            localbfu.sgW = ((bxg)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbfu.jRa = ((f.a.a.a.a)localObject1).vHC.rY();
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btp)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhd.a((f.a.a.a.a)localObject2))) {}
          localbfu.sgX = ((btp)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/protocal/c/bfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */