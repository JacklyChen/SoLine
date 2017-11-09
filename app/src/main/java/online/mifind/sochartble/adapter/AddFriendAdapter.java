package online.mifind.sochartble.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import online.mifind.sochartble.R;
import com.vise.common_base.adapter.helper.HelperAdapter;
import com.vise.common_base.adapter.helper.HelperViewHolder;
import com.vise.common_utils.utils.character.StringUtil;

public class AddFriendAdapter extends HelperAdapter<BluetoothDevice> {
    public AddFriendAdapter(Context context) {
        super(context, R.layout.item_friend_info);
    }

    @Override
    public void HelpConvert(HelperViewHolder viewHolder, int position, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return;
        }
        ImageView iconIv = viewHolder.getView(R.id.item_friend_icon);
        TextView nameTv = viewHolder.getView(R.id.item_friend_name);
        TextView addressTv = viewHolder.getView(R.id.item_friend_address);
        TextView statusTv = viewHolder.getView(R.id.item_friend_status);
        iconIv.setVisibility(View.GONE);
        statusTv.setVisibility(View.GONE);
        if(!StringUtil.isNullOrEmpty(bluetoothDevice.getName())){
            nameTv.setText(bluetoothDevice.getName());
        } else{
            nameTv.setText(mContext.getString(R.string.device_unknown));
        }
        addressTv.setText(bluetoothDevice.getAddress());
    }
}