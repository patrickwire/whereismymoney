package whereismymoney.floatec.de.whereismymoney;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView countryName;
    public ImageView countryImage;

    public ViewHolder(View itemView) {
        super(itemView);
        countryName = (TextView) itemView.findViewById(R.id.countryName);
        countryImage = (ImageView) itemView.findViewById(R.id.countryImage);
    }

}