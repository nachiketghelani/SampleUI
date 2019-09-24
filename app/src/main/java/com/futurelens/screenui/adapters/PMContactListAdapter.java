package com.futurelens.screenui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.futurelens.screenui.R;
import com.futurelens.screenui.models.CharacterBean;
import com.futurelens.screenui.models.ContactListBean;
import com.futurelens.screenui.models.DividerBean;

import java.util.List;

import static com.futurelens.screenui.utils.Constants.TYPE_CHARACTER;
import static com.futurelens.screenui.utils.Constants.TYPE_CONTACT;
import static com.futurelens.screenui.utils.Constants.TYPE_DIVIDER;

public class PMContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Object> mData;

    public PMContactListAdapter(Context context, List<Object> data) {
        this.context = context;
        this.mData = data;
    }

    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CharacterBean) {
            return TYPE_CHARACTER;
        } else if (mData.get(position) instanceof ContactListBean) {
            return TYPE_CONTACT;
        } else if (mData.get(position) instanceof DividerBean) {
            return TYPE_DIVIDER;
        }
        return -1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_CHARACTER:
                layout = R.layout.view_type_character;
                View chatView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new CharachterHolder(chatView);
                break;
            case TYPE_CONTACT:
                layout = R.layout.list_row_contacts;
                View videoView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new ContactListHolder(videoView);
                break;
            case TYPE_DIVIDER:
                layout = R.layout.view_type_divider;
                View dividerView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new ContactListHolder(dividerView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case TYPE_CHARACTER:
                CharacterBean chat = (CharacterBean) mData.get(position);
                ((CharachterHolder) holder).showDetails(chat);
                break;
            case TYPE_CONTACT:
                ContactListBean contactListBean = (ContactListBean) mData.get(position);
                ((ContactListHolder) holder).showDetails(contactListBean);
                break;
            case TYPE_DIVIDER:
                DividerBean dividerBean = (DividerBean) mData.get(position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CharachterHolder extends RecyclerView.ViewHolder {
        private TextView tvCharacter;

        public CharachterHolder(View itemView) {
            super(itemView);
            // Initiate view
            tvCharacter = (TextView) itemView.findViewById(R.id.tvCharacter);
        }

        public void showDetails(CharacterBean character) {
            // Attach values for each item
            String userName = character.getCharacter();
            tvCharacter.setText(userName);
        }
    }
}

class ContactListHolder extends RecyclerView.ViewHolder {

    private TextView tvContactName, tvDesignation;
    ImageView ivContact;

    public ContactListHolder(View itemView) {
        super(itemView);

        tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
        tvDesignation = (TextView) itemView.findViewById(R.id.tvDesignation);
        ivContact = (ImageView) itemView.findViewById(R.id.ivContact);
    }

    public void showDetails(ContactListBean contactListBean) {

        String userName = contactListBean.getName();
        String videoPlace = contactListBean.getDesignation();
        tvContactName.setText(userName);
        tvDesignation.setText(videoPlace);
        ivContact.setImageResource(contactListBean.getImage());
    }
}
