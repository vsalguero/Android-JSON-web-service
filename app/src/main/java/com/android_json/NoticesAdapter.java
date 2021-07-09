package com.android_json;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Creado por SOPWEB.
 */
public class NoticesAdapter extends RecyclerView.Adapter<NoticesAdapter.ViewHolder> {

    //Imageloader to load image
    private ImageLoader imageLoader;
    private Context context;

    public final static String EXTRA_ID = "extra_id";

    private static final String URL = "https://www.itcha.edu.sv/publicaciones/";


    //List to store all superheroes
    List<Notice> notices;

    //Constructor of this class
    public NoticesAdapter(List<Notice> notices, Context context) {
        super();
        //Getting all superheroes
        this.notices = notices;
        this.context = context;
        //this.notices.addAll(notices);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notice, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Getting the particular item from the list
        Notice notice = notices.get(position);

        //Loading image from url

        String url_new = URL + notice.getNombrecorto() + "/" + notice.getId() + "-" + notice.getFecha() + "/thumbnail/" + notice.getImagen();

        // Petición el image loader
        ImageLoader imageLoader = MySocialMediaSingleton.getInstance(context).getImageLoader();
// Petición

        //Showing data on the views
        holder.imageView.setImageUrl(url_new, imageLoader);
        holder.titulo.setText(notice.getTitulo());
        holder.descripcion.setText(notice.getDescripcion() + "...");
        holder.fechaPub.setText(notice.getFechaPub());
        holder.idNoticia.setText(String.valueOf(notice.getId()));
        holder.tiponoticia.setText(notice.getTipo());

        //holder.titulo.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return notices.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Views
        public NetworkImageView imageView;
        public TextView titulo;
        public TextView descripcion;
        public TextView fechaPub;
        public TextView idNoticia;
        public TextView tiponoticia;

        //Initializing Views
        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.img);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            fechaPub = (TextView) itemView.findViewById(R.id.fechaPub);
            idNoticia = (TextView) itemView.findViewById(R.id.idnotice);
            tiponoticia = (TextView) itemView.findViewById(R.id.tiponotice);

            imageView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

        }
    }
}