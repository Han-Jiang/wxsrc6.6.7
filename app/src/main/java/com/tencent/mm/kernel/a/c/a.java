package com.tencent.mm.kernel.a.c;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.h;

public abstract class a
  implements b
{
  public <T extends a> T after(com.tencent.mm.kernel.b.a parama)
  {
    h.Eo().Ef().DM().dqh.dro.a(b.class, this, parama);
    return this;
  }
  
  public void alone()
  {
    h.Eo().Ef().DM().dqh.dro.a(b.class, this, this);
  }
  
  public <T extends a> T before(com.tencent.mm.kernel.b.a parama)
  {
    h.Eo().Ef().DM().dqh.dro.a(b.class, parama, this);
    return this;
  }
  
  public int hashCode()
  {
    return name().hashCode();
  }
  
  public String name()
  {
    return toString();
  }
  
  public String toString()
  {
    return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/tencent/mm/kernel/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */