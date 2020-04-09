package com.macbook.wallpaper.retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static Services services;

    public static Services getServices(){
        if(services==null){
            retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://www.flickr.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            services = retrofit.create(Services.class);
        }
        return services;
    }
}
