package com.example.whatnow.API;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class Queue {
    private static Queue instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private Context ctx;

    public static synchronized Queue getInstance(Context context) {
        if (instance == null)
            instance = new Queue(context);
        return instance;
    }

    private Queue(Context context) {
        ctx = context;
        requestQueue= getRequestQueue();
        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        return requestQueue;
    }

    <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
