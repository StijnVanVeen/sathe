package com.example.stijn.sath.gui.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stijn.sath.R;
import com.example.stijn.sath.domain.ETicket;

import net.glxn.qrgen.android.QRCode;

import java.util.ArrayList;

/**
 * Created by stijn on 2-4-2018.
 */

public class ETicketAdapter extends BaseAdapter {
    private ArrayList eticketArray;
    private LayoutInflater inflater;

    public ETicketAdapter(ArrayList eticketArray, LayoutInflater inflater) {
        this.eticketArray = eticketArray;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        int size = eticketArray.size();
        return size;
    }

    @Override
    public Object getItem(int i) {
        ETicket et = (ETicket) eticketArray.get(i);
        return et;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = inflater.inflate(R.layout.eticket_list_row, null);
            viewHolder = new ViewHolder();
            viewHolder.filmTitle = view.findViewById(R.id.ticketRowTitle);
            viewHolder.hallNumber = view.findViewById(R.id.TV_HallNumber);
            viewHolder.seatNumber = view.findViewById(R.id.TV_ChairNumber);
            viewHolder.qrCode = view.findViewById(R.id.ticketRowImage);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ETicket et = (ETicket) eticketArray.get(i);
        viewHolder.filmTitle.setText(et.getFilm());
        viewHolder.seatNumber.setText(Integer.toString(et.getSeatNumber()));
        viewHolder.hallNumber.setText(Integer.toString(et.getHallNumber()));
        viewHolder.qrCode.setImageBitmap(QRCode.from("TicketNumber: " + et.getTicketNumber() + " Film: " + et.getFilm() + " Hall: " + et.getHallNumber() + " Seat: " + et.getSeatNumber()).bitmap());
        return view;
    }

    private static class ViewHolder{
        ImageView qrCode;
        TextView filmTitle;
        TextView seatNumber;
        TextView hallNumber;
    }
}
