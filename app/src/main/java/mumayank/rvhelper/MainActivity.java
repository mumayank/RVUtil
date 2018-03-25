package mumayank.rvhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");

        RVUtil.setupRV(new RVUtil.RVCallbacks() {
            @Override
            public Context getApplicationContext() {
                return MainActivity.this.getApplicationContext();
            }

            @Override
            public RecyclerView getRecyclerView() {
                return (RecyclerView) findViewById(R.id.rv);
            }

            @Override
            public int getItemViewResourceLayoutId() {
                return R.layout.rv_item;
            }

            @Override
            public RecyclerView.ViewHolder getViewHolder(View view) {
                return new CustomViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                CustomViewHolder customViewHolder = (CustomViewHolder) holder;
                String item = arrayList.get(position);
                customViewHolder.textView.setText(item);
            }

            @Override
            public int getItemCount() {
                return arrayList.size();
            }
        });

    }

}

class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public CustomViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}
