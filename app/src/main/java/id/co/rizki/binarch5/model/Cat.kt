package id.co.rizki.binarch5.model

import android.os.Parcel
import android.os.Parcelable

class Cat() : Parcelable {
    var nama: String? = null
    var umur = 0
    var warna: String? = null
    var keturunan: String? = null

    constructor(parcel: Parcel) : this() {
        nama = parcel.readString()
        umur = parcel.readInt()
        warna = parcel.readString()
        keturunan = parcel.readString()
    }

    fun tidur() {
        println("$nama Tidur")
    }

    fun main() {
        println("$nama Main")
    }

    fun makan() {
        println("$nama Makan")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(umur)
        parcel.writeString(warna)
        parcel.writeString(keturunan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cat> {
        override fun createFromParcel(parcel: Parcel): Cat {
            return Cat(parcel)
        }

        override fun newArray(size: Int): Array<Cat?> {
            return arrayOfNulls(size)
        }
    }
}