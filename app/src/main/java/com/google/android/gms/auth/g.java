package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class g
  implements Parcelable.Creator<AccountChangeEventsResponse>
{
  static void a(AccountChangeEventsResponse paramAccountChangeEventsResponse, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramAccountChangeEventsResponse.aIs);
    b.b(paramParcel, 2, paramAccountChangeEventsResponse.aIz);
    b.u(paramParcel, i);
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes5-dex2jar.jar!/com/google/android/gms/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */