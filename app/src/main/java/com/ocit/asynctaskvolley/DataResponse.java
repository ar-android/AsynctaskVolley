package com.ocit.asynctaskvolley;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ar-android on 01/11/2015.
 */
public class DataResponse implements Parcelable{
    public int id;
    public String title;
    public String thumbnail;
    public String genere;
    public String desc;

    protected DataResponse(Parcel in) {
        id = in.readInt();
        title = in.readString();
        thumbnail = in.readString();
        genere = in.readString();
        desc = in.readString();
    }

    public static final Creator<DataResponse> CREATOR = new Creator<DataResponse>() {
        @Override
        public DataResponse createFromParcel(Parcel in) {
            return new DataResponse(in);
        }

        @Override
        public DataResponse[] newArray(int size) {
            return new DataResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(genere);
        dest.writeString(desc);
    }
}
