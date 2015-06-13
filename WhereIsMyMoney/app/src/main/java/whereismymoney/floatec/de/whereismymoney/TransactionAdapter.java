package whereismymoney.floatec.de.whereismymoney;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>{
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public TransactionAdapter(String[] myDataset){
        this.mDataset = myDataset
    }


}
