package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetAllCapabilitiesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new h();
  final List<CapabilityInfoParcelable> bet;
  public final int statusCode;
  public final int versionCode;
  
  GetAllCapabilitiesResponse(int paramInt1, int paramInt2, List<CapabilityInfoParcelable> paramList)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.bet = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel);
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes-dex2jar.jar!/com/google/android/gms/wearable/internal/GetAllCapabilitiesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */