package com.tencent.mm.protocal.c;

import f.a.a.b;
import java.util.LinkedList;

public final class aud
  extends com.tencent.mm.bk.a
{
  public bhz rXc;
  public bhz rbR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rbR == null) {
        throw new b("Not all required fields were included: ChatRoomName");
      }
      if (this.rXc == null) {
        throw new b("Not all required fields were included: ChatRoomTopic");
      }
      if (this.rbR != null)
      {
        paramVarArgs.fV(1, this.rbR.boi());
        this.rbR.a(paramVarArgs);
      }
      if (this.rXc != null)
      {
        paramVarArgs.fV(2, this.rXc.boi());
        this.rXc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.rbR == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = f.a.a.a.fS(1, this.rbR.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rXc != null) {
        i = paramInt + f.a.a.a.fS(2, this.rXc.boi());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bk.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bk.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        if (this.rbR == null) {
          throw new b("Not all required fields were included: ChatRoomName");
        }
        if (this.rXc != null) {
          break;
        }
        throw new b("Not all required fields were included: ChatRoomTopic");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aud localaud = (aud)paramVarArgs[1];
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
            localObject1 = new bhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhz)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, com.tencent.mm.bk.a.a((f.a.a.a.a)localObject2))) {}
            localaud.rbR = ((bhz)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bhz)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, com.tencent.mm.bk.a.a((f.a.a.a.a)localObject2))) {}
          localaud.rXc = ((bhz)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/protocal/c/aud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */