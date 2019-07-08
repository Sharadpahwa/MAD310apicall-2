package com.example.mad_310apicall;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {

    String pimgurl,pproname,pdesc;
    Long price;



    public Products(String pimgurl, String pproname, String pdesc, Long price) {
        this.pimgurl = pimgurl;
        this.pproname = pproname;
        this.pdesc = pdesc;
        this.price = price;
    }

    public Products(String pimgurl, String pproname) {
        this.pimgurl = pimgurl;
        this.pproname = pproname;
    }

    protected Products(Parcel in) {
        pimgurl = in.readString();
        pproname = in.readString();
        pdesc = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readLong();
        }
    }


    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPimgurl() {
        return pimgurl;
    }

    public void setPimgurl(String pimgurl) {
        this.pimgurl = pimgurl;
    }

    public String getPproname() {
        return pproname;
    }

    public void setPproname(String pproname) {
        this.pproname = pproname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pimgurl);
        dest.writeString(pproname);
        dest.writeString(pdesc);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(price);
        }
    }
}
