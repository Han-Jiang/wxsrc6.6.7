package com.tencent.mm.protocal.c;

import f.a.a.b;
import java.util.LinkedList;

public final class vm
  extends bhp
{
  public LinkedList<aqe> rqi = new LinkedList();
  public bbt ryJ;
  public String ryK;
  public String ryL;
  public String ryM;
  public String ryN;
  
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
      paramVarArgs.d(2, 8, this.rqi);
      if (this.ryJ != null)
      {
        paramVarArgs.fV(3, this.ryJ.boi());
        this.ryJ.a(paramVarArgs);
      }
      if (this.ryK != null) {
        paramVarArgs.g(4, this.ryK);
      }
      if (this.ryL != null) {
        paramVarArgs.g(5, this.ryL);
      }
      if (this.ryM != null) {
        paramVarArgs.g(6, this.ryM);
      }
      if (this.ryN != null) {
        paramVarArgs.g(7, this.ryN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.six == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = f.a.a.a.fS(1, this.six.boi()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.rqi);
      paramInt = i;
      if (this.ryJ != null) {
        paramInt = i + f.a.a.a.fS(3, this.ryJ.boi());
      }
      i = paramInt;
      if (this.ryK != null) {
        i = paramInt + f.a.a.b.b.a.h(4, this.ryK);
      }
      paramInt = i;
      if (this.ryL != null) {
        paramInt = i + f.a.a.b.b.a.h(5, this.ryL);
      }
      i = paramInt;
      if (this.ryM != null) {
        i = paramInt + f.a.a.b.b.a.h(6, this.ryM);
      }
      paramInt = i;
      if (this.ryN != null) {
        paramInt = i + f.a.a.b.b.a.h(7, this.ryN);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rqi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        vm localvm = (vm)paramVarArgs[1];
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
            localObject1 = new fl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fl)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhp.a((f.a.a.a.a)localObject2))) {}
            localvm.six = ((fl)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqe)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhp.a((f.a.a.a.a)localObject2))) {}
            localvm.rqi.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).IC(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbt)localObject1).a((f.a.a.a.a)localObject2, (com.tencent.mm.bk.a)localObject1, bhp.a((f.a.a.a.a)localObject2))) {}
            localvm.ryJ = ((bbt)localObject1);
            paramInt += 1;
          }
        case 4: 
          localvm.ryK = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 5: 
          localvm.ryL = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        case 6: 
          localvm.ryM = ((f.a.a.a.a)localObject1).vHC.readString();
          return 0;
        }
        localvm.ryN = ((f.a.a.a.a)localObject1).vHC.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes6-dex2jar.jar!/com/tencent/mm/protocal/c/vm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */