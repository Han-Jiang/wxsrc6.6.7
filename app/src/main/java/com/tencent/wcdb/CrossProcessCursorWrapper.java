package com.tencent.wcdb;

public class CrossProcessCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  public CrossProcessCursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    if ((this.mCursor instanceof CrossProcessCursor))
    {
      ((CrossProcessCursor)this.mCursor).fillWindow(paramInt, paramCursorWindow);
      return;
    }
    DatabaseUtils.cursorFillWindow(this.mCursor, paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    if ((this.mCursor instanceof CrossProcessCursor)) {
      return ((CrossProcessCursor)this.mCursor).getWindow();
    }
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mCursor instanceof CrossProcessCursor)) {
      return ((CrossProcessCursor)this.mCursor).onMove(paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes6-dex2jar.jar!/com/tencent/wcdb/CrossProcessCursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */