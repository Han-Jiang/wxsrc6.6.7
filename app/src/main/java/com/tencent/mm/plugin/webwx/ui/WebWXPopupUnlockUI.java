package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI
  extends MMBaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringExtra("deviceName");
      if (paramBundle != null)
      {
        Dialog localDialog = new Dialog(this);
        localDialog.requestWindowFeature(1);
        View localView = View.inflate(this, R.i.extdevice_unlock, null);
        TextView localTextView = (TextView)localView.findViewById(R.h.device_name);
        ((TextView)localView.findViewById(R.h.unlock_bt)).setOnClickListener(new WebWXPopupUnlockUI.1(this, localDialog));
        localDialog.setOnDismissListener(new WebWXPopupUnlockUI.2(this));
        localTextView.setText(paramBundle);
        localDialog.setContentView(localView);
        localDialog.show();
      }
    }
    else
    {
      return;
    }
    x.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes6-dex2jar.jar!/com/tencent/mm/plugin/webwx/ui/WebWXPopupUnlockUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */