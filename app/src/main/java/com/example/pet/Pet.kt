package com.example.pet

import android.os.Parcel
import android.os.Parcelable

class Pet() :Parcelable {
    var name:String="";
    var year:Int=0;
    var month:Int=0;
    constructor(parcel: Parcel) : this() {
        name=parcel.readString().toString();
        year=parcel.readInt();
        month=parcel.readInt();
    }
    constructor(_name:String,_year:Int,_month:Int):this(){
        name=_name;
        year=_year;
        month=_month;
    }

    override fun writeToParcel(dest: Parcel, flags: Int){
        dest?.writeString(name)
        dest?.writeInt(year)
        dest?.writeInt(month)
    }

    fun write():String{
        return "Порода:${name} \n Год: ${year} \n Месяц: ${month}"
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }



}