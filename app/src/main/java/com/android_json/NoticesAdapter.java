package com.android_json;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Creado por Vladimir Salguero.
 */
public class NoticesAdapter extends RecyclerView.Adapter<NoticesAdapter.ViewHolder> {

    private Context context;

    //root url for images
    private static final String URL = "https://www.itcha.edu.sv/publicaciones/";

    //List to store all notices
    List<Notice> notices;

    //Constructor of this class
    public NoticesAdapter(List<Notice> notices, Context context) {
        super();
        //Getting all notices
        this.notices = notices;
        this.context = context;
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
// Request

        //Showing data on the views
        holder.imageView.setImageUrl(url_new, imageLoader);
        holder.titulo.setText(notice.getTitulo());
        holder.descripcion.setText(notice.getDescripcion() + "...");
        holder.fechaPub.setText(notice.getFechaPub());
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

        //Initializing Views
        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.img);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            fechaPub = (TextView) itemView.findViewById(R.id.fechaPub);

            imageView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

        }
    }
}