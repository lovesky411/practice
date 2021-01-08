package chat.ksh.com;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    List<Friend> mFriend;
    String email;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvEmail;
        public ImageView ivUser;
        public Button btnChat;

        public ViewHolder(View itemView) {
            super(itemView);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            ivUser = itemView.findViewById(R.id.ivUser);
            btnChat = itemView.findViewById(R.id.btnChat);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FriendAdapter(List<Friend> mFriend, Context context) {
        this.mFriend = mFriend;
        this.context = context;
    }



    // Create new views (invoked by the layout manager)
    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

        View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_friend, parent, false);

        // create a new view

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvEmail.setText(mFriend.get(position).getEmail());
        if(TextUtils.isEmpty(mFriend.get(position).getPhoto())){
            Picasso.get().load(R.mipmap.ic_launcher).fit().centerInside().into(holder.ivUser);
        }else{
            Picasso.get().load(mFriend.get(position).getPhoto()).fit().centerInside().into(holder.ivUser);
        }

        holder.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stFriendId = mFriend.get(position).getKey();
                Intent in = new Intent(context, ChatActivity.class);

                in.putExtra("friendUid", stFriendId);
                context.startActivity(in);
            }
        });



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mFriend.size();
    }


}
