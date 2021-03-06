package com.example.paymu.UI.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paymu.Adapter;
import com.example.paymu.Data.Model.DataTransaksi;
import com.example.paymu.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragmen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragmen extends Fragment {

    RecyclerView recyclerView;
    ArrayList<DataTransaksi> dataholder;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragmen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragmen.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragmen newInstance(String param1, String param2) {
        HistoryFragmen fragment = new HistoryFragmen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder = new ArrayList<>();

        DataTransaksi ob1 = new DataTransaksi("19 Januari 2022","PLN Bill", "Success");
        dataholder.add(ob1);

        DataTransaksi ob2 = new DataTransaksi("03 Maret 2018", "Sopypay", "Failed");
        dataholder.add(ob2);

        DataTransaksi ob3 = new DataTransaksi("15 Agustus 2019", "BPJS BILL", "Success");
        dataholder.add(ob3);

        DataTransaksi ob4 = new DataTransaksi("15 Januari 2021", "Saldo OVO", "Failed");
        dataholder.add(ob4);

        // Inflate the layout for this fragment

        recyclerView.setAdapter(new Adapter(dataholder,this));
        return view;
    }
}