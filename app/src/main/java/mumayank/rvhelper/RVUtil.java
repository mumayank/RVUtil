package mumayank.rvhelper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mayank on 26-03-2018.
 */

public class RVUtil {

    public interface RVCallbacks {
        Context getApplicationContext();

        RecyclerView getRecyclerView();

        int getItemViewResourceLayoutId();

        RecyclerView.ViewHolder getViewHolder(View view);

        void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

        int getItemCount();
    }

    static RVAdapter rvAdapter;

    public static void setupRV(final RVCallbacks rvCallbacks) {
        rvCallbacks.getRecyclerView().setLayoutManager(new LinearLayoutManager(rvCallbacks.getApplicationContext()));
        rvAdapter = new RVAdapter(rvCallbacks);
        rvCallbacks.getRecyclerView().setAdapter(rvAdapter);
    }

    public static void notifyDataSetChanged() {
        rvAdapter.notifyDataSetChanged();
    }

    static class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        RVCallbacks rvCallbacks;

        public RVAdapter(RVCallbacks rvCallbacks) {
            this.rvCallbacks = rvCallbacks;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(rvCallbacks.getApplicationContext()).inflate(rvCallbacks.getItemViewResourceLayoutId(), parent, false);
            return rvCallbacks.getViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            rvCallbacks.onBindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return rvCallbacks.getItemCount();
        }

    }

}