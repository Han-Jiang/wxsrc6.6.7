package com.tencent.mm.protocal.c;

public final class wm
  extends com.tencent.mm.bk.a
{
  public String bHD;
  public String jOS;
  public int rcd;
  public String rce;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bHD != null) {
        paramVarArgs.g(1, this.bHD);
      }
      if (this.jOS != null) {
        paramVarArgs.g(2, this.jOS);
      }
      paramVarArgs.fT(3, this.rcd);
      if (this.rce != null) {
        paramVarArgs.g(4, this.rce);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bHD == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = f.a.a.b.b.a.h(1, this.bHD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jOS != null) {
        i = paramInt + f.a.a.b.b.a.h(2, this.jOS);
      }
      i += f.a.a.a.fQ(3, this.rcd);
      paramInt = i;
      if (this.rce != null) {
        paramInt = i + f.a.a.b.b.a.h(4, this.rce);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bk.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bk.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cJS();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wm localwm = (wm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localwm.bHD = locala.vHC.readString();
          return 0;
        case 2: 
          localwm.jOS = locala.vHC.readString();
          return 0;
        case 3: 
          localwm.rcd = locala.vHC.rY();
          return 0;
        }
        localwm.rce = locala.vHC.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/protocal/c/wm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */