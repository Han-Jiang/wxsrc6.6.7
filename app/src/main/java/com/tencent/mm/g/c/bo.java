package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bo
  extends c
{
  public static final String[] ciG = new String[0];
  private static final int ciP = "rowid".hashCode();
  private static final int cjf;
  private static final int cjy = "key".hashCode();
  private boolean ciX;
  private boolean cju;
  public String field_key;
  public byte[] field_value;
  
  static
  {
    cjf = "value".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (cjy != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.cju = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cjf == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (ciP == k) {
        this.sKx = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues wH()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cju) {
      localContentValues.put("key", this.field_key);
    }
    if (this.ciX) {
      localContentValues.put("value", this.field_value);
    }
    if (this.sKx > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.sKx));
    }
    return localContentValues;
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes4-dex2jar.jar!/com/tencent/mm/g/c/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */