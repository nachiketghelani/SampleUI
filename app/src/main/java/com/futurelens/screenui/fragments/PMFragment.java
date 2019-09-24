package com.futurelens.screenui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futurelens.screenui.R;
import com.futurelens.screenui.adapters.PMContactListAdapter;
import com.futurelens.screenui.models.CharacterBean;
import com.futurelens.screenui.models.ContactListBean;
import com.futurelens.screenui.models.DividerBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PMFragment extends Fragment {


    @BindView(R.id.rvPMContactList) RecyclerView rvPMContactList;
    @BindView(R.id.rvCharacter) RecyclerView rvCharacter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pm_contact, container, false);
        ButterKnife.bind(this,view);
        initUI(view);
        return view;
    }

    private void initUI(View view) {


        ArrayList<Object> contactList = new ArrayList<>();
        contactList.add(new CharacterBean("T"));
        contactList.add(new ContactListBean(R.drawable.rectangle,"Tommy Blake","Network Admin"));
        contactList.add(new ContactListBean(R.drawable.rectangle_2,"Tori Bridges","Content Creator"));
        contactList.add(new ContactListBean(R.drawable.rectangle_3,"Tyler Brooks","Account Slaes"));

        contactList.add(new DividerBean());

        contactList.add(new CharacterBean("U"));
        contactList.add(new ContactListBean(R.drawable.rectangle_2,"Upadhyay","Content Creator"));
        contactList.add(new ContactListBean(R.drawable.rectangle_3,"Upnesh","Account Slaes"));

        setupStories(contactList);

        setContactCharacter();

    }

    private void setContactCharacter() {
       /* rvPMContactList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvPMContactList.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new PMContactListAdapter(getContext(), story);
        rvPMContactList.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/
    }

    private void setupStories(final ArrayList<Object> story) {
        rvPMContactList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvPMContactList.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new PMContactListAdapter(getContext(), story);
        rvPMContactList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}