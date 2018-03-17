package com.MediApp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class EHealthFragment extends Fragment {

    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private DatabaseReference mDatabase;

    private RecyclerView mHospitalList;

    View mMainView;
    public EHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("hospital");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView=inflater.inflate(R.layout.fragment_ehealth, container, false);


        mHospitalList =(RecyclerView)mMainView.findViewById(R.id.hospital_list);
        mHospitalList.setHasFixedSize(true);
        mHospitalList.setLayoutManager(new LinearLayoutManager(getContext()));
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Hospital, HospitalViewHolder>
                (Hospital.class, R.layout.hospitals_row, HospitalViewHolder.class,
                        mDatabase) {


            @Override
            protected void populateViewHolder(HospitalViewHolder viewHolder, Hospital model, int position) {

                final String post_key = getRef(position).getKey();

                viewHolder.setName(model.getName());
                viewHolder.setDesc(model.getDescription());

                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "Getting Hospital Details", Toast.LENGTH_LONG).show();

                    }
                });
            }

        };

        mHospitalList.setAdapter(firebaseRecyclerAdapter);
    return mMainView;
    }





    public static class HospitalViewHolder extends RecyclerView.ViewHolder{

        View mview;
        TextView hospital_name,hospital_dese;

        ImageView map,contact,website;

        FirebaseAuth mAuth;

        public HospitalViewHolder(View itemView) {
            super(itemView);
            mview=itemView;


            mAuth=FirebaseAuth.getInstance();
            hospital_name=(TextView)mview.findViewById(R.id.hospitalname);

            hospital_dese= (TextView) mview.findViewById(R.id.hospitaldesc);

            map=(ImageView)mview.findViewById(R.id.mapimg);
            contact=(ImageView)mview.findViewById(R.id.phoneimg);
            website=(ImageView)mview.findViewById(R.id.websiteimg);

            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        public void setName(String name){
            TextView hopitalname=(TextView)mview.findViewById(R.id.hospitalname);
            hopitalname.setText(name);
        }


        public void setDesc(String desc){
            TextView hospital_desc=(TextView)mview.findViewById(R.id.hospitaldesc);
            hospital_desc.setText(desc);
        }

    }

}
