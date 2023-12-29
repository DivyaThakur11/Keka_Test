package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import kotlin.ParameterName;

public class Result implements Serializable {
   public String uri;
   public String url;
   public Object id;
   public Object asset_id;
   public String source;
   public String published_date;
   public String updated;
   public String section;
   public String subsection;
   public String nytdsection;
   public String adx_keywords;
   public Object column;
   public String byline;
   public String type;
   public String title;
   @SerializedName("abstract")
  public String abstract_;
   public ArrayList<Medium> media;
   public int eta_id;


}