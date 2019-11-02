package com.godohosting.ehgus83133.sugangapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<User> userList;
    private Fragment parent;
    private List<User> saveList;

    public UserListAdapter(Context context, List<User> userList, ManageFragment parent, List<User> saveList) {
        this.context = context;
        this.userList = userList;
        this.parent = parent;
        this.saveList = saveList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.user, null);
        final TextView userID = (TextView) v.findViewById(R.id.userID);
        final TextView userName = (TextView) v.findViewById(R.id.userName);
        TextView userEmail = (TextView) v.findViewById(R.id.userEmail);
        TextView userGender = (TextView) v.findViewById(R.id.userGender);
        final TextView userMajor = (TextView) v.findViewById(R.id.userMajor);
        TextView admin = (TextView) v.findViewById(R.id.admin);

        userID.setText(userList.get(i).getUserID());
        userName.setText(userList.get(i).getUserName());
        userEmail.setText(userList.get(i).getUserEmail());
        userGender.setText(userList.get(i).getUserGender());
        userMajor.setText(userList.get(i).getUserMajor());
        admin.setText(userList.get(i).getAdmin());

        v.setTag(userList.get(i).getUserID());


        Button deleteButton = (Button) v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Response.Listener<String> responseListner = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                AlertDialog dialog = builder.setMessage("삭제되었습니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                for(int i = 0; i < saveList.size(); i++) {
                                    if (saveList.get(i).getUserID().equals(userID.getText().toString()) || saveList.get(i).getUserName().equals(userName.getText().toString()) || saveList.get(i).getUserMajor().equals(userMajor.getText().toString())) {
                                        saveList.remove(i);
                                        notifyDataSetChanged();
                                        break;
                                    }
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                AlertDialog dialog = builder.setMessage("삭제에 실패하였습니다.")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                ManageDeleteRequest manageDeleteRequest = new ManageDeleteRequest(userID.getText().toString(), responseListner);
                RequestQueue queue = Volley.newRequestQueue(parent.getActivity());
                queue.add(manageDeleteRequest);
            }
        });

        return v;
    }
}
