package com.android_json;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by SOPWEB on 16/08/2016.
 */
public class Config {
    //Data URL
    public static final String DATA_URL = "https://www.itcha.edu.sv/android-json/feed.php?page=";
    //JSON TAGS
    public static final String TAG_ID = "id";
    public static final String TAG_IMAGE = "IMG";
    public static final String TAG_TITULO = "titulo";
    public static final String TAG_DESCRIPCION = "descripcion";
    public static final String TAG_CONTENIDO = "contenido";
    public static final String TAG_NOMBRECORTO = "nombreCorto";
    public static final String TAG_FECHA = "fecha";
    public static final String TAG_FECHAPUB = "fechaPub";
    public static final String TAG_TIPO = "tipo";
    public static final String TAG_VISITADO = "visitado";
    public static final String TAG_TOTAL = "total";

    public static final String TAG_FECHA_DIA = "fechaDia";
    public static final String TAG_FECHA_MES = "fechaMes";
    public static final String TAG_FECHA_ANIO = "fechaAnio";

    public static final String TAG_IMAGE_DESCRIPTION = "descripcionFoto";
    public static final String TAG_ID_FOTO = "idFoto";




    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
